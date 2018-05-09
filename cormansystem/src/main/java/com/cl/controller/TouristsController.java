package com.cl.controller;


import com.cl.biz.DeliveryService;
import com.cl.biz.PostitionesService;
import com.cl.biz.RecruitmentService;
import com.cl.biz.ResumeService;
import com.cl.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by one on 2018/4/22.
 */
@Controller
public class TouristsController {
    @Autowired
   private RecruitmentService recruitmentService;
   @Autowired
   private DeliveryService deliveryService;
   @Autowired
   private ResumeService resumeService;
   @Autowired
   private PostitionesService postitionesService;
    @RequestMapping("tourists.do")//游客查看招聘信息
    public String Tourists(HttpSession session)throws Exception{
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd ");
        List<Recruitment> recruitments=recruitmentService.getRecruitment();
        for(Recruitment recruitment:recruitments){
            recruitment.setCreatetime(sdf.format(recruitment.getR_createtime()));
        }
        session.setAttribute("recruitments",recruitments);
        session.setAttribute("touristr",1);
        return "success";
    }
    @RequestMapping("choosere.do")//投递简历
    public String choosere(HttpServletRequest request, HttpServletResponse response)throws Exception{
        HttpSession session=request.getSession();
        int id= Integer.parseInt(request.getParameter("id"));
        User user= (User) session.getAttribute("user");
        int num= (int) session.getAttribute("touristr");
        if (num==3){
            String prompt="您目前已经是我司员工，无需投递简历";
            session.setAttribute("prompt",prompt);
            return "empromptinterface";
        }else if (num==1){
            String prompt="游客无法投递简历";
            session.setAttribute("prompt",prompt);
            return "touristsprompt";
        }
        if (user==null){
            return "../../index";
        }else if (resumeService.getResumebyuid(user.getU_id())!=null){
            Resume resume=resumeService.getResumebyuid(user.getU_id());
            Recruitment recruitment=recruitmentService.getRecruitmentByid(id);
            Delivery delivery1=deliveryService.getDeliveryByuidandreid(user.getU_id());
            if (delivery1!=null){
                String prompt="职位简历只能提交一次，请去简历状态查看是否通知面试";
                session.setAttribute("prompt",prompt);
                return "touristsprompt";
            }
            Postitions postitions=postitionesService.getPostitonsBynamenoemploy(recruitment.getR_job());
            Delivery delivery=new Delivery();
            delivery.setDe_state("已投递");
            delivery.setRecruitment(recruitment);
            delivery.setPostitions(postitions);
            delivery.setResume(resume);
            delivery.setUser(user);
            deliveryService.addDelivery(delivery);
            String prompt="投递成功";
            session.setAttribute("prompt",prompt);
            return "touristsprompt";
        }else {
            return "addresume";
        }
    }
    @RequestMapping("addresume.do")
    public String addresume(Resume resume,HttpSession session)throws Exception{
        User user= (User) session.getAttribute("user");
        resume.setUser(user);
        if (resumeService.addResume(resume)){
             Resume resume1=resumeService.getResumebyuid(user.getU_id());
             session.setAttribute("resume",resume1);
             return "saveresume";
        }else {
            return "addresume";
        }
    }
    @RequestMapping("upresume.do")//修改简历ps：验证没有添加
    public String upresume(Resume resume,HttpSession session)throws Exception{
       User user= (User) session.getAttribute("user");
       resume.setUser(user);
       if (resumeService.updateResume(resume)){
           session.setAttribute("resume",resume);
           return "saveresume";
       } else {
           return "updateresume";
       }
    }
    @RequestMapping("resumestate.do")
    public String resumestate(HttpSession session) throws Exception{
        User user= (User) session.getAttribute("user");
        int num= (int) session.getAttribute("touristr");
        if (num==1){
            String prompt="您目前游客身份无法进行此操作，请先注册";
            session.setAttribute("prompt",prompt);
            return "touristsprompt";
        }
        List<Delivery> deliveries=deliveryService.getDeliveryByuid(user.getU_id());
        if (deliveries!=null&&deliveries.size()!=0){
            session.setAttribute("delivery",deliveries);
            return "resumestate";
        }
        String prompt="目前暂无简历投递";
        session.setAttribute("prompt",prompt);
        return "touristsprompt";
    }
}

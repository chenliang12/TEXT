package com.cl.controller;


import com.cl.biz.DeliveryService;
import com.cl.biz.RecruitmentService;
import com.cl.biz.ResumeService;
import com.cl.model.Delivery;
import com.cl.model.Recruitment;
import com.cl.model.Resume;
import com.cl.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    @RequestMapping("tourists.do")//游客查看招聘信息
    public String Tourists(HttpSession session)throws Exception{
        List<Recruitment> recruitments=recruitmentService.getRecruitment();
        session.setAttribute("recruitments",recruitments);
        return "success";
    }
    @RequestMapping("choosere.do")//投递简历
    public String choosere(HttpServletRequest request, HttpServletResponse response)throws Exception{
        HttpSession session=request.getSession();
        int id= Integer.parseInt(request.getParameter("id"));
        User user= (User) session.getAttribute("user");
        if (user==null){
            return "../../index";
        }else if (resumeService.getResumebyuid(user.getU_id())!=null){
            Resume resume=resumeService.getResumebyuid(user.getU_id());
            Recruitment recruitment=new Recruitment();
            recruitment.setR_id(id);
            Delivery delivery=new Delivery();
            delivery.setDe_state("已投递");
            delivery.setRecruitment(recruitment);
            delivery.setResume(resume);
            delivery.setUser(user);
            deliveryService.addDelivery(delivery);
            return "subresume";
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
        if (deliveryService.getDeliveryByuid(user.getU_id())!=null){
            List<Delivery> deliveries=deliveryService.getDeliveryByuid(user.getU_id());
            session.setAttribute("delivery",deliveries);
            return "resumestate";
        }
        return "";
    }
}

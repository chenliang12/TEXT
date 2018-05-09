package com.cl.controller;

import com.cl.biz.DepartmentService;
import com.cl.biz.RecruitmentService;
import com.cl.biz.ResumeService;
import com.cl.model.Department;
import com.cl.model.Recruitment;
import com.cl.model.Resume;
import com.cl.model.User;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by one on 2018/4/22.
 */
@Controller
public class HyperlinkController {
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private RecruitmentService recruitmentService;
    @RequestMapping("addusers.do")
    public String addusers()throws Exception{
        return "adduser";
    }
    @RequestMapping("updateresume.do")
    public String updateresume() throws Exception{
        return "updateresume";
    }
    @RequestMapping("saveresume.do")
    public String saveresume(HttpSession session) throws  Exception{
        User user= (User) session.getAttribute("user");
        int num= (int) session.getAttribute("touristr");
        if (num==1){
            String prompt="您目前游客身份无法进行此操作，请先注册";
            session.setAttribute("prompt",prompt);
            return "touristsprompt";
        }else if (num==3){
            String prompt="您目前已经成为员工无法操作";
            session.setAttribute("prompt",prompt);
            return "touristsprompt";
        }
        Resume resume=resumeService.getResumebyuid(user.getU_id());
        if (resume!=null){
            session.setAttribute("resume",resume);
            return "saveresume";
        }
        String prompt="您还没有创建简历";
        session.setAttribute("prompt",prompt);
        return "touristsprompt";
    }
    @RequestMapping("adddepar.do")
    public String adddepar() throws Exception{
        return "adddepar";
    }
    @RequestMapping("addpos.do")
    public String addpos(HttpSession session, HttpServletRequest request) throws Exception{
        int id= Integer.parseInt(request.getParameter("id"));
        session.setAttribute("did",id);
        return "addpos";
    }
    @RequestMapping("updateemploy.do")
    public String updateemploy()throws Exception{
        return "updateemployee";
    }
    @RequestMapping("addtrains.do")
    public String addtrains(HttpSession session)throws Exception{
        List<Department> departments=departmentService.getDepartment();
        session.setAttribute("departments",departments);
        return "addtrains";
    }
    @RequestMapping("succes.do")
    public String succes(HttpSession session,HttpServletRequest request) throws Exception{
        int touristr= Integer.parseInt(request.getParameter("touristr"));
        session.setAttribute("touristr",touristr);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd ");
        List<Recruitment> recruitments=recruitmentService.getRecruitment();
        for(Recruitment recruitment:recruitments){
            recruitment.setCreatetime(sdf.format(recruitment.getR_createtime()));
        }
        session.setAttribute("recruitments",recruitments);
        return "success";
    }
    @RequestMapping("addreandpun.do")
    public String addreandpun()throws Exception{
        return "addreandpun";
    }
    @RequestMapping("addrecruiments.do")
    public String addrecruiments() throws Exception{
        return "addrecruiments";
    }
@RequestMapping("attendance.do")
    public String attendance() throws Exception{
        return "attendance";
}
@RequestMapping("companyprofile.do")
    public String companyprofile() throws Exception{
        return "companyprofile";
}
@RequestMapping("business.do")
   public String business() throws Exception{
        return "business";
}
@RequestMapping("addresumes.do")
    public String addresumes() throws Exception{
        return "addresume";
}
@RequestMapping("success.do")
    public String success() throws Exception{
        return "success";
}
}

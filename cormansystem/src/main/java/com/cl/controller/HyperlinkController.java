package com.cl.controller;

import com.cl.biz.ResumeService;
import com.cl.model.Resume;
import com.cl.model.User;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by one on 2018/4/22.
 */
@Controller
public class HyperlinkController {
    @Autowired
    private ResumeService resumeService;
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
    public String addtrains()throws Exception{
        return "addtrains";
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
}

package com.cl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by one on 2018/4/22.
 */
@Controller
public class HyperlinkController {
    @RequestMapping("addusers.do")
    public String addusers()throws Exception{
        return "adduser";
    }
    @RequestMapping("updateresume.do")
    public String updateresume() throws Exception{
        return "updateresume";
    }
    @RequestMapping("saveresume.do")
    public String saveresume() throws  Exception{
        return "saveresume";
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
}

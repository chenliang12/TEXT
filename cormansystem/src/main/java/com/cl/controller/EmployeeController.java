package com.cl.controller;

import com.cl.biz.RecruitmentService;
import com.cl.biz.ResumeService;
import com.cl.biz.UserService;
import com.cl.model.Recruitment;
import com.cl.model.Resume;
import com.cl.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by one on 2018/4/20.
 */
@Controller
public class EmployeeController {
    @Autowired
    private UserService userService;
    @Autowired
    private RecruitmentService recruitmentService;
    @Autowired
    private ResumeService resumeService;
    @RequestMapping("login.do")//登陆
    public String loginsession(User user,HttpServletRequest request)throws  Exception{
        HttpSession session=request.getSession();
        if (userService.getUser(user)!=null){
           User user1=userService.getUser(user);
           if (user1.getAuthority()==1){
               session.setAttribute("user",user1);
               List<Recruitment> recruitments=recruitmentService.getRecruitment();
               session.setAttribute("recruitments",recruitments);
               Resume resume=resumeService.getResumebyuid(user1.getU_id());
               session.setAttribute("resume",resume);
               return "success";
           }else if(user1.getAuthority()==2){
                return "employsuccess";
           }else{
               return  "adminsuccess";
            }
        }else {
            return "../../index";
        }
    }

    @RequestMapping("adduser.do")//注册账号
    public  String adduser(User user)throws Exception{
        if (userService.getUserbyname(user.getUname())==null){
            user.setAuthority(1);
            userService.addUser(user);
            return "../../index";
        }else {
            return "adduser";
        }
    }
    @RequestMapping("checkname.do")
    private String checkname(String uname)throws Exception{
        User user=new User();
        user.setUname(uname);
        System.out.println("进来了");
        return "没问题";
        /*if (userService.getUserbyname(user)==null){
            return "用户名可用";
        }else {

        }*/

    }
}

package com.cl.controller;

import com.cl.biz.*;
import com.cl.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private PostitionesService postitionesService;
    @Autowired
    private TrainService trainService;
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
               session.setAttribute("user",user1);

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
    @RequestMapping("checkname.do")//注册账号验证ajax
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
    @RequestMapping("saveemploy.do")
    public String saveemploy(HttpSession session) throws Exception{
        User user= (User) session.getAttribute("user");
        Employee employee=employeeService.getEmployeeByuid(user.getU_id());
        session.setAttribute("employee",employee);
        return "saveemployee1";
    }
    @RequestMapping("updateemployee.do")//员工本人修改自己信息
    public String updateemployee(HttpSession session,Employee employee) throws Exception{
        User user= (User) session.getAttribute("user");
        employee.setUser(user);
        employeeService.updateEmployee(employee);
        return saveemploy(session);
    }
    @RequestMapping("saveemps.do")//员工查询部门
    public String saveemps(HttpSession session)throws Exception{
        if (departmentService.getDepartment()!=null){
            List<Department> department=departmentService.getDepartment();
            int size=department.size();
            session.setAttribute("size",size);
            session.setAttribute("department",department);
            return "emsavedep";
        }
        return "";//返回一个错误界面
    }
    @RequestMapping("saveempes.do")//员工查询职位信息
    public String saveempes(HttpSession session,HttpServletRequest request)throws Exception{
        int id= Integer.parseInt(request.getParameter("id"));
        Department department=departmentService.getDepartmentbyid(id);
        session.setAttribute("department",department);
        List<Postitions> postitions=postitionesService.getPostitionsbydeid(id);
        if (postitions!=null){
            for (Postitions postitions1:postitions){
                Employee employee=employeeService.getEmployeeByuid(postitions1.getUser().getU_id());
                postitions1.setEmployee(employee);
            }
            int size=postitions.size();
            session.setAttribute("size",size);
            session.setAttribute("postitions",postitions);
            session.setAttribute("did",id);
            return "emsavepos";
        }
        return "";//返回一个没有职位的显示网址
    }
    @RequestMapping("saveempess.do")
    public String saveempess(HttpSession session,HttpServletRequest request)throws Exception{
        int id= Integer.parseInt(request.getParameter("id"));
        Employee employee=employeeService.getEmployeeByid(id);
        session.setAttribute("employee",employee);
        return "emsaveemployee";
    }
    @RequestMapping("emsavetrain.do")
    public String emsavetrain(HttpSession session)throws Exception{
       User user= (User) session.getAttribute("user");
       Postitions postitions=postitionesService.getPostitonsByuid(user.getU_id());
       List<Train> train=trainService.getTrainsByPid(postitions.getDepartment().getD_id());
       if (train!=null){
           session.setAttribute("trains",train);
           return "emsavetrains";
       }else {
           return "";//返回提示暂无培训内容
       }
    }
}

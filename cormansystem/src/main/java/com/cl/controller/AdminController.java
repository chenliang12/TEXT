package com.cl.controller;


import com.cl.biz.*;
import com.cl.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by one on 2018/4/23.
 */
@Controller
public class AdminController {

    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private PostitionesService postitionesService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeService employeeService;
   @Autowired
   private TrainService trainService;
    @RequestMapping("adminsaveresume.do")
    public String adminsaveresume(HttpSession session) throws Exception{
         if (deliveryService.getDelivery()!=null){
             List<Delivery> deliveries=deliveryService.getDelivery();
             session.setAttribute("delivery",deliveries);
             for (Delivery delivery:deliveries){
                 System.out.println(delivery);
             }
             return"adsaveresume";
         }
         return "";
    }
    @RequestMapping("updateresume1.do")//简历录用管理
    public String updateresume1(HttpSession session, HttpServletRequest request) throws Exception{
        int id= Integer.parseInt(request.getParameter("id"));
        String state=request.getParameter("state");
        Delivery delivery=new Delivery();
        delivery.setDe_id(id);
        if (state.equals("已投递")){
            delivery.setDe_state("已通知面试");
            deliveryService.updateDelivery(delivery);
            List<Delivery> deliveries=deliveryService.getDelivery();
            session.setAttribute("delivery",deliveries);
            return"adsaveresume";
        }else if(state.equals("已通知面试")){
            Delivery delivery1=deliveryService.getDeliveryByid(id);
            Postitions postitions=new Postitions();
            postitions.setUser(delivery1.getUser());
            postitions.setP_position(delivery1.getRecruitment().getR_job());
            postitionesService.updatePostitions(postitions);
            delivery.setDe_state("已录用");
            User user= (User) session.getAttribute("user");
            user.setAuthority(2);
            //添加将简历信息转移到员工信息上
            Employee employee=new Employee();
            Date date=new Date();
            employee.setE_age(delivery1.getResume().getR_age());
            employee.setE_createtime(date);
            employee.setE_name(delivery1.getResume().getR_name());
            employee.setE_origin(delivery1.getResume().getR_origin());
            employee.setE_state("实习");
            employee.setE_phone(delivery1.getResume().getR_phone());
            employee.setE_sex(delivery1.getResume().getR_sex());
            deliveryService.updateDelivery(delivery);
            List<Delivery> deliveries=deliveryService.getDelivery();
            session.setAttribute("delivery",deliveries);
            return"adsaveresume";
        }else {
            return "";//返回一个错误界面
        }
    }
    @RequestMapping("updateresume2.do")
    public String updateresume2(HttpSession session, HttpServletRequest request) throws Exception{
        int id= Integer.parseInt(request.getParameter("id"));
        String state=request.getParameter("state");
        Delivery delivery=new Delivery();
        delivery.setDe_id(id);
        if (state.equals("已录用")){
            return "";//返回一个错误界面
        }else {
            delivery.setDe_state("已拒绝");
            deliveryService.updateDelivery(delivery);
            List<Delivery> deliveries=deliveryService.getDelivery();
            session.setAttribute("delivery",deliveries);
            return"adsaveresume";
        }
    }
    @RequestMapping("savedepartment.do")//查看部门
    public String savedepartment(HttpSession session)throws Exception{
        if (departmentService.getDepartment()!=null){
            List<Department> department=departmentService.getDepartment();
            int size=department.size();
            session.setAttribute("size",size);
            session.setAttribute("department",department);
            return "savepepartment";
        }
        return "";//返回一个错误网址
    }
    @RequestMapping("savepostitions.do")
    public String savepostitions(HttpSession session,HttpServletRequest request) throws Exception{
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
            return "savepostitions";
        }
        return "";//返回一个没有职位的显示网址
    }
    @RequestMapping("saveemployee.do")//从详细部门进入到员工信息
    public String saveemployee(HttpSession session,HttpServletRequest request)throws Exception{
        int id= Integer.parseInt(request.getParameter("id"));
        Employee employee=employeeService.getEmployeeByid(id);
        session.setAttribute("employee",employee);
        return "saveemployee";
    }
    @RequestMapping("addddepartment.do")//添加部门
    public String addddepartment(HttpSession session,Department department) throws Exception {
        if (departmentService.getDepartmentBydeid(department)!=null){
            return "";//弹到错误界面
        }else {
            departmentService.addDepartment(department);
            Department department1=departmentService.getDepartmentBydeid(department);
            session.setAttribute("did",department1.getD_id());
            return "addpos";
        }
    }
    @RequestMapping("addpostitions.do")//添加职位
    public String addpostitions(HttpSession session,Postitions postitions) throws Exception{
        int id= (int) session.getAttribute("did");
        Department department=new Department();
        department.setD_id(id);
        postitions.setDepartment(department);
        User user=new User();
        user.setU_id(0);
        postitions.setUser(user);
        Employee employee=new Employee();
        employee.setE_id(0);
        postitions.setEmployee(employee);
        postitionesService.addPostitions(postitions);
        return savedepartment(session);//弹到提示成功页面，让其进入主页查看部门查看
    }
    @RequestMapping("deletedepart.do")
    public String deletedepart(HttpSession session,HttpServletRequest request) throws Exception{
        int id= Integer.parseInt(request.getParameter("id"));
        Department department=new Department();
        department.setD_id(id);
        System.out.println(department.getD_id());
        List<Postitions> postitions=postitionesService.getPostitionsbydeid(department.getD_id());
        for (Postitions postitions1:postitions){
            if (postitions1.getUser().getU_id()!=0){
                return "";//跳转错误界面
            }
        }
        Postitions postitions1=new Postitions();
        postitions1.setDepartment(department);
        postitionesService.deletePostitions(postitions1);
        departmentService.deleteDepartment(department);
        return savedepartment(session);
    }
    @RequestMapping("deletepos.do")
    public String deletepos(HttpServletRequest request,HttpSession session)throws Exception{
        int id= Integer.parseInt(request.getParameter("id"));
        Postitions postitions=postitionesService.getPostitionsbyid(id);
        postitionesService.deletePostitions(postitions);
        return savedepartment(session);
    }
    @RequestMapping("adsavetrain.do")//管理员查询培训信息
    public String adsavetrain(HttpSession session) throws Exception{
       List<Train> trains=trainService.getTrains();
       if (trains!=null){
           session.setAttribute("trains",trains);
           return "adsavetrains";
       }
       return "";//返回一个爆空页面让其添加
    }
    @RequestMapping("addtrain.do")
    public String addtrain(HttpSession session,Train train,HttpServletRequest request) throws Exception{
        String depat=request.getParameter("depname");
        Department department=new Department();
        department.setD_depat(depat);
        if (departmentService.getDepartmentBydeid(department)!=null){
            Department department1=departmentService.getDepartmentBydeid(department);
            train.setDepartment(department1);
            train.setT_state("未培训");
            trainService.addTrain(train);
            return adsavetrain(session);
        }else {
            return "";//提示部门不存在
        }
    }
    @RequestMapping("updatetrain.do")
    public String updatetrain(HttpSession session,HttpServletRequest request)throws Exception{
       int id= Integer.parseInt(request.getParameter("id"));
       Train train=trainService.getTrainByid(id);
       train.setT_state("已培训");
       trainService.updateTrain(train);
       return adsavetrain(session);
    }
}

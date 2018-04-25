package com.cl.controller;


import com.cl.biz.*;
import com.cl.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by one on 2018/4/23.
 */
@Controller
public class AdminController {
    @Autowired
    private UserService userService;
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
   @Autowired
   private ReandpunService reandpunService;
   @Autowired
   private RecruitmentService recruitmentService;
    @RequestMapping("adminsaveresume.do")
    public String adminsaveresume(HttpSession session) throws Exception{
        List<Delivery> deliveries=deliveryService.getDelivery();
         if (deliveries!=null&&deliveries.size()!=0){//消除已经同意和回绝的简历
             session.setAttribute("delivery",deliveries);
             return"adsaveresume";
         }
         String prompt="暂时无人投递简历";
         session.setAttribute("prompt",prompt);
         return "promptinterface";
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
            delivery.setDe_state("已录用");
            User user=userService.getUserByid(delivery1.getUser().getU_id());
            user.setAuthority(2);
            Employee employee=new Employee();
            Date date=new Date();
            employee.setE_age(delivery1.getResume().getR_age());
            employee.setE_createtime(date);
            employee.setE_name(delivery1.getResume().getR_name());
            employee.setE_origin(delivery1.getResume().getR_origin());
            employee.setE_state("实习");
            employee.setE_phone(delivery1.getResume().getR_phone());
            employee.setE_sex(delivery1.getResume().getR_sex());
            employee.setUser(user);
            employeeService.addEmployee(employee);
            Employee employee1=employeeService.getEmployeeByuid(user.getU_id());
            postitions.setEmployee(employee1);
            deliveryService.updateDelivery(delivery);
            postitionesService.updatePostitions(postitions);
            List<Delivery> deliveries=deliveryService.getDelivery();
            session.setAttribute("delivery",deliveries);
            return"adsaveresume";
        }else {
            String prompt="操作无效请确认操作是否正确";
            session.setAttribute("prompt",prompt);
            return "promptinterface";//返回一个错误界面
        }
    }
    @RequestMapping("updateresume2.do")
    public String updateresume2(HttpSession session, HttpServletRequest request) throws Exception{
        int id= Integer.parseInt(request.getParameter("id"));
        String state=request.getParameter("state");
        Delivery delivery=new Delivery();
        delivery.setDe_id(id);
        if (state.equals("已录用")){
            String prompt="员工已经录用，无效操作";
            session.setAttribute("prompt",prompt);
            return "promptinterface";//返回一个错误界面
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
        List<Department> department=departmentService.getDepartment();
        if (department!=null&&department.size()!=0){
            int size=department.size();
            session.setAttribute("size",size);
            session.setAttribute("department",department);
            return "savepepartment";
        }
        String prompt="公司目前没有部门创建";
        session.setAttribute("prompt",prompt);
        return "promptinterface";//返回一个错误网址
    }
    @RequestMapping("savepostitions.do")
    public String savepostitions(HttpSession session,HttpServletRequest request) throws Exception{
        int id= Integer.parseInt(request.getParameter("id"));
        session.setAttribute("did",id);
        Department department=departmentService.getDepartmentbyid(id);
        session.setAttribute("department",department);
        List<Postitions> postitions=postitionesService.getPostitionsbydeid(id);
        if (postitions!=null&&postitions.size()!=0){
            for (Postitions postitions1:postitions){
                Employee employee=employeeService.getEmployeeByuid(postitions1.getUser().getU_id());
                postitions1.setEmployee(employee);
            }
            int size=postitions.size();
            session.setAttribute("size",size);
            session.setAttribute("postitions",postitions);
            return "savepostitions";
        }
        String prompt="该部门目前没有职位";
        session.setAttribute("prompt",prompt);
        return "promptinterface";//返回一个没有职位的显示网址
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
            String prompt="该部门已经存在";
            session.setAttribute("prompt",prompt);
            return "promptinterface";//弹到错误界面
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
        List<Postitions> postitions=postitionesService.getPostitionsbydeid(department.getD_id());
        for (Postitions postitions1:postitions){
            if (postitions1.getUser().getU_id()!=0){
                String prompt="该部门下目前有人就职，无法删除";
                session.setAttribute("prompt",prompt);
                return "promptinterface";//跳转错误界面
            }
            if (recruitmentService.getRecruitmentByjob(postitions1.getP_position())==null){
                String prompt="该部门目前没有职位";
                session.setAttribute("prompt",prompt);
                return "promptinterface";//跳转到提示有招聘信息没有删除
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
        if (recruitmentService.getRecruitmentByjob(postitions.getP_position())==null){
            return "";//跳转到提示有招聘信息没有删除
        }
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
    @RequestMapping("addtrain.do")//增加培训
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
    @RequestMapping("updatetrain.do")//修改培训
    public String updatetrain(HttpSession session,HttpServletRequest request)throws Exception{
       int id= Integer.parseInt(request.getParameter("id"));
       Train train=trainService.getTrainByid(id);
       train.setT_state("已培训");
       trainService.updateTrain(train);
       return adsavetrain(session);
    }
    @RequestMapping("adsavereandpun.do")//查看奖惩
    public String adsavereandpun(HttpSession session)throws Exception{
        List<Reandpun> reandpuns=reandpunService.getReandpun();
        if (reandpuns!=null){
            session.setAttribute("reandpuns",reandpuns);
            return "adsavereandpun";
        }else {
            return "";//返回提示空界面
        }
    }
    @RequestMapping("adaddreandpun.do")//增加奖惩
    public String adaddreandpun(HttpSession session, HttpServletRequest request)throws Exception{
        int i= Integer.parseInt(request.getParameter("name"));
        int money= Integer.parseInt(request.getParameter("money"));
        String ename=request.getParameter("ename");
        String postitions=request.getParameter("postition");
        String explanation=request.getParameter("explanation");
        Postitions postitions1=postitionesService.getPostitonsByname(postitions);
        Date date=new Date();
        if (postitions1.getEmployee().getE_name().equals(ename)){
            Reandpun reandpun=new Reandpun();
            if (i==1){
                reandpun.setRe_reward(money);
                reandpun.setRe_punishment(0);
            }else {
                reandpun.setRe_reward(0);
                reandpun.setRe_punishment(money);
            }
            reandpun.setRe_state("未结算");
            reandpun.setRe_explanation(explanation);
            reandpun.setEmployee(postitions1.getEmployee());
            reandpun.setRe_date(date);
            reandpunService.addReandpun(reandpun);
            return adsavereandpun(session);
        }
        return "";
    }
    @RequestMapping("updatereandpun.do")//跳转修改奖惩页面
    public String updatereandpun(HttpSession session,HttpServletRequest request)throws Exception{
        int id= Integer.parseInt(request.getParameter("id"));
        Reandpun reandpun=reandpunService.getReandpunByid(id);
        if (reandpun.getRe_state().equals("未结算")){
            session.setAttribute("reandpun",reandpun);
            return "updatereandpun";
        }else {
            return "";//返回无法修改界面
        }

    }
    @RequestMapping("updatereandpuns.do")//修改奖惩
    public String updatereandpuns(HttpSession session,HttpServletRequest request)throws Exception{
        int id= Integer.parseInt(request.getParameter("id"));
        int money= Integer.parseInt(request.getParameter("money"));
        String explanation=request.getParameter("explanation");
        int num= Integer.parseInt(request.getParameter("num"));
        Reandpun reandpun=reandpunService.getReandpunByid(id);
        if (num==1){
            reandpun.setRe_reward(money);
        }else {
            reandpun.setRe_punishment(money);
        }
        reandpun.setRe_explanation(explanation);
        reandpunService.updateReandpun(reandpun);
        return adsavereandpun(session);
    }
    @RequestMapping("adminsaverecrui.do")
    public String adminsaverecrui(HttpSession session) throws Exception{
        List<Recruitment> recruitments=recruitmentService.getRecruitment();
        if (recruitments!=null){
            session.setAttribute("recruitments",recruitments);
            return "adminsaverecrui";
        }
        return "";
    }
    @RequestMapping("addrecruiment.do")
    public String addrecruiment(HttpSession session,Recruitment recruitment) throws Exception{
        Date date=new Date();
        if (postitionesService.getPostitonsBynamenoemploy(recruitment.getR_job())!=null){
            recruitment.setR_createtime(date);
            recruitment.setR_state("未招满");
            recruitmentService.addRecruitment(recruitment);
            return adminsaverecrui(session);
        }else {
            return "";//提示没有该职位请先添加该职位
        }
    }
    @RequestMapping("deleterecru.do")
    public String deletetecru(HttpSession session,HttpServletRequest request)throws  Exception{
        int id= Integer.parseInt(request.getParameter("id"));
        Recruitment recruitment=new Recruitment();
        recruitment.setR_id(id);
        recruitmentService.deleteRecruitment(recruitment);
        return adminsaverecrui(session);
    }
    @RequestMapping("moveofpersonnel.do")
    public String moveofpersonnel(HttpSession session)throws Exception{
        List<Department> departments=departmentService.getDepartment();
        session.setAttribute("departmentList",departments);
        return "moveofpersonnel";
    }
    @RequestMapping("moveofpersonnelajax.do")//人员调动采用二级联动
    public @ResponseBody List<Postitions> moveofpersonnelajax(int depid) throws Exception{
        List<Postitions> postitions=postitionesService.getPostitionsbydeid(depid);
        return postitions;
    }
    @RequestMapping("replace.do")
    public String replace(HttpSession session,HttpServletRequest request) throws Exception{
        int dep= Integer.parseInt(request.getParameter("depid"));
        int pos= Integer.parseInt(request.getParameter("posid"));
        int eid= Integer.parseInt(request.getParameter("eid"));
        Employee employee=employeeService.getEmployeeByid(eid);
        System.out.println(employee);
        Postitions postition=postitionesService.getPostitonsByuid(employee.getUser().getU_id());
        User user=new User();
        user.setU_id(0);
        postition.setUser(user);
        Employee employee1=new Employee();
        employee1.setE_id(0);
        postition.setEmployee(employee1);
        postitionesService.updatePostitionsByuande(postition);
        Postitions postition1=postitionesService.getPostitionsbyid(pos);
        postition1.setEmployee(employee);
        postition1.setUser(employee.getUser());
        postitionesService.updatePostitionsByuande(postition1);
        return "";
    }
}

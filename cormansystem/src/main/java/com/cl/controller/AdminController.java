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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
   @Autowired
   private AttendanceService attendanceService;
   @Autowired
   private WageService wageService;
   @Autowired
   private DissentService dissentService;
   @Autowired
   private ResumeService resumeService;
    @RequestMapping("adminsaveresume.do")
    public String adminsaveresume(HttpSession session) throws Exception{
        List<Delivery> deliveries=deliveryService.getDelivery();
         if (deliveries!=null&&deliveries.size()!=0){//消除已经同意和回绝的简历
             List<Delivery> deliveries1=new ArrayList<>();
             for (Delivery delivery:deliveries){
                 if (delivery.getDe_state().equals("已录用")||delivery.getDe_state().equals("已回绝")){
                 }else {
                     deliveries1.add(delivery);
                 }
             }
             if (deliveries1.size()==0){
                 String prompt="暂时无人投递简历";
                 session.setAttribute("prompt",prompt);
                 return "promptinterface";
             }
             session.setAttribute("delivery",deliveries1);
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
            Recruitment recruitment=delivery1.getRecruitment();
            recruitmentService.deleteRecruitment(recruitment);
            Postitions postitions=new Postitions();
            postitions.setUser(delivery1.getUser());
            postitions.setP_position(delivery1.getRecruitment().getR_job());
            delivery.setDe_state("已录用");
            User user=userService.getUserByid(delivery1.getUser().getU_id());
            user.setAuthority(2);
            userService.updateUser(user);
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
            delivery.setDe_state("已回绝");
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
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
        employee.setDate(sdf.format(employee.getE_createtime()));
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
            } else  if (recruitmentService.getRecruitmentByjob(postitions1.getP_position())!=null){
                String prompt="该部门下有职位的招聘信息，请先删除掉招聘信息";
                session.setAttribute("prompt",prompt);
                return "promptinterface";//跳转到提示有招聘信息没有删除
            }else {
                postitionesService.deletePostitions(postitions1);
            }
        }
        departmentService.deleteDepartment(department);
        return savedepartment(session);
    }
    @RequestMapping("deletepos.do")
    public String deletepos(HttpServletRequest request,HttpSession session)throws Exception{
        int id= Integer.parseInt(request.getParameter("id"));
        Postitions postitions=postitionesService.getPostitionsbyid(id);
        if (recruitmentService.getRecruitmentByjob(postitions.getP_position())!=null){
            String prompt="该职位的招聘信息，请先删除掉招聘信息";
            session.setAttribute("prompt",prompt);
            return "promptinterface";//跳转到提示有招聘信息没有删除
        }
        postitionesService.deletePostitions(postitions);
        return savedepartment(session);
    }
    @RequestMapping("adsavetrain.do")//管理员查询培训信息
    public String adsavetrain(HttpSession session) throws Exception{
       List<Train> trains=trainService.getTrains();
       if (trains!=null&&trains.size()!=0){
           session.setAttribute("trains",trains);
           return "adsavetrains";
       }
        String prompt="目前没有培训信息";
        session.setAttribute("prompt",prompt);
        return "promptinterface";//返回一个爆空页面让其添加
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
            String prompt="您输入的部门不存在，无法添加培训内容";
            session.setAttribute("prompt",prompt);
            return "promptinterface";//提示部门不存在
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
    @RequestMapping("deletetrain.do")
    public String deletetrain(HttpSession session,HttpServletRequest request) throws Exception{
        int id= Integer.parseInt(request.getParameter("id"));
        Train train=trainService.getTrainByid(id);
        trainService.deleteTrain(train);
        return adsavetrain(session);
    }
    @RequestMapping("adsavereandpun.do")//查看奖惩
    public String adsavereandpun(HttpSession session,HttpServletRequest request)throws Exception{
        int id= Integer.parseInt(request.getParameter("id"));
        List<Reandpun> reandpuns=reandpunService.getReandpunByuid(id);
        List<Reandpun> reandpuns1=new ArrayList<>();
        if (reandpuns!=null&&reandpuns.size()!=0){
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
            for (Reandpun reandpun:reandpuns){
                if (reandpun.getRe_state().equals("未结算")){
                    reandpun.setDate(sdf.format(reandpun.getRe_date()));
                    reandpuns1.add(reandpun);
                }
            }
            session.setAttribute("reandpuns",reandpuns1);
            return "adsavereandpun";
        }else {
            String prompt="目前没有奖惩记录";
            session.setAttribute("prompt",prompt);
            return "promptinterface";//返回提示空界面
        }
    }
    @RequestMapping("adsavereandpun1.do")
    public String adsavereandpun1(HttpSession session,HttpServletRequest request)throws Exception{
        int id= Integer.parseInt(request.getParameter("id"));
        List<Reandpun> reandpuns=reandpunService.getReandpunByuid(id);
        List<Reandpun> reandpuns1=new ArrayList<>();
        if (reandpuns!=null&&reandpuns.size()!=0){
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
            for (Reandpun reandpun:reandpuns){
                if (reandpun.getRe_state().equals("已结算")){
                    reandpun.setDate(sdf.format(reandpun.getRe_date()));
                    reandpuns1.add(reandpun);
                }
            }
            session.setAttribute("reandpuns",reandpuns1);
            return "adsavereandpun";
        }else {
            String prompt="目前没有奖惩记录";
            session.setAttribute("prompt",prompt);
            return "promptinterface";//返回提示空界面
        }
    }

    @RequestMapping("adaddreandpun.do")//增加奖惩
    public String adaddreandpun(HttpSession session, HttpServletRequest request)throws Exception{
        String i= request.getParameter("name");
        if (i==null){
            return "addreandpun";
        }
        int num= Integer.parseInt(i);
        int money= Integer.parseInt(request.getParameter("money"));
        String ename=request.getParameter("ename");
        String postitions=request.getParameter("postition");
        String explanation=request.getParameter("explanation");
        Postitions postitions1=postitionesService.getPostitonsByname(postitions);
        Date date=new Date();
        if (postitions1.getEmployee().getE_name().equals(ename)){
            Reandpun reandpun=new Reandpun();
            if (num==1){
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
            return adsavereandpun(session,request);
        }
        String prompt="您输入的职位或者人员不存在，请检查后重新输入";
        session.setAttribute("prompt",prompt);
        return "promptinterface";
    }
    @RequestMapping("updatereandpun.do")//跳转修改奖惩页面
    public String updatereandpun(HttpSession session,HttpServletRequest request)throws Exception{
        int id= Integer.parseInt(request.getParameter("id"));
        Reandpun reandpun=reandpunService.getReandpunByid(id);
        if (reandpun.getRe_state().equals("未结算")){
            session.setAttribute("reandpun",reandpun);
            return "updatereandpun";
        }else {
            String prompt="已经结算奖惩，无法进行修改";
            session.setAttribute("prompt",prompt);
            return "promptinterface";//返回无法修改界面
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
        return adsavereandpun(session,request);
    }
    @RequestMapping("adminsaverecrui.do")
    public String adminsaverecrui(HttpSession session) throws Exception{
        List<Recruitment> recruitments=recruitmentService.getRecruitment();
        if (recruitments!=null&&recruitments.size()!=0){
            SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
            for (Recruitment recruitment:recruitments){
                recruitment.setCreatetime(sdf1.format(recruitment.getR_createtime()));
            }
            session.setAttribute("recruitments",recruitments);
            return "adminsaverecrui";
        }
        String prompt="暂时没有招聘信息";
        session.setAttribute("prompt",prompt);
        return "promptinterface";
    }
    @RequestMapping("addrecruiment.do")
    public String addrecruiment(HttpSession session,Recruitment recruitment) throws Exception{
        Date date=new Date();
        Postitions postitions=
                postitionesService.getPostitonsBynamenoemploy(recruitment.getR_job());
        if (postitions!=null){
            recruitment.setR_wage(postitions.getP_wage());
            recruitment.setR_createtime(date);
            recruitment.setR_state("未招满");
            recruitmentService.addRecruitment(recruitment);
            return adminsaverecrui(session);
        }else {
            String prompt="招聘的职位暂时没有添加，请先添加职位信息";
            session.setAttribute("prompt",prompt);
            return "promptinterface";//提示没有该职位请先添加该职位
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
        Postitions postitions=postitionesService.getPostitionsbyid(pos);
        if (postitions.getEmployee().getE_name().equals("无人任职")){
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
            return savedepartment(session);
        }
        String prompt="该职位目前有人无法进行换岗操作";
        session.setAttribute("prompt",prompt);
        return "promptinterface";
    }
    @RequestMapping("saveatt.do")
    public String  saveatt(HttpSession session,HttpServletRequest request) throws Exception{
        int num= Integer.parseInt(request.getParameter("num"));
        int id= Integer.parseInt(request.getParameter("id"));
        Employee employee=employeeService.getEmployeeByid(id);
        session.setAttribute("employee",employee);
        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH)+1;
        List<Attendance> attendances=attendanceService.getAttendance(year,month,employee.getUser().getU_id());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
        int i=(num-1)*5;
        List<Attendance> attendances1=new ArrayList<>();
            for (Attendance attendance:attendances){
                if (attendance.getA_offtime()!=null){
                    attendance.setOfftime(sdf.format(attendance.getA_offtime()));
                }

                if (attendance.getA_starttime()!=null){
                    attendance.setStarttime(sdf.format(attendance.getA_starttime()));
                }
                if (attendance.getA_date()!=null){
                    attendance.setDate(sdf.format(attendance.getA_date()));
                }

            }
            session.setAttribute("lsitatt",attendances);
            if (attendances.size()-(num*5)>=0){
                for (;i<num*5;i++){
                    attendances1.add(attendances.get(i));
                }
            }else {
                for (;i<attendances.size();i++){
                    attendances1.add(attendances.get(i));
                }
            }
        session.setAttribute("attendances",attendances1);
        List years=new ArrayList();
        for (int x=0;x<20;x++){
            years.add(year);
            year=year-1;
        }
        int lenth=attendances.size()/5;
        if (attendances.size()%5!=0){
            lenth=lenth+1;
        }
        List lenths=new ArrayList();
        for (int y=1;y<=lenth;y++){
            lenths.add(y);
        }
        session.setAttribute("sizes",lenths);
        session.setAttribute("years",years);
        return "adsaveatt";
    }
    @RequestMapping("saveatt2.do")
    public String saveatt2(HttpServletRequest request,HttpSession session)throws Exception{
        List<Attendance> attendances= (List<Attendance>) session.getAttribute("lsitatt");
        int num= Integer.parseInt(request.getParameter("num"));
        int i=(num-1)*5;
        List<Attendance> attendances1=new ArrayList<>();
        session.setAttribute("lsitatt",attendances);
        if (attendances.size()-(num*5)>=0){
            for (;i<num*5;i++){
                attendances1.add(attendances.get(i));
            }
        }else {
            for (;i<attendances.size();i++){
                attendances1.add(attendances.get(i));
            }
        }
        session.setAttribute("attendances",attendances1);
        int lenth=attendances.size()/5;
        if (attendances.size()%5!=0){
            lenth=lenth+1;
        }
        List lenths=new ArrayList();
        for (int y=1;y<=lenth;y++){
            lenths.add(y);
        }
        session.setAttribute("sizes",lenths);
        return "adsaveatt";
    }
    @RequestMapping("saveatt1.do")
    public String saveattendance1(HttpSession session,int year,int month,HttpServletRequest request) throws Exception{
        Employee employee= (Employee) session.getAttribute("employee");
        List<Attendance> attendances=attendanceService.getAttendance(year,month,employee.getE_id());
        session.setAttribute("lsitatt",attendances);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        for (Attendance attendance:attendances){
            if (attendance.getA_date()!=null){
                attendance.setDate(sdf1.format(attendance.getA_date()));
            }
            if (attendance.getA_offtime()!=null){
                attendance.setOfftime(sdf.format(attendance.getA_offtime()));
            }
            if (attendance.getA_starttime()!=null){
                attendance.setStarttime(sdf.format(attendance.getA_starttime()));
            }
        }
        int num= Integer.parseInt(request.getParameter("num"));
        int i=(num-1)*5;
        List<Attendance> attendances1=new ArrayList<>();
        if (attendances.size()-(num*5)>=0){
            for (;i<num*5;i++){
                attendances1.add(attendances.get(i));
            }
        }else {
            for (;i<attendances.size();i++){
                attendances1.add(attendances.get(i));
            }
        }
        session.setAttribute("attendances",attendances1);
        int lenth=attendances.size()/5;
        if (attendances.size()%5!=0){
            lenth=lenth+1;
        }
        List lenths=new ArrayList();
        for (int y=1;y<=lenth;y++){
            lenths.add(y);
        }
        session.setAttribute("sizes",lenths);
        return "adsaveatt";
    }
    @RequestMapping("upemployee.do")//员工升职，辞退操作
    public String upemployee(HttpSession session,HttpServletRequest request) throws Exception {
        int id= Integer.parseInt(request.getParameter("id"));
        Employee employee=employeeService.getEmployeeByid(id);
        if (employee.getE_state().equals("实习")){
            employee.setE_state("正式工");
            employeeService.updateEmployeebystate(employee);
        }else if (employee.getE_state().equals("正式工")){
            employee.setE_state("已辞退");
            List<Reandpun> reandpun=reandpunService.getReandpunByeid(id);
            for (Reandpun reandpun1:reandpun){
                reandpun1.setRe_state("已辞退");
                reandpunService.updateReandpunBystate(reandpun1);//修改掉奖惩记录
            }
            List<Dissent> dissents=dissentService.getDissentbyeid(id);
            for (Dissent dissent:dissents){
                dissent.setD_state("已辞退");
               dissentService.updateDissent(dissent);//修改掉奖惩异议记录
            }
            User user1=employee.getUser();
            user1.setAuthority(1);
            Delivery delivery=new Delivery();
            delivery.setUser(user1);
            delivery.setDe_state("已辞退");
            deliveryService.updateDelivery(delivery);//删除投递记录
            userService.updateUser(user1);//修改账号权限
            User user=new User();
            user.setU_id(-1);
            Postitions postitions=postitionesService.getPostitonsByuid(employee.getUser().getU_id());
            Employee employee1=new Employee();
            employee1.setE_id(0);
            postitions.setEmployee(employee1);
            User user2=new User();
            user2.setU_id(0);
            postitions.setUser(user2);
            postitionesService.updatePostitions(postitions);//消除职位信息
            employee.setUser(user);
            employeeService.updateEmployeebystate(employee);//消除账号和员工表的联系
        }
        return savedepartment(session);
    }
    @RequestMapping("settwage.do")//工资结算
    public String settwage(HttpSession session,HttpServletRequest request) throws Exception{
        int id= Integer.parseInt(request.getParameter("id"));
        Employee employee=employeeService.getEmployeeByid(id);//查询出要统计薪资的人
        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);//获取上个月的年月
        Wage wages=wageService.getWage(year,month,id);
        if (wages!=null){
            String prompt="上个月工资已经结算，可以进查询页面查看";
            session.setAttribute("prompt",prompt);
            return "promptinterface";
        }
        if (month==0){
            month=12;
        }//当前月份为1的时候，取得的月份为0，转换成12月份
        List<Reandpun> reandpuns=reandpunService.getReandpunBydate(year,month,id);
        int num=0;
        for (Reandpun reandpun:reandpuns){
            if (reandpun.getRe_state().equals("未结算")){
                num=num+reandpun.getRe_reward()-reandpun.getRe_punishment();
            }
        }
        List<Attendance> attendances=attendanceService.getAttendance(year,month,id);//统计考勤超过22天 算加班，没过22天算缺勤
        int days=0;
        for (Attendance attendance:attendances){
            if (attendance.getA_offtime()!=null){
               days=days+1;
            }
        }
        cal.setTime(employee.getE_createtime());
        int year1=cal.get(Calendar.YEAR);
        int month1=cal.get(Calendar.MONTH);
        if (year==year1&&month==month1){//比较入职时间，确保上个月员工是否在职
            String prompt="该员工上个月还没有入职，无法结算";
            session.setAttribute("prompt",prompt);
            return "promptinterface";
        }
        Postitions postitions=postitionesService.getPostitonsByuid(id);
        int num1=(days-22)*(postitions.getP_wage()/22);
        session.setAttribute("num1",num1);
        Wage wage=new Wage();
        wage.setW_reandpun(num+num1);
        wage.setEmployee(employee);
        wage.setW_bawage(postitions.getP_wage());
        wage.setW_social(postitions.getP_wage()*0.15);
        wage.setW_year(year);
        wage.setW_month(month);
        session.setAttribute("wage",wage);
        return "settwage";
    }
    @RequestMapping("settwage1.do")
    public String settwage1(HttpSession session,HttpServletRequest request) throws Exception{
        int performance= Integer.parseInt(request.getParameter("w_performance"));
        Wage wage= (Wage) session.getAttribute("wage");
        wage.setW_performance(performance);
        int num= (int) session.getAttribute("num1");
        Reandpun reandpun1=new Reandpun();
        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH)+1;//获取上个月的年月
        Date date=new Date();
        if (num<0){
            reandpun1.setRe_reward(0);
            reandpun1.setRe_punishment(-num);
            reandpun1.setRe_state("已结算");
            reandpun1.setRe_month(month);
            reandpun1.setRe_year(year);
            reandpun1.setRe_explanation("上月打卡没有满22天");
            reandpun1.setEmployee(wage.getEmployee());
            reandpun1.setRe_date(date);
            reandpunService.addReandpun(reandpun1);
        }else if (num>0){
            reandpun1.setRe_reward(num);
            reandpun1.setRe_punishment(0);
            reandpun1.setRe_state("已结算");
            reandpun1.setRe_month(month);
            reandpun1.setRe_year(year);
            reandpun1.setRe_explanation("上月打卡超过22天计算加班");
            reandpun1.setEmployee(wage.getEmployee());
            reandpun1.setRe_date(date);
            reandpunService.addReandpun(reandpun1);
        }
        List<Reandpun> reandpuns=reandpunService.getReandpunBydate(wage.getW_year(),wage.getW_month(),wage.getEmployee().getE_id());
        for (Reandpun reandpun:reandpuns){
            if (reandpun.getRe_state().equals("有异议")){
                String prompt="该员工对奖惩信息有异议，请先处理";
                session.setAttribute("prompt",prompt);
                return "promptinterface";
            }
            reandpun.setRe_state("已结算");
            reandpunService.updateReandpunBystate(reandpun);
        }
        double wages=wage.getW_bawage()+wage.getW_performance()+wage.getW_reandpun()-wage.getW_social();
        wage.setW_wages(wages);
        wageService.addWage(wage);
        String prompt="已结算完成，可以到员工信息中查询";
        session.setAttribute("prompt",prompt);
        return "promptinterface";
    }
    @RequestMapping("savewage.do")
    public  String savewage(HttpSession session,HttpServletRequest request) throws Exception{
        int id= Integer.parseInt(request.getParameter("id"));
        List<Wage> wage=wageService.getWageByuid(id);
        session.setAttribute("wage",wage);
        return "adsavewage";
    }
    @RequestMapping("adsavedissents.do")//查看奖惩
    public String adsavedissents(HttpSession session) throws Exception{
        List<Dissent> dissents=dissentService.getDissents();
        List<Dissent> dissents1=new ArrayList<>();
        session.setAttribute("state",1);
        if(dissents.size()!=0&&dissents!=null){
            SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
            for (Dissent dissent:dissents){
                dissent.getReandpun().setDate(sdf1.format(dissent.getReandpun().getRe_date()));
                if (dissent.getD_state().equals("已辞退")){

                }else if (dissent.getD_state().equals("未解决")){
                    dissents1.add(dissent);
                }
            }
            session.setAttribute("dissents",dissents1);
            return "adsavedissents";
        }
        String prompt="目前没有提交的疑问";
        session.setAttribute("prompt",prompt);
        return "promptinterface";
    }
    @RequestMapping("adsavedissents1.do")//查看奖惩
    public String adsavedissents1(HttpSession session) throws Exception{
        List<Dissent> dissents=dissentService.getDissents();
        List<Dissent> dissents1=new ArrayList<>();
        session.setAttribute("state",2);
        if(dissents.size()!=0&&dissents!=null){
            SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
            for (Dissent dissent:dissents){
                dissent.getReandpun().setDate(sdf1.format(dissent.getReandpun().getRe_date()));
                if (dissent.getD_state().equals("已辞退")){

                }else if (dissent.getD_state().equals("已解决")){
                    dissents1.add(dissent);
                }
            }
            session.setAttribute("dissents",dissents1);
            return "adsavedissents";
        }
        String prompt="目前没有提交的疑问";
        session.setAttribute("prompt",prompt);
        return "promptinterface";
    }
    @RequestMapping("updatedissents.do")
    public String updatedissents(HttpSession session,HttpServletRequest request) throws Exception{
        int num= Integer.parseInt(request.getParameter("num"));
        int id= Integer.parseInt(request.getParameter("id"));
        Dissent dissent=dissentService.getDissentByid(id);
        Reandpun reandpun=dissent.getReandpun();
        if (num==1){
            dissent.setD_state("已解决");
            dissentService.updateDissent(dissent);
            reandpun.setRe_state("已作废");
            reandpunService.updateReandpunBystate(reandpun);//同意解决，奖励做删除处理
            return adsavedissents(session);
        }else {
            reandpun.setRe_state("未结算");
            dissent.setD_state("驳回");
            reandpunService.updateReandpunBystate(reandpun);
            dissentService.updateDissent(dissent);
            return adsavedissents(session);
        }
    }
}

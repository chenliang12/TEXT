package com.cl.controller;

import com.cl.biz.*;
import com.cl.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    @Autowired
    private ReandpunService reandpunService;
    @Autowired
    private AttendanceService attendanceService;
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
        List<Department> department=departmentService.getDepartment();
        if (department!=null&&department.size()!=0){
            int size=department.size();
            session.setAttribute("size",size);
            session.setAttribute("department",department);
            return "emsavedep";
        }
        String prompt="目前公司还没有创建部门";
        session.setAttribute("prompt",prompt);
        return "promptinterface";//返回一个错误界面
    }
    @RequestMapping("saveempes.do")//员工查询职位信息
    public String saveempes(HttpSession session,HttpServletRequest request)throws Exception{
        int id= Integer.parseInt(request.getParameter("id"));
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
            session.setAttribute("did",id);
            return "emsavepos";
        }
        String prompt="目前该部门还没有创建职位";
        session.setAttribute("prompt",prompt);
        return "promptinterface";//返回一个没有职位的显示网址
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
       if (train!=null&&train.size()!=0){
           session.setAttribute("trains",train);
           return "emsavetrains";
       }else {
           String prompt="目前暂无培训内容";
           session.setAttribute("prompt",prompt);
           return "promptinterface";//返回提示暂无培训内容
       }
    }
    @RequestMapping("emsavereandpun.do")
    public String emsavereandpun(HttpSession session)throws Exception{
        User user= (User) session.getAttribute("user");
        Employee employee=employeeService.getEmployeeByuid(user.getU_id());
        List<Reandpun> reandpun=reandpunService.getReandpunByuid(employee.getE_id());
        if (reandpun!=null&&reandpun.size()!=0){
            session.setAttribute("reandpuns",reandpun);
            return "emsavereandpun";
        }
        String prompt="目前暂无奖惩记录";
        session.setAttribute("prompt",prompt);
        return "promptinterface";//返回空
    }
    @RequestMapping("statetime.do")
    public String statetime(HttpSession session)throws Exception{
        User user= (User) session.getAttribute("user");
        Attendance attendance=new Attendance();
        Employee employee=employeeService.getEmployeeByuid(user.getU_id());
        Reandpun reandpun=new Reandpun();
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        String time=sdf1.format(date)+"09:00";//定的上班时间
        Date date1=sdf.parse(time);
        String time1=sdf1.format(date);//打卡当时的日期
        Date date2=sdf1.parse(time1);
        attendance.setA_date(date2);//存入打开的日期
        attendance.setUser(user);
        Attendance attendance1=attendanceService.getAttendanceByuidanddate(user.getU_id(),date2);
        if (attendance1==null){
            attendance.setA_starttime(date);//存入打卡的具体时间
            if (date.getTime()-date1.getTime()>600000){
                attendance.setA_state("矿工");//打卡状态
                reandpun.setRe_punishment(200);
                reandpun.setRe_date(date2);
                reandpun.setRe_reward(0);
                reandpun.setRe_state("未结算");
                reandpun.setRe_explanation("上班迟到10分钟以上");
                reandpun.setEmployee(employee);
                reandpunService.addReandpun(reandpun);//增加惩罚
                attendanceService.addAttendance(attendance);//添加当天打卡时间
                return""; //跳转提示已经计算矿工
            }else if(date.getTime()-date1.getTime()>0){
                attendance.setA_state("迟到");//打卡状态
                reandpun.setRe_punishment(20);
                reandpun.setRe_date(date2);
                reandpun.setRe_reward(0);
                reandpun.setRe_state("未结算");
                reandpun.setRe_explanation("上班迟到");
                reandpun.setEmployee(employee);
                reandpunService.addReandpun(reandpun);//增加惩罚
                attendanceService.addAttendance(attendance);//添加当天打卡时间
                return""; //跳转提示已经计算迟到
            }else {
                attendance.setA_state("正常");//打卡状态
                attendanceService.addAttendance(attendance);//添加当天打卡时间
                return""; //跳转提示恭喜成功打卡
            }
        }else {
            return "";//跳转已经打过上班卡了
        }
    }
    @RequestMapping("offtime.do")
    public String offtime(HttpSession session) throws Exception{
        User user= (User) session.getAttribute("user");
        Attendance attendance=new Attendance();
        Employee employee=employeeService.getEmployeeByuid(user.getU_id());
        Reandpun reandpun=new Reandpun();
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        String time=sdf1.format(date)+"18:00";//定的下班时间
        Date date1=sdf.parse(time);
        String time1=sdf1.format(date);//打卡当时的日期
        Date date2=sdf1.parse(time1);
        attendance.setA_date(date2);//存入打开的日期
        attendance.setUser(user);
        Attendance attendance1=attendanceService.getAttendanceByuidanddate(user.getU_id(),date2);
        if (attendance1!=null&&attendance1.getA_offtime()==null){//检测是否打了上班卡
            attendance1.setA_offtime(date);//存入打卡的具体时间
            if (date1.getTime()-date.getTime()>600000){//检测是否提前10分钟之前下的班
                if (attendance1.getA_state().equals("迟到")){//如果白天已经记了迟到，修改惩罚表状态
                    reandpun.setEmployee(employee);
                    reandpun.setRe_date(date2);
                    reandpun.setRe_explanation("上班迟到");
                    Reandpun reandpun1=reandpunService.getReanddpunByatt(reandpun);
                    reandpun1.setRe_explanation("提前10分钟以上下班，记旷工");
                    reandpun1.setRe_punishment(200);
                }else if (attendance1.getA_state().equals("正常")){
                    reandpun.setEmployee(employee);
                    reandpun.setRe_date(date2);
                    reandpun.setRe_punishment(200);
                }
                attendance1.setA_state("矿工");//打卡状态
                reandpunService.updateReandpunByexpl(reandpun);
                attendanceService.updateAttendance(attendance);//添加当天打卡时间
                return""; //跳转提示已经计算矿工
            }else if(date1.getTime()-date.getTime()>0){
                if (attendance1.getA_state().equals("迟到")){//如果白天已经记了迟到，修改惩罚表状态
                    attendance1.setA_state("矿工");//打卡状态
                    reandpun.setEmployee(employee);
                    reandpun.setRe_date(date2);
                    reandpun.setRe_explanation("上班迟到");
                    Reandpun reandpun1=reandpunService.getReanddpunByatt(reandpun);
                    reandpun1.setRe_explanation("迟到+早退，记旷工");
                    reandpun1.setRe_punishment(200);
                }else if (attendance1.getA_state().equals("正常")){
                    attendance1.setA_state("早退");//打卡状态
                    reandpun.setEmployee(employee);
                    reandpun.setRe_date(date2);
                    reandpun.setRe_punishment(20);
                }
                reandpunService.updateReandpunByexpl(reandpun);
                attendanceService.updateAttendance(attendance);//添加当天打卡时间
                return""; //跳转提示已经计算矿工
            }else {
                attendance.setA_state("正常");//打卡状态
                attendanceService.updateAttendance(attendance);//添加当天打卡时间
                return""; //跳转提示恭喜成功打卡
            }
        }else if (attendance1==null){
            return "";//跳转上班卡没有打
        }else {
            return "";//跳转提示下班卡已经打过了
        }
    }
}

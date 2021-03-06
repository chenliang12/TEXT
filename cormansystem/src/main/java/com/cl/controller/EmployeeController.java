package com.cl.controller;

import com.cl.biz.*;
import com.cl.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    @Autowired
    private WageService wageService;
    @Autowired
    private DissentService dissentService;
    @RequestMapping("login.do")//登陆
    public String loginsession(User user,HttpServletRequest request)throws  Exception{
        HttpSession session=request.getSession();
        if (userService.getUser(user)!=null){
           User user1=userService.getUser(user);
           if (user1.getAuthority()==1){
               session.setAttribute("user",user1);
               SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd ");
               List<Recruitment> recruitments=recruitmentService.getRecruitment();
               for(Recruitment recruitment:recruitments){
                   recruitment.setCreatetime(sdf.format(recruitment.getR_createtime()));
               }
               session.setAttribute("touristr",2);
               session.setAttribute("recruitments",recruitments);
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
    public  String adduser(User user,HttpServletRequest request)throws Exception{
        String name=request.getParameter("name");
        user.setUname(name);
        if (userService.getUserbyname(user.getUname())==null){
            user.setAuthority(1);
            userService.addUser(user);
            return "../../index";
        }else {
            return "adduser";
        }
    }
    @RequestMapping("checknames.do")//注册账号验证ajax
    public  @ResponseBody int checkname(String name, HttpServletResponse response)throws Exception{
        if (userService.getUserbyname(name)!=null){
            return 1;
        }else {
           return 2;
        }
    }
    @RequestMapping("saveemploy.do")
    public String saveemploy(HttpSession session) throws Exception{
        User user= (User) session.getAttribute("user");
        Employee employee=employeeService.getEmployeeByuid(user.getU_id());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
        employee.setDate(sdf.format(employee.getE_createtime()));
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
        return "empromptinterface";//返回一个错误界面
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
        return "empromptinterface";//返回一个没有职位的显示网址
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
           return "empromptinterface";//返回提示暂无培训内容
       }
    }
    @RequestMapping("emsavereandpun.do")
    public String emsavereandpun(HttpSession session)throws Exception{
        User user= (User) session.getAttribute("user");
        Employee employee=employeeService.getEmployeeByuid(user.getU_id());
        List<Reandpun> reandpun=reandpunService.getReandpunByuid(employee.getE_id());
        if (reandpun!=null&&reandpun.size()!=0){
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
            for (Reandpun reandpun1:reandpun){
                String time=sdf.format(reandpun1.getRe_date());
                reandpun1.setDate(time);
            }
            session.setAttribute("reandpuns",reandpun);
            return "emsavereandpun";
        }
        String prompt="目前暂无奖惩记录";
        session.setAttribute("prompt",prompt);
        return "empromptinterface";//返回空
    }
    @RequestMapping("statetime.do")
    public String statetime(HttpSession session)throws Exception{
        User user= (User) session.getAttribute("user");
        Attendance attendance=new Attendance();
        Employee employee=employeeService.getEmployeeByuid(user.getU_id());
        Reandpun reandpun=new Reandpun();
        Date date=new Date();
        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);//获取年份
        int month=cal.get(Calendar.MONTH)+1;//获取月份
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        String time=sdf1.format(date)+" 09:00";//定的上班时间
        Date date1=sdf.parse(time);
        String time1=sdf1.format(date);//打卡当时的日期
        Date date2=sdf1.parse(time1);
        attendance.setA_date(date2);//存入打开的日期
        attendance.setEmployee(employee);
        Attendance attendance1=attendanceService.getAttendanceByuidanddate(employee.getE_id(),date2);
        if (attendance1==null){
            attendance.setA_starttime(date);//存入打卡的具体时间
            attendance.setA_year(year);
            attendance.setA_month(month);
            if (date.getTime()-date1.getTime()>600000){
                attendance.setA_state("矿工");//打卡状态
                reandpun.setRe_punishment(200);
                reandpun.setRe_date(date2);
                reandpun.setRe_reward(0);
                reandpun.setRe_state("未结算");
                reandpun.setRe_explanation("上班迟到10分钟以上");
                reandpun.setEmployee(employee);
                reandpun.setRe_year(year);
                reandpun.setRe_month(month);
                reandpunService.addReandpun(reandpun);//增加惩罚
                attendanceService.addAttendance(attendance);//添加当天打卡时间
                String prompt="您已迟到10分钟以上，记为旷工，如有疑问请联系管理员";
                session.setAttribute("prompt",prompt);
                return "empromptinterface"; //跳转提示已经计算矿工
            }else if(date.getTime()-date1.getTime()>0){
                attendance.setA_state("迟到");//打卡状态
                reandpun.setRe_punishment(20);
                reandpun.setRe_date(date2);
                reandpun.setRe_reward(0);
                reandpun.setRe_state("未结算");
                reandpun.setRe_explanation("上班迟到");
                reandpun.setEmployee(employee);
                reandpun.setRe_year(year);
                reandpun.setRe_month(month);
                reandpunService.addReandpun(reandpun);//增加惩罚
                attendanceService.addAttendance(attendance);//添加当天打卡时间
                String prompt="您已迟到，如有疑问请联系管理员";
                session.setAttribute("prompt",prompt);
                return "empromptinterface"; //跳转提示已经计算迟到
            }else {
                attendance.setA_state("正常");//打卡状态
                attendanceService.addAttendance(attendance);//添加当天打卡时间
                String prompt="恭喜您成功签到";
                session.setAttribute("prompt",prompt);
                return "empromptinterface"; //跳转提示恭喜成功打卡
            }
        }else {
            String prompt="您当日已经签过到了，请忽重复签到";
            session.setAttribute("prompt",prompt);
            return "empromptinterface";//跳转已经打过上班卡了
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
        String time=sdf1.format(date)+" 18:00";//定的下班时间
        Date date1=sdf.parse(time);
        String time1=sdf1.format(date);//打卡当时的日期
        Date date2=sdf1.parse(time1);
        attendance.setA_date(date2);//存入打开的日期
        attendance.setEmployee(employee);
        Attendance attendance1=attendanceService.getAttendanceByuidanddate(employee.getE_id(),date2);
        if (attendance1!=null&&attendance1.getA_offtime()==null){//检测是否打了上班卡
            attendance1.setA_offtime(date);//存入打卡的具体时间
            if (date1.getTime()-date.getTime()>600000){//检测是否提前10分钟之前下的班
                if (attendance1.getA_state().equals("正常")){
                    reandpun.setEmployee(employee);
                    reandpun.setRe_date(date2);
                    reandpun.setRe_punishment(200);
                    reandpun.setRe_reward(0);
                    reandpun.setRe_state("未结算");
                    reandpun.setRe_explanation("提前10分钟以上下班，记旷工");
                    reandpun.setRe_year(attendance1.getA_year());
                    reandpun.setRe_month(attendance1.getA_month());
                    reandpunService.addReandpun(reandpun);
                } else {//如果白天已经记了迟到，修改惩罚表状态
                    reandpun.setEmployee(employee);
                    reandpun.setRe_date(date2);
                    reandpun.setRe_explanation("上班迟到");
                    Reandpun reandpun1=reandpunService.getReanddpunByatt(reandpun);
                    if (reandpun1==null){
                        reandpun.setRe_explanation("上班迟到10分钟以上");
                        reandpun1=reandpunService.getReanddpunByatt(reandpun);
                        reandpun1.setRe_explanation("上下班打卡均超时10分钟，记旷工");
                        reandpun1.setRe_punishment(200);
                        reandpunService.updateReandpunByexpl(reandpun1);
                    }else {
                        reandpun1.setRe_explanation("提前10分钟以上下班，记旷工");
                        reandpun1.setRe_punishment(200);
                        reandpunService.updateReandpunByexpl(reandpun1);
                    }
                }
                attendance1.setA_state("矿工");//打卡状态
                attendanceService.updateAttendance(attendance1);//添加当天打卡时间
                String prompt="您早退10分钟以上，记为旷工，如有疑问请联系管理员";
                session.setAttribute("prompt",prompt);
                return "empromptinterface"; //跳转提示已经计算矿工
            }else if(date1.getTime()-date.getTime()>0){
                if(attendance1.getA_state().equals("正常")) {
                    attendance1.setA_state("早退");//打卡状态
                    reandpun.setEmployee(employee);
                    reandpun.setRe_date(date2);
                    reandpun.setRe_punishment(20);
                    reandpun.setRe_reward(0);
                    reandpun.setRe_explanation("早退");
                    reandpun.setRe_year(attendance1.getA_year());
                    reandpun.setRe_month(attendance1.getA_month());
                    reandpunService.addReandpun(reandpun);
                    attendanceService.updateAttendance(attendance1);
                    String prompt="您早退打卡，如有疑问请联系管理员";
                    session.setAttribute("prompt",prompt);
                    return "empromptinterface";
                }else {//如果白天已经记了迟到，修改惩罚表状态
                    attendance1.setA_state("矿工");//打卡状态
                    reandpun.setEmployee(employee);
                    reandpun.setRe_date(date2);
                    reandpun.setRe_explanation("上班迟到");
                    Reandpun reandpun1=reandpunService.getReanddpunByatt(reandpun);
                    if (reandpun1==null){
                        reandpun.setRe_explanation("上班迟到10分钟以上");
                        reandpun1=reandpunService.getReanddpunByatt(reandpun);
                        reandpun1.setRe_explanation("迟到+早退，记旷工");
                        reandpun1.setRe_punishment(200);
                        reandpunService.updateReandpunByexpl(reandpun1);
                    }else {
                        reandpun1.setRe_explanation("提前10分钟以上下班，记旷工");
                        reandpun1.setRe_punishment(200);
                        reandpunService.updateReandpunByexpl(reandpun1);
                    }
                }
                    attendanceService.updateAttendance(attendance1);
                    String prompt="您早退，加上白天迟到，已经记为矿工，如有疑问请联系管理员";
                    session.setAttribute("prompt",prompt);
                    return "empromptinterface";
            }else if (date.getTime()-date1.getTime()>3600000){
                if(attendance1.getA_state().equals("正常")) {
                    attendance1.setA_state("加班");//打卡状态
                    reandpun.setEmployee(employee);
                    reandpun.setRe_date(date2);
                    int t= (int) (date.getTime()-date1.getTime());
                    int num=t/3600000;
                    reandpun.setRe_punishment(0);
                    reandpun.setRe_reward(20*num);
                    reandpun.setRe_explanation("加班");
                    reandpun.setRe_year(attendance1.getA_year());
                    reandpun.setRe_month(attendance1.getA_month());
                    reandpunService.addReandpun(reandpun);
                    attendanceService.updateAttendance(attendance1);
                    String prompt="已登记加班"+num+"小时";
                    session.setAttribute("prompt",prompt);
                    return "empromptinterface";
                }else {
                    String prompt="上班打卡迟到，不计入加班工时";
                    session.setAttribute("prompt",prompt);
                    return "empromptinterface";
                }
            }else {
                attendance.setA_state("正常");//打卡状态
                attendanceService.updateAttendance(attendance1);//添加当天打卡时间
                String prompt="恭喜您成功签到";
                session.setAttribute("prompt",prompt);
                return "empromptinterface";  //跳转提示恭喜成功打卡
            }
        }else if (attendance1==null){
            String prompt="您上班签到还没有打";
            session.setAttribute("prompt",prompt);
            return "empromptinterface";//跳转上班卡没有打
        }else {
            String prompt="您下班卡已经打过了，请互重复打卡";
            session.setAttribute("prompt",prompt);
            return "empromptinterface";//跳转提示下班卡已经打过了
        }
    }
    @RequestMapping("saveattendance.do")
    public String saveattendance(HttpSession session,HttpServletRequest request)throws Exception{
        User user= (User) session.getAttribute("user");
        int num= Integer.parseInt(request.getParameter("num"));
        Employee employee=employeeService.getEmployeeByuid(user.getU_id());
        session.setAttribute("employee",employee);
        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH)+1;
        int i=(num-1)*5;
        List<Attendance> attendances=attendanceService.getAttendance(year,month,employee.getE_id());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        List<Attendance> attendances1=new ArrayList<>();
        for (Attendance attendance:attendances){
            if (attendance.getA_date()!=null){
                attendance.setDate(sdf1.format(attendance.getA_date()));
            }
            if (attendance.getA_starttime()!=null){
                attendance.setStarttime(sdf.format(attendance.getA_starttime()));
            }
           if (attendance.getA_offtime()!=null){
               attendance.setOfftime(sdf.format(attendance.getA_offtime()));
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
        return "emsaveatt";
    }
    @RequestMapping("emsaveatt2.do")
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
        return "emsaveatt";
    }
    @RequestMapping("saveattendance1.do")
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
        return "emsaveatt";
    }
    @RequestMapping("emsavewages.do")
    public String emsavewages(HttpSession session) throws Exception{
        User user= (User) session.getAttribute("user");
        Employee employee=employeeService.getEmployeeByuid(user.getU_id());
        List<Wage> wage=wageService.getWageByuid(employee.getE_id());
        session.setAttribute("wage",wage);
        return "emsavewages";
    }
    @RequestMapping("adddissent.do")
    public String adddissent(HttpSession session,HttpServletRequest request) throws Exception{
        int id= Integer.parseInt(request.getParameter("id"));
        String reason=request.getParameter("reason");
        User user= (User) session.getAttribute("user");
        Employee employee=employeeService.getEmployeeByuid(user.getU_id());
        Reandpun reandpun=reandpunService.getReandpunByid(id);
        reandpun.setRe_state("有异议");
        reandpunService.updateReandpunBystate(reandpun);
        Dissent dissent=new Dissent();
        dissent.setD_reason(reason);
        dissent.setD_state("未解决");
        dissent.setEmployee(employee);
        dissent.setReandpun(reandpun);
        dissentService.addDissent(dissent);
        String prompt="已经提交，可以在首页进入查看页面，查看处理进度";
        session.setAttribute("prompt",prompt);
        return "empromptinterface";
    }
    @RequestMapping("emsavedissent.do")
    public String emsavedissent(HttpSession session) throws Exception{
        User user= (User) session.getAttribute("user");
        Employee employee=employeeService.getEmployeeByuid(user.getU_id());
        List<Dissent> dissents=dissentService.getDissentbyeid(employee.getE_id());
        if (dissents!=null&&dissents.size()!=0){
            SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
            for (Dissent dissent:dissents){
               dissent.getReandpun().setDate(sdf1.format(dissent.getReandpun().getRe_date()));
            }
            session.setAttribute("dissents",dissents);
            return "emsavedissent";
        }
        String prompt="目前没有异常记录";
        session.setAttribute("prompt",prompt);
        return "empromptinterface";
    }
}

package com.cl.biz.Impl;

import com.cl.biz.AttendanceService;
import com.cl.dao.AttendanceMapper;
import com.cl.model.Attendance;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by one on 2018/4/26.
 */
@Controller
public class AttendanceServiceImpl implements AttendanceService {
    @Resource
    private AttendanceMapper attendanceMapper;
    @Override
    public List<Attendance> getAttendanceByuid(int id) {
        return attendanceMapper.getAttendanceByuid(id);
    }

    @Override
    public Attendance getAttendanceByuidanddate(int id, Date date) {
        return attendanceMapper.getAttendanceByuidanddate(id,date);
    }

    @Override
    public boolean addAttendance(Attendance attendance) {
        return attendanceMapper.addAttendance(attendance);
    }

    @Override
    public boolean updateAttendance(Attendance attendance) {
        return attendanceMapper.updateAttendance(attendance);
    }

    @Override
    public boolean deleteAttendance(Attendance attendance) {
        return attendanceMapper.deleteAttendance(attendance);
    }

    @Override
    public List<Attendance> getAttendance(int year, int month, int uid) {
        return attendanceMapper.getAttendance(year,month,uid);
    }
}

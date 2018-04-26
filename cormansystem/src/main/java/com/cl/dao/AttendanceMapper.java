package com.cl.dao;

import com.cl.model.Attendance;

import java.util.Date;
import java.util.List;

/**
 * Created by one on 2018/4/26.
 */
public interface AttendanceMapper {
    List<Attendance> getAttendanceByuid(int id);
    Attendance getAttendanceByuidanddate(int id, Date date);
    boolean addAttendance(Attendance attendance);
    boolean updateAttendance(Attendance attendance);
    boolean deleteAttendance(Attendance attendance);
}

package com.cl.dao;

import com.cl.model.Attendance;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by one on 2018/4/26.
 */
public interface AttendanceMapper {
    List<Attendance> getAttendanceByuid(int id);
    Attendance getAttendanceByuidanddate(@Param("id")int id, @Param("date")Date date);
    boolean addAttendance(Attendance attendance);
    boolean updateAttendance(Attendance attendance);
    boolean deleteAttendance(Attendance attendance);
    List<Attendance> getAttendance(@Param("year") int year,@Param("month") int month,@Param("uid") int uid);
}

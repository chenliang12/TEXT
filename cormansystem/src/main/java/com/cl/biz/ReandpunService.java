package com.cl.biz;

import com.cl.model.Reandpun;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by one on 2018/4/24.
 */
public interface ReandpunService {
    List<Reandpun> getReandpun();
    List<Reandpun> getReandpunByuid(int id);
    boolean addReandpun(Reandpun reandpun);
    boolean updateReandpun(Reandpun reandpun);
    boolean deleteReandpun(Reandpun reandpun);
    Reandpun getReandpunByid(int id);
    Reandpun getReanddpunByatt(Reandpun reandpun);
    boolean  updateReandpunBystate(Reandpun  reandpun);
    boolean updateReandpunByexpl(Reandpun reandpun);
    Reandpun getReandpunByeid(int id);
    List<Reandpun> getReandpunBydate(@Param("year") int year, @Param("month") int month, @Param("eid") int eid);
}

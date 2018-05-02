package com.cl.controller;

import com.cl.biz.Impl.ReandpunSerciceImpl;
import com.cl.biz.ReandpunService;
import com.cl.model.Reandpun;

import java.util.Calendar;
import java.util.List;

/**
 * Created by one on 2018/5/2.
 */
public class Text {
    public static void main(String[] args) {
        ReandpunService reandpunService=new ReandpunSerciceImpl();
        List<Reandpun> reandpuns=reandpunService.getReandpunBydate(2018,4,1);
        for (Reandpun reandpun:reandpuns){
            reandpun.setRe_state("已结算");
            reandpunService.updateReandpunBystate(reandpun);
        }
    }
}

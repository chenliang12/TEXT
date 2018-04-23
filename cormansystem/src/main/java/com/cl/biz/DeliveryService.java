package com.cl.biz;

import com.cl.model.Delivery;

import java.util.List;

/**
 * Created by one on 2018/4/22.
 */
public interface DeliveryService {
    List<Delivery> getDelivery();
    Delivery getDeliveryByid(int id);
    List<Delivery> getDeliveryByuid(int id);
    boolean addDelivery(Delivery delivery);
    boolean updateDelivery(Delivery delivery);
    boolean deleteDelivery(Delivery delivery);
}

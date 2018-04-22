package com.cl.dao;

import com.cl.model.Delivery;

import java.util.List;

/**
 * Created by one on 2018/4/22.
 */
public interface DeliveryDao {
    List<Delivery> getDelivery();
    boolean addDelivery(Delivery delivery);
    boolean updateDelivery(Delivery delivery);
    boolean deleteDelivery(Delivery delivery);
}

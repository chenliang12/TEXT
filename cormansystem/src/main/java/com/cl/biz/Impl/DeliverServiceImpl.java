package com.cl.biz.Impl;

import com.cl.biz.DeliveryService;
import com.cl.dao.DeliveryDao;
import com.cl.model.Delivery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by one on 2018/4/22.
 */
@Service
public class DeliverServiceImpl implements DeliveryService {
    @Resource
    private DeliveryDao deliveryDao;
    @Override
    public List<Delivery> getDelivery() {
        return deliveryDao.getDelivery();
    }

    @Override
    public Delivery getDeliveryByid(int id) {
        return deliveryDao.getDeliveryByid(id);
    }

    @Override
    public List<Delivery> getDeliveryByuid(int id) {
        return deliveryDao.getDeliveryByuid(id);
    }

    @Override
    public boolean addDelivery(Delivery delivery) {
        return deliveryDao.addDelivery(delivery);
    }

    @Override
    public boolean updateDelivery(Delivery delivery) {
        return deliveryDao.updateDelivery(delivery);
    }

    @Override
    public boolean deleteDelivery(Delivery delivery) {
        return deliveryDao.deleteDelivery(delivery);
    }

    @Override
    public Delivery getDeliveryByuidandreid(int uid) {
        return deliveryDao.getDeliveryByuidandreid(uid);
    }
}

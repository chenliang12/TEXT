package com.cl.biz.Impl;

import com.cl.biz.TrainService;
import com.cl.dao.TrainMapper;
import com.cl.model.Train;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by one on 2018/4/24.
 */
@Controller
public class TrainServiceImpl implements TrainService{
   @Resource
   private TrainMapper trainMapper;
    @Override
    public List<Train> getTrains() {
        return trainMapper.getTrains();
    }

    @Override
    public List<Train> getTrainsByPid(int id) {
        return trainMapper.getTrainsByPid(id);
    }

    @Override
    public Train getTrainByid(int id) {
        return trainMapper.getTrainByid(id);
    }

    @Override
    public boolean addTrain(Train train) {
        return trainMapper.addTrain(train);
    }

    @Override
    public boolean updateTrain(Train train) {
        return trainMapper.updateTrain(train);
    }

    @Override
    public boolean deleteTrain(Train train) {
        return trainMapper.deleteTrain(train);
    }
}

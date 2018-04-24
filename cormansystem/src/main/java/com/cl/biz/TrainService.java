package com.cl.biz;

import com.cl.model.Train;

import java.util.List;

/**
 * Created by one on 2018/4/24.
 */
public interface TrainService {
    List<Train> getTrains();
    List<Train> getTrainsByPid(int id);
    Train getTrainByid(int id);
    boolean addTrain(Train train);
    boolean updateTrain(Train train);
    boolean deleteTrain(Train train);
}

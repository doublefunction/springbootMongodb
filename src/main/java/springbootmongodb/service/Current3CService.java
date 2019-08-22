package springbootmongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import springbootmongodb.model.Current3C;
import springbootmongodb.model.DeviceBaseInfo;

import java.util.List;

public interface Current3CService {


    public  void insert(Current3C current3C);
    List<Current3C> findByDeviceId(String deviceId);
}

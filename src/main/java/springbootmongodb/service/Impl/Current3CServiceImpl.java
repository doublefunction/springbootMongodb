package springbootmongodb.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import springbootmongodb.model.Current3C;
import springbootmongodb.model.DeviceBaseInfo;
import springbootmongodb.service.Current3CService;

import java.util.List;

@Service
@Slf4j
public class Current3CServiceImpl implements Current3CService {
    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public void insert(Current3C current3C) {
        this.mongoTemplate.insert(current3C);
        log.info("设备插入成功");
    }

    @Override
    public List<Current3C> findByDeviceId(String deviceId) {
        Query query = Query.query(Criteria.where("deviceId").is(deviceId));
        List<Current3C> list   = this.mongoTemplate.find(query, Current3C.class);
        return list;
    }


}

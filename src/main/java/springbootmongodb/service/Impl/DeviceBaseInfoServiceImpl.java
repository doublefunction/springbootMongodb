package springbootmongodb.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import springbootmongodb.Result.ResultObject;
import springbootmongodb.model.DeviceBaseInfo;
import springbootmongodb.service.DeviceBaseInfoService;

import javax.servlet.http.HttpServletResponse;
@Service
public class DeviceBaseInfoServiceImpl implements DeviceBaseInfoService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public DeviceBaseInfo findByDeviceId(String deviceId) {
        Query query = Query.query(Criteria.where("deviceId").is(deviceId));
        DeviceBaseInfo deviceBaseInfo = this.mongoTemplate.findOne(query, DeviceBaseInfo.class);
        return deviceBaseInfo;
    }

    @Override
    public Integer insert(DeviceBaseInfo deviceBaseInfo) {
        return null;
    }

}

package springbootmongodb.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springbootmongodb.Result.ResultObject;
import springbootmongodb.model.DeviceBaseInfo;
import springbootmongodb.service.DeviceBaseInfoService;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/mongodbController")
public class MongodbController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private DeviceBaseInfoService deviceBaseInfoService;

    /**表名*/
    private static final String collectionName = "user";



    /**
     * 描述：查询
     * @author maochengyuan
     * @created 2018/9/1 20:17
     * @param
     * @return ResultObject
     */
    @RequestMapping("/query")
    @ResponseBody
    public DeviceBaseInfo query() throws Exception {
        DeviceBaseInfo deviceBaseInfo = deviceBaseInfoService.findByDeviceId("lic00002");
        return deviceBaseInfo;
    }
    @RequestMapping("/insert")
    @ResponseBody
    public String insert(){
        try {
            DeviceBaseInfo deviceBaseInfo = new DeviceBaseInfo();
            deviceBaseInfo.setDeviceId("lic00003");
            deviceBaseInfo.setProductKey("a1uulxMWCKh");
            deviceBaseInfo.setDeviceName("866289032062491");
            deviceBaseInfoService.insert(deviceBaseInfo);
        }catch (Exception e ){
            return "false";
        }
        return "true";
    }

}
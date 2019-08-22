package springbootmongodb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springbootmongodb.VO.ResultVO;
import springbootmongodb.enums.MsgEnums;
import springbootmongodb.model.DeviceBaseInfo;
import springbootmongodb.service.DeviceBaseInfoService;
import springbootmongodb.utils.ResultVOUtils;
import springbootmongodb.utils.SendMessageToDeviceUtil;

@Controller
@RequestMapping("/control_device")
public class DeviceController {

    public static final String url ="/user/control/lic/command";//阿里云下行topic

    @Autowired
    private DeviceBaseInfoService deviceBaseInfoService;

    /**
     * 操作设备
     * @return
     */
    @RequestMapping("/buzzing")
    @ResponseBody
    public ResultVO deviceBuzzing(@RequestParam String deviceId)
    {
        String msg = MsgEnums.buzzing.getMsg();
        DeviceBaseInfo deviceBaseInfo = deviceBaseInfoService.findByDeviceId(deviceId);
        String productKey =deviceBaseInfo.getProductKey();
        String deviceName =deviceBaseInfo.getDeviceName();
        String topic = "/" + productKey + "/" + deviceName + url;
        try{

            SendMessageToDeviceUtil.pubTest(productKey,topic,msg);
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtils.error("设备操作失败");
        }
        return ResultVOUtils.success("操作设备蜂鸣");
    }
    @RequestMapping("/device_restart")
    @ResponseBody
    public ResultVO deviceRestart(@RequestParam String deviceId){
        String msg = MsgEnums.device_Restart.getMsg();
        DeviceBaseInfo deviceBaseInfo = deviceBaseInfoService.findByDeviceId(deviceId);
        String productKey =deviceBaseInfo.getProductKey();
        String deviceName =deviceBaseInfo.getDeviceName();
        String topic = "/" + productKey + "/" + deviceName + url;
        //  Test.pubTest(productKey, topic, msg);
        try{
            SendMessageToDeviceUtil.pubTest(productKey,topic,msg);
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtils.error("设备重启失败");
        }
        return ResultVOUtils.success("设备重启");
    }
    @RequestMapping("/device_upgrade")
    @ResponseBody
    public ResultVO deviceManager3(@RequestParam String deviceId){
        String msg = MsgEnums.device_upgrade.getMsg();
        DeviceBaseInfo deviceBaseInfo = deviceBaseInfoService.findByDeviceId(deviceId);
        String productKey =deviceBaseInfo.getProductKey();
        String deviceName =deviceBaseInfo.getDeviceName();
        String topic = "/" + productKey + "/" + deviceName + url;
        //Test.pubTest(productKey, topic, msg);
        try{
            SendMessageToDeviceUtil.pubTest(productKey,topic,msg);
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtils.error("设备升级失败");
        }
        return ResultVOUtils.success("设备升级");
    }

}

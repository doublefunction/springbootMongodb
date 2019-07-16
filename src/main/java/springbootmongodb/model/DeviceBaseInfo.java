package springbootmongodb.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document(collection="device_base_info")
@Data
public class DeviceBaseInfo {
    private String deviceId;  //用户设备标识
    private String productKey;   //阿里云的产品标识
    private String deviceName;  //阿里云唯一标识
    private String deviceSecret;
    private String register;   //用户是否已经注册。0：没有被注册；1：已经注册
    private String checkCode;   //校验码，设备是否被注册
    private Date date;     //创建时间
    private Long online;   //最近一次上线时间
    private String lifecycle;  //生命周期  create|delete|enable|disable
    private String status;   //设备状态 ONLINE\OFFLINE
    private String nodeType;
    private String region;
}

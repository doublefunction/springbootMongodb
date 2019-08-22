package springbootmongodb.service.Impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import springbootmongodb.model.DeviceBaseInfo;
import springbootmongodb.service.DeviceBaseInfoService;

import static org.junit.Assert.*;

public class DeviceBaseInfoServiceImplTest {

    @Autowired
    private DeviceBaseInfoService deviceBaseInfoService;

    @Test
    public void findByDeviceId() {
    }

    @Test
    public void insert() {
        DeviceBaseInfo deviceBaseInfo= new DeviceBaseInfo();
        deviceBaseInfo.setDeviceId("lic00003");
        deviceBaseInfo.setProductKey("a1uulxMWCKh");
        deviceBaseInfo.setDeviceName("866289032062491");
deviceBaseInfoService.insert(deviceBaseInfo);
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}
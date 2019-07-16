package springbootmongodb.service;

import springbootmongodb.model.DeviceBaseInfo;

public interface DeviceBaseInfoService {
    DeviceBaseInfo findByDeviceId(String deviceId);
    Integer insert(DeviceBaseInfo deviceBaseInfo);
}

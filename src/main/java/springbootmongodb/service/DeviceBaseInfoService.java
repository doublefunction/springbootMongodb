package springbootmongodb.service;

import springbootmongodb.model.DeviceBaseInfo;

public interface DeviceBaseInfoService {
    DeviceBaseInfo findByDeviceId(String deviceId);
    void insert(DeviceBaseInfo deviceBaseInfo);
    void update(DeviceBaseInfo deviceBaseInfo);
    void delete(String deviceId);
}

package springbootmongodb.enums;

import lombok.Getter;

@Getter
public enum MsgEnums {
    buzzing("蜂鸣","{\n" +
            "\t\"Cmd\": \"Buzzing\",\n" +
            "\t\"Para\": 255\n" +
            "}"),
    device_Restart("设备重启","{\"Cmd\":  \"Reset\", \"Para\": 255}"),
    device_upgrade("设备升级","{\"Cmd\":\"FirmwareUpdate\",\"Version\":\"1.0.1\",\"FileSize\":42351,\"MD5\":\"7546bf766d872b5c434ca60c06a8b977\",  \"Para\": 255 }")
    ;
    private String name;
     private String msg;

    MsgEnums(String name, String msg) {
        this.name = name;
        this.msg = msg;
    }

}

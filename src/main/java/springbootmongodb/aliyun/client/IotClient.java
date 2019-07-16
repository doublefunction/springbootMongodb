package springbootmongodb.aliyun.client;



import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import springbootmongodb.utils.LogUtil;

import java.util.Properties;

/**
 * 初始化阿里云client
 */
public class IotClient {
    private static String accessKeyID;
    private static String accessKeySecret;
    private static String regionId;
    private static String domain;
    private static String version;



    public static DefaultAcsClient getClient() {
        DefaultAcsClient client = null;

        Properties prop = new Properties();
        try {
            prop.load(Object.class.getResourceAsStream("/config.properties"));
            accessKeyID = prop.getProperty("user.accessKeyID");
            accessKeySecret = prop.getProperty("user.accessKeySecret");
            regionId = prop.getProperty("iot.regionId");
            domain = prop.getProperty("iot.domain");
            version = prop.getProperty("iot.version");

            IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyID, accessKeySecret);
            DefaultProfile.addEndpoint(regionId, regionId, prop.getProperty("iot.productCode"),
                    prop.getProperty("iot.domain"));
            // 初始化client
            client = new DefaultAcsClient(profile);

        } catch (Exception e) {
            LogUtil.print("初始化client失败！exception:" + e.getMessage());
        }

        return client;
    }

    public static String getRegionId() {
        return regionId;
    }

    public static void setRegionId(String regionId) {
        IotClient.regionId = regionId;
    }

    public static String getDomain() {
        return domain;
    }

    public static void setDomain(String domain) {
        IotClient.domain = domain;
    }

    public static String getVersion() {
        return version;
    }

    public static void setVersion(String version) {
        IotClient.version = version;
    }
}

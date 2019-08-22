package springbootmongodb.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 3路电流
 */
@Data
@Document(collection = "current")
public class Current3C {
    private String deviceId;
    private Integer current1;
    private Integer current2;
    private Integer current3;
    private long timestampFromRTC;
    private long timestampFromAli;
}

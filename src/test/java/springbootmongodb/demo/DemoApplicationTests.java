package springbootmongodb.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springbootmongodb.model.Current3C;
import springbootmongodb.service.Current3CService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    @Autowired
    Current3CService current3CService;


    @Test
    public void contextLoads() {
        Date date = new Date();
      date.setYear(2019);
      date.setMonth(6);
      date.setDate(1);
      date.setHours(0);
      date.setMinutes(0);
      date.setSeconds(0);
      Long time = date.getTime();

      Date end =new Date();
      date.setYear(2019);
      date.setMonth(7);
      date.setDate(1);
      date.setHours(0);
      date.setMinutes(0);
      date.setSeconds(0);

        Current3C current3C = new Current3C();
        while(time < date.getTime()) {
            current3C.setDeviceId("JNFS0002");
            current3C.setCurrent1(220);
            current3C.setCurrent2(0);
            current3C.setCurrent3(0);
            current3C.setTimestampFromRTC(time += 1000 * 60 * 60);
            current3C.setTimestampFromAli(time);
            current3CService.insert(current3C);
        }
    }
    @Test
    public void testinsert(){
        List<Current3C> cList = current3CService.findByDeviceId("JNFS0001");
        System.out.println(cList);
    }


}

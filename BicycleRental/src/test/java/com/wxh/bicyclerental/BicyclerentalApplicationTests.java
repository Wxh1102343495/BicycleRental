package com.wxh.bicyclerental;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;

@RunWith(SpringRunner.class)
@SpringBootTest
class BicyclerentalApplicationTests {

    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() throws Exception{
        System.out.println(dataSource.getClass());
       Connection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }

}

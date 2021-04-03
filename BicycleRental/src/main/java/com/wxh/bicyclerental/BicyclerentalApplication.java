package com.wxh.bicyclerental;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@EntityScan("com.wxh.bicyclerental")
public class BicyclerentalApplication {
    private static Logger logger = LoggerFactory.getLogger(BicyclerentalApplication.class);
    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(BicyclerentalApplication.class, args);
        Environment env = application.getEnvironment();

        logger.warn("\n"+
                        "   d8888b. d888888b  .o88b. db    db  .o88b. db      d88888b      d8888b. d88888b d8b   db d888888b  .d8b.  db \n" +
                        "   88  `8D   `88'   d8P  Y8 `8b  d8' d8P  Y8 88      88'          88  `8D 88'     888o  88 `~~88~~' d8' `8b 88 \n" +
                        "   88oooY'    88    8P       `8bd8'  8P      88      8800000      88oobY' 8800000 88V8o 88    88    88ooo88 88 \n" +
                        "   88~~~b.    88    8b         88    8b      88      88~~~~~      88`8b   88~~~~~ 88 V8o88    88    88~~~88 88 \n" +
                        "   88   8D   .88.   Y8b  d8    88    Y8b  d8 88b000. 88.          88 `88. 88.     88  V888    88    88   88 88b000.\n" +
                        "   Y8888P' Y888888P  `Y88P'    YP     `Y88P' Y88888P Y88888P      88   YD Y88888P VP   V8P    YP    YP   YP Y88888P \n"+
                        "Swagger文档: \t\thttp://{}:{}/doc.html\n",
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port")
        );
        System.out.println("(♥◠‿◠)ﾉﾞ  自行车租赁管理系统启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}

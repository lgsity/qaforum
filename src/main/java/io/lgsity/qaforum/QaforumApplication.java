package io.lgsity.qaforum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("io.lgsity.qaforum.mapper")
public class QaforumApplication {

    public static void main(String[] args) {
        SpringApplication.run(QaforumApplication.class, args);
    }

}

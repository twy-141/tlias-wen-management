package com.tweiy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class TliasWenManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TliasWenManagementApplication.class, args);
    }

}

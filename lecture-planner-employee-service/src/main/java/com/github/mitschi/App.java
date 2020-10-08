package com.github.mitschi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * Hello world!
 *
 */
@SpringBootApplication

public class App
{
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

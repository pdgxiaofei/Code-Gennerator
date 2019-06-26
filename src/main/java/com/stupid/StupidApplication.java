package com.stupid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @description:
 * @author: Peng, Dingguo e092201
 * @email: Dingguo.Peng@mastercard.com
 * @date: 6/26/2018 5:45 PM
 */
@SpringBootApplication
@MapperScan("com.stupid.dao")
public class StupidApplication {

	public static void main(String[] args) {
		SpringApplication.run(StupidApplication.class, args);
	}
}

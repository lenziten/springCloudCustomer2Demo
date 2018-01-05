package com;

import org.mybatis.spring.annotation.MapperScan;
//import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//@Configuration
//@RestController
@MapperScan("com.dao")
@EnableDiscoveryClient
@EnableFeignClients
@EnableAutoConfiguration//(exclude={MapperScannerConfigurer.class})
//@SpringBootApplication
@ComponentScan
public class Application implements EmbeddedServletContainerCustomizer{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer arg0) {
//		arg0.setPort(9000);
	}
	
//	/**开启均衡负载能力*/
//	@Bean
//	@LoadBalanced
//	public RestTemplate restTemplate(){
//		return new RestTemplate();
//	}

}

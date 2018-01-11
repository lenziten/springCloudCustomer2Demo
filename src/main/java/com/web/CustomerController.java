package com.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.domain.User;
import com.service.ComputeClient;
import com.service.DemoComponent;
import com.service.UserService;

@RestController
@RequestMapping("/exit")
public class CustomerController {
	
	private final Logger logger = Logger.getLogger(getClass());
    @Autowired
    private ApplicationContext appContext;
	
	@Autowired
	ComputeClient computeClient;
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public Integer add(){
		return computeClient.add(10, 20);
	}
	
    @RequestMapping("/shutDown")
	public String shutDownBoot(){
    	int result = SpringApplication.exit(appContext);
		return String.valueOf(result);
	}

}

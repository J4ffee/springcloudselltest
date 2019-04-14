package com.hand.controller;

import com.hand.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author jiahui.xu@hand-china.com
 * @Date 2019/4/13
 */
@RestController
public class ClientController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private ProductClient productClient;
    @GetMapping("/getProductMsg")
    public String getProductMsg(){
        //1.第一种方式
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8082/msg", String.class);
        //2.第二种方式
//        ServiceInstance serviceInstance = loadBalancerClient.choose("product");
//        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/msg";
//        RestTemplate restTemplate= new RestTemplate();
//        String response = restTemplate.getForObject(url, String.class);
        //3.第三种方式
    String response = productClient.getMsg();
        return response;
    }
}

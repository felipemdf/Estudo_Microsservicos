package com.estudos.microservice.hroauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.estudos.microservice.hroauth.entity.User;

@Component
@FeignClient(name = "hr-user", url = "http://localhost:8761", path = "/users")
public interface UserFeignClient {
	
	@GetMapping(value = "/search")
	ResponseEntity<User> findByEmail(@RequestParam String email);	
}

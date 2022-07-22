package com.bilgeadam.springbootthymeleaf.rest;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "deneme")
@RequiredArgsConstructor
public class denemeRest {
	@NonNull
	private ApplicationContext applicationContext;

	@GetMapping(path = "beans")
	public ResponseEntity<String> beans() {
		// int k = 7 / 0;
		// localhost:8080/deneme/beans
		String[] names = applicationContext.getBeanDefinitionNames();
		Arrays.sort(names);
		StringBuilder builder = new StringBuilder();
		builder.append("---- " + names.length + " ----").append("<br>");
		for (String name : names) {
			builder.append(name + " ---> " + applicationContext.getBean(name).getClass().getName()).append("<br>");
		}
		return ResponseEntity.ok(builder.toString());
	}
}

package com.ph.juy.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class AppInfoController {

	@GetMapping("/app-info")
	public String appInfo() {
		return UUID.randomUUID().toString();
	}

}

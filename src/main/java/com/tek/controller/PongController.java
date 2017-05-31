package com.tek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tek.service.PongService;


/*
 * PingPong Controller
 */
@RestController
public class PongController {
	@
	
	@Autowired
	PongService pongService;
	
	@RequestMapping(value="/ping", method=RequestMethod.GET)
	public int getCount() {
		return pongService.getPongServicesCount();
	}

}

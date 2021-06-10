package com.techm.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.techm.poc.DeadPojo;
import com.techm.poc.Source;
import com.techm.poc.service.AsyncSource;
import com.techm.poc.service.SyncService;

import reactor.core.publisher.Mono;



@RestController
public class PocController {
	
	@Autowired
	private AsyncSource asyncSource;
	
	@Autowired
	private SyncService syncService;

	@PostMapping(value = "/process")
	public Mono process(@RequestHeader Source source, @RequestBody DeadPojo deadPojo) {
		if (Source.asyncSource.name().equals(source.name())) {
			return asyncSource.asynchStuff();
		} else {
			return syncService.buildSomeRandomData();
		}
	}

}

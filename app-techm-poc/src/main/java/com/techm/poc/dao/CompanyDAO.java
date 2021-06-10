package com.techm.poc.dao;

import reactor.core.publisher.Mono;

public class CompanyDAO {
	
	public static Mono<String> getData () {
		return Mono.just("Tech M");
	}

}

package com.techm.poc.dao;

import reactor.core.publisher.Mono;

public class PocDAO {
	
	public static Mono<String> getData () {
		return Mono.just("Reactive POC");
	}

}

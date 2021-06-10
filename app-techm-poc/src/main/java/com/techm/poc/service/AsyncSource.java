package com.techm.poc.service;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class AsyncSource {

	public Mono<Void> asynchStuff() {

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(20000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("POC stuff from Async");
			}
		});
		thread.start();
		return Mono.empty();
	}

}

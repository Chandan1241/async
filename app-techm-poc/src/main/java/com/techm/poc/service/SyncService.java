package com.techm.poc.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.techm.poc.dao.CompanyDAO;
import com.techm.poc.dao.PocDAO;

import reactor.core.publisher.Mono;

@Service
public class SyncService {
	
	public Mono<Map<String, String>> buildSomeRandomData() {
		
		return CompanyDAO.getData().flatMap( data -> {
			Map<String, String> map = new HashMap<>();
			map.put("compant", data);
			return PocDAO.getData().flatMap(poc -> {
				map.put("poc", poc);
				return Mono.just(map);
			});
		});
	}

}

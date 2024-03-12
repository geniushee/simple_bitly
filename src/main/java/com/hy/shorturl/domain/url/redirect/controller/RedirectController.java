package com.hy.shorturl.domain.url.redirect.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hy.shorturl.domain.url.redirect.dto.RedirectUrlDto;
import com.hy.shorturl.domain.url.url.dto.UrlSvcDto;
import com.hy.shorturl.domain.url.url.service.UrlSvcService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/r")
@RequiredArgsConstructor
public class RedirectController {

	private final UrlSvcService urlSvcService;

	@GetMapping("/{value}")
	public ResponseEntity<Void> redirectUrl(@PathVariable("value") String path){
		UrlSvcDto dto = urlSvcService.findRedirectPage(path);
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.LOCATION, dto.getOldUrl());

		return ResponseEntity.status(302).headers(headers).build();
	}
}

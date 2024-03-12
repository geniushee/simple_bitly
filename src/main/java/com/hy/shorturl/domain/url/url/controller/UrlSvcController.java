package com.hy.shorturl.domain.url.url.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hy.shorturl.domain.url.url.dto.ChangedUrlSvcDto;
import com.hy.shorturl.domain.url.url.dto.ChangedUrlTitleDto;
import com.hy.shorturl.domain.url.url.dto.UrlSvcDto;
import com.hy.shorturl.domain.url.url.dto.UrlSvcRequestDto;
import com.hy.shorturl.domain.url.url.service.UrlSvcService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/short")
@RequiredArgsConstructor
public class UrlSvcController {
	private final UrlSvcService urlSvcService;

	@PostMapping("/createNew")
	public ResponseEntity<UrlSvcDto> urlSvcCreateNew(@RequestBody UrlSvcRequestDto RqDto){
		UrlSvcDto res = urlSvcService.createNewUrl(RqDto);
		ResponseEntity<UrlSvcDto> responseEntity = ResponseEntity.ok(res);
		return responseEntity;
	}

	@GetMapping("/modifyOld")
	public ResponseEntity<ChangedUrlSvcDto> urlSvcDetails(@RequestBody UrlSvcRequestDto RqDto){
		ChangedUrlSvcDto res = urlSvcService.findUrlSvcByNewUrl(RqDto);
		ResponseEntity<ChangedUrlSvcDto> responseEntity = ResponseEntity.ok(res);
		return responseEntity;
	}

	@PostMapping("/modifyOld")
	public ResponseEntity<UrlSvcDto> urlSvcModifyTitle(@RequestBody ChangedUrlTitleDto RqDto){
		UrlSvcDto res = urlSvcService.modifyUrl(RqDto);
		ResponseEntity<UrlSvcDto> responseEntity = ResponseEntity.ok(res);
		return responseEntity;
	}

}

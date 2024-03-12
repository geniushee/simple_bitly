package com.hy.shorturl.domain.url.url.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	// todo 제목을 수정하여 새로운 주소를 변경
	@PostMapping("/modifyOld")
	public ResponseEntity<UrlSvcDto> urlSvcModifyTitle(@RequestBody ChangedUrlTitleDto RqDto){
		UrlSvcDto res = urlSvcService.modifyUrl(RqDto);
		ResponseEntity<UrlSvcDto> responseEntity = ResponseEntity.ok(res);
		return responseEntity;
	}

}

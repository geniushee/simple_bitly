package com.hy.shorturl.domain.url.url.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hy.shorturl.domain.url.url.dto.ChangedUrlTitleDto;
import com.hy.shorturl.domain.url.url.dto.UrlSvcDto;
import com.hy.shorturl.domain.url.url.dto.UrlSvcRequestDto;
import com.hy.shorturl.domain.url.url.entity.UrlSvc;
import com.hy.shorturl.domain.url.url.repository.UrlSvcRepository;
import com.hy.shorturl.global.util.UrlCoder;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UrlSvcService {

	private final UrlSvcRepository urlSvcRepository;

	@Transactional
	public UrlSvcDto createNewUrl(UrlSvcRequestDto rqDto) {

		String encodedOldUrl = UrlCoder.urlDecode(rqDto.getOldUrl());
		UrlSvc newOne = UrlSvc.builder()
			.oldUrl(encodedOldUrl)
			.build();

		newOne = urlSvcRepository.save(newOne);

		String hexLong = Long.toHexString(newOne.getId());
		String newUrl = "https://short.io/" + hexLong;
		newOne.setNewUrl(newUrl);
		newOne = urlSvcRepository.save(newOne);

		return new UrlSvcDto(newOne);
	}

	public UrlSvcDto modifyUrl(ChangedUrlTitleDto rqDto) {
		return null;
	}
}

package com.hy.shorturl.domain.url.url.dto;

import com.hy.shorturl.domain.url.url.entity.UrlSvc;

import lombok.Data;

@Data
public class UrlSvcDto {

	private String oldUrl;

	private String newUrl;

	public UrlSvcDto(UrlSvc newOne) {
		this.oldUrl = newOne.getOldUrl();
		this.newUrl = newOne.getNewUrl();
	}
}

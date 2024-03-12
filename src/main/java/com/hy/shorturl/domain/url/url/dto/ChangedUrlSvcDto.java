package com.hy.shorturl.domain.url.url.dto;

import com.hy.shorturl.domain.url.url.entity.UrlSvc;

import lombok.Data;

@Data
public class ChangedUrlSvcDto {

	private String oldUrl;

	private String newUrl;

	private String title;

	public ChangedUrlSvcDto(UrlSvc urlSvc, String title) {
		oldUrl = urlSvc.getOldUrl();
		newUrl = urlSvc.getNewUrl();
		this.title = title;
	}
}

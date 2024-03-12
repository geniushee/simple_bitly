package com.hy.shorturl.domain.url.url.dto;

import lombok.Data;

@Data
public class UrlSvcRequestDto {

	private String oldUrl;

	private String newUrl;
}

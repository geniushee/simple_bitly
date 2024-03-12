package com.hy.shorturl.domain.url.redirect.dto;

import lombok.Data;

@Data
public class RedirectUrlDto {
	private String Url;

	public RedirectUrlDto(String oldUrl) {
		this.Url = oldUrl;
	}
}

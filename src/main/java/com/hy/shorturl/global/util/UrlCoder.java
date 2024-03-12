package com.hy.shorturl.global.util;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class UrlCoder {

	public static String urlEncode(String url){
		return URLEncoder.encode(url, StandardCharsets.UTF_8);
	}

	public static String urlDecode(String encodedUrl){
		return URLDecoder.decode(encodedUrl, StandardCharsets.UTF_8);
	}
}

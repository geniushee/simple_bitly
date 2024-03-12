package com.hy.shorturl.domain.url.url.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hy.shorturl.domain.url.url.entity.UrlSvc;

@Repository
public interface UrlSvcRepository extends JpaRepository<UrlSvc, Long> {
	UrlSvc findByNewUrl(String newUrl);
}

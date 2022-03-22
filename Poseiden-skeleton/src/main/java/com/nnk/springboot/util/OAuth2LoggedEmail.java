package com.nnk.springboot.util;

import java.util.Collections;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.user.OAuth2User;


public class OAuth2LoggedEmail {

	Logger logger = LoggerFactory.getLogger(OAuth2LoggedEmail.class);
	
	@Autowired
	OAuth2AuthorizedClientService authorizedClientService;

	public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
		return Collections.singletonMap("email", principal.getAttribute("email"));
	}

}

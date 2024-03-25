package com.example.rustem.bookshopping.config;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
@Setter
public class MySession {

	private String username;

	public MySession() {
		System.out.println("MySession>constructor");
		Authentication LoggedInUser = SecurityContextHolder.getContext().getAuthentication();
		String username = LoggedInUser.getName();
		this.username = username;
	}
}
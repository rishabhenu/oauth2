package com.rishabh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
@EnableWebSecurity
//@EnableResourceServer
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class OauthAuthServerApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OauthAuthServerApplication.class, args);
		assert context != null;
	}

}

package com.jwt_decorder.jwt_decorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

@RestController("/jwt")
@SpringBootApplication
public class JwtDecorderApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtDecorderApplication.class, args);
	}

	@PostMapping("/decode")
	public String decorodeJwt(@RequestBody String token) throws UnsupportedEncodingException {
		// header.payload.signature
		String header = token.split("\\.")[0];
		String payload = token.split("\\.")[1];
		String signature = token.split("\\.")[2];

		return new String(Base64.decodeBase64(payload), "UTF-8");
	}
}

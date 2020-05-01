package io.ss.spring.boot.api.accounts.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account-mgmt")
public class AccountMgmtController {

	@GetMapping("/up")
	public ResponseEntity<String> up() {
		return ResponseEntity.ok("UP");
	}
	
	@GetMapping("/ready")
	public ResponseEntity<String> ready() {
		return ResponseEntity.ok("READY");
	}
}

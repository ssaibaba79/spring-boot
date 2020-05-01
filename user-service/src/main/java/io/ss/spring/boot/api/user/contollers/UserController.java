package io.ss.spring.boot.api.user.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private Environment env;
	
	@GetMapping("/up")
	public ResponseEntity<String> up() {
		return ResponseEntity.ok("UP on port : " + env.getProperty("local.server.port") + " - " +env.getProperty("demo.user.name"));
	}
	
	@GetMapping("/ready")
	public ResponseEntity<String> ready() {
		return ResponseEntity.ok("READY on port : "+ env.getProperty("local.server.port")  + " - " +env.getProperty("demo.user.name"));
	}
	
}

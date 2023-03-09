package com.anhanguera.pw.resource;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anhanguera.pw.entities.User;
import com.anhanguera.pw.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	public UserService userService;

	@GetMapping()
	public ResponseEntity<List<User>> findAll() {
		List<User> userList = userService.findAll();

		return ResponseEntity.ok().body(userList);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(UUID id) {
		User user = userService.findById(id);

		return ResponseEntity.ok().body(user);
	}

	@PostMapping
	public ResponseEntity<User> insert(User user) {
		User savedUser = userService.insert(user);

		return ResponseEntity.status(200).body(savedUser);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable UUID id) {
		userService.delete(id);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable(value = "id") UUID id, @RequestBody User user) {
		User updatedUser = userService.update(id, user);

		return ResponseEntity.ok().body(updatedUser);
	}
}

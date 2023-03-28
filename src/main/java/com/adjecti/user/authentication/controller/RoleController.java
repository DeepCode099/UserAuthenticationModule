package com.adjecti.user.authentication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adjecti.user.authentication.exception.ResourceNotFoundException;
import com.adjecti.user.authentication.model.Role;
import com.adjecti.user.authentication.repository.RoleRepository;

@RestController
@RequestMapping("/api/v2")
public class RoleController {


	@Autowired
	private RoleRepository roleRepository;
	

	//get Roles
	@GetMapping("/roles")
	public List<Role> getAllRoles(){
		return roleRepository.findAll();
	}
	
	//get user by id
	/*
	 * @GetMapping("/users/{id}") public ResponseEntity<Role>
	 * getRoleById(@PathVariable(value = "id") Long roleId) throws
	 * ResourceNotFoundException{ Role role =
	 * roleRepository.findById(roleId).orElseThrow(() -> new
	 * ResourceNotFoundException("Role is not found for this id :: " + roleId) );
	 * return ResponseEntity.ok().body(role); }
	 * 
	 */
	
	
	// save Role
	@PostMapping("/roles")
	public Role createRole(@Valid @RequestBody Role role) {
		return roleRepository.save(role);
	}

	
		// delete Role 
	@DeleteMapping("/deleteroles/{id}")
	public Map<String, Boolean> deleteRole(@PathVariable(value = "id") Long roleId)
			throws ResourceNotFoundException {
		Role user = roleRepository.findById(roleId)
				.orElseThrow(() -> new ResourceNotFoundException("Role is  not found for this id :: " + roleId));
		roleRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	
	

	
	
}

package com.adjecti.user.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adjecti.user.authentication.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}

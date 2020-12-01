package com.tcs.authdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.authdemo.model.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}

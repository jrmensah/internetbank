package me.jrmensah.internetbank.repositories;

import me.jrmensah.internetbank.entities.UserRole;
import org.springframework.data.repository.CrudRepository;


public interface RoleRepository extends CrudRepository<UserRole, Long> {
    UserRole findByRole(String role);
}

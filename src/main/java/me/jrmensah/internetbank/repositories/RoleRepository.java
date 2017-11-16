package me.jrmensah.internetbank.repositories;

import me.jrmensah.internetbank.entities.UserRole;
import org.springframework.data.repository.CrudRepository;

import javax.management.relation.Role;

public interface RoleRepository extends CrudRepository<UserRole, Long> {
    Role findByRole(String role);
}

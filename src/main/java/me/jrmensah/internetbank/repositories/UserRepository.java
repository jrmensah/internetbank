package me.jrmensah.internetbank.repositories;

import me.jrmensah.internetbank.entities.UserData;

public interface UserRepository extends CrudRepository<UserData, Long> {
    UserData findByUsername(String username);
}

package me.jrmensah.internetbank.repositories;

import me.jrmensah.internetbank.entities.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account,Long>{
}

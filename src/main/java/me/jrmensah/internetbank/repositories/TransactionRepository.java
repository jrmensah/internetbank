package me.jrmensah.internetbank.repositories;

import me.jrmensah.internetbank.entities.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}

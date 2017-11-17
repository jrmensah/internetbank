package me.jrmensah.internetbank.repositories;

import org.hibernate.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}

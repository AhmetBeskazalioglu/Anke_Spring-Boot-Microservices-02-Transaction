package com.anke.Anke_Spring_Boot_Microservices_02_Transaction.repository;

import com.anke.Anke_Spring_Boot_Microservices_02_Transaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, Long> {
}

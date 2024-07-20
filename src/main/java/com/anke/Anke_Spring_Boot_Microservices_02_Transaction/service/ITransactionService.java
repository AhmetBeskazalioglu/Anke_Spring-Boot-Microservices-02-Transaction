package com.anke.Anke_Spring_Boot_Microservices_02_Transaction.service;

import com.anke.Anke_Spring_Boot_Microservices_02_Transaction.entity.Transaction;

public interface ITransactionService {

    Transaction saveTransaction(Transaction transaction);
    Transaction updateTransaction(Long transactionId, Transaction transaction);
    Transaction getTransactionById(Long transactionId);
    Iterable<Transaction> getAllTransactions();
    void deleteTransactionById(Long transactionId);
    void deleteAllTransactions();

}

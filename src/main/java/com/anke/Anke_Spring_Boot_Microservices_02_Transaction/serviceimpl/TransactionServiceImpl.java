package com.anke.Anke_Spring_Boot_Microservices_02_Transaction.serviceimpl;

import com.anke.Anke_Spring_Boot_Microservices_02_Transaction.entity.Transaction;
import com.anke.Anke_Spring_Boot_Microservices_02_Transaction.repository.ITransactionRepository;
import com.anke.Anke_Spring_Boot_Microservices_02_Transaction.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements ITransactionService {

    private ITransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(ITransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction updateTransaction(Long transactionId, Transaction updatedTransaction) {
        Transaction transaction = transactionRepository.findById(transactionId).get();
        transaction.setUserId(updatedTransaction.getUserId());
        transaction.setProductId(updatedTransaction.getProductId());
        transaction.setTransactionTime(updatedTransaction.getTransactionTime());
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransactionById(Long transactionId) {
        return transactionRepository.findById(transactionId).get();
    }

    @Override
    public Iterable<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public void deleteTransactionById(Long transactionId) {
        transactionRepository.deleteById(transactionId);
    }

    @Override
    public void deleteAllTransactions() {
        transactionRepository.deleteAll();
    }
}

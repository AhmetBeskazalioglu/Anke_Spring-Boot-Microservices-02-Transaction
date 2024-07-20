package com.anke.Anke_Spring_Boot_Microservices_02_Transaction.controller;

import com.anke.Anke_Spring_Boot_Microservices_02_Transaction.entity.Transaction;
import com.anke.Anke_Spring_Boot_Microservices_02_Transaction.serviceimpl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    private TransactionServiceImpl transactionService;

    @Autowired
    public TransactionController(TransactionServiceImpl transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/add")
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionService.saveTransaction(transaction));
    }

    @PutMapping("/update/{transactionId}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable("transactionId") Long transactionId, @RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionService.updateTransaction(transactionId, transaction));
    }

    @GetMapping("/get/{transactionId}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable("transactionId") Long transactionId) {
        return ResponseEntity.ok(transactionService.getTransactionById(transactionId));
    }

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<Transaction>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @DeleteMapping("/delete/{transactionId}")
    public ResponseEntity<String> deleteTransactionById(@PathVariable("transactionId") Long transactionId) {
        if (transactionService.getTransactionById(transactionId) != null) {
            transactionService.deleteTransactionById(transactionId);
            return ResponseEntity.ok("Transaction with id " + transactionId + " deleted successfully");
        } else {
            return ResponseEntity.ok("Transaction with id " + transactionId + " not found");
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllTransactions() {
        transactionService.deleteAllTransactions();
        return ResponseEntity.ok("All transactions deleted successfully");
    }

}

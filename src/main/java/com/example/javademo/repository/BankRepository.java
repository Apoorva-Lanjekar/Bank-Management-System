package com.example.javademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.javademo.models.BankAccount;

public interface BankRepository extends JpaRepository<BankAccount, Long> {

}

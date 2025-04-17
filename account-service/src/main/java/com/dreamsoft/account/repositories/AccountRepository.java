package com.dreamsoft.account.repositories;

import com.dreamsoft.account.entites.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}

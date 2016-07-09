/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.mythbusters.aps.repository;

import java.util.List;

import za.co.mainframemythbusters.aps.domain.model.statement.Statement;
import za.co.mythbusters.aps.model.internal.Account;

/**
 *
 */
public interface StatementRepository {

    Statement find(Account accountId);

    List<Statement> findAll();

    void store(Statement statement);
    
}

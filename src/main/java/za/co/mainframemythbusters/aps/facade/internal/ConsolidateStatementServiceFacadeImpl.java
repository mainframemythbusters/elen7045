/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.mainframemythbusters.aps.facade.internal;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import za.co.mainframemythbusters.aps.domain.model.statement.Statement;
import za.co.mainframemythbusters.aps.facade.ConsolidatedStatementServiceFacade;
import za.co.mythbusters.aps.model.internal.Account;
import za.co.mythbusters.aps.model.internal.ConsolidatedStatement;
import za.co.mythbusters.aps.model.internal.Profile;
import za.co.mythbusters.aps.repository.ProfileRepository;
import za.co.mythbusters.aps.repository.StatementRepository;

/**
 * makes the necessary calls to internal services 
 */
@ApplicationScoped
public class ConsolidateStatementServiceFacadeImpl implements ConsolidatedStatementServiceFacade, Serializable {

    //@Inject
    //private ConsolidatedStatementService consolidatedStatement;
    
    @Inject
    private ProfileRepository profileRepository;
    
    @Inject
    private StatementRepository statementRepository;
    
    @Override
    public ConsolidatedStatement consolidateStatements(Profile profile) {
        ConsolidatedStatement conStmt = null;
        String apsCustomerNumber = "";
        String customerName = "";
        
        List<Account> accounts = null;//profileRepository.findProfileAccounts(profile);
        
        List<Statement> profileStatements = new LinkedList<>();
        
        for(Account account: accounts) {
            profileStatements.add(statementRepository.find(account));
        }
        
        conStmt = null;//consolidatedStatement.consolidateStatements(apsCustomerNumber, customerName, profileStatements);
        
        
        
        return conStmt;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.mainframemythbusters.aps.domain.model.statement;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 */
public interface Statement {
    

    public String getAccountNumber();

    public String getAccountHolderName();

    public Date getStatementDate();

    public int getStatementNumber();

    public int getStatementMonth();

    public BigDecimal getTotalDue();

    public Date getDueDate();
    
}

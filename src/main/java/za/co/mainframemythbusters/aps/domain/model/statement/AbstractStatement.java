/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.mainframemythbusters.aps.domain.model.statement;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.Validate;

import za.co.mythbusters.aps.model.internal.Account;

/**
 *
 */
@Entity
public abstract class AbstractStatement implements Statement, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long statementId;
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "statement_type")
    private Type type;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "account_holder_name")
    private String accountHolderName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "statement_date")
    private Date statementDate;

    @Column(name = "statement_number")
    private int statementNumber;

    @Column(name = "statement_month")
    private int statementMonth;

    @Column(name = "total_due")
    private BigDecimal totalDue;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "opening_balance")
    private BigDecimal openingBalance;

    @Column(name = "closing_balance")
    private BigDecimal closingBalance;

    @Column(name = "payment_recieved")
    private BigDecimal paymentRecieved;

    @Column(name = "new_charges")
    private BigDecimal newCharges;

    private BigDecimal deductions;

    private BigDecimal discount;

    @Column(name = "vat_amount")
    private BigDecimal vatAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    
    /**
     * AbstractStatement type. allows the aps to report accordingly .
     */
    public enum Type {

        MUNICIPAL("MUNICIPALITY"),
        CREDITCARD("CREDITCARD"),
        TELCOM("TELCOM");
        
        private final String type;

        /**
         * Private enum constructor.
         *
         * @param type
         */
        private Type(String type) {
            this.type = type;
        }
    }
    
    public AbstractStatement() {
        
    }
    
    public AbstractStatement(Type type) {
        
        Validate.notNull(type, "Statement.Type is required");
        this.type = type;
    }
    
    public AbstractStatement(Type type, String accountNumber, String accountHolderName, Date statementDate, 
            int statementNumber, int statementMonth, Account account) {
        
        Validate.notNull(type, "Statement.Type is required");
        Validate.notNull(accountNumber, "accountNumber is required");
        Validate.notNull(accountHolderName, "accountHolderName");
        Validate.notNull(statementDate, "statementDate is required");
        Validate.notNull(statementNumber, "statementNumber is required");
        Validate.notNull(statementMonth, "statementMonth is required");
        Validate.notNull(account, "account is required");
        
        this.type = type;
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.statementDate = statementDate;
        this.statementNumber = statementNumber;
        this.statementMonth = statementMonth;
        this.account = account;
    }    

    public AbstractStatement(Type type, String accountNumber, String accountHolderName, Date statementDate, 
            int statementNumber, int statementMonth, BigDecimal totalDue, Date dueDate, 
            BigDecimal openingBalance, BigDecimal closingBalance, BigDecimal paymentRecieved, 
            BigDecimal newCharges, BigDecimal deductions, BigDecimal discount, 
            BigDecimal vatAmount, Account account) {
        
        Validate.notNull(type, "Statement.Type is required");
        Validate.notNull(accountNumber, "accountNumber is required");
        Validate.notNull(accountHolderName, "accountHolderName");
        Validate.notNull(statementDate, "statementDate is required");
        Validate.notNull(statementNumber, "statementNumber is required");
        Validate.notNull(statementMonth, "statementMonth is required");
        Validate.notNull(totalDue, "totalDue is required");
        Validate.notNull(dueDate, "dueDate is required");
        Validate.notNull(openingBalance, "openingBalance is required");
        Validate.notNull(closingBalance, "closingBalance is required");
        Validate.notNull(paymentRecieved, "paymentRecieved is required");
        Validate.notNull(newCharges, "newCharges is required");
        Validate.notNull(deductions, "deductions is required");
        Validate.notNull(discount, "discount is required");
        Validate.notNull(vatAmount, "vatAmount is required");
        Validate.notNull(account, "account is required");
        
        this.type = type;
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.statementDate = statementDate;
        this.statementNumber = statementNumber;
        this.statementMonth = statementMonth;
        this.totalDue = totalDue;
        this.dueDate = dueDate;
        this.openingBalance = openingBalance;
        this.closingBalance = closingBalance;
        this.paymentRecieved = paymentRecieved;
        this.newCharges = newCharges;
        this.deductions = deductions;
        this.discount = discount;
        this.vatAmount = vatAmount;
        this.account = account;
    }

    public Long getStatementId() {
        return statementId;
    }

    public void setStatementId(Long StatementId) {
        this.statementId = StatementId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statementId != null ? statementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the StatementId fields are not set
        if (!(object instanceof AbstractStatement)) {
            return false;
        }
        AbstractStatement other = (AbstractStatement) object;
        if ((this.statementId == null && other.statementId != null) || (this.statementId != null && !this.statementId.equals(other.statementId))) {
            return false;
        }
        return true;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String getAccountHolderName() {
        return accountHolderName;
    }

    @Override
    public Date getStatementDate() {
        return statementDate;
    }

    @Override
    public int getStatementNumber() {
        return statementNumber;
    }

    @Override
    public int getStatementMonth() {
        return statementMonth;
    }

    @Override
    public BigDecimal getTotalDue() {
        return totalDue;
    }

    @Override
    public Date getDueDate() {
        return dueDate;
    }

    public BigDecimal getOpeningBalance() {
        return openingBalance;
    }

    public BigDecimal getClosingBalance() {
        return closingBalance;
    }

    public BigDecimal getPaymentRecieved() {
        return paymentRecieved;
    }

    public BigDecimal getNewCharges() {
        return newCharges;
    }

    public BigDecimal getDeductions() {
        return deductions;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public BigDecimal getVatAmount() {
        return vatAmount;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "za.co.mainframemythbusters.aps.domain.model.statement.Statement[ id=" + statementId + " ]";
    }
    
}

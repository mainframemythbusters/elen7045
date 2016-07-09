package za.co.mythbusters.aps.model.internal;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 */
@Entity
public class ConsolidatedStatementDetailLine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "billing_company_name")
    private String billingCompanyName;
    
    @Column(name = "account_number")
    private String accountNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "statement_date")
    private Date statementDate;
    
    @Column(name = "ammount_due")
    private BigDecimal amountDue;

    public ConsolidatedStatementDetailLine() {
        this.amountDue = BigDecimal.ZERO;
    }

    public ConsolidatedStatementDetailLine(String billingCompanyName, String accountNumber, Date statementDate) {
        this.billingCompanyName = billingCompanyName;
        this.accountNumber = accountNumber;
        this.statementDate = statementDate;
    }

    public ConsolidatedStatementDetailLine(String billingCompanyName, String accountNumber, Date statementDate, BigDecimal amountDue) {
        this.billingCompanyName = billingCompanyName;
        this.accountNumber = accountNumber;
        this.statementDate = statementDate;
        this.amountDue = amountDue;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the billingCompanyName
     */
    public String getBillingCompanyName() {
        return billingCompanyName;
    }

    /**
     * @param billingCompanyName the billingCompanyName to set
     */
    public void setBillingCompanyName(String billingCompanyName) {
        this.billingCompanyName = billingCompanyName;
    }

    /**
     * @return the accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return the statementDate
     */
    public Date getStatementDate() {
        return statementDate;
    }

    /**
     * @param statementDate the statementDate to set
     */
    public void setStatementDate(Date statementDate) {
        this.statementDate = statementDate;
    }

    /**
     * @return the amountDue
     */
    public BigDecimal getAmountDue() {
        return amountDue;
    }

    /**
     * @param amountDue the amountDue to set
     */
    public void setAmountDue(BigDecimal amountDue) {
        this.amountDue = amountDue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsolidatedStatementDetailLine)) {
            return false;
        }
        ConsolidatedStatementDetailLine other = (ConsolidatedStatementDetailLine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.co.mainframemythbusters.aps.domain.model.consolidated.ConsolidatedStatementDetailLine[ id=" + id + " ]";
    }
    
}

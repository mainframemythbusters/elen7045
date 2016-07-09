/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.mainframemythbusters.aps.domain.model.statement;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 */
@Embeddable
public class CreditCardStatement extends AbstractStatement {

    @Id
    @Column(name = "credit_card_statement_id")
    private Long creditCardStatementId;

    @Column(name = "card_type")
    private String cardType;

    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    @Column(name = "credit_limit")
    private BigDecimal creditLimit;

    @Column(name = "credit_available")
    private BigDecimal creditAvailable;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "minimum_amount_due")
    private Date minimumAmountDue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statement_id")
    private AbstractStatement statement;
    
}

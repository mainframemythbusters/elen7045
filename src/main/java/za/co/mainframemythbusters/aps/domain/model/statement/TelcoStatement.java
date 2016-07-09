/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.mainframemythbusters.aps.domain.model.statement;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 */
@Embeddable
public class TelcoStatement extends AbstractStatement {
    
    @Id
    @Column(name = "telco_statement_id")
    private Long telcoStatementrId;

    @Column(name = "telephone_number")
    private String telephoneNumber;

    @Column(name = "service_charges")
    private BigDecimal serviceCharges;

    @Column(name = "call_charges")
    private BigDecimal callCharges;

    @Column(name = "total_number_of_calls")
    private int totalNumberOfCalls;

    @Column(name = "total_call_duration")
    private int totalCallDuration;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statement_id")
    private AbstractStatement statement;
    
}

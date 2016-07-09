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
public class MunicipalStatement extends AbstractStatement {

    @Id
    @Column(name = "municipal_statement_id")
    private int municipalStatementId;

    @Column(name = "instalment_notice")
    private String instalmentNotice;

    @Column(name = "electricity_used")
    private BigDecimal electricityUsed;

    @Column(name = "electricity_charges")
    private BigDecimal electricityCharges;

    @Column(name = "gas_used")
    private BigDecimal gasUsed;

    @Column(name = "gas_charges")
    private BigDecimal gasCharges;

    @Column(name = "water_used")
    private BigDecimal waterUsed;

    @Column(name = "water_charges")
    private BigDecimal waterCharges;

    @Column(name = "refuse_charges")
    private BigDecimal refuseCharges;

    @Column(name = "sewerage_charges")
    private BigDecimal sewerageCharges;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statement_id")
    private AbstractStatement statement;
    
}

package za.co.mythbusters.aps.model.internal;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.commons.lang3.Validate;
import za.co.mainframemythbusters.aps.domain.model.statement.AbstractStatement;

/**
 *
 */
@Entity
public class ConsolidatedStatement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "aps_customer_number")
    private String apsCustomerNumber;
    
    @Column(name = "customer_name")
    private String customerName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "statement_date")
    private Date statementDate;
    
    @Column(name = "total_due")
    private BigDecimal totalDue;
    
    @JoinTable(name="ConsolidatedStatementDetailLine")
    @ManyToOne
    private List<ConsolidatedStatementDetailLine> detailLines; 
    
    public ConsolidatedStatement () {
        
    }

    public ConsolidatedStatement(String apsCustomerNumber, String customerName, Date statementDate, 
            BigDecimal totalDue, List<ConsolidatedStatementDetailLine> detailLines) {
        
        Validate.notNull(apsCustomerNumber, "customer number must be assigned");
        Validate.notNull(customerName, "customer name must be assigned");
        Validate.notNull(statementDate, "statement date must be assigned");
        Validate.notNull(totalDue, "total due must be assigned");
        Validate.notNull(detailLines, "detail lines must be assigned");
        
        this.apsCustomerNumber = apsCustomerNumber;
        this.customerName = customerName;
        this.statementDate = statementDate;
        this.totalDue = totalDue;
        this.detailLines = detailLines;
    }
    
    public ConsolidatedStatement(String apsCustomerNumber, String customerName, Date statementDate) {
        
        Validate.notNull(apsCustomerNumber, "customer number must be assigned");
        Validate.notNull(customerName, "customer name must be assigned");
        Validate.notNull(statementDate, "statement date must be assigned");
        
        this.apsCustomerNumber = apsCustomerNumber;
        this.customerName = customerName;
        this.statementDate = statementDate;
        this.detailLines = new LinkedList<>();
    }
    
    public void addDetailLineToStatement(ConsolidatedStatementDetailLine detailLine) {
        this.getDetailLines().add(detailLine);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the apsCustomerNumber
     */
    public String getApsCustomerNumber() {
        return apsCustomerNumber;
    }

    /**
     * @param apsCustomerNumber the apsCustomerNumber to set
     */
    public void setApsCustomerNumber(String apsCustomerNumber) {
        this.apsCustomerNumber = apsCustomerNumber;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
     * @return the totalDue
     */
    public BigDecimal getTotalDue() {
        return totalDue;
    }

    /**
     * @param totalDue the totalDue to set
     */
    public void setTotalDue(BigDecimal totalDue) {
        this.totalDue = totalDue;
    }

    /**
     * @return the detailLines
     */
    public List<ConsolidatedStatementDetailLine> getDetailLines() {
        return detailLines;
    }

    /**
     * @param detailLines the detailLines to set
     */
    public void setDetailLines(List<ConsolidatedStatementDetailLine> detailLines) {
        this.detailLines = detailLines;
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
        if (!(object instanceof ConsolidatedStatement)) {
            return false;
        }
        ConsolidatedStatement other = (ConsolidatedStatement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.co.mainframemythbusters.aps.domain.model.consolidated.ConsolidatedStatement[ id=" + id + " ]";
    }
    
}

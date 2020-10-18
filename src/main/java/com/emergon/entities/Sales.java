
package com.emergon.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/* @author emergon */
@Entity
@Table(name = "sales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sales.findAll", query = "SELECT s FROM Sales s")
    , @NamedQuery(name = "Sales.findByScode", query = "SELECT s FROM Sales s WHERE s.scode = :scode")
    , @NamedQuery(name = "Sales.findByQuant", query = "SELECT s FROM Sales s WHERE s.quant = :quant")
    , @NamedQuery(name = "Sales.findByCost", query = "SELECT s FROM Sales s WHERE s.cost = :cost")
    , @NamedQuery(name = "Sales.findBySdate", query = "SELECT s FROM Sales s WHERE s.sdate = :sdate")})
public class Sales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "scode")
    private Integer scode;
    @Column(name = "quant")
    private Integer quant;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost")
    private BigDecimal cost;
    @Column(name = "sdate")
    private LocalDate sdate;
    @JoinColumn(name = "ccode", referencedColumnName = "ccode")
    @ManyToOne(optional = false)
    private Customer customer;
    @JoinColumn(name = "pcode", referencedColumnName = "pcode")
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "smcode", referencedColumnName = "scode")
    @ManyToOne(optional = false)
    private Salesman salesman;

    public Sales() {
    }

    public Sales(Integer scode) {
        this.scode = scode;
    }

    public Integer getScode() {
        return scode;
    }

    public void setScode(Integer scode) {
        this.scode = scode;
    }

    public Integer getQuant() {
        return quant;
    }

    public void setQuant(Integer quant) {
        this.quant = quant;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public LocalDate getSdate() {
        return sdate;
    }

    public void setSdate(LocalDate sdate) {
        this.sdate = sdate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scode != null ? scode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sales)) {
            return false;
        }
        Sales other = (Sales) object;
        if ((this.scode == null && other.scode != null) || (this.scode != null && !this.scode.equals(other.scode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emergon.entities.Sales[ scode=" + scode + " ]";
    }

}

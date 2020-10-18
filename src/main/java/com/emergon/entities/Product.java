
package com.emergon.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/* @author emergon */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
    , @NamedQuery(name = "Product.findByPcode", query = "SELECT p FROM Product p WHERE p.pcode = :pcode")
    , @NamedQuery(name = "Product.findByPdescr", query = "SELECT p FROM Product p WHERE p.pdescr = :pdescr")
    , @NamedQuery(name = "Product.findByPprice", query = "SELECT p FROM Product p WHERE p.pprice = :pprice")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pcode")
    private Integer pcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pdescr")
    private String pdescr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pprice")
    private BigDecimal pprice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Set<Sales> sales;

    public Product() {
    }

    public Product(Integer pcode) {
        this.pcode = pcode;
    }

    public Product(Integer pcode, String pdescr) {
        this.pcode = pcode;
        this.pdescr = pdescr;
    }

    public Integer getPcode() {
        return pcode;
    }

    public void setPcode(Integer pcode) {
        this.pcode = pcode;
    }

    public String getPdescr() {
        return pdescr;
    }

    public void setPdescr(String pdescr) {
        this.pdescr = pdescr;
    }

    public BigDecimal getPprice() {
        return pprice;
    }

    public void setPprice(BigDecimal pprice) {
        this.pprice = pprice;
    }

    @XmlTransient
    public Set<Sales> getSales() {
        return sales;
    }

    public void setSales(Set<Sales> sales) {
        this.sales = sales;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pcode != null ? pcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.pcode == null && other.pcode != null) || (this.pcode != null && !this.pcode.equals(other.pcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emergon.entities.Product[ pcode=" + pcode + " ]";
    }

}

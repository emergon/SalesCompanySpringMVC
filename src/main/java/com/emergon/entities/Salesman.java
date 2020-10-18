
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "salesman")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salesman.findAll", query = "SELECT s FROM Salesman s")
    , @NamedQuery(name = "Salesman.findByScode", query = "SELECT s FROM Salesman s WHERE s.scode = :scode")
    , @NamedQuery(name = "Salesman.findBySname", query = "SELECT s FROM Salesman s WHERE s.sname = :sname")
    , @NamedQuery(name = "Salesman.findByScity", query = "SELECT s FROM Salesman s WHERE s.scity = :scity")
    , @NamedQuery(name = "Salesman.findByScomm", query = "SELECT s FROM Salesman s WHERE s.scomm = :scomm")})
public class Salesman implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "scode")
    private Integer scode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "sname")
    private String sname;
    @Size(max = 15)
    @Column(name = "scity")
    private String scity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "scomm")
    private BigDecimal scomm;
    @JoinTable(name = "salesman_store", joinColumns = {
        @JoinColumn(name = "scode", referencedColumnName = "scode")}, inverseJoinColumns = {
        @JoinColumn(name = "stid", referencedColumnName = "stid")})
    @ManyToMany
    private Set<Store> stores;
    @OneToMany(mappedBy = "salesman")
    private Set<Family> family;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesman")
    private Set<Sales> sales;

    public Salesman() {
    }

    public Salesman(Integer scode) {
        this.scode = scode;
    }

    public Salesman(Integer scode, String sname) {
        this.scode = scode;
        this.sname = sname;
    }

    public Integer getScode() {
        return scode;
    }

    public void setScode(Integer scode) {
        this.scode = scode;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getScity() {
        return scity;
    }

    public void setScity(String scity) {
        this.scity = scity;
    }

    public BigDecimal getScomm() {
        return scomm;
    }

    public void setScomm(BigDecimal scomm) {
        this.scomm = scomm;
    }

    @XmlTransient
    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }

    @XmlTransient
    public Set<Family> getFamily() {
        return family;
    }

    public void setFamily(Set<Family> family) {
        this.family = family;
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
        hash += (scode != null ? scode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salesman)) {
            return false;
        }
        Salesman other = (Salesman) object;
        if ((this.scode == null && other.scode != null) || (this.scode != null && !this.scode.equals(other.scode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emergon.entities.Salesman[ scode=" + scode + " ]";
    }

}

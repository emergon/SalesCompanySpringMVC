
package com.emergon.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/* @author emergon */
@Entity
@Table(name = "customer_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerDetail.findAll", query = "SELECT c FROM CustomerDetail c")
    , @NamedQuery(name = "CustomerDetail.findById", query = "SELECT c FROM CustomerDetail c WHERE c.id = :id")
    , @NamedQuery(name = "CustomerDetail.findByAddress", query = "SELECT c FROM CustomerDetail c WHERE c.address = :address")})
public class CustomerDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "address")
    private String address;
    @OneToOne(mappedBy = "detail")
    private Customer customer;

    public CustomerDetail() {
    }

    public CustomerDetail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlTransient
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        if (!(object instanceof CustomerDetail)) {
            return false;
        }
        CustomerDetail other = (CustomerDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emergon.entities.CustomerDetail[ id=" + id + " ]";
    }

}

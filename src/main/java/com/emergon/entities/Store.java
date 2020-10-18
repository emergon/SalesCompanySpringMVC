
package com.emergon.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/* @author emergon */
@Entity
@Table(name = "store")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Store.findAll", query = "SELECT s FROM Store s")
    , @NamedQuery(name = "Store.findByStid", query = "SELECT s FROM Store s WHERE s.stid = :stid")
    , @NamedQuery(name = "Store.findByStname", query = "SELECT s FROM Store s WHERE s.stname = :stname")
    , @NamedQuery(name = "Store.findByStphone", query = "SELECT s FROM Store s WHERE s.stphone = :stphone")})
public class Store implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stid")
    private Integer stid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "stname")
    private String stname;
    @Size(max = 10)
    @Column(name = "stphone")
    private String stphone;
    @ManyToMany(mappedBy = "stores")
    private Set<Salesman> salesmen;

    public Store() {
    }

    public Store(Integer stid) {
        this.stid = stid;
    }

    public Store(Integer stid, String stname) {
        this.stid = stid;
        this.stname = stname;
    }

    public Integer getStid() {
        return stid;
    }

    public void setStid(Integer stid) {
        this.stid = stid;
    }

    public String getStname() {
        return stname;
    }

    public void setStname(String stname) {
        this.stname = stname;
    }

    public String getStphone() {
        return stphone;
    }

    public void setStphone(String stphone) {
        this.stphone = stphone;
    }

    @XmlTransient
    public Set<Salesman> getSalesmen() {
        return salesmen;
    }

    public void setSalesmen(Set<Salesman> salesmen) {
        this.salesmen = salesmen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stid != null ? stid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Store)) {
            return false;
        }
        Store other = (Store) object;
        if ((this.stid == null && other.stid != null) || (this.stid != null && !this.stid.equals(other.stid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emergon.entities.Store[ stid=" + stid + " ]";
    }

}

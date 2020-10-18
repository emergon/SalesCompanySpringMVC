
package com.emergon.entities;

import java.io.Serializable;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/* @author emergon */
@Entity
@Table(name = "family")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Family.findAll", query = "SELECT f FROM Family f")
    , @NamedQuery(name = "Family.findByFid", query = "SELECT f FROM Family f WHERE f.fid = :fid")
    , @NamedQuery(name = "Family.findByFname", query = "SELECT f FROM Family f WHERE f.fname = :fname")
    , @NamedQuery(name = "Family.findByFrelationship", query = "SELECT f FROM Family f WHERE f.frelationship = :frelationship")
    , @NamedQuery(name = "Family.findByDob", query = "SELECT f FROM Family f WHERE f.dob = :dob")})
public class Family implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fid")
    private Integer fid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "fname")
    private String fname;
    @Size(max = 20)
    @Column(name = "frelationship")
    private String frelationship;
    @Column(name = "dob")
    private LocalDate dob;
    @JoinColumn(name = "salesman", referencedColumnName = "scode")
    @ManyToOne
    private Salesman salesman;

    public Family() {
    }

    public Family(Integer fid) {
        this.fid = fid;
    }

    public Family(Integer fid, String fname) {
        this.fid = fid;
        this.fname = fname;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFrelationship() {
        return frelationship;
    }

    public void setFrelationship(String frelationship) {
        this.frelationship = frelationship;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
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
        hash += (fid != null ? fid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Family)) {
            return false;
        }
        Family other = (Family) object;
        if ((this.fid == null && other.fid != null) || (this.fid != null && !this.fid.equals(other.fid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.emergon.entities.Family[ fid=" + fid + " ]";
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author kkk
 */
@Entity
@Table(name = "TRENER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trener.findAll", query = "SELECT t FROM Trener t")
    , @NamedQuery(name = "Trener.findByTrenerId", query = "SELECT t FROM Trener t WHERE t.trenerId = :trenerId")
    , @NamedQuery(name = "Trener.findByImie", query = "SELECT t FROM Trener t WHERE t.imie = :imie")
    , @NamedQuery(name = "Trener.findByNazwisko", query = "SELECT t FROM Trener t WHERE t.nazwisko = :nazwisko")
    , @NamedQuery(name = "Trener.findByEmail", query = "SELECT t FROM Trener t WHERE t.email = :email")})
public class Trener implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TRENER_ID")
    private Integer trenerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "IMIE")
    private String imie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NAZWISKO")
    private String nazwisko;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrener")
    private Collection<Grupa> grupaCollection;

    public Trener() {
    }

    public Trener(Integer trenerId) {
        this.trenerId = trenerId;
    }

    public Trener(Integer trenerId, String imie, String nazwisko, String email) {
        this.trenerId = trenerId;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
    }

    public Integer getTrenerId() {
        return trenerId;
    }

    public void setTrenerId(Integer trenerId) {
        this.trenerId = trenerId;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Grupa> getGrupaCollection() {
        return grupaCollection;
    }

    public void setGrupaCollection(Collection<Grupa> grupaCollection) {
        this.grupaCollection = grupaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trenerId != null ? trenerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trener)) {
            return false;
        }
        Trener other = (Trener) object;
        if ((this.trenerId == null && other.trenerId != null) || (this.trenerId != null && !this.trenerId.equals(other.trenerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Trener[ trenerId=" + trenerId + " ]";
    }
    
}

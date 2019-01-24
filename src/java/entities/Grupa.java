/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kkk
 */
@Entity
@Table(name = "GRUPA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupa.findAll", query = "SELECT g FROM Grupa g")
    , @NamedQuery(name = "Grupa.findByGrupaId", query = "SELECT g FROM Grupa g WHERE g.grupaId = :grupaId")
    , @NamedQuery(name = "Grupa.findByNazwa", query = "SELECT g FROM Grupa g WHERE g.nazwa = :nazwa")})
public class Grupa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GRUPA_ID")
    private Integer grupaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NAZWA")
    private String nazwa;
    @JoinColumn(name = "ID_TRENER", referencedColumnName = "TRENER_ID")
    @ManyToOne(optional = false)
    private Trener idTrener;

    public Grupa() {
    }

    public Grupa(Integer grupaId) {
        this.grupaId = grupaId;
    }

    public Grupa(Integer grupaId, String nazwa) {
        this.grupaId = grupaId;
        this.nazwa = nazwa;
    }

    public Integer getGrupaId() {
        return grupaId;
    }

    public void setGrupaId(Integer grupaId) {
        this.grupaId = grupaId;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Trener getIdTrener() {
        return idTrener;
    }

    public void setIdTrener(Trener idTrener) {
        this.idTrener = idTrener;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupaId != null ? grupaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupa)) {
            return false;
        }
        Grupa other = (Grupa) object;
        if ((this.grupaId == null && other.grupaId != null) || (this.grupaId != null && !this.grupaId.equals(other.grupaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Grupa[ grupaId=" + grupaId + " ]";
    }
    
}

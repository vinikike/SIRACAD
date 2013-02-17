/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guille
 */
@Entity
@Table(name = "otrainformacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Otrainformacion.findAll", query = "SELECT o FROM Otrainformacion o"),
    @NamedQuery(name = "Otrainformacion.findByIdPeriodoEscolar", query = "SELECT o FROM Otrainformacion o WHERE o.otrainformacionPK.idPeriodoEscolar = :idPeriodoEscolar"),
    @NamedQuery(name = "Otrainformacion.findByNie", query = "SELECT o FROM Otrainformacion o WHERE o.otrainformacionPK.nie = :nie"),
    @NamedQuery(name = "Otrainformacion.findByPresentapartida", query = "SELECT o FROM Otrainformacion o WHERE o.presentapartida = :presentapartida"),
    @NamedQuery(name = "Otrainformacion.findByPresentacertificado", query = "SELECT o FROM Otrainformacion o WHERE o.presentacertificado = :presentacertificado"),
    @NamedQuery(name = "Otrainformacion.findByPresentaficha", query = "SELECT o FROM Otrainformacion o WHERE o.presentaficha = :presentaficha"),
    @NamedQuery(name = "Otrainformacion.findByPresentaboletadenotas", query = "SELECT o FROM Otrainformacion o WHERE o.presentaboletadenotas = :presentaboletadenotas"),
    @NamedQuery(name = "Otrainformacion.findByRecibeapoyo", query = "SELECT o FROM Otrainformacion o WHERE o.recibeapoyo = :recibeapoyo"),
    @NamedQuery(name = "Otrainformacion.findByTipodeapoyo", query = "SELECT o FROM Otrainformacion o WHERE o.tipodeapoyo = :tipodeapoyo"),
    @NamedQuery(name = "Otrainformacion.findByActividadeconomica", query = "SELECT o FROM Otrainformacion o WHERE o.actividadeconomica = :actividadeconomica"),
    @NamedQuery(name = "Otrainformacion.findByPartidanumero", query = "SELECT o FROM Otrainformacion o WHERE o.partidanumero = :partidanumero"),
    @NamedQuery(name = "Otrainformacion.findByPartidafolio", query = "SELECT o FROM Otrainformacion o WHERE o.partidafolio = :partidafolio"),
    @NamedQuery(name = "Otrainformacion.findByPartidatomo", query = "SELECT o FROM Otrainformacion o WHERE o.partidatomo = :partidatomo"),
    @NamedQuery(name = "Otrainformacion.findByPartidalibro", query = "SELECT o FROM Otrainformacion o WHERE o.partidalibro = :partidalibro")})
public class Otrainformacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OtrainformacionPK otrainformacionPK;
    @Column(name = "presentapartida")
    private Boolean presentapartida;
    @Column(name = "presentacertificado")
    private Boolean presentacertificado;
    @Column(name = "presentaficha")
    private Boolean presentaficha;
    @Column(name = "presentaboletadenotas")
    private Boolean presentaboletadenotas;
    @Size(max = 50)
    @Column(name = "recibeapoyo")
    private String recibeapoyo;
    @Size(max = 50)
    @Column(name = "tipodeapoyo")
    private String tipodeapoyo;
    @Size(max = 50)
    @Column(name = "actividadeconomica")
    private String actividadeconomica;
    @Column(name = "partidanumero")
    private Integer partidanumero;
    @Column(name = "partidafolio")
    private Integer partidafolio;
    @Column(name = "partidatomo")
    private Integer partidatomo;
    @Column(name = "partidalibro")
    private Integer partidalibro;
    @JoinColumns({
        @JoinColumn(name = "id_periodo_escolar", referencedColumnName = "id_periodo_escolar", insertable = false, updatable = false),
        @JoinColumn(name = "nie", referencedColumnName = "nie", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Alumno alumno;

    public Otrainformacion() {
    }

    public Otrainformacion(OtrainformacionPK otrainformacionPK) {
        this.otrainformacionPK = otrainformacionPK;
    }

    public Otrainformacion(int idPeriodoEscolar, String nie) {
        this.otrainformacionPK = new OtrainformacionPK(idPeriodoEscolar, nie);
    }

    public OtrainformacionPK getOtrainformacionPK() {
        return otrainformacionPK;
    }

    public void setOtrainformacionPK(OtrainformacionPK otrainformacionPK) {
        this.otrainformacionPK = otrainformacionPK;
    }

    public Boolean getPresentapartida() {
        return presentapartida;
    }

    public void setPresentapartida(Boolean presentapartida) {
        this.presentapartida = presentapartida;
    }

    public Boolean getPresentacertificado() {
        return presentacertificado;
    }

    public void setPresentacertificado(Boolean presentacertificado) {
        this.presentacertificado = presentacertificado;
    }

    public Boolean getPresentaficha() {
        return presentaficha;
    }

    public void setPresentaficha(Boolean presentaficha) {
        this.presentaficha = presentaficha;
    }

    public Boolean getPresentaboletadenotas() {
        return presentaboletadenotas;
    }

    public void setPresentaboletadenotas(Boolean presentaboletadenotas) {
        this.presentaboletadenotas = presentaboletadenotas;
    }

    public String getRecibeapoyo() {
        return recibeapoyo;
    }

    public void setRecibeapoyo(String recibeapoyo) {
        this.recibeapoyo = recibeapoyo;
    }

    public String getTipodeapoyo() {
        return tipodeapoyo;
    }

    public void setTipodeapoyo(String tipodeapoyo) {
        this.tipodeapoyo = tipodeapoyo;
    }

    public String getActividadeconomica() {
        return actividadeconomica;
    }

    public void setActividadeconomica(String actividadeconomica) {
        this.actividadeconomica = actividadeconomica;
    }

    public Integer getPartidanumero() {
        return partidanumero;
    }

    public void setPartidanumero(Integer partidanumero) {
        this.partidanumero = partidanumero;
    }

    public Integer getPartidafolio() {
        return partidafolio;
    }

    public void setPartidafolio(Integer partidafolio) {
        this.partidafolio = partidafolio;
    }

    public Integer getPartidatomo() {
        return partidatomo;
    }

    public void setPartidatomo(Integer partidatomo) {
        this.partidatomo = partidatomo;
    }

    public Integer getPartidalibro() {
        return partidalibro;
    }

    public void setPartidalibro(Integer partidalibro) {
        this.partidalibro = partidalibro;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (otrainformacionPK != null ? otrainformacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Otrainformacion)) {
            return false;
        }
        Otrainformacion other = (Otrainformacion) object;
        if ((this.otrainformacionPK == null && other.otrainformacionPK != null) || (this.otrainformacionPK != null && !this.otrainformacionPK.equals(other.otrainformacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.Otrainformacion[ otrainformacionPK=" + otrainformacionPK + " ]";
    }
    
}

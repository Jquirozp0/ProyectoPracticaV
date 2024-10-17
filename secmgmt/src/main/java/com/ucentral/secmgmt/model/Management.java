package com.ucentral.secmgmt.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "management")
@Data
@NoArgsConstructor
public class Management {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "vulnerabilidad_id", referencedColumnName = "id")
    private Vulnerability vulnerabilidad;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(nullable = true, columnDefinition = "DATE")
    private Date fechaHoraGestion;
    private String accionesRealizadas;
    private String comentarios;
    @Lob
    @Column(name = "imagen_soporte",length = 1000000)
    private String imagenSoporte;

   /* private String estado;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vulnerability getVulnerabilidad() {
        return vulnerabilidad;
    }

    public void setVulnerabilidad(Vulnerability vulnerabilidad) {
        this.vulnerabilidad = vulnerabilidad;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getFechaHoraGestion() {
        return fechaHoraGestion;
    }

    public void setFechaHoraGestion(Date fechaHoraGestion) {
        this.fechaHoraGestion = fechaHoraGestion;
    }

    public String getAccionesRealizadas() {
        return accionesRealizadas;
    }

    public void setAccionesRealizadas(String accionesRealizadas) {
        this.accionesRealizadas = accionesRealizadas;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getImagenSoporte() {
        return imagenSoporte;
    }

    public void setImagenSoporte(String imagenSoporte) {
        this.imagenSoporte = imagenSoporte;
    }
}


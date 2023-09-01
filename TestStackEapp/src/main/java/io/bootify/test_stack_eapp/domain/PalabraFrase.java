package io.bootify.test_stack_eapp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Set;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class PalabraFrase {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Long id;

    @Column
    private String contenido;

    @Column(length = 20)
    private String dificultad;

    @Column
    private Boolean aprendido;

    @Column
    private LocalDateTime fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id_id")
    private Usuario usuarioId;

    @OneToMany(mappedBy = "palabraFraseId")
    private Set<Significado> significados;

    @OneToMany(mappedBy = "palabraFraseId")
    private Set<Practica> practicas;

    @OneToMany(mappedBy = "palabraFraseId")
    private Set<Oracion> oraciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_id_id")
    private Tipo tipoId;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(final String contenido) {
        this.contenido = contenido;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(final String dificultad) {
        this.dificultad = dificultad;
    }

    public Boolean getAprendido() {
        return aprendido;
    }

    public void setAprendido(final Boolean aprendido) {
        this.aprendido = aprendido;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(final LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(final Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Set<Significado> getSignificados() {
        return significados;
    }

    public void setSignificados(final Set<Significado> significados) {
        this.significados = significados;
    }

    public Set<Practica> getPracticas() {
        return practicas;
    }

    public void setPracticas(final Set<Practica> practicas) {
        this.practicas = practicas;
    }

    public Set<Oracion> getOraciones() {
        return oraciones;
    }

    public void setOraciones(final Set<Oracion> oraciones) {
        this.oraciones = oraciones;
    }

    public Tipo getTipoId() {
        return tipoId;
    }

    public void setTipoId(final Tipo tipoId) {
        this.tipoId = tipoId;
    }

    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(final OffsetDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(final OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}

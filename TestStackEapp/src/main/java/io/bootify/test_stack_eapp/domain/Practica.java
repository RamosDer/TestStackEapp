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
public class Practica {

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
    private LocalDateTime ultimaFecha;

    @Column
    private Integer conteo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id_id")
    private Usuario usuarioId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "palabra_frase_id_id")
    private PalabraFrase palabraFraseId;

    @OneToMany(mappedBy = "practicaId")
    private Set<Resumen> resumenes;

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

    public LocalDateTime getUltimaFecha() {
        return ultimaFecha;
    }

    public void setUltimaFecha(final LocalDateTime ultimaFecha) {
        this.ultimaFecha = ultimaFecha;
    }

    public Integer getConteo() {
        return conteo;
    }

    public void setConteo(final Integer conteo) {
        this.conteo = conteo;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(final Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public PalabraFrase getPalabraFraseId() {
        return palabraFraseId;
    }

    public void setPalabraFraseId(final PalabraFrase palabraFraseId) {
        this.palabraFraseId = palabraFraseId;
    }

    public Set<Resumen> getResumenes() {
        return resumenes;
    }

    public void setResumenes(final Set<Resumen> resumenes) {
        this.resumenes = resumenes;
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

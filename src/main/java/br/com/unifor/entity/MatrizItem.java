package br.com.unifor.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(
        name = "matriz_item",
        uniqueConstraints = @UniqueConstraint(name = "uk_item_matriz_disciplina", columnNames = {"matriz_id","disciplina_id"})
)
public class MatrizItem extends PanacheEntity {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "matriz_id", nullable = false, foreignKey = @ForeignKey(name = "fk_item_matriz"))
    public MatrizCurricular matriz;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "disciplina_id", nullable = false, foreignKey = @ForeignKey(name = "fk_item_disciplina"))
    public Disciplina disciplina;

    @Min(1)
    @Column(nullable = false)
    public int ordem;
}

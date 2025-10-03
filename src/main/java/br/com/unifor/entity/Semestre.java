package br.com.unifor.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(
        name = "semestre",
        uniqueConstraints = @UniqueConstraint(name = "uk_semestre_ano_periodo", columnNames = {"ano","periodo"})
)
public class Semestre extends PanacheEntity {

    @Min(2000)
    @Column(nullable = false)
    public int ano;

    @Min(1) @Max(2)
    @Column(nullable = false)
    public int periodo; // 1 ou 2

    @Column(nullable = false)
    public boolean ativo = true;
}

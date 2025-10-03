package br.com.unifor.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "disciplina")
public class Disciplina extends PanacheEntity {

    @NotBlank
    @Column(nullable = false, unique = true, length = 20)
    public String codigo;

    @NotBlank
    @Column(nullable = false, length = 140)
    public String nome;

    @Positive
    @Column(nullable = false)
    public int cargaHoraria; // horas
}

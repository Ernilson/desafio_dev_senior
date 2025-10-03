package br.com.unifor.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="curso")
public class Curso extends PanacheEntity {
    @NotBlank
    public String nome;
    @NotBlank @Column(unique = true) public String codigo;
    public boolean ativo = true;
}


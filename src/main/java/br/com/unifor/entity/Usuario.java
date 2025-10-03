package br.com.unifor.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario extends PanacheEntity {

    public String nome;
    public String email;

    @Enumerated(EnumType.STRING)
    public Role role;

    public enum Role {
        ADMINISTRADOR,
        COORDENADOR,
        PROFESSOR,
        ALUNO
    }
}

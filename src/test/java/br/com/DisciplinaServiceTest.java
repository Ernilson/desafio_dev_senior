package br.com;

import br.com.unifor.entity.Curso;
import br.com.unifor.entity.Disciplina;
import br.com.unifor.service.DisciplinaService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class DisciplinaServiceTest {

    @Inject
    DisciplinaService service;

//    @Test
//    void deveCriarUmaDisciplinaComSucesso() {
//
//        Disciplina disciplina = new Disciplina();
//        disciplina.nome = "Matematica";
//        disciplina.codigo = "Test3";
//        disciplina.cargaHoraria = 23;
//
//        Disciplina disciplinaCriado = service.create(disciplina);
//
//        Assertions.assertNotNull(disciplinaCriado, "A disciplina criada não deve ser nula.");
//
//        Assertions.assertNotNull(disciplinaCriado.id, "O ID da disciplina deve ser gerado pelo BD.");
//
//        Assertions.assertEquals("Matematica", disciplinaCriado.nome);
//    }
}

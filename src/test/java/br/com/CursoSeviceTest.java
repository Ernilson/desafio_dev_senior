package br.com;

import br.com.unifor.entity.Curso;

import br.com.unifor.service.CursoService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


@QuarkusTest
public class CursoSeviceTest {

    @Inject
    CursoService service;

    @Test
    void deveCriarCursoComSucesso() {
        // 1. Crie a entidade
        Curso usuario = new Curso();
        usuario.nome = "Fulano da Silva";
        usuario.codigo = "Test";
        usuario.ativo = true;

        // 2. Chame o método do serviço
       Curso curesoCriado = service.criar(usuario);

        Assertions.assertNotNull(curesoCriado, "O curso criado não deve ser nulo.");

        Assertions.assertNotNull(curesoCriado.id, "O ID do curso deve ser gerado pelo BD.");

        Assertions.assertEquals("Fulano da Silva", curesoCriado.nome);
    }
}

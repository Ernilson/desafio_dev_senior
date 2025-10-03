package br.com;

import br.com.unifor.entity.Usuario;
import br.com.unifor.service.UsuarioService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
class UsuarioServiceTest { // Nome mais apropriado para o que você está testando

    // Injete o serviço que você quer testar
    @Inject
    UsuarioService service;

//    @Test
//    void deveCriarUsuarioComSucesso() {
//        // 1. Crie a entidade
//        Usuario usuario = new Usuario();
//        usuario.nome = "Fulano da Silva";
//        usuario.email = "teste@teste.com";
//        // Configure outros campos obrigatórios, como senha, se houver.
//
//        // 2. Chame o método do serviço
//        Usuario usuarioCriado = service.criarUsuario(usuario);
//
//        // 3. Verifique as asserções
//        // Garante que o usuário foi retornado
//        Assertions.assertNotNull(usuarioCriado, "O usuário criado não deve ser nulo.");
//        // Garante que o ID foi gerado (indicando persistência no BD)
//        Assertions.assertNotNull(usuarioCriado.id, "O ID do usuário deve ser gerado pelo BD.");
//        // Garante que o email está correto
//        Assertions.assertEquals("teste@teste.com", usuarioCriado.email);
//    }
}
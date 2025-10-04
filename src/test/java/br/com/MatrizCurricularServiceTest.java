package br.com;

import br.com.unifor.entity.Curso;
import br.com.unifor.entity.MatrizCurricular;
import br.com.unifor.entity.Semestre;
import br.com.unifor.service.MatrizCurricularService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class MatrizCurricularServiceTest {

    @Inject
    MatrizCurricularService service;

    // Variáveis para armazenar as entidades criadas no setup
    private Curso cursoExistente;
    private Semestre semestreExistente;

    /**
     * Este método é executado ANTES de cada @Test.
     * A anotação @Transactional garante que os dados criados aqui
     * estarão disponíveis no banco de dados para o teste que virá a seguir.
     */
    @BeforeEach
    @Transactional
    void setUp() {
        // 1. Limpa os dados de testes anteriores para garantir isolamento
        MatrizCurricular.deleteAll();
        Curso.deleteAll();
        Semestre.deleteAll();

        // 2. Cria e persiste um Curso no banco de dados de teste
        cursoExistente = new Curso();
        cursoExistente.codigo = "CC001";
        cursoExistente.nome = "Ciência da Computação"; // Dando um nome para referência
        cursoExistente.persist();

        // 3. Cria e persiste um Semestre no banco de dados de teste
        semestreExistente = new Semestre();
        semestreExistente.ano = (int) 2025.1;
        semestreExistente.periodo = 1;
        semestreExistente.persist();
    }


    @Test
    @Transactional // Envolve este teste em uma transação que será revertida ao final
    void deveCriarMatrizComSucesso() {
        // --- Ação (Act) ---
        // Chama o método do serviço passando os IDs das entidades que já existem no banco
        MatrizCurricular matrizCriada = service.create(cursoExistente.id, semestreExistente.id, true);

        // --- Verificação (Assert) ---
        // Garante que o serviço retornou um objeto
        Assertions.assertNotNull(matrizCriada, "A matriz criada não deve ser nula.");

        // Garante que a persistência gerou um ID
        Assertions.assertNotNull(matrizCriada.id, "O ID da matriz deve ser gerado pelo banco de dados.");

        // Verifica se os IDs das entidades relacionadas estão corretos
        Assertions.assertEquals(cursoExistente.id, matrizCriada.curso.id, "O ID do curso não corresponde ao esperado.");
        Assertions.assertEquals(semestreExistente.id, matrizCriada.semestre.id, "O ID do semestre não corresponde ao esperado.");

        // Verifica o valor do campo 'ativa'
        Assertions.assertTrue(matrizCriada.ativa, "A matriz deveria ser criada como 'ativa'.");
    }
}
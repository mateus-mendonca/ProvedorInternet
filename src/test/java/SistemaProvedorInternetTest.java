import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

public class SistemaProvedorInternetTest {
    SistemaProvedorInternetMax sistema;

    @BeforeEach
    void setUp() {
        this.sistema = new SistemaProvedorInternetMax();
    }

    @Test
    void testPesquisaCliente() {
        try {
            sistema.pesquisaCliente("99999999999");
            fail("Deveria falhar pois não existe");
        } catch (ClienteNaoExisteException e) {

        }
    }
    @Test
    void testCadastraEPesquisaCliente() {
        try {
            sistema.cadastrarCliente("Mateus", "99999999999", "10/07/2005", "999999999", "Helio",
                    "Osmarina", "a", "83 9999-9999", Plano.planosPadrao.get(0));
            Cliente a = sistema.pesquisaCliente("99999999999");
            assertEquals("Mateus", a.getNome());
            assertEquals("99999999999", a.getCpf());
        } catch ( ClienteJaCadastradoException | ClienteNaoExisteException e) {
            fail("Não deveria lançar exceção.");
        }
    }

    @Test
    void testMostrarPlanos() {
        Collection<Plano> p = sistema.planosDisponiveis();
        assertEquals(Plano.planosPadrao, p);
    }

    @Test
    void testMostrarSituacaoDoCliente() {
        try {
            sistema.cadastrarCliente("Mateus", "99999999999", "10/07/2005", "999999999", "Helio",
                    "Osmarina", "a", "83 9999-9999", Plano.planosPadrao.get(0));
            Cliente a = sistema.pesquisaCliente("99999999999");
            sistema.mostrarSituacaoDoCliente("99999999999");

        } catch (ClienteNaoExisteException e) {
            fail("Não deveria lançar exceção");
        }
    }

    @Test
    void testGerarPagamento() {
        sistema.gerarPagamento("Intermediário");
        assertTrue(Plano.planosPadrao.get(1).getPreco() == 99.9);

    }
}

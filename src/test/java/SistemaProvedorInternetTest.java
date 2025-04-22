import static org.junit.jupiter.api.Assertions.*;

import br.ufpb.dcx.Mateus.*;
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
            Cliente c = new Cliente("Mateus", "99999999999", "10/07/2005", "999999999", "Helio",
                    "Osmarina", "a", "83 9999-9999", Plano.planosPadrao.get(0));
            sistema.cadastrarCliente(c);
            Cliente a = sistema.pesquisaCliente("99999999999");
            assertEquals("Mateus", a.getNome());
            assertEquals("99999999999", a.getCpf());
        } catch (ClienteJaCadastradoException | ClienteNaoExisteException e) {
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
            Cliente c = new Cliente("Mateus", "99999999999", "10/07/2005", "999999999", "Helio",
                    "Osmarina", "a", "83 9999-9999", Plano.planosPadrao.get(0));
            sistema.cadastrarCliente(c);
            Cliente a = sistema.pesquisaCliente("99999999999");
            sistema.mostrarSituacaoDoCliente("99999999999");

        } catch (ClienteNaoExisteException e) {
            fail("Não deveria lançar exceção");
        }
    }

    @Test
    void testGerarPagamento() {
        sistema.gerarPagamento("br.ufpb.dcx.Mateus.Plano Intermediário");
        assertTrue(Plano.planosPadrao.get(1).getPreco() == 99.9);

    }

    @Test
    void testAlterarNomePlano() {
        sistema.alterarNomePlano("br.ufpb.dcx.Mateus.Plano Básico", "br.ufpb.dcx.Mateus.Plano Padrão");
        assertEquals("br.ufpb.dcx.Mateus.Plano Padrão", Plano.planosPadrao.get(0).getNome());
    }

    @Test
    void testAlterarPlanoCliente() {
        Cliente c = new Cliente("Mateus", "99999999999", "10/07/2005", "999999999", "Helio",
                "Osmarina", "a", "83 9999-9999", Plano.planosPadrao.get(0));
        sistema.cadastrarCliente(c);
        sistema.alterarPlanoCliente("99999999999", Plano.planosPadrao.get(2));
        assertEquals(Plano.planosPadrao.get(2), c.getPlano());
    }
}

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class SistemaProvedorInternetPOO implements SistemaProvedorInternet {
    private GravadorDeDados gravadorDeDados;
    private Map<String, Cliente> clienteMap;

    @Override
    public void cadastrarCliente(Cliente cliente) {

    }

    @Override
    public void cadastrarLancamentos() {

    }

    @Override
    public void cadastrarPlano(Planos planos) {

    }

    @Override
    public void alterarPlano(Planos planos) {

    }

    @Override
    public void gerarPagamento() {

    }

    @Override
    public void cadastrarOcorrencia(String ocorrencia) {

    }

    @Override
    public String mostrarSituacaoDoCliente(String cpf) {
        return "";
    }


    @Override
    public Cliente buscaCliente(String cpf) {
        return null;
    }

    @Override
    public void removerCliente(String cpf) {

    }

    @Override
    public Collection<Lancamentos> historicoLancamentos() {
        return List.of();
    }


    @Override
    public Collection<Planos> pesquisaTodosPlanos(String codigo) {
        return List.of();
    }

    @Override
    public void alteraDadosDoCliente(Endereco endereco, String telefone) {

    }

    public void gravarDados() {

    }

    public void recuperaDados() {

    }
}

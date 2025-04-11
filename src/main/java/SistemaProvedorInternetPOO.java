import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class SistemaProvedorInternetPOO implements SistemaProvedorInternet {
    private GravadorDeDados gravadorDeDados;
    private Map<String, Cliente> clienteMap;



    public void gravarDados() {

    }

    public void recuperaDados() {

    }

    @Override
    public void cadastrarCliente(String nome, String cpf, String dataDeNascimento, Endereco endereco,
                                 String telefone, Plano planos) {
        Cliente cliente = new Cliente(nome, cpf, dataDeNascimento, endereco,
                telefone, planos);
        this.clienteMap.put(cpf, cliente);
    }

    @Override
    public void cadastrarPlano(String codigo, String nome, String descricao, float preco) {
        Plano plano = new Plano(codigo, nome, descricao, preco);
        Plano.planosPadrao.add(plano);
    }

    @Override
    public Cliente pesquisaCliente(String cpf) {
        if (!clienteMap.containsKey(cpf))
            return null;
        return clienteMap.get(cpf);
    }

    @Override
    public Collection<String> pesquisaTodosPlanos() {
        Collection<String> planos = new ArrayList<>();
        for (Plano p : Plano.planosPadrao) {
            planos.add(p.toString());
        }
        return planos;
    }

    @Override
    public void removerCliente(String cpf) {

    }

    @Override
    public void alterarPlano(Plano planos) {

    }

    @Override
    public void alterarPlanoCliente(String cpf, Plano planos) {

    }

    @Override
    public void alteraDadosDoCliente(Endereco endereco, String telefone) {

    }

    @Override
    public void gerarPagamento() {

    }

    @Override
    public void renovarIP(String ip) {

    }

    @Override
    public void cadastrarOcorrencia(String ocorrencia) {

    }

    @Override
    public String mostrarSituacaoDoCliente(String cpf) {
        return "";
    }
}

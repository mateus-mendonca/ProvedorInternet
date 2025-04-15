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
    public void cadastrarCliente(String nome, String CPF, String dataDeNascimento, Endereco endereco,
                                 String telefone, Plano planos) throws ClienteJaCadastradoException {
        if (this.clienteMap.containsKey(CPF))
            throw new ClienteJaCadastradoException("Cliente já cadastrado no sistema.");
        Cliente cliente = new Cliente(nome, CPF, dataDeNascimento, endereco,
                telefone, planos);
        this.clienteMap.put(CPF, cliente);
    }

    @Override
    public void cadastrarPlano(String nome, String descricao, float preco) {
        Plano plano = new Plano(nome, descricao, preco);
        Plano.planosPadrao.add(plano);
    }

    @Override
    public Cliente pesquisaCliente(String CPF) throws ClienteNaoExisteException {
        if (!clienteMap.containsKey(CPF))
            throw new ClienteNaoExisteException("Cliente não encontrado.");
        return clienteMap.get(CPF);
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
    public void removerCliente(String CPF) throws ClienteNaoExisteException{
        if (!clienteMap.containsKey(CPF))
            throw new ClienteNaoExisteException("Cliente não encontrado.");
        this.clienteMap.remove(CPF);
    }

    @Override
    public void alterarNomePlano(String nome, String novoNome) {
        for (Plano p : Plano.planosPadrao) {
            if (p.getNome().equals(nome)) {
                p.setNome(novoNome);
            }
        }
    }

    @Override
    public void alterarDescPlano(String nome, String novaDescricao) {
        for (Plano p : Plano.planosPadrao) {
            if (p.getNome().equals(nome)) {
                p.setDescricao(novaDescricao);
            }
        }
    }

    @Override
    public void alterarPrecoPlano(String nome, float novoPreco) {
        for (Plano p : Plano.planosPadrao) {
            if (p.getNome().equals(nome)) {
                p.setPreco(novoPreco);
            }
        }
    }

    @Override
    public void alterarPlanoCliente(String CPF, Plano novoPlano) {
        for (Cliente c : clienteMap.values())
            if (c.getCpf().equals(CPF))
                c.setPlanos(novoPlano);
    }

    @Override
    public void alteraEnderecoCliente(String CPF, Endereco endereco) {
        for (Cliente c : clienteMap.values())
            if (c.getCpf().equals(CPF)) {
                c.setEndereco(endereco);
            }
    }

    @Override
    public void alteraTelefoneCliente(String CPF, String novoTelefone) {
        for (Cliente c : clienteMap.values())
            if (c.getCpf().equals(CPF)) {
                c.setTelefone(novoTelefone);
            }
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

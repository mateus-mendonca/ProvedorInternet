import java.util.Collection;

public interface SistemaProvedorInternet {
    //CADASTROS
    void cadastrarCliente(String nome, String cpf, String dataDeNascimento, String rg, String nomePai,
                          String nomeMae, String endereco, String telefone, Plano plano) throws ClienteJaCadastradoException;
    void cadastrarPlano(String nome, String descricao, double preco);

    //PESQUISA
    Cliente pesquisaCliente(String cpf) throws ClienteNaoExisteException;
    Collection<String> pesquisaTodosPlanos();

    //REMOÇÃO
    void removerCliente(String cpf) throws ClienteNaoExisteException;

    //ALTERAÇÃO DE PLANOS
    void alterarNomePlano(String nome, String novoNome);
    void alterarDescPlano(String nome, String novaDescricao);
    void alterarPrecoPlano(String nome, double novoPreco);
    void alterarPlanoCliente(String cpf, Plano planos) throws ClienteNaoExisteException;

    //ALTERAÇÃO DE DADOS DO CLIENTE
    void alteraEnderecoCliente(String cpf, String endereco);
    void alteraTelefoneCliente(String cpf, String telefone);

    void gerarPagamento();

    void mostrarSituacaoDoCliente(String cpf) throws ClienteNaoExisteException;

}

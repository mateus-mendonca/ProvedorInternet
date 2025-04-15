import java.util.Collection;

public interface SistemaProvedorInternet {
    //CADASTROS
    void cadastrarCliente(String nome, String cpf, String dataDeNascimento, Endereco endereco,
                          String telefone, Plano planos) throws ClienteJaCadastradoException;
    void cadastrarPlano(String nome, String descricao, float preco);

    //PESQUISA
    Cliente pesquisaCliente(String cpf) throws ClienteNaoExisteException;
    Collection<String> pesquisaTodosPlanos();

    //REMOÇÃO
    void removerCliente(String cpf) throws ClienteNaoExisteException;

    //ALTERAÇÃO DE PLANOS
    void alterarNomePlano(String nome, String novoNome);
    void alterarDescPlano(String nome, String novaDescricao);
    void alterarPrecoPlano(String nome,float novoPreco);
    void alterarPlanoCliente(String cpf, Plano planos) throws ClienteNaoExisteException;

    //ALTERAÇÃO DE DADOS DO CLIENTE
    void alteraEnderecoCliente(String cpf, Endereco endereco);
    void alteraTelefoneCliente(String cpf, String telefone);

    void gerarPagamento();
    //gerarIP
    void renovarIP(String ip);
    void cadastrarOcorrencia(String ocorrencia);
    String mostrarSituacaoDoCliente(String cpf);

}

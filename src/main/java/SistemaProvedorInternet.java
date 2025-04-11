import java.util.Collection;

public interface SistemaProvedorInternet {
    //CADASTROS
    void cadastrarCliente(String nome, String cpf, String dataDeNascimento, Endereco endereco,
                          String telefone, Plano planos);
    void cadastrarPlano(String codigo, String nome, String descricao, float preco);

    //PESQUISA
    Cliente pesquisaCliente(String cpf);
    Collection<String> pesquisaTodosPlanos();

    //REMOÇÃO E ALTERAÇÃO
    void removerCliente(String cpf);
    void alterarPlano(Plano planos);
    void alterarPlanoCliente(String cpf, Plano planos);
    void alteraDadosDoCliente(Endereco endereco, String telefone);

    void gerarPagamento();
    //gerarIP
    void renovarIP(String ip);
    void cadastrarOcorrencia(String ocorrencia);
    String mostrarSituacaoDoCliente(String cpf);

}

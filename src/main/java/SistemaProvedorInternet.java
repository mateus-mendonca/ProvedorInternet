import java.util.Collection;

public interface SistemaProvedorInternet {
    //CADASTROS
    void cadastrarCliente(Cliente cliente);
    void cadastrarLancamentos();
    void cadastrarPlano(Planos planos);

    //BUSCA
    Cliente buscaCliente(String cpf);
    Collection<Planos> pesquisaTodosPlanos(String codigo);
    Collection<Lancamentos> historicoLancamentos();

    //REMOÇÃO E ALTERAÇÃO
    void removerCliente(String cpf);
    void alterarPlano(Planos planos);
    void alteraDadosDoCliente(Endereco endereco, String telefone);

    void gerarPagamento();
    void cadastrarOcorrencia(String ocorrencia);
    String mostrarSituacaoDoCliente(String cpf);

}

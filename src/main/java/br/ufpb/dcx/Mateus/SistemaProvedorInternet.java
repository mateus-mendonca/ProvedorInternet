package br.ufpb.dcx.Mateus;

import java.util.Collection;

public interface SistemaProvedorInternet {
    //CADASTROS
    void cadastrarCliente(Cliente cliente) throws ClienteJaCadastradoException;
    void cadastrarPlano(String nome, String descricao, double preco);

    //PESQUISA
    Cliente pesquisaCliente(String cpf) throws ClienteNaoExisteException;
    Collection<Plano> planosDisponiveis();

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

    void gerarPagamento(String escolhaPlano);

    void mostrarSituacaoDoCliente(String cpf) throws ClienteNaoExisteException;

}

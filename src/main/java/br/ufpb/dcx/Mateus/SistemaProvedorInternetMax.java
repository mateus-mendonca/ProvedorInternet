package br.ufpb.dcx.Mateus;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SistemaProvedorInternetMax implements SistemaProvedorInternet {
    private GravadorDeDados gravadorDeDados;
    private Map<String, Cliente> clienteMap;

    public SistemaProvedorInternetMax() {
        this.clienteMap = new HashMap<>();
        this.gravadorDeDados = new GravadorDeDados();
    }



    public void gravarDados() throws IOException {
        this.gravadorDeDados.gravaDados(this.clienteMap.values());

    }

    public void recuperaDados() throws IOException {
        Collection<Cliente> clientesAchados = this.gravadorDeDados.recuperaDados();
        for (Cliente c : clientesAchados) {
            this.cadastrarCliente(c);
        }
    }

    @Override
    public void cadastrarCliente(Cliente cliente) throws ClienteJaCadastradoException {
        if (this.clienteMap.containsKey(cliente.getCpf()))
            throw new ClienteJaCadastradoException("Cliente já cadastrado no sistema.");
//        br.ufpb.dcx.Mateus.Cliente cliente = new br.ufpb.dcx.Mateus.Cliente(nome, cpf, dataDeNascimento, rg, nomePai, nomeMae, endereco,
//                telefone, plano);
//        this.clienteMap.put(cpf, cliente);
        clienteMap.put(cliente.getCpf(), cliente);
    }

    @Override
    public void cadastrarPlano(String nome, String descricao, double preco) {
        Plano plano = new Plano(nome, descricao, preco);
        Plano.planosPadrao.add(plano);
    }

    @Override
    public Cliente pesquisaCliente(String cpf) throws ClienteNaoExisteException {
        if (!clienteMap.containsKey(cpf))
            throw new ClienteNaoExisteException("Cliente não encontrado.");
        return clienteMap.get(cpf);
    }

    @Override
    public Collection<Plano> planosDisponiveis() {
        return Plano.planosPadrao;
//        Collection<String> planos = new ArrayList<>();
//        for (br.ufpb.dcx.Mateus.Plano p : br.ufpb.dcx.Mateus.Plano.planosPadrao) {
//            planos.add(p.toString());
//        }
//        return planos;
    }

    @Override
    public void removerCliente(String cpf) throws ClienteNaoExisteException{
        if (!clienteMap.containsKey(cpf))
            throw new ClienteNaoExisteException("Cliente não encontrado.");
        this.clienteMap.remove(cpf);
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
    public void alterarPrecoPlano(String nome, double novoPreco) {
        for (Plano p : Plano.planosPadrao) {
            if (p.getNome().equals(nome)) {
                p.setPreco(novoPreco);
            }
        }
    }

    @Override
    public void alterarPlanoCliente(String cpf, Plano novoPlano) {
        clienteMap.values().stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst()
                .ifPresent(c -> c.setPlano(novoPlano));
    }
//        for (br.ufpb.dcx.Mateus.Cliente c : clienteMap.values())
//            if (c.getCpf().equals(cpf)) {
//                c.setPlano(novoPlano);
//                break;
//            }
//    }

    @Override
    public void alteraEnderecoCliente(String cpf, String novoEndereco) {
        for (Cliente c : clienteMap.values())
            if (c.getCpf().equals(cpf)) {
                c.setEndereco(novoEndereco);
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
    public void gerarPagamento(String escolhaPlano) {
        for (Plano p : Plano.planosPadrao) {
            if (p.getNome().equals(escolhaPlano)) {
                System.out.println("O plano de sua escolha "+ p.getNome() +" custará R$ " + p.getPreco() + ". Envie o" +
                        " " +
                        "dinheiro para maxconnect@gmail.com e comece a desfrutar dos seus benefícios." +
                        " ");
            }
        }
    }

    @Override
    public void mostrarSituacaoDoCliente(String cpf) throws ClienteNaoExisteException {
        Cliente cliente = this.clienteMap.get(cpf);
        if (!this.clienteMap.containsKey(cpf))
            throw new ClienteNaoExisteException("Cliente não encontrado.");
        System.out.println("----- Situação do Cliente -----");
        System.out.println("Nome: " + this.clienteMap.get(cpf).getNome());
        System.out.println("CPF: " + this.clienteMap.get(cpf).getCpf());
        System.out.println("Plano: " + this.clienteMap.get(cpf).getPlano());
//
//        String statusPagamento = cliente.pagamentosEmDia() ? "Em dia" : "Em atraso";
//        System.out.println("Pagamento: " + statusPagamento);
//        System.out.println("---------------------------------\n");
    }
}

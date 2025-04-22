package Gui.br.com.servidor.projetologin.ActionListeners;

import br.ufpb.dcx.Mateus.*;
import Gui.br.com.servidor.projetologin.TelaCadastroCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarCliente implements ActionListener {

    private SistemaProvedorInternetMax sistema;
    private JFrame janelaPrincipal;

    public CadastrarCliente(SistemaProvedorInternetMax sistema, JFrame janelaPrincipal) {
        this.sistema = sistema;
        this.janelaPrincipal = janelaPrincipal;
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        try {

            String nome = JOptionPane.showInputDialog(janelaPrincipal, "Nome do cliente.");
            String cpf = JOptionPane.showInputDialog(janelaPrincipal, "CPF: ");
            String dataDeNascimento = JOptionPane.showInputDialog(janelaPrincipal, "Data de Nascimento. ");
            String rg = JOptionPane.showInputDialog(janelaPrincipal, "RG.");
            String nomePai = JOptionPane.showInputDialog(janelaPrincipal, "Nome do pai.");
            String nomeMae = JOptionPane.showInputDialog(janelaPrincipal, "Nome da mãe.");
            String endereco = JOptionPane.showInputDialog(janelaPrincipal, "Endereço.");
            String telefone = JOptionPane.showInputDialog(janelaPrincipal, "Telefone.");
            Plano plano = Plano.planosPadrao.get(Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Plano 1, 2 ou 3")));
            Cliente c = new Cliente(nome, cpf, dataDeNascimento, rg, nomePai, nomeMae, endereco, telefone, plano);
            sistema.cadastrarCliente(c);
        } catch (ClienteJaCadastradoException e) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Erro ao cadastrar Cliente: "+ e.getMessage());
            e.printStackTrace();
        }
    }
}

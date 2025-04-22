package Gui.br.com.servidor.projetologin.ActionListeners;

import br.ufpb.dcx.Mateus.Cliente;
import br.ufpb.dcx.Mateus.ClienteNaoExisteException;
import br.ufpb.dcx.Mateus.SistemaProvedorInternetMax;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PesquisarCliente implements ActionListener {

    private SistemaProvedorInternetMax sistema;
    private JFrame janelaPrincipal;


    public PesquisarCliente(SistemaProvedorInternetMax sistema, JFrame janelaPrincipal) {
        this.sistema = sistema;
        this.janelaPrincipal = janelaPrincipal;
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        String cpf = JOptionPane.showInputDialog(janelaPrincipal, "Digite o cpf do cliente: ");
        try {
            JOptionPane.showMessageDialog(janelaPrincipal, "Jogo encontrado!" + sistema.pesquisaCliente(cpf));
        } catch (ClienteNaoExisteException e) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Jogo inexistente!" + e.getMessage());
        }

    }
}

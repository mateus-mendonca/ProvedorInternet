package Gui.br.com.servidor.projetologin.ActionListeners;

import java.awt.event.ActionListener;

import br.ufpb.dcx.Mateus.*;
import Gui.br.com.servidor.projetologin.TelaCadastroCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class SalvarDadosCliente implements ActionListener {

    private SistemaProvedorInternetMax sistema;
    private JFrame janelaPrincipal;

    public SalvarDadosCliente(SistemaProvedorInternetMax sistema, JFrame janelaPrincipal) {
        this.sistema = sistema;
        this.janelaPrincipal = janelaPrincipal;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            sistema.gravarDados();
        } catch (IOException ex) {
            ex.getStackTrace();
        }
        JOptionPane.showMessageDialog(janelaPrincipal, "Dados salvos com sucesso.");
    }
}

package br.ufpb.dcx.Mateus;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class TestaGravador {
    public static void main(String[] args) {

        Cliente c1 = new br.ufpb.dcx.Mateus.Cliente("Nome", "11111111111", "01/01/2001", "111111111", "Nome Pai", "Nome Mãe", "Endereço"
                , "11 11111111", Plano.planosPadrao.get(1));
        List<Cliente> clientes = new LinkedList<>();
        clientes.add(c1);

        GravadorDeDados gravadorDeDados = new GravadorDeDados();
        System.out.println("Recuperando dados do cliente:");
        try {
            Collection<Cliente> clientesAchados = gravadorDeDados.recuperaDados();
            System.out.println("Clientes achados: ");
            for (Cliente c : clientesAchados) {
                System.out.println(c.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            gravadorDeDados.gravaDados(clientes);
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

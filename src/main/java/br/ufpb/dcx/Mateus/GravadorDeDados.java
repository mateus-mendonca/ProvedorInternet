package br.ufpb.dcx.Mateus;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class GravadorDeDados {

    private String arquivoCliente;

    public GravadorDeDados () {
        this.arquivoCliente = "clientes.dat";
    }

    public Collection<Cliente> recuperaDados() throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.arquivoCliente))) {
            Collection<Cliente> dadosRecuperados = (ArrayList<Cliente>) in.readObject();
            return dadosRecuperados;
        } catch (ClassNotFoundException | ClassCastException e) {
            throw new IOException(e);
        }
    }

    public void gravaDados(Collection<Cliente> clientes) throws IOException {
        ArrayList<Cliente> clientesArrayList = new ArrayList<>();
        clientesArrayList.addAll(clientes);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.arquivoCliente))) {
            out.writeObject(clientesArrayList);
        }
    }
}
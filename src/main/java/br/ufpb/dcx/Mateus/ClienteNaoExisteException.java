package br.ufpb.dcx.Mateus;

public class ClienteNaoExisteException extends RuntimeException {
    public ClienteNaoExisteException(String message) {
        super(message);
    }
}

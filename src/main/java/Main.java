public class Main {
    public static void main(String[] args) {
        SistemaProvedorInternetPOO sistema = new SistemaProvedorInternetPOO();

//        sistema.cadastrarCliente("Mateus", "70069770450", "10/07/2005", "231241434", "Helio",
//                "Osmarina", "a", "83 9999-9999", Plano.planosPadrao.get(0));
        Cliente cliente1 = new Cliente("Mateus", "70069770450", "10/07/2005", "231241434", "Helio",
                "Osmarina", "a", "83 9999-9999", Plano.planosPadrao.get(0));
        try {
            sistema.mostrarSituacaoDoCliente("70069770450");
        } catch (ClienteNaoExisteException e) {
            System.out.println(e.getMessage());;
        }
    }
}

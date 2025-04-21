public class Main {
    public static void main(String[] args) {
        SistemaProvedorInternetMax sistema = new SistemaProvedorInternetMax();

//        sistema.cadastrarCliente("Mateus", "70069770450", "10/07/2005", "231241434", "Helio",
//                "Osmarina", "a", "83 9999-9999", Plano.planosPadrao.get(0));
        Cliente cliente1 = new Cliente("Mateus", "99999999999", "10/07/2005", "231241434", "Helio",
                "Osmarina", "a", "83 9999-9999", Plano.planosPadrao.get(0));
        try {
            sistema.mostrarSituacaoDoCliente("99999999999");
        } catch (ClienteNaoExisteException e) {
            System.out.println(e.getMessage());;
        }
        System.out.println(sistema.planosDisponiveis());
    }
}

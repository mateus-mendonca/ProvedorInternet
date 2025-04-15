import java.util.ArrayList;
import java.util.List;

public class Plano {
    private String nome;
    private String descricao;
    private float preco;

    public Plano(String nome, String descricao, float preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome + " - " + descricao + " - R$" + preco;
    }




    public static final List<Plano> planosPadrao = new ArrayList<>(List.of(
            new Plano("Plano Básico", "Internet 100Mbps", 79.90f),
            new Plano("Intermediário", "Internet 300Mbps", 99.90f),
            new Plano("Avançado", "Internet 600Mbps", 149.90f)
    ));
}

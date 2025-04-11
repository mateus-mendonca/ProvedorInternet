import java.util.ArrayList;
import java.util.List;

public class Plano {
    private String codigo;
    private String nome;
    private String descricao;
    private float preco;

    public Plano(String codigo, String nome, String descricao, float preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
            new Plano("01", "Plano Básico", "Internet 100Mbps", 79.90f),
            new Plano("02", "Intermediário", "Internet 300Mbps", 99.90f),
            new Plano("03", "Avançado", "Internet 600Mbps", 149.90f)
    ));
}

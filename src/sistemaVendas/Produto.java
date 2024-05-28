package sistemaVendas;

public class Produto {
//declarando atributos da classe produto
    private int id;
    private String descricao;
    private double preco;
//construtor da classe produto  
    public Produto(int id, String descricao, double preco) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
    }
//metodos getters
    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Descrição: " + descricao + ", Preço: " + preco;
    }
}

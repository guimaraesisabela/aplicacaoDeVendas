package sistemaVendas;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

//criando array para armazenar dados 
public class ProdutoTableModel extends AbstractTableModel {

//declara um array de strings chamado colunas que contém os nomes das colunas da tabela.
    private final String[] colunas = {"ID", "Descrição", "Preço"}; //variavel de instancia
    private ArrayList<Produto> produtos; 
    
//cnstrutor q recebe uma lista de produtos como parâmetro e a atribui à variável de instância produtos.
   public ProdutoTableModel(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public int getRowCount() {
        return produtos.size();
    
    } //pegando os valores de linha e da coluna 

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
//metodo q fornece os valores p/ as celulas da tabela
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produto = produtos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return produto.getId();
            case 1:
                return produto.getDescricao();
            case 2:
                return produto.getPreco();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
}

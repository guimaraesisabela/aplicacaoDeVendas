package sistemaVendas;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ProdutoTableModel extends AbstractTableModel {
    private final String[] colunas = {"ID", "Descrição", "Preço"};
    private ArrayList<Produto> produtos;

    public ProdutoTableModel(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public int getRowCount() {
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

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

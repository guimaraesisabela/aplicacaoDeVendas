//FRAME LISTAGEM DE PRODUTOS
package sistemaVendas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProdutosFrame extends JFrame {
    private ArrayList<Produto> produtos;
    private JTable tabela;
    private ProdutoTableModel tableModel;
    
//construtor	 
    public ProdutosFrame() {
        setTitle("Produtos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

 //criando um array e atribuindo a produtos
        produtos = new ArrayList<>();

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton novoButton = new JButton("Novo");
        JButton pesquisarButton = new JButton("Pesquisar");
        JButton excluirButton = new JButton("Excluir");
        JButton atualizarButton = new JButton("Atualizar");

        panel.add(novoButton);
        panel.add(pesquisarButton);
        panel.add(excluirButton);
        panel.add(atualizarButton);

        add(panel, BorderLayout.NORTH);

        tableModel = new ProdutoTableModel(produtos);
        tabela = new JTable(tableModel);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        novoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NovoProdutoDialog dialog = new NovoProdutoDialog(ProdutosFrame.this);
                dialog.setVisible(true);
                atualizarTabela();
            }
        });

        pesquisarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idStr = JOptionPane.showInputDialog("Informe o ID ou a descrição:");
                if (idStr != null) {
                    pesquisarProduto(idStr);
                }
            }
        });

        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tabela.getSelectedRow();
                if (selectedRow >= 0) {
                    int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?");
                    if (confirm == JOptionPane.YES_OPTION) {
                        produtos.remove(selectedRow);
                        atualizarTabela();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um produto para excluir.");
                }
            }
        });

        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarTabela();
            }
        });
    }
//metodo para btn pesquisar
    private void pesquisarProduto(String idStr) {
        try {
            int id = Integer.parseInt(idStr);
            for (Produto produto : produtos) {
                if (produto.getId() == id) {
                    JOptionPane.showMessageDialog(null, "Produto encontrado: " + produto);
                    return;
                }
            }
        } catch (NumberFormatException e) {
            for (Produto produto : produtos) {
                if (produto.getDescricao().equalsIgnoreCase(idStr)) {
                    JOptionPane.showMessageDialog(null, "Produto encontrado: " + produto);
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Produto não encontrado.");
    }

    private void atualizarTabela() {
        tableModel.fireTableDataChanged();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        atualizarTabela();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ProdutosFrame frame = new ProdutosFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

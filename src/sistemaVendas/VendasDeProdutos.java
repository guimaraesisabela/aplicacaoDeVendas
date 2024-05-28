package sistemaVendas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VendasDeProdutos extends JFrame {
//array p/ armazenar os produtos
    private ArrayList<String> produtosList; 

 //construtor chamado quando um obj é criado
    public VendasDeProdutos() {
        setTitle("Vendas de Produtos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

// iniciando uma lista vazia
        produtosList = new ArrayList<>();

        JPanel mainPanel = new JPanel(new BorderLayout());
        getContentPane().add(mainPanel);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());

// criando componentes
        JLabel lblId = new JLabel("Id:");
        JTextField txtId = new JTextField(10);

        JLabel lblCliente = new JLabel("Cliente:");
        JTextField txtCliente = new JTextField(20);

        JLabel lblProduto = new JLabel("Produto:");
        JTextField txtProduto = new JTextField(20); 

        JLabel lblQuantidade = new JLabel("Quantidade:");
        JTextField txtQuantidade = new JTextField(5);

        JLabel lblPreco = new JLabel("Preço:");
        JTextField txtPreco = new JTextField(10);

        JButton btnAdicionar = new JButton("Adicionar");

// adicionando os componentes ao painel, indicando suas posições
        addComponent(formPanel, lblId, 0, 0);
        addComponent(formPanel, txtId, 1, 0);
        addComponent(formPanel, lblCliente, 0, 1);
        addComponent(formPanel, txtCliente, 1, 1);
        addComponent(formPanel, lblProduto, 0, 2);
        addComponent(formPanel, txtProduto, 1, 2); 
        addComponent(formPanel, lblQuantidade, 0, 3);
        addComponent(formPanel, txtQuantidade, 1, 3);
        addComponent(formPanel, lblPreco, 0, 4);
        addComponent(formPanel, txtPreco, 1, 4);
        addComponent(formPanel, btnAdicionar, 1, 5);

        mainPanel.add(formPanel, BorderLayout.NORTH);

// tabela pedidos do dia
        String[] columnNames = {"Id", "Produto", "Cliente", "Quantidade", "Preço", "Total"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

// adc funcionalidade ao btn adicionar
        btnAdicionar.addActionListener(e -> {
            String id = txtId.getText();
            String cliente = txtCliente.getText();
            String produto = txtProduto.getText(); //p/ obter o nome do produto do campo de texto
            String quantidade = txtQuantidade.getText();
            String preco = txtPreco.getText();

// verificando se o nome do produto foi inserido
            if (!produto.isEmpty()) {
                // calculando o total baseado na quantidade e no preço 
                String total = String.valueOf(Integer.parseInt(quantidade) * Double.parseDouble(preco));

                Object[] row = {id, produto, cliente, quantidade, preco, total};
                model.addRow(row);

// limapando campo de texto dps de adicionar o produto 
                txtProduto.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, insira o nome do produto.");
            }
        });
    }

//adicionando componentes ao painel
    private void addComponent(JPanel panel, JComponent component, int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(component, gbc);
    }
//metodo inciando o programa
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VendasDeProdutos().setVisible(true);
        });
    }
}
//Lembrete: GridBagConstraints e GridBagLayout sao classes usadas para a organização dos componentes 

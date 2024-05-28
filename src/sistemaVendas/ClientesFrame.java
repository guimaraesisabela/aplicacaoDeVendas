package sistemaVendas;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientesFrame extends JFrame {
//metodos declarando componentes do frame
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel tableModel;

// começando o construtor da classe ClientesFrame
    public ClientesFrame() {
        setTitle("Clientes");
        setSize(557, 275);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null); //criando Jpanel e informando que o layout nao sera o padrao
    
        JButton novoButton = new JButton("Novo"); //criando botao e adicionando uma ação a ele
        novoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, "Novo Cliente", "01/01/2024"}); //adicionando o nome do cliente na linha da tabela
            }
        });
        novoButton.setBounds(54, 28, 100, 30);
        contentPane.add(novoButton); //definindo o tamanho e adicionando o botao no frame
        
        JButton pesquisarButton = new JButton("Pesquisar");
        pesquisarButton.setBounds(227, 28, 100, 30);
        contentPane.add(pesquisarButton); //criando botao e adicionando uma ação a ele
        
        JButton excluirButton = new JButton("Excluir"); //configurando o botao excluir, adicionando um evento e fazendo um if para mensagem de confirmação
        excluirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    int confirm = JOptionPane.showConfirmDialog(ClientesFrame.this, 
                        "Deseja realmente excluir o registro selecionado?", "Confirmação", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        tableModel.removeRow(selectedRow);
                    }
                }
            }
        });
        excluirButton.setBounds(388, 28, 100, 30);
        contentPane.add(excluirButton); //estabelecendo os tamanhos e adicionando ao frame

// definindo as colunas do JTable
        String[] columnNames = {"Id", "Nome", "Dt.Cadastro"};
        
// dados exemplos iniciais da tabela
        Object[][] data = {
            {1, "Isabela", "06/07/2024"}
        };

        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 80, 520, 150);
        contentPane.add(scrollPane);
    }

// método main(onde o programa começa)
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ClientesFrame frame = new ClientesFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

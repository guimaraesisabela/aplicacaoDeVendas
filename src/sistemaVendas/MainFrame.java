package sistemaVendas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//declaração da classe main
public class MainFrame extends JFrame {
	
//construtor da classe
    public MainFrame() {
        setTitle("Sistema de Vendas");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
//criando painel
        JPanel panel = new JPanel();
//criando os botões
        
        JButton clientesButton = new JButton("Clientes");
        clientesButton.setBounds(92, 22, 101, 30);
        JButton produtosButton = new JButton("Produtos");
        produtosButton.setBounds(92, 62, 101, 30);
        JButton vendasButton = new JButton("Vendas");
        vendasButton.setBounds(92, 102, 101, 30);

        panel.setLayout(null);

        panel.add(clientesButton);
        panel.add(produtosButton);
        panel.add(vendasButton);

        getContentPane().add(panel);
        
//definindo ações para os botões
//metodo do objeto "botao clientes"
        clientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientesFrame clientesFrame = new ClientesFrame();
                clientesFrame.setVisible(true);
            }
        });
//metodo do objeto "botao produtos"
        produtosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProdutosFrame produtosFrame = new ProdutosFrame();
                produtosFrame.setVisible(true);
            }
        });
    
 //metodo do objeto botao vendas
    vendasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            VendasDeProdutos vendasFrame = new VendasDeProdutos();
            vendasFrame.setVisible(true);
        }
    });
}
//programa começa aqui
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

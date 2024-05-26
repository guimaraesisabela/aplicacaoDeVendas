package sistemaVendas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Sistema de Gerenciamento");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        int buttonWidth = 80;
        int buttonHeight = 30;
        int spacing = 10;
        int xOffset = 30;

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

        clientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientesFrame clientesFrame = new ClientesFrame();
                clientesFrame.setVisible(true);
            }
        });

        produtosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProdutosFrame produtosFrame = new ProdutosFrame();
                produtosFrame.setVisible(true);
            }
        });
    }

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

package sistemaVendas;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClientesFrame extends JFrame {

    private JPanel contentPane;

  // começando o construtor da classe ClientesFrame
    public ClientesFrame() {
        setTitle("Clientes");
        setSize(364, 204);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null); //s/ layout automatico
        
        JButton novoButton = new JButton("Novo");
        novoButton.setBounds(124, 28, 100, 30);
        contentPane.add(novoButton);
        
        JButton pesquisarButton = new JButton("Pesquisar");
        pesquisarButton.setBounds(124, 68, 100, 30);
        contentPane.add(pesquisarButton);
        
        JButton excluirButton = new JButton("Excluir");
        excluirButton.setBounds(124, 108, 100, 30);
        contentPane.add(excluirButton);
    }
//metodo main(onde o programa começa)
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


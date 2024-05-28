package sistemaVendas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NovoProdutoDialog extends JDialog {
//campos para inserir os dados
    private JTextField idField;
    private JTextField descricaoField;
    private JTextField precoField;
    private ProdutosFrame parent; //criação de novo produto

    public NovoProdutoDialog(ProdutosFrame parent) {
        super(parent, "Novo Produto", true);
        this.parent = parent;

        setLayout(new GridLayout(4, 2));
        setSize(300, 200);
//adicionando componentes
        add(new JLabel("ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Descrição:"));
        descricaoField = new JTextField();
        add(descricaoField);

        add(new JLabel("Preço:"));
        precoField = new JTextField();
        add(precoField);

        JButton adicionarButton = new JButton("Adicionar");
        add(adicionarButton);

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                String descricao = descricaoField.getText();
                double preco = Double.parseDouble(precoField.getText());
                Produto produto = new Produto(id, descricao, preco); //criando objeto produto c/ valores id, desc e preço
                parent.adicionarProduto(produto); //parent referencia a janela principal ProdutosFrame
                dispose(); // fechando a caixa de dialogo
            }
        });
    }
}


package br.com.feltex.excel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InputInicial extends JFrame {

    public InputInicial() {
        setTitle("Sistema de Usuário");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("Bem-vindo!", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titulo);

        JButton btnLogin = new JButton("Fazer Login");
        JButton btnCadastro = new JButton("Cadastrar-se");

        panel.add(btnLogin);
        panel.add(btnCadastro);

        btnLogin.addActionListener((ActionEvent e) -> {
            dispose(); // fecha a tela inicial
            new InputLogin().setVisible(true);
        });

        btnCadastro.addActionListener((ActionEvent e) -> {
            dispose(); // fecha a tela inicial
            new inputCadastro().setVisible(true);
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InputInicial().setVisible(true));
    }
}

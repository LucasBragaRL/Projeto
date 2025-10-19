package br.com.feltex.excel;

import usuario.Usuario;
import javax.swing.*;
import java.awt.*;

public class inputCadastro extends JFrame {

    private JTextField nomeField;
    private JTextField emailField;
    private JPasswordField senhaField;

    public inputCadastro() {
        setTitle("Cadastro de Usuário");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Painel principal
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel nomeLabel = new JLabel("Nome:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nomeLabel, gbc);

        nomeField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(nomeField, gbc);

        JLabel emailLabel = new JLabel("E-mail:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(emailLabel, gbc);

        emailField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(emailField, gbc);

        JLabel senhaLabel = new JLabel("Senha:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(senhaLabel, gbc);

        senhaField = new JPasswordField(20);
        gbc.gridx = 1;
        panel.add(senhaField, gbc);

        JButton cadastrarButton = new JButton("Cadastrar");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(cadastrarButton, gbc);

        JButton voltarButton = new JButton("Voltar");
        gbc.gridy = 4;
        panel.add(voltarButton, gbc);

        // === BOTÃO CADASTRAR ===
        cadastrarButton.addActionListener(e -> {
            String nome = nomeField.getText().trim();
            String email = emailField.getText().trim();
            String senha = new String(senhaField.getPassword()).trim();

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
                return;
            }

            try {
                // Aqui segue exatamente sua lógica original:
                Usuario service = new Usuario(nome, email, senha);
                CriaUsuario novo = new CriaUsuario(service);
                novo.criarArquivo();

                JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");

                // limpa os campos
                nomeField.setText("");
                emailField.setText("");
                senhaField.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        });

        // === BOTÃO VOLTAR ===
        voltarButton.addActionListener(e -> {
            dispose();
            new InputInicial().setVisible(true);
        });

        add(panel);
    }
}

package br.com.feltex.excel;

import usuario.Usuario;
import javax.swing.*;
import java.awt.*;


public class InputLogin extends JFrame {

    private JTextField emailField;
    private JPasswordField senhaField;

    public InputLogin() {
        setTitle("Login de Usuário");
        setSize(350, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel emailLabel = new JLabel("E-mail:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(emailLabel, gbc);

        emailField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(emailField, gbc);

        JLabel senhaLabel = new JLabel("Senha:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(senhaLabel, gbc);

        senhaField = new JPasswordField(20);
        gbc.gridx = 1;
        panel.add(senhaField, gbc);

        JButton entrarButton = new JButton("Entrar");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(entrarButton, gbc);

        JButton voltarButton = new JButton("Voltar");
        gbc.gridy = 3;
        panel.add(voltarButton, gbc);

        // === AÇÃO DO BOTÃO ENTRAR ===
        entrarButton.addActionListener(e -> {
            String email = emailField.getText().trim();
            String senha = new String(senhaField.getPassword()).trim();

            if (email.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
                return;
            }

            Usuario usuario = new Usuario();
            usuario.setEmail(email);
            usuario.setSenha(senha);

            // Chama a lógica separada
            LoginService loginService = new LoginService(usuario);
            boolean autenticado = loginService.autenticar();

            if (autenticado) {
                JOptionPane.showMessageDialog(this, "Login realizado com sucesso!");
                // Aqui você pode abrir a próxima tela do sistema
            } else {
                JOptionPane.showMessageDialog(this, "Usuário não encontrado ou senha incorreta.");
            }

            emailField.setText("");
            senhaField.setText("");
        });

        voltarButton.addActionListener(e -> {
            dispose();
            new InputInicial().setVisible(true);
        });

        add(panel);
    }
}

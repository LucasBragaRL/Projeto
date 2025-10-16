package br.com.feltex.excel;

import java.util.Scanner;

import usuario.Usuario;

public class inputCadastro {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        

        System.out.println("=== Cadastro de Usuário ===");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        scanner.close();
        
        Usuario service = new Usuario(nome,email,senha);
        CriaUsuario novo = new CriaUsuario(service);
        

        novo.criarArquivo();

}}

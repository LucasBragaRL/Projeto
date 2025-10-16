package br.com.feltex.excel;

import java.util.Scanner;

import usuario.Usuario;

public class InputLogin {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        

        System.out.println("=== login de usuario ===");


        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        scanner.close();
        
        Usuario service = new Usuario(email,senha);
        LerArquivoExcelTest novologin = new LerArquivoExcelTest(service);
        
        novologin.lerArquivo();
    }
}

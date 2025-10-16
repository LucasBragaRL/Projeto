package br.com.feltex.excel;

import org.junit.jupiter.api.Test;

import configExcel.LerArquivoExcel;
import usuario.Usuario;


class LerArquivoExcelTest {
	
	private Usuario user = new Usuario();
	
	public LerArquivoExcelTest(Usuario user) {
		this.user = user;
		
	}

    @Test
    void lerArquivo() {
    	LerArquivoExcel leitor = new LerArquivoExcel();
    	boolean existe = leitor.verificarCredenciais("Usuarios.xlsx", user.getEmail(),  user.getSenha());

    	if (existe) {
    	    System.out.println("Usuário encontrado!");
    	} else {
    	    System.out.println("Usuário não encontrado.");
    	}
    }

}

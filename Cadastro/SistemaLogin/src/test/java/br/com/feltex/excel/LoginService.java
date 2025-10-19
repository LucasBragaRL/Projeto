package br.com.feltex.excel;

import org.junit.jupiter.api.Test;

import configExcel.LerArquivoExcel;
import usuario.Usuario;


class LoginService {
	
	private Usuario user = new Usuario();
	
	public LoginService(Usuario user) {
		this.user = user;
		
	}

    @Test
    boolean autenticar() {
    	LerArquivoExcel leitor = new LerArquivoExcel();
    	boolean existe = leitor.verificarCredenciais("Usuarios.xlsx", user.getEmail(),  user.getSenha());

    	if (existe) {
    	    return true;
    	} else {
    	    return false;
    	}
    }

}

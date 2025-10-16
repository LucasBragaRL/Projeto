package br.com.feltex.excel;

import configExcel.CriaArquivoExcel;
import usuario.Usuario;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertNotNull;

class CriaUsuario {
	
	private Usuario user = new Usuario();
	
	public CriaUsuario(Usuario user) {
		this.user = user;
		
	}

    @Test
    void criarArquivo() {
        var criaArquivoExcel = new CriaArquivoExcel();
        assertNotNull(criaArquivoExcel);
        criaArquivoExcel.criarArquivo("Usuarios.xlsx", user);
    }
}

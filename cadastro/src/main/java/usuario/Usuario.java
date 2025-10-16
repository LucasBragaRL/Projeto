package usuario;


import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Usuario {
    private String id;
    private String nome;
    private String email;
    private String senha;
    
    // Construtor
    public Usuario(String nome, String email, String senha) {
        this.id = UUID.randomUUID().toString(); 
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    
    public Usuario() {}
    
    public Usuario( String email, String senha) {
        this.id = UUID.randomUUID().toString(); 
        this.email = email;
        this.senha = senha;
    }
    
 // Getters
    public String getId() {
        return id;
    }
    
    public void setNome(String nome) {
    	this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setSenha(String senha) {
    	this.senha = senha;
    }
    
    public String getSenha() {
        return senha;
    }
    

	
}

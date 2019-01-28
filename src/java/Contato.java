/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sete
 */
public class Contato {
    private String nome;
    private String telefone;
    private String email;
    private String rua;
    private String estado;
    private String numero;
    private String bairro;
    private String cidade;
    
    public Contato(String nome, String tel, String email, String rua, String numero, String bairro, String cidade, String estado){
        this.nome = nome;
        telefone = tel;
        this.email = email;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getTel(){
        return telefone;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getRua(){
        return rua;
    }
    
    public String getNumero(){
        return numero;
    }
    
    public String getBairro(){
        return bairro;
    }
    
    public String getCidade(){
        return cidade;
    }
    
    public String getEstado(){
        return estado;
    }
}

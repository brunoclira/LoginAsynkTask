package br.edu.ifpb.notificationwear.entidade;

public class Usuario {

    private String nome;
    private String senha;

    public Usuario (){
        nome = null;
        senha = null;
    }
    public Usuario (String nome, String senha){
        this.nome = nome;
        this.senha = senha;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getSenha() {
        return senha;
    }
}

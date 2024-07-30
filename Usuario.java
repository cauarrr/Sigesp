public abstract class Usuario {
    private String nome;
    private String email;
    private String senha;
    private String login;

    Usuario(){

    }

    public Usuario(String nome, String email, String senha, String login) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "[Nome:" + nome + ", Email: " + email + ", Login: " + login + "]";
    }

    
    
}

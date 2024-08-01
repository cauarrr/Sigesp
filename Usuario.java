public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private String login;
    private Aluno aluno;
    private Professor professor;

    Usuario(){
        this.aluno = null;
        this.professor = null;
    }

    public Usuario(String nome, String email, String senha, String login) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.login = login;
        this.aluno = null;
        this.professor = null;
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

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    @Override
    public String toString() {
        return "[Nome:" + nome + ", Email: " + email + ", Login: " + login + "]";
    }


    
    
}

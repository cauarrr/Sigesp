public class Aluno extends Usuario {
    private String matricula;
    private String curso;
    private int semestre;
    
    public Aluno() {
    }
    public Aluno(String nome, String email, String senha, String login) {
        super(nome, email, senha, login);
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public int getSemestre() {
        return semestre;
    }
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    
}

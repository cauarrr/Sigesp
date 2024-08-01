public class Aluno {
    private int matricula;
    private String curso;
    private int semestre;
    
    public Aluno() {
    }

    public Aluno(int matricula, String curso, int semestre) {
        this.matricula = matricula;
        this.curso = curso;
        this.semestre = semestre;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
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

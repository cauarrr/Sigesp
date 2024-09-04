import java.util.List;

public class Professor {
    private String siape;
    private List<String> cursos;
    private List<Projeto> projetos;
    
    public Professor() {
    }
    public Professor(String siape, List<String> cursos, List<Projeto> projetos) {
        this.siape = siape;
        this.cursos = cursos;
        this.projetos = projetos;
    }
    public String getSiape() {
        return siape;
    }
    public List<String> getCursos() {
        return cursos;
    }
    public void setCursos(List<String> cursos) {
        this.cursos = cursos;
    }
    public List<Projeto> getProjetos() {
        return projetos;
    }
    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    
}
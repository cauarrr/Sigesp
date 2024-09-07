import java.util.List;
import java.time.LocalDate;
// Classe SelecaoProjetos
public class SelecaoProjetos extends ProcessoSeletivo {
    private List<Projeto> projetosInscritos;
    private List<Projeto> aprovados;

    // Construtor com parâmetros
    public SelecaoProjetos(String nome, String descricao, int numVagas, LocalDate iniInscricoes, LocalDate fimInscricoes, List<Professor> banca, Fase status) {
        super(nome, descricao, numVagas, iniInscricoes, fimInscricoes, banca, status);
    }

    public List<Projeto> getProjetosInscritos() {
        return projetosInscritos;
    }

    // Setter com verificação
    public void setProjetosInscritos(List<Projeto> projetosInscritos) {
        if (projetosInscritos == null) {
            throw new IllegalArgumentException("Lista de projetos inscritos não pode ser nula.");
        }
        this.projetosInscritos = projetosInscritos;
    }

    public List<Projeto> getAprovados() {
        return aprovados;
    }

    // Setter com verificação
    public void setAprovados(List<Projeto> aprovados) {
        if (aprovados == null) {
            throw new IllegalArgumentException("Lista de aprovados não pode ser nula.");
        }
        this.aprovados = aprovados;
    }
}

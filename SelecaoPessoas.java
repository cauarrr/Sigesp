import java.util.List;
import java.time.LocalDate;
// Classe SelecaoPessoas
public class SelecaoPessoas extends ProcessoSeletivo {
    private List<Aluno> alunosInscritos;
    private List<Aluno> aprovados;

    // Construtor com parâmetros
    public SelecaoPessoas(String nome, String descricao, int numVagas, LocalDate iniInscricoes, LocalDate fimInscricoes, List<Professor> banca, Fase status) {
        super(nome, descricao, numVagas, iniInscricoes, fimInscricoes, banca, status);
    }

    public List<Aluno> getAlunosInscritos() {
        return alunosInscritos;
    }

    // Setter com verificação
    public void setAlunosInscritos(List<Aluno> alunosInscritos) {
        if (alunosInscritos == null) {
            throw new IllegalArgumentException("Lista de alunos inscritos não pode ser nula.");
        }
        this.alunosInscritos = alunosInscritos;
    }

    public List<Aluno> getAprovados() {
        return aprovados;
    }

    // Setter com verificação
    public void setAprovados(List<Aluno> aprovados) {
        if (aprovados == null) {
            throw new IllegalArgumentException("Lista de aprovados não pode ser nula.");
        }
        this.aprovados = aprovados;
    }
}

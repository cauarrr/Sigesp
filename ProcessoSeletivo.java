import java.util.List;
import java.time.LocalDate;

public abstract class ProcessoSeletivo {
    private String nome;
    private String descricao;
    private int numVagas;
    private List<Professor> banca; 
    private int numInscritos;
    private int numAprovados;
    private Fase status;
    private Avaliacao avaliacao;

    // Construtor padrão
    public ProcessoSeletivo(){}

    // Construtor com parâmetros
    public ProcessoSeletivo(String nome, String descricao, int numVagas, LocalDate iniInscricoes, LocalDate fimInscricoes, List<Professor> banca, Fase status) {
        this.setNome(nome); // Verifica e define o nome
        this.setDescricao(descricao); // Verifica e define a descrição
        this.setNumVagas(numVagas); // Verifica e define o número de vagas
        this.setBanca(banca); // Verifica e define a banca
        this.setStatus(status); // Verifica e define o status (fase)
    }

    public String getNome() {
        return nome;
    }

    // Setter com verificação
    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    // Setter com verificação
    public void setDescricao(String descricao) {
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("Descrição não pode ser nula ou vazia.");
        }
        this.descricao = descricao;
    }

    public int getNumVagas() {
        return numVagas;
    }

    // Setter com verificação
    public void setNumVagas(int numVagas) {
        if (numVagas <= 0) {
            throw new IllegalArgumentException("Número de vagas deve ser maior que zero.");
        }
        this.numVagas = numVagas;
    }

    public List<Professor> getBanca() {
        return banca;
    }

    // Setter com verificação
    public void setBanca(List<Professor> banca) {
        if (banca == null || banca.isEmpty()) {
            throw new IllegalArgumentException("A banca não pode ser nula ou vazia.");
        }
        this.banca = banca;
    }

    public int getNumInscritos() {
        return numInscritos;
    }

    public int getNumAprovados() {
        return numAprovados;
    }

    // Setter com verificação
    public void setNumAprovados(int numAprovados) {
        if (numAprovados < 0) {
            throw new IllegalArgumentException("Número de aprovados não pode ser negativo.");
        }
        this.numAprovados = numAprovados;
    }

    public Fase getStatus() {
        return status;
    }

    // Setter com verificação
    public void setStatus(Fase status) {
        if (status == null) {
            throw new IllegalArgumentException("Status (fase) não pode ser nulo.");
        }
        this.status = status;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    // Setter para a avaliação
    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }
}

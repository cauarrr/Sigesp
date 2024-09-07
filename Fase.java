import java.time.LocalDate;
// Classe Fase
public class Fase {
    private String nome;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    // Construtor
    public Fase(String nome, String descricao, LocalDate dataInicio, LocalDate dataFim) {
        this.setNome(nome); // Verifica e define o nome
        this.setDescricao(descricao); // Verifica e define a descrição
        this.setDataInicio(dataInicio); // Verifica e define a data de início
        this.setDataFim(dataFim); // Verifica e define a data de fim
    }

    // Obtém o nome da fase
    public String getNome() {
        return nome;
    }

    // Define o nome da fase
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Obtém a descrição da fase
    public String getDescricao() {
        return descricao;
    }

    // Define a descrição da fase
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Obtém a data de início da fase
    public LocalDate getDataInicio() {
        return dataInicio;
    }

    // Define a data de início da fase com validação
    public void setDataInicio(LocalDate dataInicio) {
        if (dataInicio != null && (dataFim == null || !dataInicio.isAfter(dataFim))) {
            this.dataInicio = dataInicio;
        } else {
            throw new IllegalArgumentException("A data de início deve ser anterior ou igual à data de fim e não pode ser nula.");
        }
    }

    // Obtém a data de fim da fase
    public LocalDate getDataFim() {
        return dataFim;
    }

    // Define a data de fim da fase com validação
    public void setDataFim(LocalDate dataFim) {
        if (dataFim != null && (dataInicio == null || !dataFim.isBefore(dataInicio))) {
            this.dataFim = dataFim;
        } else {
            throw new IllegalArgumentException("A data de fim deve ser posterior ou igual à data de início e não pode ser nula.");
        }
    }

    @Override
    public String toString() {
        return "Fase [nome=" + nome + ", descricao=" + descricao + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + "]";
    }
}

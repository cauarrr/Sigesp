import java.time.LocalDate;
import java.util.List;

// Classe que representa um Projeto no sistema
public class Projeto {
    // Atributos privados da classe Projeto
    private String nome;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate prevTermino;
    private Professor coordenadorProj;
    private List<Aluno> bolsistas;
    private List<Aluno> voluntarios;

    // Construtor padrão
    public Projeto() {}

    // Construtor com parâmetros
    public Projeto(String nome, String descricao, LocalDate dataInicio, Professor coordenadorProj) {
        this.setNome(nome); // Verifica e define o nome do projeto
        this.setDescricao(descricao); // Verifica e define a descrição do projeto
        this.setDataInicio(dataInicio); // Verifica e define a data de início
        this.setCoordenadorProj(coordenadorProj); // Verifica e define o coordenador do projeto
    }

    // Getter para o nome do projeto
    public String getNome() {
        return nome;
    }

    // Setter para o nome do projeto com verificação
    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome do projeto não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    // Getter para a descrição do projeto
    public String getDescricao() {
        return descricao;
    }

    // Setter para a descrição do projeto com verificação
    public void setDescricao(String descricao) {
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("Descrição do projeto não pode ser nula ou vazia.");
        }
        this.descricao = descricao;
    }

    // Getter para a data de início do projeto
    public LocalDate getDataInicio() {
        return dataInicio;
    }

    // Setter para a data de início com verificação
    public void setDataInicio(LocalDate dataInicio) {
        if (dataInicio == null) {
            throw new IllegalArgumentException("Data de início não pode ser nula.");
        }
        this.dataInicio = dataInicio;
    }

    // Getter para a data prevista de término
    public LocalDate getPrevTermino() {
        return prevTermino;
    }

    // Setter para a data prevista de término
    public void setPrevTermino(LocalDate prevTermino) {
        this.prevTermino = prevTermino;
    }

    // Getter para o coordenador do projeto
    public Professor getCoordenadorProj() {
        return coordenadorProj;
    }

    // Setter para o coordenador do projeto com verificação
    public void setCoordenadorProj(Professor coordenadorProj) {
        if (coordenadorProj == null) {
            throw new IllegalArgumentException("Coordenador do projeto não pode ser nulo.");
        }
        this.coordenadorProj = coordenadorProj;
    }

    // Getter para a lista de bolsistas
    public List<Aluno> getBolsistas() {
        return bolsistas;
    }

    // Setter para a lista de bolsistas
    public void setBolsistas(List<Aluno> bolsistas) {
        this.bolsistas = bolsistas;
    }

    // Getter para a lista de voluntários
    public List<Aluno> getVoluntarios() {
        return voluntarios;
    }

    // Setter para a lista de voluntários
    public void setVoluntarios(List<Aluno> voluntarios) {
        this.voluntarios = voluntarios;
    }

    // Sobrescreve o método toString para exibir informações do projeto
    @Override
    public String toString() {
        return "\nProjeto: " + nome + "\nDescricao: " + descricao + "\nData de inicio: " + dataInicio + "\nCoordenador: " + coordenadorProj + "\nBolsistas: " + bolsistas + "\nVoluntarios: " + voluntarios + ".";
    }
}

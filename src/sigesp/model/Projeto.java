package sigesp.model;

import java.time.LocalDate;
import java.util.List;

public class Projeto{
    private String nome;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate prevTermino;
    private Usuario coordenadorProj;
    private List<Aluno> bolsistas;
    private List<Aluno> voluntarios;

    public Projeto(){
        
    }

    public Projeto(String nome, String descricao, Usuario coordenadorProj, LocalDate dataInicio ){
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.coordenadorProj = coordenadorProj;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String decricao) {
        this.descricao = decricao;
    }
    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
    public LocalDate getPrevTermino() {
        return prevTermino;
    }
    public void setPrevTermino(LocalDate prevTermino) {
        this.prevTermino = prevTermino;
    }
    public Usuario getCoordenadorProj() {
        return coordenadorProj;
    }
    public void setCoordenadorProj(Usuario coordenadorProj) {
        if (coordenadorProj.getVinculo() instanceof Professor){
            this.coordenadorProj = coordenadorProj;
        }
        
    }
    public List<Aluno> getBolsistas() {
        return bolsistas;
    }
    public void setBolsistas(List<Aluno> bolsistas) {
        this.bolsistas = bolsistas;
    }
    public List<Aluno> getVoluntarios() {
        return voluntarios;
    }
    public void setVoluntarios(List<Aluno> voluntarios) {
        this.voluntarios = voluntarios;
    }

    @Override
    public String toString() {
        return "\nProjeto: " + nome + "\nDescricao: " + descricao + "\nData de inicio: " + dataInicio + "\nCoordenador: " + coordenadorProj + "\nBolsistas: " + bolsistas + "\nVoluntarios: " + voluntarios + ".";
    }
    
}
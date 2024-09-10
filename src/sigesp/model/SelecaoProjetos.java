package sigesp.model;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
public class SelecaoProjetos extends ProcessoSeletivo {
    private List<Projeto> projetosInscritos;
    private List<Projeto> aprovados;

    public SelecaoProjetos(
        String nome, 
        String descricao, 
        int numVagas, 
        LocalDate iniInscricoes, 
        LocalDate fimInscricoes, 
        ArrayList<Usuario> banca, 
        Fase status
        ) {
        super(
            nome, 
            descricao, 
            numVagas, 
            iniInscricoes, 
            fimInscricoes, 
            banca,
            status);
    }

    public List<Projeto> getProjetosInscritos() {
        return projetosInscritos;
    }

    public void setProjetosInscritos(List<Projeto> projetosInscritos) {
        this.projetosInscritos = projetosInscritos;
    }

    public List<Projeto> getAprovados() {
        return aprovados;
    }

    public void setAprovados(List<Projeto> aprovados) {
        this.aprovados = aprovados;
    }
}
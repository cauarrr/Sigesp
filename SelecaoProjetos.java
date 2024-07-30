public class SelecaoProjetos extends ProcessoSeletivo {
    private Projeto[] projetosInscritos;
    private Projeto[] aprovados;

    public SelecaoProjetos(String nome, String descricao, int numVagas, String iniInscricoes, String fimInscricoes, Professor[] banca, int numInscritos, int numAprovados, String status) {
        super(nome, descricao, numVagas, iniInscricoes, fimInscricoes, banca, numInscritos, numAprovados, status);
    }

    public Projeto[] getProjetosInscritos() {
        return projetosInscritos;
    }

    public void setProjetosInscritos(Projeto[] projetosInscritos) {
        this.projetosInscritos = projetosInscritos;
    }

    public Projeto[] getAprovados() {
        return aprovados;
    }

    public void setAprovados(Projeto[] aprovados) {
        this.aprovados = aprovados;
    }
}
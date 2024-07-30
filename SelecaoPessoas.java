
public class SelecaoPessoas extends ProcessoSeletivo {
    private Aluno[] alunosInscritos;
    private Aluno[] aprovados;

    public SelecaoPessoas(
            String nome, 
            String descricao, 
            int numVagas, 
            String iniInscricoes, 
            String fimInscricoes, 
            Professor[] banca, 
            int numInscritos, 
            int numAprovados, 
            String status
        ) {
        
        super(
            nome, 
            descricao, 
            numVagas, 
            iniInscricoes, 
            fimInscricoes, 
            banca, 
            numInscritos, 
            numAprovados, 
            status
        );
    }

    public Aluno[] getAlunosInscritos() {
        return alunosInscritos;
    }

    public void setAlunosInscritos(Aluno[] alunosInscritos) {
        this.alunosInscritos = alunosInscritos;
    }

    public Aluno[] getAprovados() {
        return aprovados;
    }

    public void setAprovados(Aluno[] aprovados) {
        this.aprovados = aprovados;
    }
}
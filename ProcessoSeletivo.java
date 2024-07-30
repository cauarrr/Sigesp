public abstract class ProcessoSeletivo {
    private String nome;
    private String descricao;
    private int numVagas;
    private String iniInscricoes;
    private String fimInscricoes; 
    private Professor[] banca; 
    private int numInscritos;
    private int numAprovados;
    private String status;

    public ProcessoSeletivo(){}
    
    public ProcessoSeletivo(String nome, String descricao, int numVagas, String iniInscricoes, String fimInscricoes, Professor[] banca, int numInscritos, int numAprovados, String status) {
        this.nome = nome;
        this.descricao = descricao;
        this.numVagas = numVagas;
        this.iniInscricoes = iniInscricoes;
        this.fimInscricoes = fimInscricoes;
        this.banca = banca;
        this.numInscritos = numInscritos;
        this.numAprovados = numAprovados;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        if (nome != null) {
            this.nome = nome;
        }
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        if (descricao != null) {
            this.descricao = descricao;
        }
    }
    
    public int getNumVagas() {
        return numVagas;
    }
    
    public void setNumVagas(int numVagas) {
        if (numVagas > 0) {
            this.numVagas = numVagas;
        }
    }
    
    public String getIniInscricoes() {
        return iniInscricoes;
    }
    
    public void setIniInscricoes(String iniInscricoes) {
        if (iniInscricoes != null) {
            this.iniInscricoes = iniInscricoes;
        }
    }
    
    public String getFimInscricoes() {
        return fimInscricoes;
    }
    
    public void setFimInscricoes(String fimInscricoes) {
        if (fimInscricoes != null) {
            this.fimInscricoes = fimInscricoes;
        }
    }
    
    public Professor[] getBanca() {
        return banca;
    }
    
    public void setBanca(Professor[] banca) {
        if (banca != null) {
            this.banca = banca;
        }
    }
    
    public int getNumInscritos() {
        return numInscritos;
    }
    
    public int getNumAprovados() {
        return numAprovados;
    }
    
    public void setNumAprovados(int numAprovados) {
        if (numAprovados >= 0) {
            this.numAprovados = numAprovados;
        }
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        if (status != null) {
            this.status = status;
        }
    }
    
}

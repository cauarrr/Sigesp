// Classe CriterioAvaliacao
public class CriterioAvaliacao {
    private String descricao;
    private double peso;

    // Construtor
    public CriterioAvaliacao(String descricao, double peso) {
        this.setDescricao(descricao); // Verifica e define a descrição
        this.setPeso(peso); // Verifica e define o peso
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

    public double getPeso() {
        return peso;
    }

    // Setter com verificação
    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("Peso deve ser maior que zero.");
        }
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "CriterioAvaliacao [descricao=" + descricao + ", peso=" + peso + "]";
    }
}

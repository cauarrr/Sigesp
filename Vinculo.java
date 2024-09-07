// Classe que representa o vínculo de um Usuário (pode ser Aluno ou Professor)
public abstract class Vinculo { 
    // Atributos privados da classe Vinculo
    private String tipo;
    private String id;

    // Construtor padrão
    public Vinculo() {}

    // Construtor com parâmetros
    public Vinculo(String tipo, String id) {
        this.setTipo(tipo); // Verifica e define o tipo do vínculo
        this.setId(id); // Verifica e define o ID do vínculo
    }

    // Getter para o tipo de vínculo
    public String getTipo() {
        return tipo;
    }

    // Setter para o tipo de vínculo com verificação
    public void setTipo(String tipo) {
        if (tipo == null || tipo.isEmpty()) {
            throw new IllegalArgumentException("Tipo de vínculo não pode ser nulo ou vazio.");
        }
        this.tipo = tipo;
    }

    // Getter para o ID do vínculo
    public String getId() {
        return id;
    }

    // Setter para o ID do vínculo com verificação
    public void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID do vínculo não pode ser nulo ou vazio.");
        }
        this.id = id;
    }
}

public class Avaliacao {
    private CriterioAvaliacao criterio;
    private double nota;

    public Avaliacao(CriterioAvaliacao criterio, double nota) {
        this.criterio = criterio;
        this.nota = nota;    }

    public CriterioAvaliacao getCriterio() {
        return criterio;
    }

    public void setCriterio(CriterioAvaliacao criterio) {
        this.criterio = criterio;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Avaliacao [criterio=" + criterio + ", nota=" + nota + "]";
    }
}
package SM;

public class Pastelaria extends Restauracao {

    private double bolosMedia; // número de bolos que vendem por dia
    private double bolosFatura; // valor médio de faturação anual por bolo vendido por dia

    public Pastelaria(String nome, String categoria, String distrito, Coordenadas localizacao, double clientesMedia,
            int numEmpregados, double salarioAnual, double bolosMedia, double bolosFatura) {
        super(nome, categoria, distrito, localizacao, clientesMedia, numEmpregados, salarioAnual);
        this.bolosMedia = bolosMedia;
        this.bolosFatura = bolosFatura;
    }

    public void setBolosMedia(double bolosMedia) {
        this.bolosMedia = bolosMedia;
    }

    public double getBolosMedia() {
        return bolosMedia;
    }

    public void setBolosFatura(double bolosFatura) {
        this.bolosFatura = bolosFatura;
    }

    public double getBolosFatura() {
        return bolosFatura;
    }

    public double getDespesaAnual() {
        return getNumEmpregados() * getSalarioAnual();
    }

    public double getReceitaAnual() {
        return getBolosMedia() * getBolosFatura();
    }

    public String toString() {
        return super.toString() + " | Número médio de bolos: " + bolosMedia + "/dia | Média faturação anual por bolo: "
                + String.format("%.2f", bolosFatura) + "€ | Despesa anual: "
                + String.format("%.2f", getDespesaAnual())
                + "€ | Receita Anual: " + String.format("%.2f", getReceitaAnual())
                + "€ | Lucro: " + String.format("%.2f", getLucro()) + "€ (" + Lucro() + ")";

    }
}

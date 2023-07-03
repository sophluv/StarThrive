package SM;

public class Cafe extends Restauracao {

    private double cafesMedia; // número médio de cafés que vendem por dia
    private double cafesFatura; // valor médio de faturação anual por café vendido por dia

    public Cafe(String nome, String categoria, String distrito, Coordenadas localizacao, double clientesMedia, int numEmpregados, double salarioAnual, double cafesMedia, double cafesFatura) {
        super(nome, categoria, distrito, localizacao, clientesMedia, numEmpregados, salarioAnual);
        this.cafesMedia=cafesMedia;
        this.cafesFatura=cafesFatura;
    }
    public void setCafesMedia(double cafesMedia) {
        this.cafesMedia = cafesMedia;
    }

    public double getCafesMedia() {
        return cafesMedia;
    }

    public void setCafesFatura(double cafesFatura) {
        this.cafesFatura = cafesFatura;
    }

    public double getCafesFatura() {
        return cafesFatura;
    }

    public double getDespesaAnual() {
        return getNumEmpregados()*getSalarioAnual();
    }

    public double getReceitaAnual() {
        return getCafesMedia()*getCafesFatura();
    }

    public String toString() {
        return super.toString() + " | Número médio de cafés: " + cafesMedia + "/dia | Média faturação anual por café: " + cafesFatura + "€ | Despesa anual: "
        + String.format("%.2f", getDespesaAnual())
        + "€ | Receita Anual: " + String.format("%.2f", getReceitaAnual())
        + "€ | Lucro: " + String.format("%.2f", (getLucro())) + "€ (" + Lucro() + ")";

    }
}


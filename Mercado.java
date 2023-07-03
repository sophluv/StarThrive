package SM;

public class Mercado extends Mercearia {

    private String tipo; // min ou super ou hiper
    private double area; // área de corredores (m2)
    private double areaFaturaAnual; // valor médio de faturação anual por m2

    public Mercado(String nome, String categoria, String distrito, Coordenadas localizacao, double limpezaCustoAnual,
            String tipo, double area, double areaFaturaAnual) {
        super(nome, categoria, distrito, localizacao, limpezaCustoAnual);
        this.tipo = tipo;
        this.area = area;
        this.areaFaturaAnual = areaFaturaAnual;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    public void setAreaFaturaAnual(double areaFaturaAnual) {
        this.areaFaturaAnual = areaFaturaAnual;
    }

    public double getAreaFaturaAnual() {
        return areaFaturaAnual;
    }

    public double getDespesaAnual() {
        return super.getDespesaAnual();
    }

    public double getReceitaAnual() {
        return getArea() * getAreaFaturaAnual();
    }

    public String toString() {
        return super.toString() + " | Tipo: " + tipo + " | Área de corredores: " + String.format("%.2f", area)
                + " m2 | Valor médio de faturação anual: " + String.format("%.2f", areaFaturaAnual)
                + "€/m2  Despesa anual: "
                + String.format("%.2f", getDespesaAnual())
                + "€ | Receita Anual: " + String.format("%.2f", getReceitaAnual())
                + "€ | Lucro: " + String.format("%.2f", getLucro()) + "€ (" + Lucro() + ")";
    }
}

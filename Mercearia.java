
package SM;

abstract class Mercearia extends Empresa {

    private double limpezaCustoAnual; // custo anual de limpeza do estabelecimento

    public Mercearia(String nome, String categoria, String distrito, Coordenadas localizacao,
            double limpezaCustoAnual) {
        super(nome, categoria, distrito, localizacao);
        this.limpezaCustoAnual = limpezaCustoAnual;
    }

    public void setLimpezaCustoAnual(double limpezaCustoAnual) {
        this.limpezaCustoAnual = limpezaCustoAnual;
    }

    public double getLimpezaCustoAnual() {
        return limpezaCustoAnual;
    }

    public double getDespesaAnual() {
        return limpezaCustoAnual;
    }

    public String toString() {
        return super.toString() + " | Custo anual de limpeza: " + String.format("%.2f", limpezaCustoAnual) + "€ ";
    }
}
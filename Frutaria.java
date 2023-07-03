package SM;

public class Frutaria extends Mercearia {

    private int numProdutos; // numero de produtos
    private double produtosFaturaAnual; // valoe médio de faturação anual por produto

    public Frutaria(String nome, String categoria, String distrito, Coordenadas localizacao, double limpezaCustoAnual,
            int numProdutos, double produtosFaturaAnual) {

        super(nome, categoria, distrito, localizacao, limpezaCustoAnual);
        this.numProdutos = numProdutos;
        this.produtosFaturaAnual = produtosFaturaAnual;
    }

    public void setNumProdutos(int numProdutos) {
        this.numProdutos = numProdutos;
    }

    public int getnumProdutos() {
        return numProdutos;
    }

    public void setProdutosFaturaAnual(double produtosFaturaAnual) {
        this.produtosFaturaAnual = produtosFaturaAnual;
    }

    public double getProdutosFaturaAnual() {
        return produtosFaturaAnual;
    }

    public double getDespesaAnual() {
        return super.getDespesaAnual();
    }

    public double getReceitaAnual() {
        return getnumProdutos() * getProdutosFaturaAnual();
    }


    public String toString() {
        return super.toString() + " | Número de produtos: " + numProdutos
                + " | Valor médio faturação anual por produto: " + String.format("%.2f", produtosFaturaAnual)
                + "€ | Despesa anual: "
                + String.format("%.2f", getDespesaAnual())
                + "€ | Receita Anual: " + String.format("%.2f", getReceitaAnual())
                + "€ | Lucro: " + String.format("%.2f", getLucro()) + "€ (" + Lucro() + ")";

    }
}

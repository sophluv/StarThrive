package SM;

public class Local extends Restaurante {

    private int mesasEsplanada; // número de mesas na esplanada
    private double mesasEsplanadaFatura; // custo de licença anual por mesa de esplanada

    public Local(String nome, String categoria, String distrito, Coordenadas localizacao, double clientesMedia,
            int numEmpregados, double salarioAnual, int diasAno, int mesasInteriores, double mesaDia,
            int mesasEsplanada, double mesasEsplanadaFatura) {

        super(nome, categoria, distrito, localizacao, clientesMedia, numEmpregados, salarioAnual, diasAno,
                mesasInteriores, mesaDia);
        this.mesasEsplanada = mesasEsplanada;
        this.mesasEsplanadaFatura = mesasEsplanadaFatura;
    }

    public void setMesasEsplanada(int mesasEsplanada) {
        this.mesasEsplanada = mesasEsplanada;
    }

    public int getMesasEsplanada() {
        return mesasEsplanada;
    }

    public void setMesasEsplanadaFatura(double mesasEsplanadaFatura) {
        this.mesasEsplanadaFatura = mesasEsplanadaFatura;
    }

    public double getMesasEsplanadaFatura() {
        return mesasEsplanadaFatura;
    }

    public double getDespesaAnual() {
        return getNumEmpregados() * getSalarioAnual()
                + getMesasEsplanada() * getMesasEsplanadaFatura();
    }

    public double getReceitaAnual() {
        return (getMesasInteriores() + getMesasEsplanada()) * getMesaDia() * getDiasAno();

    }

    public String toString() {
        return super.toString() + " | Número de mesas na esplanada: " + mesasEsplanada
                + " | Custo de licença anual por mesa de esplanada: " + mesasEsplanadaFatura + "€ | Despesa anual: "
                + String.format("%.2f", getDespesaAnual())
                + "€ | Receita Anual: " + String.format("%.2f", getReceitaAnual())
                + "€ | Lucro: " + String.format("%.2f", getLucro()) + "€ (" + Lucro() + ")";
    }
}

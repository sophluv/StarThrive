package SM;

public class FastFood extends Restaurante {

    private double clientesDriveMedia; // número médio diário de clientes drive-thru
    private double clientesDriveFatura; // valor médio diário de faturação por cada cliente drive-thru

    public FastFood(String nome, String categoria, String distrito, Coordenadas localizacao, double clientesMedia, int numEmpregados, double salarioAnual, int diasAno, int mesasInterioes, double mesaDia, double clientesDriveMedia, double clientesDriveFatura) {

        super(nome, categoria, distrito, localizacao, clientesMedia, numEmpregados, salarioAnual, diasAno, mesasInterioes, mesaDia);
        this.clientesDriveFatura = clientesDriveFatura;
        this.clientesDriveMedia = clientesDriveMedia;
    }

    public void setClientesDriveMedia(double clientesDriveMedia) {
        this.clientesDriveMedia = clientesDriveMedia;
    }

    public double getClientesDriveMedia() {
        return clientesDriveMedia;
    }

    public void setClientesDriveFatura(double clientesDriveFatura) {
        this.clientesDriveFatura = clientesDriveFatura;
    }

    public double getClientesDriveFatura() {
        return clientesDriveFatura;
    }

    public double getDespesaAnual() {
        return getNumEmpregados() * getSalarioAnual();
    }

    public double getReceitaAnual() {
        return (getMesasInteriores() * getMesaDia() + getClientesDriveMedia() * getClientesDriveFatura()) * getDiasAno();

    }

    public String toString() {
        return super.toString() + " | Número médio diário de clientes drive-thru: " + clientesDriveMedia
                + " | Valor médio diário de faturação por cada cliente drive-thru: "
                + String.format("%.2f", clientesDriveFatura) + "€ | Despesa anual: "
                + String.format("%.2f", getDespesaAnual())
                + "€ | Receita Anual: " + String.format("%.2f", getReceitaAnual())
                + "€ | Lucro: " + String.format("%.2f", getLucro()) + "€ (" + Lucro() + ")";

    }


}

package SM;

abstract class Restauracao extends Empresa {

    private double clientesMedia; // número médio de clientes diário
    private int numEmpregados; // número de empregados de mesa 
    private double salarioAnual; // salário médio anual
    
    public Restauracao(String nome, String categoria, String distrito, Coordenadas localizacao, double clientesMedia, int numEmpregados, double salarioAnual) {
        super(nome, categoria, distrito, localizacao);
        this.clientesMedia=clientesMedia;
        this.numEmpregados=numEmpregados;
        this.salarioAnual=salarioAnual;
    }

    public void setClientesMedia(double clientesMedia){
        this.clientesMedia = clientesMedia;
    }
    public double getClientesMedia() {
        return clientesMedia;
    }
    public void setNumEmpregados(int numEmpregados) {
        this.numEmpregados = numEmpregados;
    }
    public int getNumEmpregados() {
        return numEmpregados;
    }
    public void setSalarioAnual(double salarioAnual) {
        this.salarioAnual = salarioAnual;
    }
    public double getSalarioAnual() {
        return salarioAnual;
    }
    
    public String toString() {
        return super.toString() + " | Número médio de clientes: " + clientesMedia + "/dia | Número empregados: " + numEmpregados + " | Média salário anual:  " +  String.format("%.2f", salarioAnual) + "€ " ;
    }

}
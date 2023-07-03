package SM;

abstract class Restaurante extends Restauracao {

    private int diasAno; // número de dias de funcionamento por ano
    private int mesasInteriores; // número de mesas interiores
    private double mesaDia; // valor médio de faturação de cada mesa por dia

    public Restaurante(String nome, String categoria, String distrito, Coordenadas localizacao, double clientesMedia,
            int numEmpregados, double salarioAnual, int diasAno, int mesasInterioes, double mesaDia) {
        super(nome, categoria, distrito, localizacao, clientesMedia, numEmpregados, salarioAnual);
        this.diasAno = diasAno;
        this.mesasInteriores = mesasInterioes;
        this.mesaDia = mesaDia;
    }

    public void setDiasAno(int diasAno) {
        this.diasAno = diasAno;
    }

    public int getDiasAno() {
        return diasAno;
    }

    public void setMesasInteriores(int mesasInteriores) {
        this.mesasInteriores = mesasInteriores;
    }

    public int getMesasInteriores() {
        return mesasInteriores;
    }

    public void setMesaDia(double mesaDia) {
        this.mesaDia = mesaDia;
    }

    public double getMesaDia() {
        return mesaDia;
    }

    public String toString() {
        return super.toString() + " | Número de dias de funcionamento por ano: " + diasAno
                + " | Número de mesas interiores: " + mesasInteriores
                + " | Valor médio de faturação de cada mesa por dia: " + String.format("%.2f", mesaDia) + "€ ";
    }

}

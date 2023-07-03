package SM;

import java.io.Serializable;

public abstract class Empresa implements Serializable {

    private String nome;
    private String categoria;
    private String distrito;
    private Coordenadas localizacao;
    /**
    * Construtor de Empresa
    * @param  nome  nome da Empresa
    * @param  categoria categoria da Empresa
    * @param  distrito  distrito da empresa
    * @param  localizacao localização da empresa 
    */
    public Empresa(String nome, String categoria, String distrito, Coordenadas localizacao) {

        this.nome = nome;
        this.categoria = categoria;
        this.distrito = distrito;
        this.localizacao = localizacao;
    }
    /**
    * Definir o nome da empresa
    * @param nome nome a ser defenido 
    */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
    * Gets the Investigation Group's Name
    * @return nome da Empresa
    */
    public String getNome() {
        return nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setLocalizacao(Coordenadas localizacao) {
        this.localizacao = localizacao;
    }

    public Coordenadas getLocalizacao() {
        return localizacao;
    }

    public abstract double getDespesaAnual();

    public abstract double getReceitaAnual();

    public double getLucro() {
        return getReceitaAnual() - getDespesaAnual();
    }
    
    public String Lucro() {
        if (getLucro() > 0) {
            return "sim";
        } else
            return "não";
    }

    public double getClientesMedia() {
        return 0;
    };

    public void setClientesMedia(double clientes) {
    }

    public void setNumEmpregados(int empregados) {
    }

    public void setSalarioAnual(double salario) {
    }

    public void setCafesMedia(double cafes) {
    }

    public void setCafesFatura(double cafesFatura) {
    }

    public void setBolosFatura(double bolosFatura) {
    }

    public void setBolosMedia(double bolos) {
    }

    public void setLimpezaCustoAnual(double limpeza) {
    }

    public void setNumProdutos(int produtos) {
    }

    public void setProdutosFaturaAnual(double produtosFatura) {
    }

    public void setTipo(String tipo) {
    }

    public void setArea(double area) {
    }

    public void setAreaFaturaAnual(double areaFatura) {
    }

    public void setDiasAno(int dias) {
    }

    public void setMesasInteriores(int mesas) {
    }

    public void setMesaDia(double mesasFatura) {
    }

    public void setMesasEsplanada(int mesas) {
    }

    public void setMesasEsplanadaFatura(double mesasFatura) {
    }

    public void setClientesDriveMedia(double driveFatura) {
    }

    public void setClientesDriveFatura(double driveFatura) {
    }

    public String toString() {
        return nome + " | " + categoria + " | Distrito: " + distrito + ", " + localizacao;
    }
}
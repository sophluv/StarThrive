package SM;

import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class GestaoEmpresa {

    private ArrayList<Empresa> empresas; // lista de todas as empresas

    public GestaoEmpresa() {
        this.empresas = new ArrayList<>();
        readInfoOBJ();
    }

    // imprime todas as empresas
    public ArrayList<Empresa> listaEmpresas() {
        return empresas;
    }

    // adicionar uma empresa
    public void addEmpresa(Empresa empresa) {
        empresas.add(empresa);
    }

    public void editNome(Empresa e, String nome) {
        e.setNome(nome);
    }

    public void editCategoria(Empresa e, String categoria) {
        e.setCategoria(categoria);
    }

    public void editDistrito(Empresa e, String distrito) {
        e.setDistrito(distrito);
    }

    public void editLocalizacao(Empresa e, Coordenadas coordenadas) {
        e.setLocalizacao(coordenadas);
    }

    public void editClientesMedia(Empresa e, double clientes) {
        e.setClientesMedia(clientes);
    }

    public void editEmpregados(Empresa e, int empregados) {
        e.setNumEmpregados(empregados);
    }

    public void editSalario(Empresa e, double salario) {
        e.setSalarioAnual(salario);
    }

    public void editCafes(Empresa e, double cafes) {
        e.setCafesMedia(cafes);
    }

    public void editCafesFatura(Empresa e, double cafesFatura) {
        e.setCafesFatura(cafesFatura);
    }

    public void editBolos(Empresa e, double bolos) {
        e.setBolosMedia(bolos);
    }

    public void editBolosFatura(Empresa e, double bolosFatura) {
        e.setBolosFatura(bolosFatura);
    }

    public void editDias(Empresa e, int dias) {
        e.setDiasAno(dias);
    }

    public void editInteriores(Empresa e, int mesas) {
        e.setMesasInteriores(mesas);
    }

    public void editMesaFatura(Empresa e, double mesasFatura) {
        e.setMesaDia(mesasFatura);
    }

    public void editEsplanada(Empresa e, int mesas) {
        e.setMesasEsplanada(mesas);
    }

    public void editEsplanadaFatura(Empresa e, double mesasFatura) {
        e.setMesasEsplanadaFatura(mesasFatura);
    }

    public void editDrive(Empresa e, double clientes) {
        e.setClientesDriveMedia(clientes);
    }

    public void editDriveFatura(Empresa e, double driveFatura) {
        e.setClientesDriveFatura(driveFatura);
    }

    public void editLimpeza(Empresa e, double limpeza) {
        e.setLimpezaCustoAnual(limpeza);
    }

    public void editProdutos(Empresa e, int produtos) {
        e.setNumProdutos(produtos);
    }

    public void editProdutosFatura(Empresa e, double produtosFatura) {
        e.setProdutosFaturaAnual(produtosFatura);
    }

    public void editTipo(Empresa e, String tipo) {
        e.setTipo(tipo);
    }

    public void editArea(Empresa e, double area) {
        e.setArea(area);
    }

    public void editAreaFatura(Empresa e, double areaFatura) {
        e.setAreaFaturaAnual(areaFatura);
    }

    // eliminar uma empresa
    public void deleteEmpresa(String nome) {
        Empresa e = getEmpresa(nome);
        empresas.remove(e);
    }

    // maior receita anual
    public String maiorReceita(String categoria) {
        double temp = Double.MIN_VALUE;
        String nome = "";
        for (Empresa e : empresas) {
            if (e.getCategoria().equals(categoria)) {
                if (temp < e.getReceitaAnual()) {
                    temp = e.getReceitaAnual();
                    nome = e.getNome();
                }
            }
        }
        return "Nome: " + nome + " | Receita anual: " + String.format("%.2f", temp) + "€";
    }

    // menor despesa anual

    public String menorDespesa(String categoria) {
        double temp = Double.MAX_VALUE;
        String nome = "";
        for (Empresa e : empresas) {
            if (e.getCategoria().equals(categoria)) {
                if (temp > e.getDespesaAnual()) {
                    temp = e.getDespesaAnual();
                    nome = e.getNome();
                }
            }
        }
        return "Nome: " + nome + " | Despesa anual: " + String.format("%.2f", temp) + "€";
    }

    // empresa com maior lucro anual

    public String maiorLucro(String categoria) {
        double temp = Double.MIN_VALUE;
        String nome = "";
        for (Empresa e : empresas) {
            if (e.getCategoria().equals(categoria)) {
                if (temp < e.getLucro()) {
                    temp = e.getLucro();
                    nome = e.getNome();
                }
            }
        }
        return "Nome: " + nome + " | Lucro: " + String.format("%.2f", temp) + "€";
    }

    public String maisClientes() {
        double temp = Double.MIN_VALUE;
        double temp2 = Double.MIN_VALUE;
        String nome = "";
        String nome2 = "";
        for (Empresa e : empresas) {
            if (e.getCategoria().equals("Cafe") || e.getCategoria().equals("Pastelaria")
                    || e.getCategoria().equals("Restaurante FasFood") || e.getCategoria().equals("Restaurante Local")) {
                if (e.getClientesMedia() > temp) {
                    temp2 = temp;
                    nome2 = nome;
                    temp = e.getClientesMedia();
                    nome = e.getNome();
                } else if (e.getClientesMedia() > temp2) {
                    temp2 = e.getClientesMedia();
                    nome2 = e.getNome();
                }
            }
        }
        return "Nome: " + nome + " | Média clientes por dia: " + temp + " | Nome: " + nome2
                + " | Média clientes por dia: " + temp2;
    }

    public Empresa getEmpresa(String nome) {
        // Not case sensitive
        for (Empresa e : empresas) {
            if (e.getNome().equals(nome)) {
                return e;
            }
        }
        return null;
    }

    // ler o ficheiro. retirar a informação do ficheiro para as Arrays.
    public void addInfo() {

        File f = new File("starthrive.txt");
        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    String[] div = line.split("\\|");

                    switch (div[0]) {
                        case "C" -> {
                            Coordenadas localizacao = new Coordenadas(Double.parseDouble(div[3]),
                                    Double.parseDouble(div[4]));
                            Empresa x = new Cafe(div[1], "Cafe", div[2], localizacao, Double.parseDouble(div[5]),
                                    Integer.parseInt(div[6]), Double.parseDouble(div[7]), Double.parseDouble(div[8]),
                                    Double.parseDouble(div[9]));
                            empresas.add(x);
                        }
                        case "P" -> {
                            Coordenadas localizacao = new Coordenadas(Double.parseDouble(div[3]),
                                    Double.parseDouble(div[4]));
                            Empresa x = new Pastelaria(div[1], "Pastelaria", div[2], localizacao,
                                    Double.parseDouble(div[5]),
                                    Integer.parseInt(div[6]), Double.parseDouble(div[7]), Double.parseDouble(div[8]),
                                    Double.parseDouble(div[9]));
                            empresas.add(x);
                        }
                        case "RL" -> {
                            Coordenadas localizacao = new Coordenadas(Double.parseDouble(div[3]),
                                    Double.parseDouble(div[4]));
                            Empresa x = new Local(div[1], "Restaurante Local", div[2], localizacao,
                                    Double.parseDouble(div[5]),
                                    Integer.parseInt(div[6]), Double.parseDouble(div[7]), Integer.parseInt(div[8]),
                                    Integer.parseInt(div[9]), Double.parseDouble(div[10]), Integer.parseInt(div[11]),
                                    Double.parseDouble(div[12]));
                            empresas.add(x);
                        }

                        case "RFF" -> {
                            Coordenadas localizacao = new Coordenadas(Double.parseDouble(div[3]),
                                    Double.parseDouble(div[4]));
                            Empresa x = new FastFood(div[1], "Restaurante FastFood", div[2], localizacao,
                                    Double.parseDouble(div[5]),
                                    Integer.parseInt(div[6]), Double.parseDouble(div[7]), Integer.parseInt(div[8]),
                                    Integer.parseInt(div[9]), Double.parseDouble(div[10]), Double.parseDouble(div[11]),
                                    Double.parseDouble(div[12]));
                            empresas.add(x);
                        }

                        case "F" -> {
                            Coordenadas localizacao = new Coordenadas(Double.parseDouble(div[3]),
                                    Double.parseDouble(div[4]));
                            Empresa x = new Frutaria(div[1], "Frutaria", div[2], localizacao,
                                    Double.parseDouble(div[5]),
                                    Integer.parseInt(div[6]), Double.parseDouble(div[7]));
                            empresas.add(x);
                        }
                        case "M" -> {
                            Coordenadas localizacao = new Coordenadas(Double.parseDouble(div[3]),
                                    Double.parseDouble(div[4]));
                            Empresa x = new Mercado(div[1], "Mercado", div[2], localizacao, Double.parseDouble(div[5]),
                                    div[6], Double.parseDouble(div[7]), Double.parseDouble(div[8]));
                            empresas.add(x);
                        }
                    }
                }
                br.close();
            } catch (FileNotFoundException ex) {
            } catch (IOException ex) {
            }
        } else {
        }
    }

    public void createInfoOBJ() {
        File f = new File("starthrive.obj");

        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(empresas);
            oos.close();

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

    @SuppressWarnings("unchecked")
    public void readInfoOBJ() {
        String fileName = "starthrive.obj";
        File f = new File(fileName);
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            empresas = (ArrayList<Empresa>) ois.readObject();

            ois.close();

        } catch (FileNotFoundException ex) {
            addInfo();
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }
}

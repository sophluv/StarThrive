package SM;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {
    // Attributes
    private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panelMain, panelTitle, panelSec, panelInfo;
    private JLabel welcome, title, img, img2, labelGeral, label1, label2, label3, label4, label5, labelInfo;
    public JTextField field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12;
    private JButton logo, logo2, cafe, pastelaria, fastfood, local, frutaria, mercado, restauracao, imprimir, adicionar,
            editar, editar2, eliminar, logout, seguinte1, add1;
    private Color buttonColor = new Color(239, 233, 225), buttonText = new Color(69, 69, 69), panelColor = Color.WHITE,
            mainColor = new Color(249, 246, 242);
    private JScrollPane listScroller;
    private String nome, categoria1, distrito, tipo1;
    private Coordenadas localizacao;
    private double latitude, longitude, clientesMedia, salarioAnual, cafesMedia, cafesFatura, bolosMedia, bolosFatura;
    private int numeroEmpregados, diasFuncionamento, mesasInteriores, mesasEsplanada, numProdutos, sizeBox = 13;
    private double mesaFatura, mesasEsplanadaFatura, driveFatura, numDrive, limpeza, produtoFatura, area, areaFatura;
    private TextfieldListener textfieldListener = new TextfieldListener();
    private JList<String> list;
    private DefaultListModel<String> listValues;
    private ComboBoxActionListener comboBoxActionListener = new ComboBoxActionListener();
    private JComboBox<String> categoria, tipo, editBox;
    private ButtonListener buttonActionListener = new ButtonListener();

    private GestaoEmpresa gestor;

    public MyFrame(GestaoEmpresa gestor) {
        super();
        this.gestor = gestor;
        // Labels
        title = newLabel("St✰rThrive", 40, 70, 400, 50, new Font("Serif", Font.BOLD, 60), new Color(37, 27, 9));
        welcome = newLabel("Clique para proceder!", 900, 450, 300, 50, new Font("Serif", Font.PLAIN, 20), Color.BLACK);
        labelGeral = newLabel("<html>Nome<br><br>Categoria<br><br>Distrito<br><br>Latitude XX.XXXXXX > XXºXX´XX.XX´N<br>Longitude XXX.XXXXXX > XXXºXX´XX.XX´W</html>", 90, 35, 200,
                350, new Font("SansSerif", Font.BOLD, 15), Color.BLACK);
        label1 = newLabel(" ", 40, 0, 270, 450, new Font("SansSerif", Font.BOLD, 15), Color.BLACK);
        // Text inputs
        field1 = newText("", 280, 105, 300, 30, new Font("SansSerif", Font.PLAIN, sizeBox));
        field2 = newText("", 280, 185, 300, 30, new Font("SansSerif", Font.PLAIN, sizeBox));
        field3 = newText("", 280, 225, 300, 30, new Font("SansSerif", Font.PLAIN, sizeBox));
        field4 = newText("", 280, 265, 300, 30, new Font("SansSerif", Font.PLAIN, sizeBox));
        field5 = newText("", 280, 105, 300, 30, new Font("SansSerif", Font.PLAIN, sizeBox));
        field6 = newText("", 280, 145, 300, 30, new Font("SansSerif", Font.PLAIN, sizeBox));
        field7 = newText("", 280, 185, 300, 30, new Font("SansSerif", Font.PLAIN, sizeBox));
        field8 = newText("", 280, 225, 300, 30, new Font("SansSerif", Font.PLAIN, sizeBox));
        field9 = newText("", 280, 265, 300, 30, new Font("SansSerif", Font.PLAIN, sizeBox));
        field10 = newText("", 280, 305, 300, 30, new Font("SansSerif", Font.PLAIN, sizeBox));
        field11 = newText("", 280, 345, 300, 30, new Font("SansSerif", Font.PLAIN, sizeBox));
        field12 = newText("", 280, 385, 300, 30, new Font("SansSerif", Font.PLAIN, sizeBox));

        // Action type list
        String[] types = { "Cafe", "Pastelaria", "Restaurante Local", "Restaurante FastFood", "Frutaria", "Mercado" };
        categoria = newComboBox(types, 280, 140, 300, 30);
        String[] types2 = { "MiniMercado", "SuperMercado", "HiperMercado" };
        tipo = newComboBox(types2, 280, 145, 300, 30);
        String[] types3 = { " " };
        editBox = newComboBox(types3, 280, 140, 300, 30);

        // Action buttons
        logo = newButton(" St✰r ", 400, 180, 700, 120, new Font("Serif", Font.PLAIN, 100), Color.BLACK, true);
        logo.setFocusable(false);
        logo2 = newButton("Thrive", 500, 300, 720, 130, new Font("Serif", Font.PLAIN, 120), Color.BLACK, true);
        logo2.setFocusable(false);
        // Panel 2
        imprimir = newButton("TODAS AS EMPRESAS", 30, 160, 250, 40, new Font("SansSerif", Font.BOLD, 15),
                Color.LIGHT_GRAY, true);
        imprimir.setFocusable(false);
        cafe = newButton("CAFE", 30, 250, 250, 40, new Font("SansSerif", Font.BOLD, 15), Color.LIGHT_GRAY, true);
        cafe.setFocusable(false);
        pastelaria = newButton("PASTELARIA", 30, 290, 250, 40, new Font("SansSerif", Font.BOLD, 15), Color.LIGHT_GRAY,
                true);
        pastelaria.setFocusable(false);
        fastfood = newButton("RESTAURANTE FASTFOOD", 30, 330, 250, 40, new Font("SansSerif", Font.BOLD, 15),
                Color.LIGHT_GRAY, true);
        fastfood.setFocusable(false);
        local = newButton("RESTAURANTE LOCAL", 30, 370, 250, 40, new Font("SansSerif", Font.BOLD, 15), Color.LIGHT_GRAY,
                true);
        local.setFocusable(false);
        frutaria = newButton("FRUTARIA", 30, 410, 250, 40, new Font("SansSerif", Font.BOLD, 15), Color.LIGHT_GRAY,
                true);
        frutaria.setFocusable(false);
        mercado = newButton("MERCADO", 30, 450, 250, 40, new Font("SansSerif", Font.BOLD, 15), Color.LIGHT_GRAY, true);
        mercado.setFocusable(false);
        restauracao = newButton("RESTAURAÇÃO", 30, 550, 400, 40, new Font("SansSerif", Font.BOLD, 15), Color.LIGHT_GRAY,
                true);
        restauracao.setFocusable(false);

        logout = newButton("LOG OUT", 750, 15, 400, 50, new Font("SansSerif", Font.BOLD, 15), buttonText, true);
        seguinte1 = newButton("SEGUINTE", 70, 420, 300, 40, new Font("SansSerif", Font.BOLD, 19), buttonText, true);
        add1 = newButton("ADICONAR EMPRESA", 20, 420, 300, 40, new Font("SansSerif", Font.BOLD, 19), buttonText, true);

        eliminar = newButton("ELIMINAR", 80, 400, 234, 40, new Font("SansSerif", Font.BOLD, 15), buttonText, false);
        eliminar.setBackground(buttonColor);
        editar = newButton("EDITAR", 318, 400, 232, 40, new Font("SansSerif", Font.BOLD, 15), buttonText, false);
        editar.setBackground(buttonColor);
        editar2 = newButton("EDITAR", 330, 200, 200, 35, new Font("SansSerif", Font.BOLD, 15), buttonText, false);
        editar2.setBackground(buttonColor);
        adicionar = newButton("ADICIONAR", 554, 400, 234, 40, new Font("SansSerif", Font.BOLD, 15), buttonText, false);
        adicionar.setBackground(buttonColor);

        labelInfo = newLabel("", 30, 50, 800, 70, new Font("SansSerif", Font.BOLD, 30), buttonText);
        label2 = newLabel("", 30, 150, 800, 50, new Font("SansSerif", Font.PLAIN, 17), buttonText);
        label3 = newLabel("", 30, 180, 800, 50, new Font("SansSerif", Font.PLAIN, 17), buttonText);
        label4 = newLabel("", 30, 210, 800, 50, new Font("SansSerif", Font.PLAIN, 17), buttonText);
        label5 = newLabel("", 30, 210, 800, 50, new Font("SansSerif", Font.PLAIN, 17), buttonText);

        // Lista
        listScroller = newScrollPane();
        // Paineis
        img = new JLabel(new ImageIcon("imagem1.png"));
        panelMain = new JPanel();
        panelMain.setLayout(new BorderLayout());
        panelMain.setBounds(400, 80, 1290, 600);
        panelMain.add(img, BorderLayout.WEST);
        panelMain.setVisible(false);
        panelTitle = newPanel(null, 0, 0, 400, 150, new Color(251, 250, 247));
        panelTitle.add(title);
        panelSec = newPanel(null, 400, 0, 1000, 80, new Color(237, 231, 217));
        panelSec.add(logout);

        img2 = new JLabel(new ImageIcon("imagem2.png"));
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setBounds(-5, -5, 1290, 660);
        panel1.setBackground(Color.BLACK);
        panel1.add(logo);
        panel1.add(logo2);
        panel1.add(welcome);
        panel1.add(img2, BorderLayout.CENTER);

        panel2 = newPanel(null, 0, 0, 400, 650, panelColor);
        panel2.add(cafe);
        panel2.add(pastelaria);
        panel2.add(fastfood);
        panel2.add(local);
        panel2.add(frutaria);
        panel2.add(mercado);
        panel2.add(imprimir);
        panel2.add(restauracao);

        panelInfo = newPanel(null, 400, 80, 1290, 600, mainColor);
        panelInfo.add(labelInfo);
        panelInfo.add(label2);
        panelInfo.add(label3);
        panelInfo.add(label4);
        panelInfo.add(label5);

        panel3 = newPanel(null, 400, 80, 1290, 600, mainColor);
        panel3.add(listScroller);
        panel3.add(editar);
        panel3.add(eliminar);
        panel3.add(adicionar);

        panel4 = newPanel(null, 400, 80, 1290, 600, mainColor);
        panel4.add(labelGeral);
        panel4.add(field1);
        panel4.add(categoria);
        panel4.add(field2);
        panel4.add(field3);
        panel4.add(field4);
        panel4.add(seguinte1);

        panel5 = newPanel(null, 400, 80, 1290, 600, mainColor);
        panel5.add(label1);

        panel5.add(field5);
        panel5.add(field6);
        panel5.add(field7);
        panel5.add(field8);
        panel5.add(field9);
        panel5.add(field10);
        panel5.add(field11);
        panel5.add(field12);
        panel5.add(tipo);
        panel5.add(add1);

        panel6 = newPanel(null, 400, 80, 1290, 600, mainColor);
        panel6.add(editBox);
        panel6.add(editar2);

        this.add(panelMain);
        this.add(panelTitle);
        this.add(panelSec);
        this.add(panel1);
        this.add(panel2);
        this.add(panelInfo);
        this.add(panel3);
        this.add(panel4);
        this.add(panel5);
        this.add(panel6);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null, "Informação foi guardada automáticamente.");
                gestor.createInfoOBJ();
                e.getWindow().dispose();
            }
        });
    }

    private JPanel newPanel(LayoutManager layout, int x, int y, int w, int h, Color color) {
        JPanel panel = new JPanel();
        panel.setLayout(layout);
        panel.setBounds(x, y, w, h);
        panel.setBackground(color);
        panel.setVisible(false);
        return panel;
    }

    private JButton newButton(String text, int x, int y, int w, int h, Font font, Color color, boolean op) {
        JButton button = new JButton(text);
        button.setBounds(x, y, w, h);
        button.setFont(font);
        button.setForeground(color);
        if (op == true) {
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            button.setHorizontalAlignment(SwingConstants.LEFT);
        }
        button.addActionListener(buttonActionListener);
        return button;
    }

    private JTextField newText(String text, int x, int y, int w, int h, Font font) {
        JTextField textField = new JTextField(text);
        textField.setBounds(x, y, w, h);
        textField.setFont(font);
        textField.setBorder(BorderFactory.createEtchedBorder());
        textField.addFocusListener(textfieldListener);
        textField.addKeyListener(textfieldListener);
        return textField;
    }

    private JLabel newLabel(String text, int x, int y, int w, int h, Font font, Color color) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, w, h);
        label.setFont(font);
        label.setForeground(color);
        return label;
    }

    private JComboBox<String> newComboBox(String[] type, int x, int y, int w, int h) {
        JComboBox<String> comboBox = new JComboBox<String>(type);
        comboBox.setBounds(x, y, w, h);
        comboBox.addActionListener(comboBoxActionListener);
        return comboBox;
    }

    private JScrollPane loadJScrollPane() {
        listValues.clear();
        for (Empresa e : gestor.listaEmpresas()) {
            listValues.addElement(e.toString());
        }
        return listScroller;
    }

    private JScrollPane newScrollPane() {
        listValues = new DefaultListModel<String>();
        list = new JList<String>(listValues);
        list.setFont(new Font("SansSerif", Font.PLAIN, 14));
        listScroller = new JScrollPane(list);
        listScroller.setBounds(80, 100, 710, 280);
        return listScroller;
    }

    private void clearText() {
        field1.setText("");
        field2.setText("");
        field3.setText("");
        field4.setText("");
        field5.setText("");
        field6.setText("");
        field7.setText("");
        field8.setText("");
        field9.setText("");
        field10.setText("");
        field11.setText("");
        field12.setText("");
    }

    private void setText(String categoria) {
        labelInfo.setText(categoria);
        label2.setText("Maior receita anual: " + gestor.maiorReceita(categoria));
        label3.setText("Menor despesa anual: " + gestor.menorDespesa(categoria));
        label4.setText("Maior lucro anual: " + gestor.maiorLucro(categoria));
        label5.setText("");
    }

    private void getClear() {
        panelInfo.setVisible(true);
        panelMain.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);
        panel5.setVisible(false);
        cafe.setForeground(Color.LIGHT_GRAY);
        pastelaria.setForeground(Color.LIGHT_GRAY);
        fastfood.setForeground(Color.LIGHT_GRAY);
        local.setForeground(Color.LIGHT_GRAY);
        frutaria.setForeground(Color.LIGHT_GRAY);
        mercado.setForeground(Color.LIGHT_GRAY);
        imprimir.setForeground(Color.LIGHT_GRAY);
        restauracao.setForeground(Color.LIGHT_GRAY);

    }

    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == logo || e.getSource() == logo2) {
                panel1.setVisible(false);
                panelMain.setVisible(true);
                panelTitle.setVisible(true);
                panelSec.setVisible(true);
                panel2.setVisible(true);
            }

            if (e.getSource() == imprimir) {
                getClear();
                list.setSelectedIndex(7);
                imprimir.setForeground(Color.BLACK);
                panel3.setVisible(true);
                listScroller = loadJScrollPane();
                panelInfo.setVisible(false);
                panel5.setVisible(false);
                panel4.setVisible(false);
                panel6.setVisible(false);
                panelMain.setVisible(false);
            }

            if (e.getSource() == adicionar) {
                clearText();
                panel3.setVisible(false);
                panel4.setVisible(true);
                panel5.setVisible(false);
                panelMain.setVisible(false);
            }

            if (e.getSource() == seguinte1) {

                try {
                    nome = field1.getText();
                    distrito = field2.getText();
                    latitude = Double.parseDouble(field3.getText());
                    longitude = Double.parseDouble(field4.getText());
                    categoria1 = String.valueOf(categoria.getSelectedItem());
                    localizacao = new Coordenadas(latitude, longitude);
                } catch (NumberFormatException ex) {

                }
                if (!nome.equals("") & !distrito.equals("") & latitude!=0 & longitude!=0 & latitude < 90 & latitude > -90 & longitude < 180
                        & longitude > -180) {
                    panel4.setVisible(false);
                    if (categoria1.equals("Cafe")) {
                        panel5.setVisible(true);
                        field10.setVisible(false);
                        field11.setVisible(false);
                        field12.setVisible(false);
                        tipo.setVisible(false);
                        label1.setText(
                                "<html>Nº médio de clientes diário<br><br>Número de empregados<br><br>Média salário anual<br><br>Número médio de cafés<br><br>Faturação anual cafés vendidos<br><br><br><br></html>");
                    } else if (categoria1.equals("Pastelaria")) {
                        panel5.setVisible(true);
                        field10.setVisible(false);
                        field11.setVisible(false);
                        field12.setVisible(false);
                        tipo.setVisible(false);
                        label1.setText(
                                "<html>Nº médio de clientes diário<br><br>Número de empregados<br><br>Média de salário anual<br><br>Nº médio de bolos vendidos<br><br>Faturação anual bolos vendidos<br><br><br><br></html>");
                    } else if (categoria1.equals("Restaurante FastFood")) {
                        panel5.setVisible(true);
                        field10.setVisible(true);
                        field11.setVisible(true);
                        field12.setVisible(true);
                        tipo.setVisible(false);
                        label1.setText(
                                "<html><br><br><br>Nº médio de clientes diário<br><br>Nº de empregados<br><br>Média de salário anual<br><br>Dias de funcionamento por ano<br><br>Nª mesas interiores<br><br>Média faturação diária mesa<br><br>Nº médio diário clientes drive<br><br>Média faturação cliente drive</html>");
                    } else if (categoria1.equals("Restaurante Local")) {
                        panel5.setVisible(true);
                        field10.setVisible(true);
                        field11.setVisible(true);
                        field12.setVisible(true);
                        tipo.setVisible(false);
                        label1.setText(
                                "<html><br><br><br>Nº médio de clientes diário<br><br>Nº de empregados<br><br>Média de salário anual<br><br>Dias de funcionamento por ano<br><br>Nº mesas interiores<br><br>Média faturação diária mesa<br><br>Nº mesas esplanada<br><br>Licença anual mesas esplanada</html>");
                    } else if (categoria1.equals("Frutaria")) {
                        panel5.setVisible(true);
                        field8.setVisible(false);
                        field9.setVisible(false);
                        field10.setVisible(false);
                        field11.setVisible(false);
                        field12.setVisible(false);
                        tipo.setVisible(false);
                        label1.setText(
                                "<html>Custo anual de limpeza<br><br>Nº de produtos<br><br>Faturação anual por produto<br><br><br><br><br><br><br><br></html>");
                    } else if (categoria1.equals("Mercado")) {
                        panel5.setVisible(true);
                        field6.setVisible(false);
                        field9.setVisible(false);
                        field10.setVisible(false);
                        field11.setVisible(false);
                        field12.setVisible(false);
                        tipo.setVisible(true);
                        label1.setText(
                                "<html>Custo anual de limpeza<br><br>Tipo de mercado<br><br>Área de corredores m2<br><br>Faturação anual por m2<br><br><br><br><br><br></html>");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Infomação incompleta ou mal introduzida!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

            if (e.getSource() == add1) {
                if (categoria1.equals("Cafe")) {
                    try {
                        clientesMedia = Double.parseDouble(field5.getText());
                        numeroEmpregados = Integer.parseInt(field6.getText());
                        salarioAnual = Double.parseDouble(field7.getText());
                        cafesMedia = Double.parseDouble(field8.getText());
                        cafesFatura = Double.parseDouble(field9.getText());
                    } catch (NumberFormatException ex) {

                    }
                    if (clientesMedia > 0 & numeroEmpregados > 0 & salarioAnual > 0 & cafesMedia > 0
                            & cafesFatura > 0) {

                        if (JOptionPane.showConfirmDialog(null, "Adicionar um cafe novo?", "★",
                                JOptionPane.YES_NO_OPTION) == 0) {
                            Cafe cafe = new Cafe(nome, categoria1, distrito, localizacao, clientesMedia,
                                    numeroEmpregados, salarioAnual, cafesMedia, cafesFatura);
                            gestor.addEmpresa(cafe);
                            JOptionPane.showMessageDialog(null, "Cafe adicionado com sucesso!");
                            listScroller = loadJScrollPane();
                            panel3.setVisible(true);
                            panel5.setVisible(false);
                            clearText();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Infomação incompleta ou mal introduzida!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else if (categoria1.equals("Pastelaria")) {

                    try {
                        clientesMedia = Double.parseDouble(field5.getText());
                        numeroEmpregados = Integer.parseInt(field6.getText());
                        salarioAnual = Double.parseDouble(field7.getText());
                        bolosMedia = Double.parseDouble(field8.getText());
                        bolosFatura = Double.parseDouble(field9.getText());
                    } catch (NumberFormatException ex) {

                    }
                    if (clientesMedia > 0 & numeroEmpregados > 0 & salarioAnual > 0 & bolosMedia > 0
                            & bolosFatura > 0) {

                        if (JOptionPane.showConfirmDialog(null, "Adicionar uma pastelaria nova?", "★",
                                JOptionPane.YES_NO_OPTION) == 0) {

                            Pastelaria pastelaria = new Pastelaria(nome, categoria1, distrito, localizacao,
                                    clientesMedia, numeroEmpregados, salarioAnual, bolosMedia, bolosFatura);
                            gestor.addEmpresa(pastelaria);
                            JOptionPane.showMessageDialog(null, "Pastelaria adicionado com sucesso!");
                            listScroller = loadJScrollPane();
                            panel3.setVisible(true);
                            panel5.setVisible(false);
                            clearText();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Infomação incompleta ou mal introduzida!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }

                else if (categoria1.equals("Restaurante FastFood")) {
                    try {
                        clientesMedia = Double.parseDouble(field5.getText());
                        numeroEmpregados = Integer.parseInt(field6.getText());
                        salarioAnual = Double.parseDouble(field7.getText());
                        diasFuncionamento = Integer.parseInt(field8.getText());
                        mesasInteriores = Integer.parseInt(field9.getText());
                        mesaFatura = Double.parseDouble(field10.getText());
                        numDrive = Double.parseDouble(field11.getText());
                        driveFatura = Double.parseDouble(field12.getText());
                    } catch (NumberFormatException ex) {

                    }
                    if (clientesMedia > 0 & numeroEmpregados > 0 & salarioAnual > 0 & diasFuncionamento > 0
                            & diasFuncionamento < 365 & mesasInteriores > 0 & mesaFatura > 0 & numDrive > 0
                            & driveFatura > 0) {

                        if (JOptionPane.showConfirmDialog(null, "Adicionar um restaurante FastFood novo?", "★",
                                JOptionPane.YES_NO_OPTION) == 0) {
                            FastFood fastFood = new FastFood(nome, categoria1, distrito, localizacao, clientesMedia,
                                    numeroEmpregados, salarioAnual, diasFuncionamento, mesasInteriores, mesaFatura,
                                    numDrive, driveFatura);
                            gestor.addEmpresa(fastFood);
                            JOptionPane.showMessageDialog(null, "Restaurante FastFood adicionado com sucesso!");
                            listScroller = loadJScrollPane();
                            panel3.setVisible(true);
                            panel5.setVisible(false);
                            clearText();

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Infomação incompleta ou mal introduzida!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else if (categoria1.equals("Restaurante Local")) {
                    try {
                        clientesMedia = Double.parseDouble(field5.getText());
                        numeroEmpregados = Integer.parseInt(field6.getText());
                        salarioAnual = Double.parseDouble(field7.getText());
                        diasFuncionamento = Integer.parseInt(field8.getText());
                        mesasInteriores = Integer.parseInt(field9.getText());
                        mesaFatura = Double.parseDouble(field10.getText());
                        mesasEsplanada = Integer.parseInt(field11.getText());
                        mesasEsplanadaFatura = Double.parseDouble(field12.getText());
                    } catch (NumberFormatException ex) {
   
                    }
                    if (clientesMedia > 0 & numeroEmpregados > 0 & salarioAnual > 0 & diasFuncionamento > 0
                            & diasFuncionamento < 365
                            & mesaFatura > 0
                            & (mesasInteriores > 0 || (mesasEsplanada > 0 & mesasEsplanadaFatura > 0))) {

                        if (JOptionPane.showConfirmDialog(null, "Adicionar um restaurante local novo?", "★",
                                JOptionPane.YES_NO_OPTION) == 0) {
                            Local local = new Local(nome, categoria1, distrito, localizacao, clientesMedia,
                                    numeroEmpregados, salarioAnual, diasFuncionamento, mesasInteriores, mesaFatura,
                                    mesasEsplanada, mesasEsplanadaFatura);
                            gestor.addEmpresa(local);
                            JOptionPane.showMessageDialog(null, "Restaurante Local adicionado com sucesso!");
                            listScroller = loadJScrollPane();
                            panel3.setVisible(true);
                            panel5.setVisible(false);
                            clearText();
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Infomação incompleta ou mal introduzida!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }

                else if (categoria1.equals("Frutaria")) {
                    try {
                        limpeza = Double.parseDouble(field5.getText());
                        numProdutos = Integer.parseInt(field6.getText());
                        produtoFatura = Double.parseDouble(field7.getText());
                    } catch (NumberFormatException ex) {

                    }
                    if (limpeza > 0 & numProdutos > 0 & produtoFatura > 0) {

                        if (JOptionPane.showConfirmDialog(null, "Adicionar uma frutaria nova?", "★",
                                JOptionPane.YES_NO_OPTION) == 0) {
                            Frutaria frutaria = new Frutaria(nome, categoria1, distrito, localizacao, limpeza,
                                    numProdutos, produtoFatura);
                            gestor.addEmpresa(frutaria);
                            JOptionPane.showMessageDialog(null, "Frutaria adicionadacom sucesso!");
                            listScroller = loadJScrollPane();
                            panel3.setVisible(true);
                            panel5.setVisible(false);
                            clearText();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Infomação incompleta ou mal introduzida!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }

                else if (categoria1.equals("Mercado")) {
                    try {
                        limpeza = Double.parseDouble(field5.getText());
                        tipo1 = String.valueOf(tipo.getSelectedItem());
                        area = Integer.parseInt(field7.getText());
                        areaFatura = Double.parseDouble(field8.getText());
                    } catch (NumberFormatException ex) {

                    }
                    if (limpeza > 0 & area > 0 & areaFatura > 0) {

                        if (JOptionPane.showConfirmDialog(null, "Adicionar um mercado novo?", "★",
                                JOptionPane.YES_NO_OPTION) == 0) {
                            Mercado mercado = new Mercado(nome, categoria1, distrito, localizacao, limpeza, tipo1, area,
                                    areaFatura);
                            gestor.addEmpresa(mercado);
                            JOptionPane.showMessageDialog(null, "Mercado adicionado com sucesso!");
                            listScroller = loadJScrollPane();
                            panel3.setVisible(true);
                            panel5.setVisible(false);
                            clearText();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Infomação incompleta ou mal introduzida!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            if (e.getSource() == editar) {

                String a = String.valueOf(list.getSelectedValue());

                String arr[] = a.split(" \\|");
                nome = arr[0];

                if (!nome.equals("null")) {

                    if (gestor.getEmpresa(nome).getCategoria().equals("Cafe")) {

                        panel3.setVisible(false);
                        panel6.setVisible(true);
                        String[] Options = { "Nome", "Distrito", "Categoria", "Localização", "Clientes Media",
                                "Número de empregados", "Média de salário anual",
                                "Número médio de cafés que vendem por dia",
                                "Valor médio de faturação anual por café vendido" };
                        editBox.removeAllItems();
                        for (String i : Options) {
                            editBox.addItem(i);
                        }
                    } else if (gestor.getEmpresa(nome).getCategoria().equals("Pastelaria")) {

                        panel3.setVisible(false);
                        panel6.setVisible(true);
                        String[] Options = { "Nome", "Distrito", "Categoria", "Localização", "Clientes Media",
                                "Número de empregados", "Média de salário anual",
                                "Número médio de bolos que vendem por dia",
                                "Valor médio de faturação anual por bolo vendido" };
                        editBox.removeAllItems();
                        for (String i : Options) {
                            editBox.addItem(i);
                        }
                    } else if (gestor.getEmpresa(nome).getCategoria().equals("Restaurante FastFood")) {

                        panel3.setVisible(false);
                        panel6.setVisible(true);
                        String[] Options = { "Nome", "Distrito", "Categoria", "Localização", "Clientes Media",
                                "Número de empregados", "Média de salário anual", "Dias de funcionamento por ano",
                                "Número mesas interiores", "Valor médio de faturação anual por cada mesa",
                                "Número médio diário de clientes drive",
                                "Valor médio diário de faturação por cada cliente drive" };
                        editBox.removeAllItems();
                        for (String i : Options) {
                            editBox.addItem(i);
                        }
                    } else if (gestor.getEmpresa(nome).getCategoria().equals("Restaurante Local")) {

                        panel3.setVisible(false);
                        panel6.setVisible(true);
                        String[] Options = { "Nome", "Distrito", "Categoria", "Localização", "Clientes Media",
                                "Número de empregados", "Média de salário anual", "Dias de funcionamento por ano",
                                "Número mesas interiores", "Valor médio de faturação anual por cada mesa",
                                "Número mesas esplanada", "Custo de licença anual por mesa de esplanada" };
                        editBox.removeAllItems();
                        for (String i : Options) {
                            editBox.addItem(i);
                        }
                    } else if (gestor.getEmpresa(nome).getCategoria().equals("Frutaria")) {

                        panel3.setVisible(false);
                        panel6.setVisible(true);
                        String[] Options = { "Nome", "Distrito", "Categoria", "Localização", "Custo anual de limpeza",
                                "Número de produtos", "Valor médio faturação anual por produto" };
                        editBox.removeAllItems();
                        for (String i : Options) {
                            editBox.addItem(i);
                        }
                    } else if (gestor.getEmpresa(nome).getCategoria().equals("Mercado")) {

                        panel3.setVisible(false);
                        panel6.setVisible(true);
                        String[] Options = { "Nome", "Distrito", "Categoria", "Localização", "Custo anual de limpeza",
                                "Tipo", "Área de corredores", "Valor médio de faturação anual por m2" };
                        editBox.removeAllItems();
                        for (String i : Options) {
                            editBox.addItem(i);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Não escolheu nenhuma empresa!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                listScroller = loadJScrollPane();
            }

            if (e.getSource() == editar2) {

                if (String.valueOf(editBox.getSelectedItem()).equals("Nome")) {
                    String nomeNovo = JOptionPane.showInputDialog("Insira o nome novo da empresa:");
                    gestor.editNome(gestor.getEmpresa(nome), nomeNovo);

                } else if (String.valueOf(editBox.getSelectedItem()).equals("Categoria")) {
                    String categoriaNova = " ";
                    String[] optionsCategoria = { "Cafe", "Pastelaria", "Restaurante FastFood", "Restaurante Local",
                            "Frutaria", "Mercado" };
                    int selection = JOptionPane.showOptionDialog(null, "Select one:",
                            "Insira a categoria nova da empresa", JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE, null, optionsCategoria, optionsCategoria[0]);
                    if (selection == 0) {
                        categoriaNova = "Cafe";
                    }
                    if (selection == 1) {
                        categoriaNova = "Pastelaria";
                    }
                    if (selection == 2) {
                        categoriaNova = "Restaurante FastFood";
                    }
                    if (selection == 3) {
                        categoriaNova = "Restaurante Local";
                    }
                    if (selection == 4) {
                        categoriaNova = "Frutaria";
                    }
                    if (selection == 5) {
                        categoriaNova = "Mercado";
                    }
                    gestor.editCategoria(gestor.getEmpresa(nome), categoriaNova);

                } else if (String.valueOf(editBox.getSelectedItem()).equals("Distrito")) {
                    String distritoNovo = JOptionPane.showInputDialog("Insira o distrito novo da empresa:");
                    gestor.editDistrito(gestor.getEmpresa(nome), distritoNovo);

                } else if (String.valueOf(editBox.getSelectedItem()).equals("Localização")) {
                    double latitude = Double
                            .parseDouble(JOptionPane.showInputDialog(
                                    "Insira a latitude nova da empresa:\n( XX.XXXXXX > XXºXX´XX.XX´N )"));
                    double longitude = Double
                            .parseDouble(JOptionPane.showInputDialog(
                                    "Insira a longitude nova da empresa:\n( XXX.XXXXXX > XXXºXX´XX.XX´W )"));
                    if (latitude > 90 || latitude < -90 || longitude > 180 || longitude < -180) {
                        JOptionPane.showMessageDialog(null, "Dados mal introduzidos!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        Coordenadas coordenadas = new Coordenadas(latitude, longitude);
                        gestor.editLocalizacao(gestor.getEmpresa(nome), coordenadas);
                        JOptionPane.showMessageDialog(null, "Localização editada com sucesso!");
                    }

                } else if (String.valueOf(editBox.getSelectedItem()).equals("Clientes Media")) {
                    double clientesMediaNovo = Double.parseDouble(
                            JOptionPane.showInputDialog("Insira o número médio de clientes novo da empresa:"));
                    if (clientesMediaNovo < 0) {
                        JOptionPane.showMessageDialog(null, "Dados mal introduzidos!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        gestor.editClientesMedia(gestor.getEmpresa(nome), clientesMediaNovo);
                        JOptionPane.showMessageDialog(null, "Número médio de clientes editado com sucesso!");
                    }
                } else if (String.valueOf(editBox.getSelectedItem()).equals("Número de empregados")) {
                    int empregadosNovo = Integer
                            .parseInt(JOptionPane.showInputDialog("Insira o número de empregados novo da empresa:"));
                    if (empregadosNovo < 0) {
                        JOptionPane.showMessageDialog(null, "Dados mal introduzidos!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        gestor.editEmpregados(gestor.getEmpresa(nome), empregadosNovo);
                        JOptionPane.showMessageDialog(null, "Número de empregados editado com sucesso!");
                    }
                } else if (String.valueOf(editBox.getSelectedItem()).equals("Média de salário anual")) {
                    double salarioNovo = Double.parseDouble(
                            JOptionPane.showInputDialog("Insira a média de salário anual nova da empresa:"));
                    if (salarioNovo < 0) {
                        JOptionPane.showMessageDialog(null, "Dados mal introduzidos!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        gestor.editSalario(gestor.getEmpresa(nome), salarioNovo);
                        JOptionPane.showMessageDialog(null, "Salário anual editado com sucesso!");
                    }
                } else if (String.valueOf(editBox.getSelectedItem())
                        .equals("Número médio de cafés que vendem por dia")) {
                    double cafesNovo = Double
                            .parseDouble(JOptionPane.showInputDialog("Insira o número médio novo de cafés:"));
                    if (cafesNovo < 0) {
                        JOptionPane.showMessageDialog(null, "Dados mal introduzidos!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        gestor.editCafes(gestor.getEmpresa(nome), cafesNovo);
                        JOptionPane.showMessageDialog(null, "Número médio de cafés editado com sucesso!");
                    }

                } else if (String.valueOf(editBox.getSelectedItem())
                        .equals("Valor médio de faturação anual por café vendido")) {
                    double cafesFaturaNova = Double.parseDouble(
                            JOptionPane.showInputDialog("Insira o valor médio novo de faturação anual por café:"));
                    if (cafesFaturaNova < 0) {
                        JOptionPane.showMessageDialog(null, "Dados mal introduzidos!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        gestor.editCafesFatura(gestor.getEmpresa(nome), cafesFaturaNova);
                        JOptionPane.showMessageDialog(null, "Número médio de bolos editado com sucesso!");
                    }

                } else if (String.valueOf(editBox.getSelectedItem())
                        .equals("Número médio de bolos que vendem por dia")) {
                    double bolosNovo = Double
                            .parseDouble(JOptionPane.showInputDialog("Insira o número médio novo de bolos:"));
                    if (bolosNovo < 0) {
                        JOptionPane.showMessageDialog(null, "Dados mal introduzidos!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        gestor.editBolos(gestor.getEmpresa(nome), bolosNovo);
                        JOptionPane.showMessageDialog(null, "Número médio de bolos editado com sucesso!");
                    }

                } else if (String.valueOf(editBox.getSelectedItem())
                        .equals("Valor médio de faturação anual por bolo vendido")) {
                    double bolosFaturaNova = Double.parseDouble(
                            JOptionPane.showInputDialog("Insira o valor médio novo de faturação anual por bolo:"));
                    if (bolosFaturaNova < 0) {
                        JOptionPane.showMessageDialog(null, "Dados mal introduzidos!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        gestor.editBolosFatura(gestor.getEmpresa(nome), bolosFaturaNova);
                        JOptionPane.showMessageDialog(null, "Número médio de bolos editado com sucesso!");
                    }

                } else if (String.valueOf(editBox.getSelectedItem()).equals("Dias de funcionamento por ano")) {
                    int dias = Integer.parseInt(JOptionPane.showInputDialog("Insira a nova quantidade de dias:"));
                    if (dias < 0 || dias > 365) {
                        JOptionPane.showMessageDialog(null, "Dados mal introduzidos!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        gestor.editDias(gestor.getEmpresa(nome), dias);
                        JOptionPane.showMessageDialog(null,
                                "Némero de dias de funcionamento por ano editado com sucesso!");
                    }

                } else if (String.valueOf(editBox.getSelectedItem()).equals("Número mesas interiores")) {
                    int mesas = Integer
                            .parseInt(JOptionPane.showInputDialog("Insira a nova quantidade de mesas interiores:"));

                    if (mesas < 0) {
                        JOptionPane.showMessageDialog(null, "Dados mal introduzidos!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        gestor.editInteriores(gestor.getEmpresa(nome), mesas);
                        JOptionPane.showMessageDialog(null, "Número de mesas interiores editado com sucesso!");
                    }

                } else if (String.valueOf(editBox.getSelectedItem())
                        .equals("Valor médio de faturação anual por cada mesa")) {
                    double mesaFatura = Double.parseDouble(
                            JOptionPane.showInputDialog("Insira o valor médio novo de faturação anual por mesa:"));

                    if (mesaFatura < 0) {
                        JOptionPane.showMessageDialog(null, "Dados mal introduzidos!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        gestor.editMesaFatura(gestor.getEmpresa(nome), mesaFatura);
                        JOptionPane.showMessageDialog(null, "valor médio de faturação anual editado com sucesso!");
                    }

                } else if (String.valueOf(editBox.getSelectedItem()).equals("Número mesas esplanada")) {
                    int mesas = Integer
                            .parseInt(JOptionPane.showInputDialog("Insira a nova quantidade de mesas esplanada:"));
                    if (mesas < 0) {
                        JOptionPane.showMessageDialog(null, "Dados mal introduzidos!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        gestor.editEsplanada(gestor.getEmpresa(nome), mesas);
                        JOptionPane.showMessageDialog(null, "Número de mesas esplanada editado com sucesso!");
                    }

                } else if (String.valueOf(editBox.getSelectedItem())
                        .equals("Custo de licença anual por mesa de esplanada")) {
                    double mesaFatura = Double.parseDouble(JOptionPane
                            .showInputDialog("Insira o valor médio novo de faturação anual por mesa esplanada:"));
                    if (mesaFatura < 0) {
                        JOptionPane.showMessageDialog(null, "Dados mal introduzidos!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        gestor.editEsplanadaFatura(gestor.getEmpresa(nome), mesaFatura);
                        JOptionPane.showMessageDialog(null,
                                "Valor médio de faturação anual por mesa esplanada editado com sucesso!");
                    }

                } else if (String.valueOf(editBox.getSelectedItem()).equals("Número médio diário de clientes drive")) {
                    double clientes = Double.parseDouble(
                            JOptionPane.showInputDialog("Insira o valor médio novo de clientes drive diário:"));
                    if (clientes < 0) {
                        JOptionPane.showMessageDialog(null, "Dados mal introduzidos!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        gestor.editDrive(gestor.getEmpresa(nome), clientes);
                        JOptionPane.showMessageDialog(null, "Valor médio de clientes drive editado com sucesso!");
                    }

                } else if (String.valueOf(editBox.getSelectedItem())
                        .equals("Valor médio diário de faturação por cada cliente drive")) {
                    double driveFatura = Double.parseDouble(JOptionPane
                            .showInputDialog("Insira o valor médio novo de faturação anual por cliente drive:"));
                    if (driveFatura < 0) {
                        JOptionPane.showMessageDialog(null, "Dados mal introduzidos!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        gestor.editDriveFatura(gestor.getEmpresa(nome), driveFatura);
                        JOptionPane.showMessageDialog(null,
                                "Valor médio faturação anual por cliente drive editado com sucesso!");
                    }

                } else if (String.valueOf(editBox.getSelectedItem()).equals("Custo anual de limpeza")) {
                    double limpeza = Double
                            .parseDouble(JOptionPane.showInputDialog("Insira o custo anual novo de limpeza:"));
                    if (limpeza < 0) {
                        JOptionPane.showMessageDialog(null, "Dados mal introduzidos!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        gestor.editLimpeza(gestor.getEmpresa(nome), limpeza);
                        JOptionPane.showMessageDialog(null, "Custo anual de limpeza editado com sucesso!");
                    }

                } else if (String.valueOf(editBox.getSelectedItem()).equals("Número de produtos")) {
                    int produto = Integer.parseInt(JOptionPane.showInputDialog("Insira o novo número de produtos:"));
                    if (produto < 0) {
                        JOptionPane.showMessageDialog(null, "Dados mal introduzidos!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        gestor.editProdutos(gestor.getEmpresa(nome), produto);
                        JOptionPane.showMessageDialog(null, "Número de produtos editado com sucesso!");
                    }

                } else if (String.valueOf(editBox.getSelectedItem())
                        .equals("Valor médio faturação anual por produto")) {
                    double produtoFatura = Double.parseDouble(
                            JOptionPane.showInputDialog("Insira o novo valor médio de faturação anual por produto:"));
                    if (produtoFatura < 0) {
                        JOptionPane.showMessageDialog(null, "Dados mal introduzidos!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        gestor.editProdutosFatura(gestor.getEmpresa(nome), produtoFatura);
                        JOptionPane.showMessageDialog(null,
                                "Valor médio faturação anual por produto editado com sucesso!");
                    }

                } else if (String.valueOf(editBox.getSelectedItem()).equals("Tipo")) {
                    String tipoNovo = " ";
                    String[] optionsTipo = { "MiniMercado", "SuperMercado", "HiperMercado" };
                    int selection = JOptionPane.showOptionDialog(null, "Select one:", "Insira o tipo nova da empresa",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, optionsTipo,
                            optionsTipo[0]);
                    if (selection == 0) {
                        tipoNovo = "MiniMercado";
                    }
                    if (selection == 1) {
                        tipoNovo = "SuperMercado";
                    }
                    if (selection == 2) {
                        tipoNovo = "HiperMercado";
                    }
                    gestor.editTipo(gestor.getEmpresa(nome), tipoNovo);

                } else if (String.valueOf(editBox.getSelectedItem()).equals("Área de corredores")) {
                    double area = Double.parseDouble(JOptionPane.showInputDialog("Insira a nova área de corredores:"));
                    if (area < 0) {
                        JOptionPane.showMessageDialog(null, "Dados mal introduzidos!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        gestor.editArea(gestor.getEmpresa(nome), area);
                        JOptionPane.showMessageDialog(null,
                                "Valor da área de corredores editado com sucesso!");
                    }

                } else if (String.valueOf(editBox.getSelectedItem()).equals("Valor médio de faturação anual por m2")) {
                    double areaFatura = Double.parseDouble(
                            JOptionPane.showInputDialog("Insira o novo valor médio de faturação anual por área:"));
                    if (areaFatura < 0) {
                        JOptionPane.showMessageDialog(null, "Dados mal introduzidos!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        gestor.editAreaFatura(gestor.getEmpresa(nome), areaFatura);
                        JOptionPane.showMessageDialog(null,
                                "Valor médio de faturação anual por área editado com sucesso!");
                    }
                }

                listScroller = loadJScrollPane();
                panel6.setVisible(false);
                panel3.setVisible(true);
            }

            if (e.getSource() == eliminar) {

                String a = String.valueOf(list.getSelectedValue());
                String arr[] = a.split(" \\|");
                nome = arr[0];
                if (!nome.equals("null")) {
                    if (JOptionPane.showConfirmDialog(null, "Tem a certeza que quer eliminar a empresa '" + nome + "'?",
                            "★", JOptionPane.YES_NO_OPTION) == 0) {
                        System.out.print(nome);
                        gestor.deleteEmpresa(nome);
                        listScroller = loadJScrollPane();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Não escolheu nenhuma empresa!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            if (e.getSource() == cafe) {
                setText("Cafe");
                getClear();
                cafe.setForeground(Color.BLACK);
            }

            if (e.getSource() == pastelaria) {
                setText("Pastelaria");
                getClear();
                pastelaria.setForeground(Color.BLACK);
            }

            if (e.getSource() == fastfood) {
                setText("Restaurante FastFood");
                getClear();
                fastfood.setForeground(Color.BLACK);
            }

            if (e.getSource() == local) {
                setText("Restaurante Local");
                getClear();
                local.setForeground(Color.BLACK);
            }

            if (e.getSource() == frutaria) {
                setText("Frutaria");
                getClear();
                frutaria.setForeground(Color.BLACK);
            }

            if (e.getSource() == mercado) {
                setText("Mercado");
                getClear();
                mercado.setForeground(Color.BLACK);
            }

            if (e.getSource() == restauracao) {
                label2.setText("");
                label4.setText("");
                label3.setText("2 empresas do tipo restauração com maior capacidade de clientes por dia:");
                labelInfo.setText("Restauração");
                label5.setText(gestor.maisClientes());
                getClear();
                restauracao.setForeground(Color.BLACK);
            }

            if (e.getSource() == logout) {
                if (JOptionPane.showConfirmDialog(null, "Log out?", "★", JOptionPane.YES_NO_OPTION) == 0) {
                    gestor.createInfoOBJ();
                    System.exit(0);
                }
            }
        }
    }

    private class TextfieldListener implements FocusListener, KeyListener {
        public void focusGained(FocusEvent e) {
        }

        public void focusLost(FocusEvent e) {
        }

        public void keyTyped(KeyEvent e) {
        }

        public void keyPressed(KeyEvent e) {
        }

        public void keyReleased(KeyEvent e) {
        }
    }

    private class ComboBoxActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        }
    }

    public void actionPerformed(ActionEvent e) {
    }

    public void windowClosing(WindowEvent e) {
        System.out.println("Closed");
        e.getWindow().dispose();
    }
}
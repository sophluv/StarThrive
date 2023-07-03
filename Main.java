package SM;

import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        GestaoEmpresa gestor = new GestaoEmpresa();

        MyFrame frame = new MyFrame(gestor);
        frame.setTitle("StarThrive");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().setBackground(Color.white);
        frame.setVisible(true);
        ImageIcon image = new ImageIcon("imagem3.png");
        frame.setIconImage(image.getImage());

    }

}

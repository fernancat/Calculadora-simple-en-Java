import javax.swing.*;



import java.awt.event.*;

import java.awt.Color;

public class calculadora extends JFrame implements ActionListener {
    private JButton botonesCalculadora[];
    private JLabel label1;
    private JLabel label2;
    private int ancho = 400;
    private int alto = 400;
    private int signoUtilizado;
    private String[] operacion;
    private int contador = 0;
    private int y1 = 250;
    private int x1 = 0;
    private int[] get_y1;

    //constructor
    public calculadora() {


        // configuracion Ventana
        this.setBounds(0, 0, this.ancho, this.alto);
        this.setVisible(true);
        this.setResizable(true);
        this.setLocationRelativeTo(null);

        // agregar botones
        configuracionBotones();

    }
    private void configuracionBotones(){
        // alineamiento y
        get_y1 = new int[3];
        // instancia de labels
        this.setLayout(null);
        this.label1 = new JLabel("");
        this.label1.setBorder(BorderFactory.createLineBorder(Color.black));
        label1.setBounds(0, 0, 400, 100);
        this.add(label1);
        this.label2 = new JLabel("Errores consola");
        label2.setBounds(0, 100, ancho, 50);
        // this.label2.setBorder(BorderFactory.createLineBorder(Color.red));
        this.label2.setBackground(new Color(98, 101, 112));
        this.label2.setOpaque(true); // para opacidad
        add(label2);

        // instancia de botones
        this.botonesCalculadora = new JButton[16];

        this.botonesCalculadora[0] = new JButton("1");
        this.botonesCalculadora[1] = new JButton("2");
        this.botonesCalculadora[2] = new JButton("3");
        this.botonesCalculadora[3] = new JButton("4");
        this.botonesCalculadora[4] = new JButton("5");
        this.botonesCalculadora[5] = new JButton("6");
        this.botonesCalculadora[6] = new JButton("7");
        this.botonesCalculadora[7] = new JButton("8");
        this.botonesCalculadora[8] = new JButton("9");
        this.botonesCalculadora[9] = new JButton("0");

        // signos calculadora
        this.botonesCalculadora[10] = new JButton("-");
        this.botonesCalculadora[11] = new JButton("+");
        this.botonesCalculadora[12] = new JButton("*");
        this.botonesCalculadora[13] = new JButton("/");
        this.botonesCalculadora[14] = new JButton("=");

        this.botonesCalculadora[15] = new JButton("DEL");

         for (int iterador_seccion = 0; iterador_seccion < botonesCalculadora.length; iterador_seccion++) {
            // seccion 1
            if (iterador_seccion <= 2) {
                get_y1[iterador_seccion] = y1;
                // posicion botones
                this.botonesCalculadora[iterador_seccion].setBounds(0, y1, ancho / 3, 50);

                // agregar botones y colorear

                this.botonesCalculadora[iterador_seccion].addActionListener(this);
                this.botonesCalculadora[iterador_seccion].setBackground(new Color(252, 243, 207));
                this.botonesCalculadora[iterador_seccion]
                        .setBorder(BorderFactory.createLineBorder(new Color(255, 160, 122)));
                // restar en y
                this.y1 -= 50;
                // agregar boton
                add(botonesCalculadora[iterador_seccion]);

            } else if (iterador_seccion >= 3 && iterador_seccion < 6) {
                // posicion
                this.botonesCalculadora[iterador_seccion].setBounds(x1 + 133, get_y1[contador], ancho / 3 +5, 50);

                // colorear botones y listener
                this.botonesCalculadora[iterador_seccion].addActionListener(this);
                this.botonesCalculadora[iterador_seccion].setBackground(new Color(252, 243, 207));
                this.botonesCalculadora[iterador_seccion]
                        .setBorder(BorderFactory.createLineBorder(new Color(255, 160, 122)));

                // agregar botones
                this.add(this.botonesCalculadora[iterador_seccion]);
                // contador
                contador++;

            } else if (iterador_seccion >= 6 && iterador_seccion < 9) {
                // contador
                contador -= 1;
                this.botonesCalculadora[iterador_seccion].setBounds(x1 + 266, get_y1[contador], ancho / 3, 50);

                // colorear botones y listener
                this.botonesCalculadora[iterador_seccion].addActionListener(this);
                this.botonesCalculadora[iterador_seccion].setBackground(new Color(252, 243, 207));
                this.botonesCalculadora[iterador_seccion]
                        .setBorder(BorderFactory.createLineBorder(new Color(255, 160, 122)));

                // agregar botones
                this.add(this.botonesCalculadora[iterador_seccion]);

            } else if (iterador_seccion >= 9 && iterador_seccion < 16) {
                this.botonesCalculadora[iterador_seccion].setBounds(x1, get_y1[0] + 50, ancho / 6, 65);

                // colorear botones y listener
                this.botonesCalculadora[iterador_seccion].addActionListener(this);
                this.botonesCalculadora[iterador_seccion].setBackground(new Color(252, 243, 207));
                this.botonesCalculadora[iterador_seccion]
                        .setBorder(BorderFactory.createLineBorder(new Color(255, 160, 122)));

                x1 += 60;
                // agregar botones
                this.add(this.botonesCalculadora[iterador_seccion]);
                // contador

                contador += 1;
                if (iterador_seccion == 15){
                    this.botonesCalculadora[iterador_seccion].setBounds(350,get_y1[0] + 50, ancho / 8 + 20, 65);
                }

            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
     try {
        for (int i = 0; i < botonesCalculadora.length; i++) {
            if (e.getSource().equals(botonesCalculadora[i])) {
                if (e.getSource().equals(botonesCalculadora[10]) || e.getSource().equals(botonesCalculadora[11])
                        || e.getSource().equals(botonesCalculadora[12])
                        || e.getSource().equals(botonesCalculadora[13])) {
                        label1.setText( label1.getText() + botonesCalculadora[i].getText());
                        this.signoUtilizado = i;
                        
                }

                // DEL
                else if (e.getSource().equals(botonesCalculadora[15])) {
                    label1.setText(label1.getText().replaceFirst(".$", ""));

                    // IGUAL
                }else if (e.getSource().equals(botonesCalculadora[14])) {
                    String signo = botonesCalculadora[signoUtilizado].getText();
                    this.operacion = label1.getText().split("\\" + signo);
                    
                    if (signo.equals("-")) {
                            label1.setText(String
                                    .valueOf((Double.parseDouble(operacion[0]) - Double.parseDouble(operacion[1]))));
                    }else if (signo.equals("+")) {
                        label1.setText(String
                                .valueOf((Double.parseDouble(operacion[0]) + Double.parseDouble(operacion[1]))));
                    
                    
                    }else if (signo.equals("*")) {
                        label1.setText(String
                                .valueOf((Double.parseDouble(operacion[0]) * Double.parseDouble(operacion[1]))));
                    
                    }else if (signo.equals("/")) {
                        label1.setText(String
                                .valueOf((Double.parseDouble(operacion[0]) / Double.parseDouble(operacion[1]))));
                    }

                }else {
                    label1.setText( label1.getText() + botonesCalculadora[i].getText());;

                }

            }
        }

    
         
     }catch (Exception o) {
        label2.setText("operacion invalida");
        
     }  

    }

    public void windowClosing(WindowEvent e) {
        dispose();
        System.exit(0);
    }

    public static void main(String[] args) {
        calculadora interfaz = new calculadora();

    }

}

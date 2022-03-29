package Visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class InterfaceGrafica extends JFrame {

    private static int default_frame_width = 800;
    private static int default_frame_height = 600;
    private JPanel blocoArma, blocoCrime, blocoCriminoso, blocoVitima;
    public int opTypeArma, opTypeCrime, opTypeCriminoso, opTypeVitima;

    public InterfaceGrafica() {
        super("Gerência da Delegacia");

        // configures the window
        configureWindow();

        // inserts the main window
        buildMainWindow();

        // turns the window visible for the user
        pack();
        setVisible(true);
    }

    private void configureWindow() {
        setSize(800, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5,1,20,10));
    }

    private void buildMainWindow() {
        // inits the panels
        blocoArma = new JPanel();
        blocoCrime = new JPanel();
        blocoCriminoso = new JPanel();
        blocoVitima = new JPanel();

        // builds each window
        buildBlocoArma();
        buildBlocoCrime();
        buildBlocoCriminoso();
        buildBlocoVitima();

        // prints the output
        JTextArea output = new JTextArea();
        add(output);
    }

    private void buildBlocoArma() {
        // inits the components
        JLabel labelNome = new JLabel("Nome da Arma:");
        JLabel labelClasse = new JLabel("Classe:");
        JTextField textNome = new JTextField();
        JTextField textClasse = new JTextField();
        JPanel opType = new JPanel();
        JButton btnSubmit = new JButton("Enviar");

        // configures the block
        blocoArma.setLayout(new GridLayout(3,2, 40,20));
        blocoArma.setPreferredSize(new Dimension(default_frame_width,(default_frame_height/4)));
        blocoArma.setMaximumSize(blocoArma.getPreferredSize());
        blocoArma.setMinimumSize(blocoArma.getPreferredSize());

        // configures the components
        labelNome.setHorizontalAlignment(SwingConstants.CENTER);
        labelClasse.setHorizontalAlignment(SwingConstants.CENTER);

        textNome.setBorder(BorderFactory.createCompoundBorder(textNome.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        textClasse.setBorder(BorderFactory.createCompoundBorder(textClasse.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        // defines the operation type
        JRadioButton rbBuscar = new JRadioButton("Buscar", false);
        JRadioButton rbInserir = new JRadioButton("Inserir", false);
        JRadioButton rbDeletar = new JRadioButton("Deletar", false);

        opType.add(rbBuscar);
        opType.add(rbInserir);
        opType.add(rbDeletar);

        // sets actions for the buttons
        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(rbBuscar.isSelected()) {
                    rbDeletar.setSelected(false);
                    rbInserir.setSelected(false);
                }

                if (rbDeletar.isSelected()) {
                    rbBuscar.setSelected(false);
                    rbInserir.setSelected(false);
                }

                if (rbInserir.isSelected()) {
                    rbBuscar.setSelected(false);
                    rbDeletar.setSelected(false);
                }
            }
        };

        rbInserir.addItemListener(itemListener);
        rbBuscar.addItemListener(itemListener);
        rbDeletar.addItemListener(itemListener);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botão pressionado.");
            }
        });

        // places the components
        blocoArma.add(labelNome);
        blocoArma.add(textNome);
        blocoArma.add(labelClasse);
        blocoArma.add(textClasse);
        blocoArma.add(opType);
        blocoArma.add(btnSubmit);

        add(blocoArma);
    }

    private void buildBlocoCrime() {
        // inits the components
        JLabel labelCriminoso = new JLabel("Criminoso:");
        JLabel labelVitima = new JLabel("Vitima:");
        JLabel labelArma = new JLabel("Arma:");
        JTextField textCriminoso = new JTextField();
        JTextField textVitima = new JTextField();
        JTextField textArma = new JTextField();
        JPanel opType = new JPanel();
        JButton btnSubmit = new JButton("Enviar");

        // configures the block
        blocoCrime.setLayout(new GridLayout(4,2,40,5));
        blocoCrime.setPreferredSize(new Dimension(default_frame_width,(default_frame_height/4)));
        blocoCrime.setMaximumSize(blocoCrime.getPreferredSize());
        blocoCrime.setMinimumSize(blocoCrime.getPreferredSize());

        // configures the components
        labelCriminoso.setHorizontalAlignment(SwingConstants.CENTER);
        labelVitima.setHorizontalAlignment(SwingConstants.CENTER);
        labelArma.setHorizontalAlignment(SwingConstants.CENTER);

        textCriminoso.setBorder(BorderFactory.createCompoundBorder(textCriminoso.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        textVitima.setBorder(BorderFactory.createCompoundBorder(textVitima.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        textArma.setBorder(BorderFactory.createCompoundBorder(textArma.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        // defines the operation type
        JRadioButton rbBuscar = new JRadioButton("Buscar", false);
        JRadioButton rbInserir = new JRadioButton("Inserir", false);
        JRadioButton rbDeletar = new JRadioButton("Deletar", false);

        opType.add(rbBuscar);
        opType.add(rbInserir);
        opType.add(rbDeletar);

        // sets actions for the buttons
        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(rbBuscar.isSelected()) {
                    rbDeletar.setSelected(false);
                    rbInserir.setSelected(false);
                }

                if (rbDeletar.isSelected()) {
                    rbBuscar.setSelected(false);
                    rbInserir.setSelected(false);
                }

                if (rbInserir.isSelected()) {
                    rbBuscar.setSelected(false);
                    rbDeletar.setSelected(false);
                }
            }
        };

        rbInserir.addItemListener(itemListener);
        rbBuscar.addItemListener(itemListener);
        rbDeletar.addItemListener(itemListener);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botão pressionado.");
            }
        });

        // places the components
        blocoCrime.add(labelCriminoso);
        blocoCrime.add(textCriminoso);
        blocoCrime.add(labelVitima);
        blocoCrime.add(textVitima);
        blocoCrime.add(labelArma);
        blocoCrime.add(textArma);
        blocoCrime.add(opType);
        blocoCrime.add(btnSubmit);

        add(blocoCrime);
    }

    private void buildBlocoCriminoso() {
        // inits the components
        JLabel labelNome = new JLabel("Nome do Criminoso:");
        JTextField textNome = new JTextField();
        JPanel opType = new JPanel();
        JButton btnSubmit = new JButton("Enviar");

        // configures the block
        blocoCriminoso.setLayout(new GridLayout(2,2,40,80));
        blocoCriminoso.setPreferredSize(new Dimension(default_frame_width,(default_frame_height/4)));
        blocoCriminoso.setMaximumSize(blocoCriminoso.getPreferredSize());
        blocoCriminoso.setMinimumSize(blocoCriminoso.getPreferredSize());

        // configures the components
        labelNome.setHorizontalAlignment(SwingConstants.CENTER);

        textNome.setBorder(BorderFactory.createCompoundBorder(textNome.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        // defines the operation type
        JRadioButton rbBuscar = new JRadioButton("Buscar", false);
        JRadioButton rbInserir = new JRadioButton("Inserir", false);
        JRadioButton rbDeletar = new JRadioButton("Deletar", false);

        opType.add(rbBuscar);
        opType.add(rbInserir);
        opType.add(rbDeletar);

        // sets actions for the buttons
        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(rbBuscar.isSelected()) {
                    rbDeletar.setSelected(false);
                    rbInserir.setSelected(false);
                }

                if (rbDeletar.isSelected()) {
                    rbBuscar.setSelected(false);
                    rbInserir.setSelected(false);
                }

                if (rbInserir.isSelected()) {
                    rbBuscar.setSelected(false);
                    rbDeletar.setSelected(false);
                }
            }
        };

        rbInserir.addItemListener(itemListener);
        rbBuscar.addItemListener(itemListener);
        rbDeletar.addItemListener(itemListener);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botão pressionado.");
            }
        });

        // places the components
        blocoCriminoso.add(labelNome);
        blocoCriminoso.add(textNome);
        blocoCriminoso.add(opType);
        blocoCriminoso.add(btnSubmit);

        add(blocoCriminoso);
    }

    private void buildBlocoVitima() {
        // inits the components
        JLabel labelNome = new JLabel("Nome da Vítima:");
        JTextField textNome = new JTextField();
        JPanel opType = new JPanel();
        JButton btnSubmit = new JButton("Enviar");

        // configures the block
        blocoVitima.setLayout(new GridLayout(2,2,40,80));
        blocoVitima.setPreferredSize(new Dimension(default_frame_width,(default_frame_height/4)));
        blocoVitima.setMaximumSize(blocoVitima.getPreferredSize());
        blocoVitima.setMinimumSize(blocoVitima.getPreferredSize());

        // configures the components
        labelNome.setHorizontalAlignment(SwingConstants.CENTER);

        textNome.setBorder(BorderFactory.createCompoundBorder(textNome.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        // defines the operation type
        JRadioButton rbBuscar = new JRadioButton("Buscar", false);
        JRadioButton rbInserir = new JRadioButton("Inserir", false);
        JRadioButton rbDeletar = new JRadioButton("Deletar", false);

        opType.add(rbBuscar);
        opType.add(rbInserir);
        opType.add(rbDeletar);

        // sets actions for the buttons
        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(rbBuscar.isSelected()) {
                    rbDeletar.setSelected(false);
                    rbInserir.setSelected(false);
                }

                if (rbDeletar.isSelected()) {
                    rbBuscar.setSelected(false);
                    rbInserir.setSelected(false);
                }

                if (rbInserir.isSelected()) {
                    rbBuscar.setSelected(false);
                    rbDeletar.setSelected(false);
                }
            }
        };

        rbInserir.addItemListener(itemListener);
        rbBuscar.addItemListener(itemListener);
        rbDeletar.addItemListener(itemListener);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botão pressionado.");
            }
        });

        // places the components
        blocoVitima.add(labelNome);
        blocoVitima.add(textNome);
        blocoVitima.add(opType);
        blocoVitima.add(btnSubmit);

        add(blocoVitima);
    }

}


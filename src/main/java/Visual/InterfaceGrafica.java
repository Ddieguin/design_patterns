package Visual;

import Entity.Arma;
import Factory.ArmaFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class InterfaceGrafica extends JFrame {

    private static int default_frame_width = 800;
    private static int default_frame_height = 600;

    public JPanel blocoArma, blocoCrime, blocoCriminoso, blocoVitima;

    public JTextArea output;

    public InterfaceGrafica() {
        super("Gerência da Delegacia");
        // configures the window
        configureWindow();

        // inserts the main window
        buildMainWindow();

        // defines all events for the buttons
        defineEvents();

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
        output = new JTextArea();
        add(output);
    }

    private void buildBlocoArma() {
        // inits the components
        JLabel labelId = new JLabel("Id:");
        JLabel labelNome = new JLabel("Nome da Arma:");
        JLabel labelClasse = new JLabel("Classe:");

        JTextField textId = new JTextField();
        JTextField textNome = new JTextField();
        JTextField textClasse = new JTextField();

        JPanel opType = new JPanel();
        JButton btnSubmit = new JButton("Enviar");

        // configures the block
        blocoArma.setLayout(new GridLayout(4,2,40,5));
        blocoArma.setPreferredSize(new Dimension(default_frame_width,(default_frame_height/4)));
        blocoArma.setMaximumSize(blocoArma.getPreferredSize());
        blocoArma.setMinimumSize(blocoArma.getPreferredSize());

        // configures the components
        labelId.setHorizontalAlignment(SwingConstants.CENTER);
        labelNome.setHorizontalAlignment(SwingConstants.CENTER);
        labelClasse.setHorizontalAlignment(SwingConstants.CENTER);

        textId.setBorder(BorderFactory.createCompoundBorder(textId.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
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
                System.out.println("");
            }
        });

        // places the components
        blocoArma.add(labelId);
        blocoArma.add(textId);
        blocoArma.add(labelNome);
        blocoArma.add(textNome);
        blocoArma.add(labelClasse);
        blocoArma.add(textClasse);
        blocoArma.add(opType);
        blocoArma.add(btnSubmit);

//        JLabel filler1 = new JLabel();
//        JLabel filler2 = new JLabel();
//        blocoArma.add(filler1);
//        blocoArma.add(filler2);

        add(blocoArma);
    }

    private void buildBlocoCrime() {
        // inits the components
        JLabel labelId = new JLabel("Id:");
        JLabel labelCriminoso = new JLabel("Criminoso:");
        JLabel labelVitima = new JLabel("Vitima:");
        JLabel labelArma = new JLabel("Arma:");

        JTextField textId = new JTextField();
        JTextField textCriminoso = new JTextField();
        JTextField textVitima = new JTextField();
        JTextField textArma = new JTextField();

        JPanel opType = new JPanel();
        JButton btnSubmit = new JButton("Enviar");

        // configures the block
        blocoCrime.setLayout(new GridLayout(5,2,40,5));
        blocoCrime.setPreferredSize(new Dimension(default_frame_width,(default_frame_height/4)));
        blocoCrime.setMaximumSize(blocoCrime.getPreferredSize());
        blocoCrime.setMinimumSize(blocoCrime.getPreferredSize());

        // configures the components
        labelId.setHorizontalAlignment(SwingConstants.CENTER);
        labelCriminoso.setHorizontalAlignment(SwingConstants.CENTER);
        labelVitima.setHorizontalAlignment(SwingConstants.CENTER);
        labelArma.setHorizontalAlignment(SwingConstants.CENTER);

        textId.setBorder(BorderFactory.createCompoundBorder(textId.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
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
                System.out.println("");
            }
        });

        // places the components
        blocoCrime.add(labelId);
        blocoCrime.add(textId);
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
        JLabel labelId = new JLabel("Id:");
        JLabel labelNome = new JLabel("Nome do Criminoso:");

        JTextField textId = new JTextField();
        JTextField textNome = new JTextField();

        JPanel opType = new JPanel();
        JButton btnSubmit = new JButton("Enviar");

        // configures the block
        blocoCriminoso.setLayout(new GridLayout(4,2,40,5));
        blocoCriminoso.setPreferredSize(new Dimension(default_frame_width,(default_frame_height/4)));
        blocoCriminoso.setMaximumSize(blocoCriminoso.getPreferredSize());
        blocoCriminoso.setMinimumSize(blocoCriminoso.getPreferredSize());

        // configures the components
        labelId.setHorizontalAlignment(SwingConstants.CENTER);
        labelNome.setHorizontalAlignment(SwingConstants.CENTER);

        textId.setBorder(BorderFactory.createCompoundBorder(textId.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
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
                System.out.println("");
            }
        });

        // places the components
//        JLabel filler1 = new JLabel();
//        JLabel filler2 = new JLabel();
//        blocoCriminoso.add(filler1);
//        blocoCriminoso.add(filler2);

        blocoCriminoso.add(labelId);
        blocoCriminoso.add(textId);
        blocoCriminoso.add(labelNome);
        blocoCriminoso.add(textNome);
        blocoCriminoso.add(opType);
        blocoCriminoso.add(btnSubmit);

        add(blocoCriminoso);
    }

    private void buildBlocoVitima() {
        // inits the components
        JLabel labelId = new JLabel("Id:");
        JLabel labelNome = new JLabel("Nome da Vítima:");

        JTextField textId = new JTextField();
        JTextField textNome = new JTextField();

        JPanel opType = new JPanel();
        JButton btnSubmit = new JButton("Enviar");

        // configures the block
        blocoVitima.setLayout(new GridLayout(4,2,40,5));
        blocoVitima.setPreferredSize(new Dimension(default_frame_width,(default_frame_height/4)));
        blocoVitima.setMaximumSize(blocoVitima.getPreferredSize());
        blocoVitima.setMinimumSize(blocoVitima.getPreferredSize());

        // configures the components
        labelId.setHorizontalAlignment(SwingConstants.CENTER);
        labelNome.setHorizontalAlignment(SwingConstants.CENTER);

        textId.setBorder(BorderFactory.createCompoundBorder(textId.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
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
                System.out.println("");
            }
        });

        // places the components
        blocoVitima.add(labelId);
        blocoVitima.add(textId);
        blocoVitima.add(labelNome);
        blocoVitima.add(textNome);
        blocoVitima.add(opType);
        blocoVitima.add(btnSubmit);

        JLabel filler1 = new JLabel();
        JLabel filler2 = new JLabel();
        blocoVitima.add(filler1);
        blocoVitima.add(filler2);

        add(blocoVitima);
    }

    private void defineEvents() {
        // defines the arma block operation action
        JButton btn = (JButton) blocoArma.getComponent(7);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component[] componentes = blocoArma.getComponents();
                String opType = null;

                // defining the operations
                Component[] btn_radio = ((JPanel) componentes[6]).getComponents();

                for (Component componente: btn_radio) {
                    JRadioButton aux = (JRadioButton) componente;
                    if(aux.isSelected()) opType = new String(aux.getText());
                }

                if(opType != null) {
                    debug("operation: " + opType);
                    if (opType.equals("Inserir"))
                        ArmaFactory.build().save(new Arma.Builder().setNome(((JTextField) componentes[3]).getText()).setClasse(((JTextField) componentes[5]).getText()).build());
                    else if (opType.equals("Buscar"))
                        ArmaFactory.build().index(Integer.parseInt(((JTextField) componentes[1]).getText()));
                    else
                        ArmaFactory.build().delete(Integer.parseInt(((JTextField) componentes[1]).getText()));
                } else {
                    debug("No operation selected: Listing db.");
                    for(Arma arma:ArmaFactory.build().find()) {
                        debug(arma.toString());
                    };
                }
            }
        });
    }

    public void debug(String a){
        System.out.println(a);
        output.setText(output.getText()+"\n"+a+"\n");
    }
}


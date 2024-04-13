import PaqGI1.Dispenser;
import PaqGI1.Pharmacy;
import PaqGI1.Medicine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazUni  extends JFrame {
    private JRadioButton RB1;
    private JRadioButton RB2;
    private JRadioButton RB3;
    private JRadioButton RB4;
    private JTextField TXT1;
    private JTextArea TA1;
    private JButton B1;
    private JButton B2;
    private JButton B3;
    private JButton B4;
    private JTextField TF1;
    private JTextField TF2;
    private JTextField TF3;
    private JLabel JL1;
    private JLabel JL2;
    private JLabel JL3;
    private JPanel A;
    private ButtonGroup BGROUP1;

    private Pharmacy ph;


    public InterfazUni(Pharmacy ph) {
        this.ph = ph;
        Dispenser d = new Dispenser(5, 20);
        setTitle("Welcome");
        setContentPane(A);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


//2 cuadrado
        RB1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TA1.setText("");
                for (int i = 0; i <= 4; i++) {
                    for (int j = 19; j >= 0; --j) {
                        Medicine medicine = ph.dispensers[0].dispenser[i][j];
                        if (medicine != null) {
                            String word1 = medicine.getName();
                            TA1.append(word1 + "  ");

                        } else {
                            TA1.append("Vacío"+"  ");
                        }
                    }
                    TA1.append("\n");
                }
            }
        });
        RB2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TA1.setText("");
                for (int i = 0; i <= 4; i++) {
                    for (int j = 19; j >= 0; --j) {
                        Medicine medicine = ph.dispensers[1].dispenser[i][j];
                        if (medicine != null) {
                            String word1 = medicine.getName();
                            TA1.append(word1 + "  ");

                        } else {
                            TA1.append("Vacío"+"  ");
                        }
                    }
                    TA1.append("\n");
                }
            }
        });

        RB3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TA1.setText("");
                for (int i = 0; i <= 4; i++) {
                    for (int j = 19; j >= 0; --j) {
                        Medicine medicine = ph.dispensers[2].dispenser[i][j];
                        if (medicine != null) {

                            String word1 =medicine.getName();
                            TA1.append(word1 + "  ");

                        } else {
                            TA1.append("Vacío"+"  ");
                        }
                    }
                    TA1.append("\n");
                }
            }
        });


        RB4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TA1.setText("");
                for (int i = 0; i <=4; i++) {
                    for (int j = 19; j >= 0; --j) {
                        Medicine medicine = ph.dispensers[3].dispenser[i][j];
                        if (medicine != null) {
                            String word1 = medicine.getName();
                            TA1.append(word1 + "  ");
                        }else{
                            TA1.append("Vacío"+"  ");
                        }
                    }
                    TA1.append("\n");
                }
            }

    });


/*
        public void actionPerformed(ActionEvent e) {
            TA1.setText("");
            for (int i = 0; i <=4; i++) {
                for (int j = 4; j >= 0; --j) {
                    Medicine medicine = ph.dispensers[3].dispenser[i][j];
                    if (medicine != null) {
                        String word1 = InterfazUni.this.ph.dispensers[0].dispenser[i][j].getName();

                        TA1.append(word1 + "           " + "\n");


                    }else{
                        TA1.append("Vacío\t");
                    }

                }
                TA1.append("\n");
            }
        }

 */
        //3cuadrado
        B1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nameMedicine = TF1.getText();
                int amount = Integer.parseInt(TF3.getText());
                String nameCompany = TF2.getText();
               // int medRest=

                boolean found = false;
                int column = -1;
                if (nameMedicine.equals("paracetamol")) {
                    column = 0;
                } else if (nameMedicine.equals("ibuprofeno")) {
                    column = 1;
                } else if (nameMedicine.equals("omeprazol")) {
                    column = 2;
                } else if (nameMedicine.equals("Toseína")) {
                    column = 3;
                } else if (nameMedicine.equals("Apiretal")) {
                    column = 4;
                }else if(nameMedicine.equals("diazepam")){
                    column=5;
                }else if(nameMedicine.equals("tylenol")){
                    column=6;
                }else if(nameMedicine.equals("amoxicilina")) {
                    column = 7;
                }else if(nameMedicine.equals("prozac")) {
                    column = 8;
                }else if(nameMedicine.equals("xanax")) {
                    column = 9;
                }else if(nameMedicine.equals("viagra")) {
                    column = 10;
                }else if(nameMedicine.equals("lipitor")) {
                    column = 11;
                }else if(nameMedicine.equals("zoloft")) {
                    column = 12;
                }else if(nameMedicine.equals("advil")) {
                    column = 13;
                }else if(nameMedicine.equals("zantac")) {
                    column = 14;
                }else if(nameMedicine.equals("nexium")) {
                    column = 15;
                }else if(nameMedicine.equals("prednisona")){
                    column=16;
                }else if(nameMedicine.equals("ventolin")) {
                    column = 17;
                }else if(nameMedicine.equals("ritalin")) {
                    column = 18;
                }else if(nameMedicine.equals("benadryl")) {
                    column = 19;
                }

                if (column != -1) {

                    // Iterar a través de los dispensadores
                    for (int i = 0; i < ph.dispensers.length; i++) {
                        // Verificar si hay suficientes medicamentos disponibles

                        if (amount > 0) {
                            // Suficientes medicamentos disponibles en este dispensador
                            if (amount <=5) {
                                // Quitar solo la cantidad requerida de medicamentos
                                for (int j = 0; j < ph.dispensers[i].dispenser.length && amount > 0; j++) {
                                    if (ph.dispensers[i].dispenser[j][column] != null) {
                                        ph.dispensers[i].dispenser[j][column] = null;
                                        amount--;
                                    }
                                }
                                found = true;
                                break;
                            } else {
                                amount=amount-5;
                                // Quitar todos los medicamentos disponibles y seguir buscando en el siguiente dispensador
                                for (int j = 0; j < ph.dispensers[i].dispenser.length && amount>0; j++) {
                                    if (ph.dispensers[i].dispenser[j][column] != null) {
                                        ph.dispensers[i].dispenser[j][column] = null;
                                        amount--;
                                        if (amount == 0) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        else TA1.setText("try again");
                    }
                }

                if (found) {
                    TA1.setText("Medicamento dispensado: " + nameMedicine);
                } else {
                    TA1.setText("El medicamento no está disponible en los dispensadores.");
                }
            }
        });

        B4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {




                        TA1.setText( "take one of them every 8 hours");




            }
        });

        // Al inicio del programa, guarda el texto original de los botones de los dispensadores
        String[][][] originalTexts = {
                { // Dispensador 1
                        {"epiretal", "paracetamol", "ibuprofeno", "omeprazol", "toseina"},
                        {"epiretal", "paracetamol", "ibuprofeno", "omeprazol", "toseina"},
                        {"epiretal", "paracetamol", "ibuprofeno", "omeprazol", "toseina"},
                        {"epiretal", "paracetamol", "ibuprofeno", "omeprazol", "toseina"},
                        {"epiretal", "paracetamol", "ibuprofeno", "omeprazol", "toseina"}
                },
                { // Dispensador 2
                        {"epiretal", "paracetamol", "ibuprofeno", "omeprazol", "toseina"},
                        {"epiretal", "paracetamol", "ibuprofeno", "omeprazol", "toseina"},
                        {"epiretal", "paracetamol", "ibuprofeno", "omeprazol", "toseina"},
                        {"epiretal", "paracetamol", "ibuprofeno", "omeprazol", "toseina"},
                        {"epiretal", "paracetamol", "ibuprofeno", "omeprazol", "toseina"}
                },
                { // Dispensador 3
                        {"epiretal", "paracetamol", "ibuprofeno", "omeprazol", "toseina"},
                        {"epiretal", "paracetamol", "ibuprofeno", "omeprazol", "toseina"},
                        {"epiretal", "paracetamol", "ibuprofeno", "omeprazol", "toseina"},
                        {"epiretal", "paracetamol", "ibuprofeno", "omeprazol", "toseina"},
                        {"epiretal", "paracetamol", "ibuprofeno", "omeprazol", "toseina"}
                },
                { // Dispensador 4
                        {"epiretal", "paracetamol", "ibuprofeno", "omeprazol", "toseina"},
                        {"epiretal", "paracetamol", "ibuprofeno", "omeprazol", "toseina"},
                        {"epiretal", "paracetamol", "ibuprofeno", "omeprazol", "toseina"},
                        {"epiretal", "paracetamol", "ibuprofeno", "omeprazol", "toseina"},
                        {"epiretal", "paracetamol", "ibuprofeno", "omeprazol", "toseina"}
                }
        };

        B3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String manufactures = TF2.getText();
                String name = TF1.getText();
                int amount = Integer.parseInt(TF3.getText());

                // Rellenar un medicamento específico en los dispensadores
                InterfazUni.this.ph.refillOneMedicine(name, manufactures, amount);

                // Actualizar el estado de los botones de los dispensadores
                RB1.setEnabled(true);
                RB2.setEnabled(true);
                RB3.setEnabled(true);
                RB4.setEnabled(true);

                // Restaurar el texto original de los botones de los dispensadores
                // Asignar los textos originales a los botones de los dispensadores

                for (int d = 0; d < 4; d++) {
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            // Obtener el texto del medicamento en la posición (i, j) del dispensador d
                            String originalTexts = ph.dispensers[d].dispenser[i][j].getName();
                            // Asignar el texto del medicamento al botón correspondiente
                            switch (j) {
                                case 0:
                                    RB1.setText(originalTexts);
                                    break;
                                case 1:
                                    RB2.setText(originalTexts);
                                    break;
                                case 2:
                                    RB3.setText(originalTexts);
                                    break;
                                case 3:
                                    RB4.setText(originalTexts);
                                    break;
                                // Añadir más casos si hay más botones de dispensadores
                                default:
                                    break;
                            }
                        }
                    }
                }

                TA1.setText("Refill completado para " + amount + " unidades de " + name + " de " + manufactures);

            }
        });

        B2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String manufactures = TF2.getText();
                int[] position = InterfazUni.this.ph.findPositions(manufactures);
                if (position[0] != -1) {
                    int k = position [0];
                    int j = position [1];
                    int m = position [2];
                    Medicine foundMedicine = InterfazUni.this.ph.dispensers[k].dispenser[j][m];
                    if (foundMedicine  != null){
                        TA1.setText("Name:"+foundMedicine.getName()+"\nManufacturer:"+ foundMedicine.getManufactures()+"\nUnits:"+foundMedicine.getUnits());

                    }else {
                        TA1.setText ("Medicine not found or spent");
                    }
                }else{
                    TA1.setText("Medicine not found or spent");
                }
            }
        });


    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            Dispenser[] dispensers = new Dispenser[4];

            for(int i=0;i<3;i++){
                dispensers[i]= new Dispenser();
            }


            Pharmacy ph = new Pharmacy(dispensers);

            new InterfazUni(ph).setVisible(true);

            ph.dispensers[0].dispenser[0][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
            ph.dispensers[0].dispenser[1][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
            ph.dispensers[0].dispenser[2][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
            ph.dispensers[0].dispenser[3][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
            ph.dispensers[0].dispenser[4][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
            ph.dispensers[0].dispenser[0][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
            ph.dispensers[0].dispenser[1][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
            ph.dispensers[0].dispenser[3][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
            ph.dispensers[0].dispenser[4][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
            ph.dispensers[0].dispenser[0][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
            ph.dispensers[0].dispenser[1][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
            ph.dispensers[0].dispenser[2][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
            ph.dispensers[0].dispenser[3][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
            ph.dispensers[0].dispenser[4][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
            ph.dispensers[0].dispenser[0][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
            ph.dispensers[0].dispenser[2][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
            ph.dispensers[0].dispenser[3][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
            ph.dispensers[0].dispenser[4][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
            ph.dispensers[0].dispenser[0][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
            ph.dispensers[0].dispenser[1][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
            ph.dispensers[0].dispenser[2][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
            ph.dispensers[0].dispenser[3][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
            ph.dispensers[0].dispenser[4][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);

            ph.dispensers[0].dispenser[0][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[0][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[1][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[3][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[4][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);



            ph.dispensers[1].dispenser[0][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
            ph.dispensers[1].dispenser[1][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
            ph.dispensers[1].dispenser[2][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
            ph.dispensers[1].dispenser[3][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
            ph.dispensers[1].dispenser[4][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
            ph.dispensers[1].dispenser[0][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
            ph.dispensers[1].dispenser[1][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
            ph.dispensers[1].dispenser[3][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
            ph.dispensers[1].dispenser[4][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
            ph.dispensers[1].dispenser[0][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
            ph.dispensers[1].dispenser[1][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
            ph.dispensers[1].dispenser[2][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
            ph.dispensers[1].dispenser[3][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
            ph.dispensers[1].dispenser[4][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
            ph.dispensers[1].dispenser[0][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
            ph.dispensers[1].dispenser[2][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
            ph.dispensers[1].dispenser[3][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
            ph.dispensers[1].dispenser[4][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
            ph.dispensers[1].dispenser[0][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
            ph.dispensers[1].dispenser[1][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
            ph.dispensers[1].dispenser[2][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
            ph.dispensers[1].dispenser[3][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
            ph.dispensers[1].dispenser[4][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[0][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[1][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[2][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[3][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[1].dispenser[4][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);


            ph.dispensers[2].dispenser[0][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
            ph.dispensers[2].dispenser[1][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
            ph.dispensers[2].dispenser[2][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
            ph.dispensers[2].dispenser[3][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
            ph.dispensers[2].dispenser[4][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
            ph.dispensers[2].dispenser[0][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
            ph.dispensers[2].dispenser[1][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
            ph.dispensers[2].dispenser[3][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
            ph.dispensers[2].dispenser[4][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
            ph.dispensers[2].dispenser[0][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
            ph.dispensers[2].dispenser[1][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
            ph.dispensers[2].dispenser[2][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
            ph.dispensers[2].dispenser[3][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
            ph.dispensers[2].dispenser[4][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
            ph.dispensers[2].dispenser[0][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
            ph.dispensers[2].dispenser[2][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
            ph.dispensers[2].dispenser[3][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
            ph.dispensers[2].dispenser[4][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
            ph.dispensers[2].dispenser[0][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
            ph.dispensers[2].dispenser[1][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
            ph.dispensers[2].dispenser[2][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
            ph.dispensers[2].dispenser[3][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
            ph.dispensers[2].dispenser[4][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[4][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[0][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[1][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[2][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[2].dispenser[3][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);


            ph.dispensers[3].dispenser[0][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
            ph.dispensers[3].dispenser[1][0]= new Medicine(2,"paracetamol","per 6 hours","NORMON",4);
            ph.dispensers[3].dispenser[2][0]= new Medicine(3,"paracetamol","before antibiotics","CINFA",4);
            ph.dispensers[3].dispenser[3][0]= new Medicine(4,"paracetamol","per 8 hours","NORMON",2);
            ph.dispensers[3].dispenser[4][0]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
            ph.dispensers[3].dispenser[0][1]= new Medicine(6,"ibuprofeno","before antibiotics","EFG",3);
            ph.dispensers[3].dispenser[1][1]= new Medicine(7,"ibuprofeno","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][1]= new Medicine(8,"ibuprofeno","per 8 hours","EFG",1);
            ph.dispensers[3].dispenser[3][1]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);
            ph.dispensers[3].dispenser[4][1]= new Medicine(10,"ibuprofeno","per 8 hours","CINFA",3);
            ph.dispensers[3].dispenser[0][2]= new Medicine(11,"omeprazol","per 8 hours","NORMON",4);
            ph.dispensers[3].dispenser[1][2]= new Medicine(12,"omeprazol","per 6 hours","CINFA",4);
            ph.dispensers[3].dispenser[2][2]= new Medicine(13,"omeprazol","per 8 hours","NORMON",2);
            ph.dispensers[3].dispenser[3][2]= new Medicine(14,"omeprazol","per 8 hours","EFG",1);
            ph.dispensers[3].dispenser[4][2]= new Medicine(15,"omeprazol","per 8 hours","EFG",3);
            ph.dispensers[3].dispenser[0][3]= new Medicine(16,"Toseína","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][3]= new Medicine(17,"Toseína","per 6 hours","EFG",1);
            ph.dispensers[3].dispenser[2][3]= new Medicine(18,"Toseína","per 6 hours","NORMON",4);
            ph.dispensers[3].dispenser[3][3]= new Medicine(19,"Toseína","per 6 hours","CINFA",3);
            ph.dispensers[3].dispenser[4][3]= new Medicine(20,"Toseína","before antibiotics","NORMON",4);
            ph.dispensers[3].dispenser[0][4]= new Medicine(21,"Apiretal","before antibiotics","CINFA",4);
            ph.dispensers[3].dispenser[1][4]= new Medicine(22,"Apiretal","per 8 hours","NORMON",2);
            ph.dispensers[3].dispenser[2][4]= new Medicine(23,"Apiretal","per 8 hours","EFG",1);
            ph.dispensers[3].dispenser[3][4]= new Medicine(24,"Apiretal","per 8 hours","EFG",3);
            ph.dispensers[3].dispenser[4][4]= new Medicine(25,"Apiretal","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][5]= new Medicine(25,"diazepam","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][6]= new Medicine(25,"tylenol","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][7]= new Medicine(25,"amoxicilina","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][8]= new Medicine(25,"prozac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][9]= new Medicine(25,"xanax","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][10]= new Medicine(25,"viagra","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][11]= new Medicine(25,"lipitor","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][12]= new Medicine(25,"zoloft","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][13]= new Medicine(25,"advil","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][14]= new Medicine(25,"zantac","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][15]= new Medicine(25,"nexium","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][16]= new Medicine(25,"prednisona","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][17]= new Medicine(25,"ventolin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][18]= new Medicine(25,"ritalin","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[0][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[1][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[2][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[3][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);
            ph.dispensers[3].dispenser[4][19]= new Medicine(25,"benadryl","per 8 hours","CINFA",5);



















        });

    }
}

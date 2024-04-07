import PaqGI1.Dispenser;
import PaqGI1.Pharmacy;
import PaqGI1.Medicine;

import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.FocusAdapter;

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


    public InterfazUni() {
        this.ph = ph;
        Dispenser d = new Dispenser(5, 5);
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
                for (int i = 0; i < 3; i++) {
                    for (int j = 2; j >= 0; --j) {
                        String word1 = ph.dispensers[0].dispenser[i][j].getName();
                        String word2 = ph.dispensers[0].dispenser[i][j].getManufactures();
                        TA1.append("Name Medicine: "+word1+"           "+"Manufacturer: " +word2 + "\n");


                    }
                }
            }
        });
        RB2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TA1.setText("");
                for (int i = 0; i < 3; i++) {
                    for (int j = 2; j >= 0; --j) {
                        String word1= ph.dispensers[1].dispenser[i][j].getName();
                        String word2 = ph.dispensers[1].dispenser[i][j].getManufactures();
                        TA1.append("Name Medicine: "+word1 +"           "+"Manufacturer: " +word2 + "\n");


                    }
                }
            }
        });
        RB3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TA1.setText("");
                for (int i = 0; i < 3; i++) {
                    for (int j = 2; j >= 0; --j) {
                        String word1 = ph.dispensers[2].dispenser[i][j].getName();
                        String word2 = ph.dispensers[2].dispenser[i][j].getManufactures();
                        TA1.append("Name Medicine: "+word1 +"           "+"Manufacturer: " +word2 + "\n");


                    }
                }
            }
        });


        RB4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TA1.setText("");
                for (int i = 0; i < 3; i++) {
                    for (int j = 2; j >= 0; --j) {
                        String word1 = ph.dispensers[3].dispenser[i][j].getName();
                        String word2 = ph.dispensers[3].dispenser[i][j].getManufactures();
                        TA1.append("Name Medicine: "+word1 +"           "+"Manufacturer: " +word2 + "\n");


                    }
                }
            }
        });
        //3cuadrado

        B1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nameMedicine=TF1.getText();
                int amount=Integer.parseInt(TF3.getText());
                String nameCompany=TF2.getText();



                if (ph.orderMedicicine(nameMedicine, amount) == 0) {

                    TA1.setText("order corrected");

                } else {
                    TA1.setText("that quantity is not available,auto refill.Try again");
                    ph.refill(nameMedicine, nameCompany, 10);
                }

            }
        });

        B2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                    if(B2.isSelected()){

                        TA1.setText( "take one of them every 8 hours");

                    }


            }
        });

        B3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String manufactures=TF2.getText();
                String name=TF1.getText();
                int amount=Integer.parseInt(TF3.getText());

                ph.refillOneMedicine(name,amount);

                TA1.setText("REFILL CORRECTED");

            }
        });

        B4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String manufactures = TXT1.getText();
                int[] position = ph.findPositions(manufactures);
                if (position[0] != -1) {
                    int k = position [0];
                    int j = position [1];
                    int m = position [2];
                    Medicine foundMedicine = ph.dispensers[k].dispenser[j][m];
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

//primer cuadrado

     /*   TF1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s=TXT1.getText();

            }
        });

      */
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            Dispenser[] dispensers = new Dispenser[4];

            for(int i=0;i<3;i++){
                dispensers[i]= new Dispenser();
            }


            Pharmacy ph = new Pharmacy(dispensers);

            new InterfazUni().setVisible(true);

            ph.dispensers[0].dispenser[0][0]= new Medicine(1,"paracetamol","per 8 hours","CINFA",3);
            ph.dispensers[0].dispenser[0][1]= new Medicine(2,"ibuprofeno","per 6 hours","NORMON",4);
            ph.dispensers[0].dispenser[0][2]= new Medicine(3,"omeprazol","before antibiotics","CINFA",4);
            ph.dispensers[0].dispenser[1][0]= new Medicine(4,"Toseína","per 8 hours","NORMON",2);
            ph.dispensers[0].dispenser[1][1]= new Medicine(5,"paracetamol","per 8 hours","EFG",1);
            ph.dispensers[0].dispenser[1][2]= new Medicine(6,"omeprazol","before antibiotics","EFG",3);
            ph.dispensers[0].dispenser[2][0]= new Medicine(7,"Toseína","per 8 hours","CINFA",5);
            ph.dispensers[0].dispenser[2][1]= new Medicine(8,"paracetamol","per 8 hours","EFG",1);
            ph.dispensers[0].dispenser[2][2]= new Medicine(9,"ibuprofeno","per 6 hours","NORMON",4);






        });

    }
}

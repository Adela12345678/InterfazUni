package PaqGI1;

import javax.swing.*;
import java.util.List;

public class Pharmacy extends JFrame {
    public Dispenser[] dispensers;

    public Pharmacy(Dispenser[] dispensers) {
        this.dispensers = new Dispenser[4];
        for (int i = 0; i < this.dispensers.length; i++) {
            this.dispensers[i] = new Dispenser();// Inicializa cada Dispenser
        }
    }
    public int[] findPositions(String name) {

        int[] isThere = {-1, -1, -1};


        for (int i = 0; i < 4; i++) {
            int[] positions = new int[]{dispensers[i].findMedicine(name)};

            if (positions[0] != -1) {// found medicine

                isThere[0] = i;
                isThere[1] = positions[0];
                isThere[2] = positions[1];

                return isThere;
            }
        }

        return isThere;

    }

    public Medicine orderMedicine(String name, String manufactures, int quantity) {
        for (Dispenser dispenser : dispensers) {
            for (int i = 0; i < dispenser.getRows() * dispenser.getColumns(); i++) {
                Medicine medicine = dispenser.extractMedicine(name);
                if (medicine.getId() != -1 && medicine.getUnits() > 0) {
                    if (medicine.getUnits() >= quantity) {
                        medicine.setUnits(medicine.getUnits() - quantity);
                        return medicine;
                    } else {
                        int extracted = medicine.getUnits();
                        quantity -= extracted;
                        medicine.setUnits(0);
                    }
                }
            }
        }

        // Refill the stock
        for (Dispenser dispenser : dispensers) {
            dispenser.refill();
        }

        return orderMedicine(name, manufactures, quantity);
    }

    public void refillOneMedicine(String nameMedicine, int amount) {
    }

    public int orderMedicicine(String nameMedicine, int amount) {
        return 0;
    }

    public void refill(String nameMedicine, String nameCompany, int i) {
    }
}


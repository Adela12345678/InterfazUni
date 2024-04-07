package PaqGI1;

import java.util.ArrayList;
import java.util.List;

public class Dispenser {
    public Medicine[][] dispenser;
    private int rows = 5;
    private int columns = 5;
    private Medicine[][] matrix;

    public Dispenser() {
        this.dispenser = new Medicine[rows][columns];

    }


    public Dispenser(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new Medicine[rows][columns];
    }


    //getters
    public int getRows() {

        return rows;
    }

    public int getColumns() {

        return columns;
    }

    public String toString() {
        return "Dispenser{" +
                "rows='" + rows + '\n' +
                ", columns='" + columns + '\n' +
                '}';
    }

    public void addMedicine(Medicine medicine, int rows, int columns) {

        this.matrix[rows][columns] = medicine;
    }

    private int medicineInColumns(int columns) {
        // Initialize a counter for valid medicine
        int medicineCounter = 0;

        // Iterate through the column from bottom to top
        for (int i = matrix.length - 1; i >= 0; i--) {
            Medicine medicine = matrix[i][columns];

            // Check if medicine is valid
            if (medicine.getId() != -1) {
                medicineCounter++;
            } else {
                // If medicine is not valid, stop iterating
                break;
            }
        }

        // Return the number of valid medicine in the column
        return medicineCounter;
    }

    private int nMedicine(int columns) {
        // Initialize a counter for medicine
        int medicineCounter = 0;

        // Iterate through columns
        for (int col = 0; col < columns; col++) {
            // Check how many medicine there are in the current column
            medicineCounter += medicineInColumns(col);
        }

        // Return the total number of medicine
        return medicineCounter;
    }

    //Make a method called findMedicine that, given a medicine name, returns the position that
//the medicine occupies in the name vector. If it is not there, it will return -1.
    public int findMedicine(String name) {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if (this.matrix[i][j] != null && this.matrix[i][j].getName().equals(name)) {
                    return i * this.columns + j;
                }
            }
        }
        return -1;

    }

    //Make a method that, given a medicine name passed as an argument, searches for it in the
    //dispenser, extracts it from the dispenser and returns it using the return instruction.
    public Medicine extractMedicine(String name) {
        int position = findMedicine(name);
        if (position == -1) {
            return new Medicine(-1, "", "", "", 0);
        }

        int row = position / columns;
        int column = position % columns;
        Medicine medicine = matrix[row][column];
        matrix[row][column] = null;

        return medicine;
    }

    //refill method
    public void refill() {
        int amount = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String name = dispenser[i][j].getName();
                if (name.equals(name)) {


                    dispenser[i][j].setUnits(dispenser[i][j].getUnits() + amount);

                }

            }
        }

    }

    public void refillMedicine(int amount, int x, int y) {
        dispenser[x][y].setUnits(dispenser[x][y].getUnits() + amount);

    }

    public void refillSpecificMedicine(String nameMedicine, String companyName, int amount) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Medicine medicine = matrix[i][j];
                if (medicine != null && medicine.getName().equals(nameMedicine) && medicine.getManufactures().equals(companyName)) {
                    medicine.setUnits(medicine.getUnits() + amount);
                }
            }
        }
    }

    public int availableQuantities(String nameMedicine) {
        int totalQuantitites = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Medicine medicine = matrix[i][j];
                if (medicine != null && medicine.getName().equals(nameMedicine)) {
                    totalQuantitites += medicine.getUnits();
                }


            }


        }
        return totalQuantitites;
    }



}
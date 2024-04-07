package PaqGI1;

import javax.swing.*;

public class Medicine {

        //attributes

        private int id;
        private String name;
        private String indications;
        private String manufactures;
        private int units;
        private int availableQuantities;
        //initialized
        public Medicine(int id, String name, String indications, String manufactures, int units) {
            this.id=id;
            this.name = name;
            this.indications = indications;
            this.manufactures = manufactures;
            this.units = units;

        }
        //2. Include setter, getters and constructors for each class
        public int getId(){
            return id;
        }
        public String getName() {
            return name;
        }

        public String getIndications(){
            return indications;
        }

        public String getManufactures(){
            return manufactures;
        }

        public int getUnits(){
            return units;
        }
        public void setUnits(int units){
            this.units = units;
        }


    public String toString() {
        return "Medicine{" +
                "name='" + name + '\n' +
                ", id='" + id + '\n' +
                ", indications='" + indications + '\n' +
                ", manufactures='" + manufactures + '\n' +
                ", units=" + units + '\n'+
          '}';
}
    }


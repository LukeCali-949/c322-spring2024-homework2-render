package iu.edu.lukemeng.c322spring2024homework2.model;

//Guitar Class
public class Guitar {

    String serialNumber;
    double price;
    String builder;
    String model;
    String type;
    String backWood;
    String topWood;

    public Guitar(String serialNumber, double price, String builder, String model, String type, String backWood, String topWood) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }


    public String getSerialNumber() {
        return serialNumber;
    }

    public String getBackWood() {
        return backWood;
    }

    public String getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public String getBackwood() {
        return backWood;
    }

    public String getTopWood() {
        return topWood;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "serialNumber='" + serialNumber + '\'' +
                ", price=" + price +
                ", builder='" + builder + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", backWood='" + backWood + '\'' +
                ", topWood='" + topWood + '\'' +
                '}';
    }

}

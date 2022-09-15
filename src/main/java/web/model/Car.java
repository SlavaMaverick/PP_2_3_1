package web.model;

public class Car {
    private String model;
    private String colour;
    private int prodYear;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getProdYear() {
        return prodYear;
    }

    public void setProdYear(int prodYear) {
        this.prodYear = prodYear;
    }

    public Car(String model, String colour, int prodYear) {
        this.model = model;
        this.colour = colour;
        this.prodYear = prodYear;
    }

    @Override
    public String toString() {
        return "Car {" +
                "model ='" + model + '\'' +
                ", colour ='" + colour + '\'' +
                ", prodYear =" + prodYear +
                '}';
    }
}

package ca.nait.dmit.domain;

public class BMI
{
    private double weight;
    private double height;

    // -Implementing Properties-
    // Fully implemented property

    // Use CTRL + INS to generate a getter and setter for both weight and height fields
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Generate constructors
    // "Select None"
    public BMI() {
        weight = 100;
        height = 60;
    }

    // Select both fields (height and weight)
    public BMI(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    // Defining method
    public double bmi()
    {
        return 0;
    }

    public String bmiCategory()
    {
        return "";
    }
}

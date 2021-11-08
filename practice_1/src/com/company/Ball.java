package com.company;

public class Ball {
    private String color;
    private String classification;

    public void Bounce() {
        System.out.println("The ball bounces across the field");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "color='" + color + '\'' +
                ", classification='" + classification + '\'' +
                '}';
    }

    public Ball(){}

    public Ball(String color, String classification) {
        this.color = color;
        this.classification = classification;
    }


}

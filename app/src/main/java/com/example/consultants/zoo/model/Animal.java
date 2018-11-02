package com.example.consultants.zoo.model;

import java.io.Serializable;

public class Animal implements Serializable {

    private String category;
    private String typeOfAnimal;
    private String weight;
    private String sound;
    private String detail;
    private String name;
    private byte[] image;

    public Animal(String category, String typeOfAnimal, String weight, String sound, String detail, String name, byte[] image) {
        this.category = category;
        this.typeOfAnimal = typeOfAnimal;
        this.weight = weight;
        this.sound = sound;
        this.image = image;
        this.detail = detail;
        this.name = name;
    }

    public Animal(String weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    public String getTypeOfAnimal() {
        return typeOfAnimal;
    }

    public void setTypeOfAnimal(String typeOfAnimal) {
        this.typeOfAnimal = typeOfAnimal;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "category='" + category + '\'' +
                ", typeOfAnimal='" + typeOfAnimal + '\'' +
                ", weight='" + weight + '\'' +
                ", detail='" + detail + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

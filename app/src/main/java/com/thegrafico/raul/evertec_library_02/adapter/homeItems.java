package com.thegrafico.raul.evertec_library_02.adapter;

public class homeItems {

    int image;
    String name, description, accNumber;

    public homeItems(int image, String name, String description, String accNumber) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.accNumber = accNumber;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAccNumber() {
        return accNumber;
    }
}

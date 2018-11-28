package com.thegrafico.raul.evertec_library_02;

public class homeItems {

    int image;
    String name, description;

    public homeItems(int image, String name, String description) {
        this.image = image;
        this.name = name;
        this.description = description;
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
}

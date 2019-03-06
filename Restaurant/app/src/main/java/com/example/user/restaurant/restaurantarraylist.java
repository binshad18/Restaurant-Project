package com.example.user.restaurant;

public class restaurantarraylist {
    private String id,name,image;;

    public restaurantarraylist() {
    }

    public restaurantarraylist(String id,String name,String image) {


        this.id = id;
        this.name = name;
        this.image = image;

    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }
    public String getImage() {
        return image;
    }

}

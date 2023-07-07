package com.example.sidraapp.models;

public class Food {
    private int id;
    private String foodName;
    private String weight;
    private String price;
    private String image;

//    public Food(int id, String foodName, String weight, String price){
//        this.id = id;
//        this.foodName = foodName;
//        this.weight = weight;
//        this.price = price;
//    }

    public Food( String foodName, String weight, String price, String image){
        this.foodName = foodName;
        this.weight = weight;
        this.price = price;
        this.image = image;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setFoodName(String foodName){
        this.foodName = foodName;
    }
    public String getFoodName(){
        return foodName;
    }
    public void setWeight(String weight){
        this.weight = weight;
    }
    public String getWeight(){
        return weight;
    }

    public void setPrice(String price){
        this.price = price;
    }
    public String getPrice(){
        return price;
    }

    public void setImage(String image){
        this.image = image;
    }

    public String getImage(){
        return image;
    }
}

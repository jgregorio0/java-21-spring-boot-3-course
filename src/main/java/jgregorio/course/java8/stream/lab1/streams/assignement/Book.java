package jgregorio.course.java8.stream.lab1.streams.assignement;

class Book{     
    private String title;     
    private double price;     
    Book(String title, double price){         
        this.title = title;         
        this.price = price;     
    }     
    public String getTitle() {   return title;}
    public double getPrice() {   return price;}
    public String toString() { return title+ " " + price;}
}
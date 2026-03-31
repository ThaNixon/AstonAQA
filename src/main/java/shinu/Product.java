package shinu;

public class Product {
    public String name;
    public String date;
    public String developer;
    public String country;
    public float price;
    public Boolean status;

    public Product(String name,
                   String date,
                   String developer,
                   String country,
                   float price,
                   Boolean status)
    {
        this.name = name;
        this.date = date;
        this.developer = developer;
        this.country = country;
        this.price = price;
        this.status = status;
    }

    public void printProduct() {
        System.out.println("Название:" + this.name);
        System.out.println("Дата производства:" + this.date);
        System.out.println("Производитель:" + this.developer);
        System.out.println("Страна происхождения:" + this.country);
        System.out.println("Цена:" + this.price);
        System.out.println("Состояние бронирования покупателем:" + this.status);
    }
}
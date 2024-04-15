import java.util.Date;

public class Items {
    private String name;
    private Double price;
    private String expiration;
    private String type;

    public Items(String name, Double price, String expiration, String type) {
        this.name = name;
        this.price = price;
        this.expiration = expiration;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String  expiration) {
        this.expiration = expiration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString(){
        return "Items{" +
                "name" + name + '\''+
                "price" + price + '\''+
                "type" + type + '\''+
                "expirationDate" + expiration+'\''+
                '}';
    }

}

package T12DesignPatterns.Exercise.Creational.P04Builder;

public class Product {
    private String name;
    private int id;
    private String prodDate;
    private String consumeBefore;

    public Product withName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getProdDate() {
        return prodDate;
    }

    public String getConsumeBefore() {
        return consumeBefore;
    }

    public Product withId(int id) {
        this.id = id;
        return this;
    }

    public Product withProdDate(String date) {
        this.prodDate = date;
        return this;
    }

    public Product withConsumeBefore(String consumeBefore) {
        this.consumeBefore = consumeBefore;
        return this;
    }
    public Product build() {
        return this;
    }
}

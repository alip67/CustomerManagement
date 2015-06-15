package model;

public abstract class Customer {
    private String id;

    protected Customer(String id) {
        this.id = id;
    }

    protected Customer() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

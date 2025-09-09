class Product implements Cloneable {
    String id;

    public Product(String id) { this.id = id; }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
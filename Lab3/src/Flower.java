public class Flower {
    int id;
    String name;
    String type; 
    String species;    
    String subspecies; 
    double price;
    int quantity;

    public Flower(int id, String name, String type, String species, String subspecies, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.species = species;
        this.subspecies = subspecies;
        this.price = price;
        this.quantity = quantity;
    }
}
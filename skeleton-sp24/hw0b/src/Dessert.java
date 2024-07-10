public class Dessert {
    private static int numDesserts;
    private final int flavor;
    private final int price;

    public Dessert(int f, int p) {
        this.flavor = f;
        this.price = p;
        numDesserts++;
    }

    public static void main(String[] args) {
        System.out.println("I love dessert!");
    }

    public void printDessert() {
        System.out.println(this.flavor + " " + this.price + " " + numDesserts);
    }
}

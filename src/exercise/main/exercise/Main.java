package exercise;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Bill");
        customer.addRental(new Rental(new Tape("1234", new RegularMovie("Seven")), 2));
        customer.addRental(new Rental(new Tape("2345", new NewReleaseMovie("Usual Suspects")), 3));
        customer.addRental(new Rental(new Tape("3456", new ChildrensMovie("American Beauty")), 2));

        System.out.println(customer.printStatement());
    }
}

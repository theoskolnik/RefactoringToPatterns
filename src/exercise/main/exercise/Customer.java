package exercise;

// The customer class represents the customer. So far all the classes have been dumb encapsulated data. Customer holds all the behavior for producing a statement in its statement() method.

import java.util.ArrayList;
import java.util.List;

class Customer extends DomainObject {
    private final String result;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
        this.result = printStatement();
    }

    public String printStatement() {
        return statement();
    }

    private String statement() {
        int frequentRenterPoints = 1;
        double totalAmount = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("Rental Record for " + name() + "\n");

        for (Rental rental : rentals) {
            totalAmount += rental.getRentalRate();
            frequentRenterPoints = addBonusFrequentRenterPoints(frequentRenterPoints, rental);
            sb.append("\t" + rental.tape().movie().name() + "\t" + String.valueOf(rental.getRentalRate()) + "\n");
        }

        sb.append("Amount owed is " + String.valueOf(totalAmount) + "\n");
        sb.append("You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points");
        return sb.toString();
    }

    private int addBonusFrequentRenterPoints(int frequentRenterPoints, Rental rental) {
        if ((rental.tape().movie().priceCode() == Movie.NEW_RELEASE) && rental.daysRented() > 1) frequentRenterPoints++;
        return frequentRenterPoints;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public static Customer get(String name) {
        return (Customer) Registrar.get("Customers", name);
    }

    public void persist() {
        Registrar.add("Customers", this);
    }
}
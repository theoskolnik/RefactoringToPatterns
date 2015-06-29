package exercise;

// The customer class represents the customer. So far all the classes have been dumb encapsulated data. Customer holds all the behavior for producing a statement in its statement() method.

import java.util.ArrayList;
import java.util.List;

class Customer extends DomainObject {
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public String statement() {
        int frequentRenterPoints = 1;
        double totalAmount = 0;
        String result = "Rental Record for " + name() + "\n";
        for (Rental rental : rentals) {
            //determine amounts for each line
            double thisAmount = getRentalRate(rental);
            totalAmount += thisAmount;

            // add frequent renter points
            frequentRenterPoints = addBonusFrequentRenterPoints(frequentRenterPoints, rental);


            //show figures for this rental
            result += "\t" + rental.tape().movie().name() + "\t" + String.valueOf(thisAmount) + "\n";

        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;

    }

    private int addBonusFrequentRenterPoints(int frequentRenterPoints, Rental rental) {
        // add bonus for a two day new release rental
        if ((rental.tape().movie().priceCode() == Movie.NEW_RELEASE) && rental.daysRented() > 1) frequentRenterPoints++;
        return frequentRenterPoints;
    }

    private double getRentalRate(Rental rental) {
        double thisAmount = 0;
        Movie movie = rental.tape().movie();
        thisAmount += movie.getExtraCharge();
        if (rental.daysRented() > movie.getRentalLimit()) {
            thisAmount += (rental.daysRented() - movie.getRentalLimit()) * movie.getMultiplier();

        }
        return thisAmount;
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
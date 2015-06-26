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
        int frequentRenterPoints = 0;
        double totalAmount = 0;
        String result = "Rental Record for " + name() + "\n";
        for (Rental each : rentals) {
            double thisAmount = 0;
            //determine amounts for each line
            thisAmount = calculateAmountOwed(each, thisAmount);
            totalAmount += thisAmount;

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((each.tape().movie().priceCode() == Movie.NEW_RELEASE) && each.daysRented() > 1) frequentRenterPoints++;

            //show figures for this rental
            result += "\t" + each.tape().movie().name() + "\t" + String.valueOf(thisAmount) + "\n";

        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;

    }

    private double calculateAmountOwed(Rental rental, double thisAmount) {
        switch (rental.tape().movie().priceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (rental.daysRented() > 2)
                    thisAmount += (rental.daysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += rental.daysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (rental.daysRented() > 3)
                    thisAmount += (rental.daysRented() - 3) * 1.5;
                break;

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
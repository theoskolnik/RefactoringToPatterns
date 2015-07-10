package exercise;


//The rental class represents a customer renting a movie.

class Rental extends DomainObject {
    private int daysRented;
    private Tape tape;

    public Rental(Tape tape, int daysRented) {
        this.tape = tape;
        this.daysRented = daysRented;
    }

    public int daysRented() {
        return daysRented;
    }

    public Tape tape() {
        return tape;
    }

    public double getRentalRate() {
        return rentalRateCalculator();
    }

    private double rentalRateCalculator() {
        double rentalTotal = 0;
        rentalTotal += this.tape().movie().getExtraCharge();
        if (this.daysRented() > this.tape().movie().getRentalLimit()) {
            rentalTotal += (this.daysRented() - this.tape().movie().getRentalLimit()) * this.tape().movie().getMultiplier();

        }
        return rentalTotal;
    }
}


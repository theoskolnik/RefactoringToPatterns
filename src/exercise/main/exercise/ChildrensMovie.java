package exercise;

public class ChildrensMovie extends DomainObject implements Movie {


    private final int priceCode;
    private final int rentalLimit;
    private final double extraCharge;
    private double multiplier;

    public ChildrensMovie(String name) {
        this.name = name;
        this.priceCode = Movie.CHILDRENS;
        this.rentalLimit = 3;
        this.extraCharge = 1.5;
        this.multiplier = 1.5;
    }

    @Override
    public int priceCode() {
        return priceCode;
    }

    @Override
    public void persist() {

    }

    public int getRentalLimit() {
        return rentalLimit;
    }

    @Override
    public double getExtraCharge() {
        return extraCharge;
    }

    @Override
    public double getMultiplier() {
        return multiplier;
    }
}

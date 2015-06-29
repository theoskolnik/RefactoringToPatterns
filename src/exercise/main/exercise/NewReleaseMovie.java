package exercise;

/**
 * Created by tskolnik on 6/24/15.
 */
public class NewReleaseMovie extends DomainObject implements Movie {
    private final int priceCode;
    private final int rentalLimit;
    private final double extraCharge;
    private double multiplier;

    public NewReleaseMovie(String name) {
        this.name = name;
        this.priceCode = Movie.NEW_RELEASE;
        this.rentalLimit = 0;
        this.extraCharge = 0;
        this.multiplier = 3;
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

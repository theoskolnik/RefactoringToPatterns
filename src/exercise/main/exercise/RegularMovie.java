package exercise;

// Movie represents the notion of a film. A video store might have several tapes in stock of the same movie

public class RegularMovie extends DomainObject implements Movie {

    private final int rentalLimit;
    private final double extraCharge;
    private int priceCode;
    private double multiplier;

    public RegularMovie(String name) {
        this.name = name;
        this.priceCode = Movie.REGULAR;
        this.rentalLimit = 2;
        this.extraCharge = 2;
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

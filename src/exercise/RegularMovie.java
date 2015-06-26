package exercise;

// Movie represents the notion of a film. A video store might have several tapes in stock of the same movie

public class RegularMovie extends DomainObject implements Movie {

	private int priceCode;

	public RegularMovie(String name) {
		this.name = name;
		this.priceCode = Movie.REGULAR;
	}

	@Override
    public int priceCode() {
		return priceCode;
	}

	@Override
    public void persist() {
	}

}

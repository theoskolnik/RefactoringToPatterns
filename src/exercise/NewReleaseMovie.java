package exercise;

/**
 * Created by tskolnik on 6/24/15.
 */
public class NewReleaseMovie extends DomainObject implements Movie {
    private final int priceCode;

    public NewReleaseMovie(String name) {
        this.name = name;
        this.priceCode = Movie.NEW_RELEASE;
    }

    @Override
    public int priceCode() {
        return priceCode;
    }

    @Override
    public void persist() {

    }
}

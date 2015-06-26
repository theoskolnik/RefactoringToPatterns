package exercise;

import com.sun.java.browser.plugin2.DOM;

/**
 * Created by tskolnik on 6/24/15.
 */
public class ChildrensMovie extends DomainObject implements Movie {


    private final int priceCode;

    public ChildrensMovie(String name) {
        this.name = name;
        this.priceCode = Movie.CHILDRENS;
    }

    @Override
    public int priceCode() {
        return priceCode;
    }

    @Override
    public void persist() {

    }
}

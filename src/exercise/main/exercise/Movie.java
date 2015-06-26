package exercise;

/**
 * Created by tskolnik on 6/24/15.
 */
public interface Movie {
    public static final int  CHILDRENS = 2;
    public static final int  REGULAR = 0;
    public static final int  NEW_RELEASE = 1;

    int priceCode();

    void persist();

    String name();
}

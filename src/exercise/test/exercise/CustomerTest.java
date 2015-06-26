package exercise;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerTest {

    @Test
    public void givenANewReleaseForOneDay_shouldCharge3Dollars(){
        Customer customer = new Customer("Bill");
        Rental rental = mock(Rental.class);
        Tape tape = mock(Tape.class);
        RegularMovie movie = mock(RegularMovie.class);

        when(rental.tape()).thenReturn(tape);
        when(tape.movie()).thenReturn(movie);
        when(movie.priceCode()).thenReturn(RegularMovie.NEW_RELEASE);
        when(rental.daysRented()).thenReturn(1);

        customer.addRental(rental);

        assertThat(customer.statement(), containsString("Amount owed is 3"));
    }

    @Test
    public void givenARegularForOneDay_shouldCharge2Dollars(){
        Customer customer = new Customer("Bill");
        Rental rental = mock(Rental.class);
        Tape tape = mock(Tape.class);
        RegularMovie movie = mock(RegularMovie.class);

        when(rental.tape()).thenReturn(tape);
        when(tape.movie()).thenReturn(movie);
        when(movie.priceCode()).thenReturn(RegularMovie.REGULAR);
        when(rental.daysRented()).thenReturn(1);

        customer.addRental(rental);

        assertThat(customer.statement(), containsString("Amount owed is 2"));
    }

    @Test
    public void givenARegularForThreeDays_shouldCharge3andHalfDollars(){
        Customer customer = new Customer("Bill");
        Rental rental = mock(Rental.class);
        Tape tape = mock(Tape.class);
        RegularMovie movie = mock(RegularMovie.class);

        when(rental.tape()).thenReturn(tape);
        when(tape.movie()).thenReturn(movie);
        when(movie.priceCode()).thenReturn(RegularMovie.REGULAR);
        when(rental.daysRented()).thenReturn(3);

        customer.addRental(rental);

        assertThat(customer.statement(), containsString("Amount owed is 3.5"));
        assertThat(customer.statement(), containsString("1 frequent renter points"));
    }

    @Test
    public void givenAChildrensForOneDay_shouldCharge1andHalfDollars(){
        Customer customer = new Customer("Bill");
        Rental rental = mock(Rental.class);
        Tape tape = mock(Tape.class);
        RegularMovie movie = mock(RegularMovie.class);

        when(rental.tape()).thenReturn(tape);
        when(tape.movie()).thenReturn(movie);
        when(movie.priceCode()).thenReturn(RegularMovie.CHILDRENS);
        when(rental.daysRented()).thenReturn(1);

        customer.addRental(rental);

        assertThat(customer.statement(), containsString("Amount owed is 1.5"));
    }

    @Test
    public void givenAChildrensForFourDays_shouldCharge3Dollars(){
        Customer customer = new Customer("Bill");
        Rental rental = mock(Rental.class);
        Tape tape = mock(Tape.class);
        RegularMovie movie = mock(RegularMovie.class);

        when(rental.tape()).thenReturn(tape);
        when(tape.movie()).thenReturn(movie);
        when(movie.priceCode()).thenReturn(RegularMovie.CHILDRENS);
        when(rental.daysRented()).thenReturn(4);

        customer.addRental(rental);

        assertThat(customer.statement(), containsString("Amount owed is 3"));
        assertThat(customer.statement(), containsString("1 frequent renter points"));

    }


}
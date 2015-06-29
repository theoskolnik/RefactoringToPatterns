package exercise;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class CustomerTest {

    @Test
    public void givenANewReleaseForOneDay_shouldCharge3Dollars(){
        Customer customer = new Customer("Bill");
        Movie interstellar = new NewReleaseMovie("Interstellar");
        Tape tape = new Tape("1234", interstellar);
        Rental rental = new Rental(tape, 1);

        customer.addRental(rental);

        assertThat(customer.statement(), containsString("Amount owed is 3"));
    }

    @Test
    public void givenARegularForOneDay_shouldCharge2Dollars(){
        Customer customer = new Customer("Bill");
        Movie gravity = new RegularMovie("Gravity");
        Tape tape = new Tape("5678", gravity);
        Rental rental = new Rental(tape, 1);

        customer.addRental(rental);

        assertThat(customer.statement(), containsString("Amount owed is 2"));
    }

    @Test
    public void givenARegularForThreeDays_shouldCharge3andHalfDollars(){
        Customer customer = new Customer("Bill");
        Movie gravity = new RegularMovie("Gravity");
        Tape tape = new Tape("5678", gravity);
        Rental rental = new Rental(tape, 3);


        customer.addRental(rental);

        assertThat(customer.statement(), containsString("Amount owed is 3.5"));
        assertThat(customer.statement(), containsString("1 frequent renter points"));
    }

    @Test
    public void givenAChildrensForOneDay_shouldCharge1andHalfDollars(){
        Customer customer = new Customer("Bill");
        Movie totoro = new ChildrensMovie("Totoro");
        Tape tape = new Tape("1111", totoro);
        Rental rental = new Rental(tape, 1);

        customer.addRental(rental);

        assertThat(customer.statement(), containsString("Amount owed is 1.5"));
    }

    @Test
    public void givenAChildrensForFourDays_shouldCharge3Dollars(){
        Customer customer = new Customer("Bill");
        Movie totoro = new ChildrensMovie("Totoro");
        Tape tape = new Tape("1111", totoro);
        Rental rental = new Rental(tape, 4);

        customer.addRental(rental);

        assertThat(customer.statement(), containsString("Amount owed is 3"));
        assertThat(customer.statement(), containsString("1 frequent renter points"));

    }


}
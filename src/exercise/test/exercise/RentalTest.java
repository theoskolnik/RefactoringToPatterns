package exercise;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RentalTest {

    @Test
    public void getRentalRate_shouldCalculateRentalRate() throws Exception {
        Rental rental = new Rental(new Tape("4444", new RegularMovie("Up")), 2);

        double rentalRate = rental.getRentalRate();

        assertThat(rentalRate, is(2.0));
    }



}
package edu.umb.cs680.hw3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
	
	private String[] carToStringArray(Car car) {
		String[] carDetails = {car.getMake(), car.getModel(), Integer.toString(car.getYear())};
		return carDetails;
	}
	
	@Test
	public void verifyCarEqualityWithMakeModelYear() {
		String[] exp1 = {"Toyota", "RAV4", "2018"};
		String[] exp2 = {"Honda", "Civic", "2020"};
		Car act1 = new Car("Toyota", "RAV4", 20, 2018, 400000);
		Car act2 = new Car("Honda", "Civic", 60, 2020, 600000);
		assertArrayEquals(exp1, carToStringArray(act1) );
		assertArrayEquals(exp2, carToStringArray(act2) );
	}

}
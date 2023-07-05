package Assignment1;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void test() {
		Calculator calc = new Calculator();

		System.out.println("Addition"+calc.add(10,20));
	
		System.out.println("Subtraction"+calc.sub(20,10));				

		System.out.println("Multiplication"+calc.mul(5,4));									
	
		System.out.println("Division"+calc.div(45,5));

		System.out.println("Power Calculation "+calc.power(5,4));				
	
	
		System.out.println("Square Root"+calc.square(5));
	
		System.out.println("Modulus"+calc.modulus(45,6));
	
		System.out.println("Factorial of a Number"+calc.factorial(5));
		


	}

}

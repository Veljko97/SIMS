package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Utill;

class UtillTest {

	@Test
	void testPasswordGen() {
		String pass1 = "password";
		String pass2 = "Password";			//Minimalna razlika u siframa
		int passcod1 = Utill.passworGenerator(pass1);
		int passcod2 = Utill.passworGenerator(pass1);
		int passcod3 = Utill.passworGenerator(pass2);
		assertEquals(passcod1, passcod2);
		
		assertNotEquals(passcod1, passcod3);
		
	}

}

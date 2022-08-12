package banking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class bankManagementTest {
	private static String Name;
	private static int PassCode;
	private static boolean Result;
	private static bankManagement BM;
	
	@BeforeAll
	public static void createBankingMangement() {
		System.out.println("Creating bankMangement in before all");
		BM = new bankManagement();
	}
	
	@BeforeEach
	public void setValues() {
		System.out.println("Setting Values In Before Each");
		Name = "ja";
		PassCode = 8;
	}
	
	@Test
	public void TestPostiveValidation() {
		Result = BM.CheckingValidation(Name, PassCode);
		assertEquals(true, Result);
	}
	
	@Test
	public void TestNegativeValidation() {
		System.out.println();
		Result = BM.CheckingValidation(Name, PassCode);
		assertNotEquals(false, Result);
	}
	
	@AfterEach
	public void ResetResult() {
		Result = false;
		System.out.println("Resetting Result Value");
	}
	
	public static void ResetBank() {
		BM = null;
		System.out.println("Resetting Bank Management");
	}
}

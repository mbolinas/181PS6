package base;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void Person() {
		PersonDomainModel per1 = new PersonDomainModel();
		per1.setBirthday(new Date(0));
		per1.setCity("Townsend");
		per1.setFirstName("Bert");
		per1.setLastName("Gibbons");
		per1.setPostalCode(19734);
		per1.setStreet("214 Labrador Lane");
		
		PersonDAL.addPerson(per1);
		
		
	}
	
	@Test
	public void Person2(){
		PersonDomainModel p1 = new PersonDomainModel();
		PersonDomainModel p2 = new PersonDomainModel();
		PersonDomainModel p3 = new PersonDomainModel();
		
		PersonDAL.addPerson(p1);
		PersonDAL.addPerson(p2);
		PersonDAL.addPerson(p3);
		
		assertTrue(PersonDAL.getPerson(p1.getPersonID()).getFirstName() == null);
		assertTrue(PersonDAL.getPerson(p2.getPersonID()).getFirstName() == null);
		assertTrue(PersonDAL.getPerson(p3.getPersonID()).getFirstName() == null);
		assertTrue(PersonDAL.getPersons().size() > 2);
		
		
		int size = PersonDAL.getPersons().size();
		PersonDAL.deletePerson(p1.getPersonID());
		assertTrue(PersonDAL.getPersons().size() < size);
		
		
		p2.setFirstName("me");
		PersonDAL.updatePerson(p2);
		assertTrue(PersonDAL.getPerson(p2.getPersonID()).getFirstName().equals("me"));
	}

}
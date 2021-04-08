package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmailTest {
	
	private static final String[] TEST_EMAILS = {"ab@bc.com", "a.b@c.org", "abcdefghijklmnopqrst@abcdefghijklmnopqrst.com.bd"};
	
	private static final String[] Empty_Emails = {};
	
	private String[] Test_Names = {"jnsu", "juweuh", "uireui"};
	
	private String[] testValidChars = {" ", "a", "A", "\uc5ec", "0123456789", "01234567890123456789","\n" };
	
	private EmailConcrete email;
	
	@Before
	public void setUpEmailTest() throws Exception {
		
		email = new EmailConcrete();
	}
	
	@After
	public void tearDownEmailTest() throws Exception {
		
	}
	
	
	// addBcc tests
	@Test
	public void testAddBcc() throws Exception {
		
		email.addBcc(TEST_EMAILS);
		
		assertEquals(3, email.getBccAddresses().size());
	}
	
	@Test(expected = EmailException.class)
	public void testAddBccEmpty() throws Exception  {
		
		email.addBcc(Empty_Emails);
		
		assertEquals(0, email.getBccAddresses().size());
	}
	
	// addCc tests
		@Test
		public void testAddCc() throws Exception {
			
			email.addCc(TEST_EMAILS[0]);
			
			assertEquals(1, email.getCcAddresses().size());
		}
		
		@Test(expected = EmailException.class)
		public void testAddCcEmpty() throws Exception  {
			
			email.addCc("");
			
			assertEquals(0, email.getCcAddresses().size());
		}
		
		// addHeader tests
		@Test
		public void testAddHeader() throws Exception {
			
			email.addHeader(Test_Names[0] , testValidChars[3]);
			
			assertEquals(1, email.getHeaders().size());
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testAddHeaderValue() throws Exception {
			
			email.addHeader("" , testValidChars[3]);
			
			assertEquals(0, email.getHeaders().size());
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testAddHeaderName() throws Exception {
			
			email.addHeader(Test_Names[1], "");
			
			assertEquals(0, email.getHeaders().size());
		}
		
		// addReplyTo tests
		@Test
		public void testAddReplyTo() throws Exception {
			
			email.addReplyTo(TEST_EMAILS[1], Test_Names[2]);
			
			assertEquals(1, email.getReplyToAddresses().size());
		}
}

package net.meshkorea.sample.contacts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ContactsApplication.class)
public class ContactsApplicationTests {

	@Test
	public void contextLoads() {
        Assert.assertTrue(true);
	}

}

package com.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import com.app.entities.enums.TitleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.daos.CitizenDAO;
import com.app.entities.Address;
import com.app.entities.end_users.Citizen;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CitizenTest {
	@Autowired
	private CitizenDAO citizenDao;
	
	Address add1 = new Address("ramnager","mumbatan","pune","MH","india","123456");
	Address add2 = new Address("mezza9","Ring Road","mumbai","MH","india","123432");
	Address add3 = new Address("basti","narayanpur","pune","MH","india","123455");
	Address add4 = new Address("phase3","pimpri","mumbai","MH","india","123466");
	@Test
	void testCitizenD() {
		List<Citizen> list = List.of(
				new Citizen("devil","123412341234",add1,add2,"Doctor", TitleEnum.Mr,"max","john",25,"MALE","max123@gmail.com","max123","1234567890","1998-12-02"),
				new Citizen("praneet","123412345678",add2,add1,"host",TitleEnum.Miss,"puneet","devis",25,"FEMALE","puneet123@gmail.com","puneet123","1234567800","1998-10-02"),
				new Citizen("davis","111112341234",add2,add2,"engineer",TitleEnum.Dr,"atom","derick",55,"MALE","devis123@gmail.com","devis123","1234567000","1998-09-02")
				);
		List<Citizen> list1 = citizenDao.saveAll(list);
		assertEquals(3,list1.size());
	}
}
















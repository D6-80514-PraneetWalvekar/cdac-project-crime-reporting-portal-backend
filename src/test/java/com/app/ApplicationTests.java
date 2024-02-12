package com.app;

import com.app.daos.CitizenDAO;
import com.app.daos.PoliceStationDao;
import com.app.daos.SHODao;
import com.app.entities.Address;
import com.app.entities.PoliceStation;
import com.app.entities.end_users.Citizen;
import com.app.entities.end_users.InvestigatingOfficer;
import com.app.entities.end_users.StationHouseOfficer;
import com.app.entities.enums.DutyStatus;
import com.app.entities.enums.GenderEnum;
import com.app.entities.enums.RoleEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;

@DataJpaTest
@Rollback(value = false) @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ApplicationTests {


	@Autowired
	SHODao shoDao;
	@Autowired
	PoliceStationDao stationDao;
	@Autowired
	CitizenDAO citizenDAO;


	@Test
	void insertSHO()
	{

		Address address = new Address("a", "b", "c", "d", "e",123456);
//		StationHouseOfficer sho = new StationHouseOfficer("first officer", "lastname of 1st", "1234567890", "Town Inspector",
//				GenderEnum.MALE, "sho1@police.com", LocalDate.parse("1990-09-11"), address,LocalDate.parse("2022-10-08"), DutyStatus.ACTIVE);
		Address psAddress = new Address("phase 1", "hinjewadi", "Pune", "Maharashtra", "India", 411106);
		PoliceStation policeStation = new PoliceStation(psAddress);
		PoliceStation policeStation2 = stationDao.save(policeStation);
		shoDao.save(new StationHouseOfficer("first officer", "lastname of 1st", "1234567890", "Town Inspector",
				GenderEnum.MALE, "sho1@police.com", LocalDate.parse("1990-09-11"), address,LocalDate.parse("2022-10-08"), DutyStatus.ACTIVE, policeStation2));

	}

	@Test
	void insertIO()
	{
		InvestigatingOfficer io = new InvestigatingOfficer("io1", "IO", "1234515243", "Sub-Inspector", GenderEnum.MALE, "Io1@police.com", LocalDate.parse("1991-08-11"), LocalDate.parse("2023-08-11"), RoleEnum.INVESTIGATINGOFFICER, DutyStatus.ACTIVE, stationDao.findById(1L).get());
	}


}

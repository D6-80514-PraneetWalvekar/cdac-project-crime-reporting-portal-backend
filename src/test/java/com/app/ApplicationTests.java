package com.app;

import com.app.daos.CitizenDAO;
import com.app.daos.IODao;
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
	@Autowired
	IODao ioDao;


	@Test
	void insertSHO()
	{

		Address address = new Address("a", "b", "c", "d", "e","123456");
//		StationHouseOfficer sho = new StationHouseOfficer("first officer", "lastname of 1st", "1234567890", "Town Inspector",
//				GenderEnum.MALE, "sho1@police.com", LocalDate.parse("1990-09-11"), address,LocalDate.parse("2022-10-08"), DutyStatus.ACTIVE);
		Address psAddress = new Address("phase 1", "hinjewadi", "Pune", "Maharashtra", "India", "411106");
		PoliceStation policeStation = new PoliceStation(psAddress);
		PoliceStation policeStation2 = stationDao.save(policeStation);
		shoDao.save(new StationHouseOfficer("first officer", "lastname of 1st", "1234567890", "Town Inspector",
				GenderEnum.MALE, "sho1@police.com", LocalDate.parse("1990-09-11"), address,LocalDate.parse("2022-10-08"), DutyStatus.ACTIVE, policeStation2));

		Address address2 = new Address("a1", "b2", "c3", "d4", "e","123456");
//		StationHouseOfficer sho = new StationHouseOfficer("first officer", "lastname of 1st", "1234567890", "Town Inspector",
//				GenderEnum.MALE, "sho1@police.com", LocalDate.parse("1990-09-11"), address,LocalDate.parse("2022-10-08"), DutyStatus.ACTIVE);
		Address psAddress2 = new Address("phase 3", "wakad", "Pune", "Maharashtra", "India", "411106");
		PoliceStation policeStation21 = new PoliceStation(psAddress2);
		PoliceStation policeStation22 = stationDao.save(policeStation21);
		shoDao.save(new StationHouseOfficer("second officer", "lastname of 2st", "1234143343", "Town Inspector",
				GenderEnum.MALE, "sho2@police.com", LocalDate.parse("1990-09-11"), address,LocalDate.parse("2022-10-08"), DutyStatus.ACTIVE, policeStation22));
	}

	@Test
	void insertIO()
	{

		InvestigatingOfficer io = new InvestigatingOfficer("io2", "IO22", "1222341", "Sub-Inspector", GenderEnum.MALE, "Io2@police.com", LocalDate.parse("1991-08-11"), LocalDate.parse("2023-08-11"), RoleEnum.INVESTIGATINGOFFICER, DutyStatus.ACTIVE, stationDao.findById(1L).get());
		ioDao.save(io);
		 io = new InvestigatingOfficer("io3", "IO33", "42342", "Sub-Inspector", GenderEnum.MALE, "Io3@police.com", LocalDate.parse("1995-09-11"), LocalDate.parse("2024-02-01"), RoleEnum.INVESTIGATINGOFFICER, DutyStatus.ACTIVE, stationDao.findById(1L).get());
		ioDao.save(io);
		 io = new InvestigatingOfficer("io4", "IO44", "42351240", "Sub-Inspector", GenderEnum.FEMALE, "Io4@police.com", LocalDate.parse("1996-04-11"), LocalDate.parse("2023-11-11"), RoleEnum.INVESTIGATINGOFFICER, DutyStatus.ACTIVE, stationDao.findById(2L).get());
		ioDao.save(io);
		 io = new InvestigatingOfficer("io5", "IO55", "2309842", "Sub-Inspector", GenderEnum.MALE, "Io5@police.com", LocalDate.parse("1997-05-11"), LocalDate.parse("2023-12-31"), RoleEnum.INVESTIGATINGOFFICER, DutyStatus.ACTIVE, stationDao.findById(2L).get());
		ioDao.save(io);


	}


}

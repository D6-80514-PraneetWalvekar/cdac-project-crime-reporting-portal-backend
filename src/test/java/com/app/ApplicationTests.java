package com.app;

import com.app.daos.*;
import com.app.entities.Address;
import com.app.entities.PoliceStation;
import com.app.entities.end_users.Citizen;
import com.app.entities.end_users.InvestigatingOfficer;
import com.app.entities.end_users.SPOfficer;
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
	@Autowired
	SPDao spDao;

	@Test
	void insertSP()
	{
		SPOfficer sp = new SPOfficer("SP", "Sir", "sp@police.com", "1029371986");
		spDao.save(sp);
	}


	@Test
	void insertSHO()
	{
		SPOfficer spOfficer = spDao.getReferenceById(1L);

		PoliceStation ps1 = new PoliceStation(spOfficer, "Phase 1, Hinjewadi");
		StationHouseOfficer sho1 = new StationHouseOfficer("first officer", "lastname of 1st", "sho1@police.com", "1234567890", ps1, spOfficer);

		PoliceStation ps2 = new PoliceStation(spOfficer, "Phase 2, Hinjewadi");
		StationHouseOfficer sho2 = new StationHouseOfficer("second officer", "lastname of 2nd", "sho2@police.com", "132412", ps2, spOfficer);

		PoliceStation ps3 = new PoliceStation(spOfficer, "Phase 3, Hinjewadi");
		StationHouseOfficer sho3 = new StationHouseOfficer("third officer", "lastname of 3rd", "sho3@police.com", "23413141", ps3, spOfficer);

		stationDao.save(ps1);
		stationDao.save(ps2);
		stationDao.save(ps3);

		shoDao.save(sho1);
		shoDao.save(sho2);
		shoDao.save(sho3);
	}

	@Test
	void insertIO()
	{
		InvestigatingOfficer  io = new InvestigatingOfficer("io1", "sir", "io1@police.com", "129038721", stationDao.findById(1L).get());
		ioDao.save(io);
		  io = new InvestigatingOfficer("io2", "ma'am", "io2@police.com", "234234", stationDao.findById(1L).get());
		ioDao.save(io);
		  io = new InvestigatingOfficer("io3", "sir", "io3@police.com", "1234124", stationDao.findById(1L).get());
		ioDao.save(io);

		  io = new InvestigatingOfficer("io4", "sir", "io4@police.com", "097987345", stationDao.findById(2L).get());
		ioDao.save(io);
		  io = new InvestigatingOfficer("io5", "ma'am", "io5@police.com", "0923894681", stationDao.findById(2L).get());
		ioDao.save(io);

		io = new InvestigatingOfficer("io6", "sir", "io6@police.com", "3124", stationDao.findById(3L).get());
		ioDao.save(io);
		io = new InvestigatingOfficer("io7", "ma'am", "io7@police.com", "98234", stationDao.findById(3L).get());
		ioDao.save(io);


	}


}

package com.app;

import com.app.daos.*;
import com.app.entities.Address;
import com.app.entities.PoliceStation;
import com.app.entities.end_users.*;
import com.app.entities.enums.DutyStatus;
import com.app.entities.enums.GenderEnum;
import com.app.entities.enums.RoleEnum;
import com.app.entities.enums.TitleEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
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

	@Autowired
	private PasswordEncoder encoder;

	@Test
	void insertSP()
	{
		BaseEntityUsers baseEntityUsers = new BaseEntityUsers("sp@police.com", encoder.encode("fuckCrime@2611"), RoleEnum.ROLE_SP);
		SPOfficer sp = new SPOfficer(baseEntityUsers, TitleEnum.Mr, "Supreme", "Leader", 45, LocalDate.parse("1976-08-03"),GenderEnum.MALE, "9425116206");
		spDao.save(sp);
	}


	@Test
	void insertSHO()
	{
		SPOfficer spOfficer = spDao.getReferenceById(2L);
		BaseEntityUsers baseEntityUsers = new BaseEntityUsers("sho@police.com", encoder.encode("1111"), RoleEnum.ROLE_SHO);
		PoliceStation ps1 = new PoliceStation("Mumbai","mmmm","Maharashtra","400410",spOfficer);
		StationHouseOfficer sho1 = new StationHouseOfficer(baseEntityUsers,TitleEnum.Mr,"first officer", "lastname of 1st",30, LocalDate.parse("1993-02-19"),GenderEnum.MALE, "1234567890","Inspector",LocalDate.parse("2015-10-12"),DutyStatus.ACTIVE, ps1, spOfficer);

//		PoliceStation ps2 = new PoliceStation(spOfficer, "Phase 2, Hinjewadi");
//		StationHouseOfficer sho2 = new StationHouseOfficer("second officer", "lastname of 2nd", "sho2@police.com", "132412", ps2, spOfficer);
//
//		PoliceStation ps3 = new PoliceStation(spOfficer, "Phase 3, Hinjewadi");
//		StationHouseOfficer sho3 = new StationHouseOfficer("third officer", "lastname of 3rd", "sho3@police.com", "23413141", ps3, spOfficer);

		stationDao.save(ps1);
//		stationDao.save(ps2);
//		stationDao.save(ps3);

		shoDao.save(sho1);
//		shoDao.save(sho3);
//		shoDao.save(sho2);
	}

	@Test
	void insertIO()
	{
		PoliceStation ps3 = stationDao.getReferenceById(3L);
		BaseEntityUsers baseEntityUsers = new BaseEntityUsers("ashish@police.com", encoder.encode("1111"), RoleEnum.ROLE_IO);
		InvestigatingOfficer  io = new InvestigatingOfficer(baseEntityUsers,TitleEnum.Mr,"Ashish", "Singh", 34,LocalDate.parse("1991-04-11"),GenderEnum.MALE, "129038221", "Inspector",LocalDate.parse("2012-10-12"),DutyStatus.ACTIVE,ps3,null);
		ioDao.save(io);

		PoliceStation ps2 = stationDao.getReferenceById(3L);
		BaseEntityUsers baseEntityUsers1 = new BaseEntityUsers("amar@police.com", encoder.encode("1111"), RoleEnum.ROLE_IO);
		InvestigatingOfficer  io1 = new InvestigatingOfficer(baseEntityUsers1,TitleEnum.Mr,"Amar", "Sulunke", 32,LocalDate.parse("1992-03-22"),GenderEnum.MALE, "123880721", "Inspector",LocalDate.parse("2014-02-10"),DutyStatus.ACTIVE,ps2,null);
		ioDao.save(io1);

//		  io = new InvestigatingOfficer(io,TitleEnum.Miss, "mmmmm", "dddd", 29, LocalDate.parse("1994-01-23"),GenderEnum.FEMALE,"0987654322","Inspector",LocalDate.parse("2018-09-02"),DutyStatus.ACTIVE,stationDao.findById(3L).get());
//		ioDao.save(io);
//		  io = new InvestigatingOfficer("io3", "sir", "io3@police.com", "1234124", stationDao.findById(4L).get());
//		ioDao.save(io);
//
//		  io = new InvestigatingOfficer("io4", "sir", "io4@police.com", "097987345", stationDao.findById(2L).get());
//		ioDao.save(io);
//		  io = new InvestigatingOfficer("io5", "ma'am", "io5@police.com", "0923894681", stationDao.findById(2L).get());
//		ioDao.save(io);
//
//		io = new InvestigatingOfficer("io6", "sir", "io6@police.com", "3124", stationDao.findById(3L).get());
//		ioDao.save(io);
//		io = new InvestigatingOfficer("io7", "ma'am", "io7@police.com", "98234", stationDao.findById(3L).get());
//		ioDao.save(io);


	}


}

package com.app;

import com.app.daos.CitizenDAO;
import com.app.daos.ComplaintDAO;
import com.app.daos.PoliceStationDao;
import com.app.entities.Complaint;
import com.app.entities.PoliceStation;
import com.app.entities.end_users.Citizen;
import com.app.exception.NoSuchEntityExistsException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class ComplaintDaoTest {

    @Autowired
    private ComplaintDAO complaintDAO;

    @Autowired
    private PoliceStationDao policeStationDao;

    @Autowired
    private CitizenDAO citizenDAO;

    @Test
    void insertComplaint(){
        PoliceStation ps1 = policeStationDao.findById(1L).orElseThrow(()->new NoSuchEntityExistsException("Police station with id does not exist"));
        Citizen citizen1 =  citizenDAO.findById(1L).orElseThrow(()->new NoSuchEntityExistsException("Citizen with id does not exist"));
        PoliceStation ps2 = policeStationDao.findById(2L).orElseThrow(()->new NoSuchEntityExistsException("Police station with id does not exist"));
        Citizen citizen2 =  citizenDAO.findById(2L).orElseThrow(()->new NoSuchEntityExistsException("Citizen with id does not exist"));
        List<Complaint> complaints = new ArrayList<>();
        complaints.add(new Complaint("Iphone is lost", LocalDate.parse("2022-10-19"), "Chitransh", ps1, "Hinjewadi", "Praneet", "aaaaa", false, citizen1));
        complaints.add(new Complaint("Car is stolen", LocalDate.parse("2021-11-18"), "Amar", ps1, "Hinjewadi", "Chitransh", "bbbbb", false, citizen2));
        complaints.add(new Complaint("Wallet stolen", LocalDate.parse("2020-08-20"), "Rahil", ps2, "Hinjewadi", "Akshat", "cccccc", false, citizen1));
        complaints.add(new Complaint("soul stolen", LocalDate.parse("2023-09-20"), "Sahil", ps2, "Hinjewadi", "A bird", "sad", false, citizen1));


        complaintDAO.saveAll(complaints);
    }
}

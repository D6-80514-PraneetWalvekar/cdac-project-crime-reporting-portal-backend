package com.app.entities;

import com.app.entities.end_users.InvestigatingOfficer;
import com.app.entities.enums.Status;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class FirstInformationReport extends BaseEntity{

    @JoinColumn(name = "complaint_id")
    @OneToOne
    Complaint complaint;

    @JoinColumn (name = "io_id")
    @ManyToOne
    private InvestigatingOfficer investigatingOfficer;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Status status;
}

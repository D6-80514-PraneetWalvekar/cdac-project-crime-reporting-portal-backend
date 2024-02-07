package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="policeStation")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"ioOfficers"})
@AllArgsConstructor
public class policeStation extends BaseEntity {

	@Column(length = 25)
	private String location;
	@Column(length = 25)
	private String district;
	@Column(length = 6)
	private String pinCode;
	@OneToMany(mappedBy = "station" )
	private List<OfficerDetails> ioOfficers = new ArrayList<OfficerDetails>();
	
}

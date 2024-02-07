package com.app.entities.end_users;
import javax.persistence.*;

import com.app.entities.enums.Gender;
import com.app.entities.enums.Title;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Enumerated(EnumType.STRING)
	@Column(length = 5)
	private Title title;

	@Column(length = 25,nullable = false)
	private String fName;

	@Column(length = 25,nullable = false)
	private String lName;

	@Column(nullable = false)
	private int age;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate DoB;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Gender gender;

	@Column(length = 30,nullable = false, unique = true)
	private String email;

	@Column(length = 30, nullable = false)
	private String password;

	@Column(length = 12 ,nullable = false , unique = true)
	private String mobileNo;
}

package com.app.entities.end_users;

import com.app.entities.enums.GenderEnum;
import com.app.entities.enums.TitleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@MappedSuperclass
public class BaseEntityUsers {

        @javax.persistence.Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long Id;

        @Enumerated(EnumType.STRING)
        @Column(length = 5)
        private TitleEnum title;

        @Column(length = 25,nullable = false)
        private String fName;

        @Column(length = 25,nullable = false)
        private String lName;

        @Column(nullable = false)
        private Integer age;

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate DOB;

        @Enumerated(EnumType.STRING)
        @Column(length = 10)
        private GenderEnum gender;

        @Column(length = 30,nullable = false, unique = true)
        private String email;

        @Column(length = 30, nullable = false)
        private String password;

        @Column(length = 12 ,nullable = false , unique = true)
        private String mobileNo;

        
		public BaseEntityUsers(TitleEnum title, String fName, String lName, int age,
				String gender, String email, String password, String mobileNo,String dob)
		{
			
			this.title = title;
			this.fName = fName;
			this.lName = lName;
			this.age = age;
			DOB = LocalDate.parse(dob);
			this.gender = GenderEnum.valueOf(gender);
			this.email = email;
			this.password = password;
			this.mobileNo = mobileNo;
		}
        
        
}



package com.mypet.web.person;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name= "PERSON",
uniqueConstraints={
	@UniqueConstraint(
		columnNames={"USERID"}
	)
})
@Component
@NoArgsConstructor(access= AccessLevel.PUBLIC)
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "ID", nullable=false) private Long id;
	@Column(name= "USERID",length = 64, nullable=false) private String userid;
	@Column(name= "PASSWD",length = 64, nullable=false) private String passwd;
	@Column(name= "NAME",length = 64, nullable=false) private String name;
	@Temporal(TemporalType.DATE)
	@Column(name= "BIRTHDAY", nullable=false) private Date birthday;
	@Column(name ="MALE", nullable=false) private boolean male;
	@Column(name ="HAK") private int hak;
	@Column(name ="BAN") private int ban;
	@Column(name="SCORE") private int score;
	@Column(name = "ROLE", nullable=false) private String role;
	enum Level{HIGH, MID, LOW}
}

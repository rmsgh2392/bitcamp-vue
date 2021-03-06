package com.mypet.web.person;
import java.util.Date;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data @Component @Lazy
public class PersonDTO {
	 private Long id;
	 private String userid;
	 private String passwd;
	 private String name;
	 private Date birthday;
	 private boolean male;
	 private int hak;
	 private int ban;
	 private int score;
	 private String role;
}

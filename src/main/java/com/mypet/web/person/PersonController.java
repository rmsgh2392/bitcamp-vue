package com.mypet.web.person;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypet.web.proxy.Box;
import com.mypet.web.proxy.Trunk;
import com.mypet.web.util.Printer;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class PersonController {
	@Autowired private PersonRepository personRepository;
	@Autowired private Person person;
	@Autowired
	Trunk<Object> trunk;
	@Autowired
	Box<Object> box;
	@Autowired
	private Printer printer;
	@Autowired
	ModelMapper modelMapper;//json하고 연결되는 메퍼
	@Bean
	public ModelMapper modelMapper() {return new ModelMapper();}
	@Autowired
	private PersonService personService;
	@RequestMapping("/")
	public String index() {
		Iterable<Person> all = personRepository.findAll();
		StringBuilder sb = new StringBuilder();
		all.forEach(p -> sb.append(p.getName() + " "));
		return sb.toString();
	}
	@PostMapping("/join")
	public void join(@RequestBody Person param){
		printer.accept("회원가입 진입 !!!");
		printer.accept("회원가입 아이디" +param.getUserid());
		personRepository.save(param);
	}
	@DeleteMapping("/withdraw/{userid}")
	public void withdraw(@PathVariable String userid){
		printer.accept("회원탈퇴 진입");
		printer.accept("넘어온 아이디 "+ userid);
		personRepository.delete(personRepository.findByUserid(userid));
//		trunk.put(Arrays.asList("msg"), Arrays.asList("success"));
//		return trunk.get();
	}
	@PutMapping("/modify")
	public HashMap<String, Object> update(@RequestBody Person param) {
		printer.accept("수정진입!!");
		personRepository.save(param);
		trunk.put(Arrays.asList("msg","data"), Arrays.asList("success",personRepository.findByUseridAndPasswd(param.getUserid(), param.getPasswd())));
		return trunk.get();
	}
	@GetMapping("/students")
	public List<PersonDTO> list(){
		//jpa에 있는 엔티티를 자바의 포조 맵으로 바꾸는 법
		//jpa는 iterable 로 엔티티를 사용한다 !
		Iterable<Person> entites = personRepository.findAll();
//		Iterable <Person> entites=personRepository.findByRole("student"); 성조씨
		List<PersonDTO> list = new ArrayList<>();
		for(Person p : entites) {
			PersonDTO dto = modelMapper.map(p, PersonDTO.class);
			list.add(dto);
		}
		List<PersonDTO> list1 = new ArrayList<>();
		list1 = list.stream().filter(t->t.getRole().equals("student")).collect(Collectors.toList());
//		return  list.stream().filter(role-> role.getRole().equals("student")); 위에 리턴값 Stream 가람씨
		return list1;
	}
	@GetMapping("/students/{hak}")
	public List<PersonDTO> findHak(@PathVariable String hak){
		List<PersonDTO> list = new ArrayList<>();
		Iterable<Person> entity = personRepository.findGroupByHak();
		for(Person p : entity) {
			PersonDTO dto = modelMapper.map(p, PersonDTO.class);
			if(p.getHak() == Integer.parseInt(hak)) {
				list.add(dto);
				break;
			}
		}
		return list;
	}
	@GetMapping("/students/search/{searchWord}")
	public Object findSome(@PathVariable String searchWord){
		printer.accept("조건 검색 진입 !!!");
//		List<PersonDTO> list = new ArrayList<>();
//		Iterable<Person> entity = personRepository.findAll();
		switch (searchWord) {
		case "namesOfStudents": return personService.namesOfStudents();
		case "streamToArray":return personService.streamToArray();
		case "streamToMap":return personService.streamToMap();
		case "theNumberOfStudents":return personService.theNumberOfStudents();
		case "totalScore":return personService.totalScore();
		case "topStudent":return personService.topStudent();
		case "getStat":return personService.getStat();
		case "nameList":return personService.nameList();
		case "partioningBy":return personService.partioningByGender(true);
		case "partioningCountPerGender":return personService.partioningCountPerGender(true);
		case "partioningTopPerGender":return personService.partioningTopPerGender(true);
		case "partioningRejectPerGender":return personService.partioningRejectPerGender(true);
		case "groupingByBan":return personService.findByHak();
		case "groupingByGrade":return personService.groupByGrade();
		case "groupingByCountByLevel":return personService.personCountByLevel();
		case "groupingByHakAndBan":return personService.multiGrouping();
		case "groupingTopByHakAndBan":return personService.multiGroupingMax();
		case "groupingByStat":return personService.multiGroupingGrade();
		}
		return null;
	}
	@PostMapping("/login")
	public HashMap<String,Object> login(@RequestBody Person param) {
		HashMap<String,Object> map = new HashMap<>();
		printer.accept("로그인 진입 !!");
		printer.accept(String.format("ID : %s", param.getUserid()+""));
		printer.accept(String.format("PASSWD : %s", param.getPasswd()+""));
		person = personRepository.findByUseridAndPasswd(param.getUserid(), param.getPasswd());
//		trunk.put(Arrays.asList("msg","person"), Arrays.asList("success",person));
		if(person != null) {
			printer.accept("로그인성공");
			map.put("msg", "success");
			map.put("person", person);
		}else {
			printer.accept("로그인 실패");
			map.put("msg", "fail");
			map.put("person", person);
		}
		return map;
	}
}

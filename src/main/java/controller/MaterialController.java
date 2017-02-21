package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Material;
import model.MaterialDao;
import model.Person;

@RestController
public class MaterialController {
	@RequestMapping("/test")
	public String hello(@RequestParam(value = "name", defaultValue = "Default") String name) {
		return "{\"id\":\"Is this my new home?\"}";
	}
	
	@RequestMapping("/person")
	public Person person(@RequestParam(value="name", defaultValue="Default") String name) {
		Person person = new Person();
		person.setId(1);
		person.setName("Tuomas");
		return person;		
	}
	
	@RequestMapping("/persons")
	public ArrayList<Person> persons(@RequestParam(value="name", defaultValue="Default") String name) {
		// Create an empty list and fill it up
		ArrayList<Person> persons = new ArrayList<Person>();
		Person person = new Person();
		Person person2 = new Person();
		
		person.setId(1);
		person.setName("Tuomas");
		persons.add(person);
		
		person2.setId(2);
		person2.setName("Jaakko");
		persons.add(person2);
		
		return persons;		
	}
	
	@RequestMapping("/personbyid")
	public Person personById(@RequestParam(value="id", defaultValue="1") int id) {
		return null;		
	}
	
	@RequestMapping("/materials")
	public List<Material> materials(@RequestParam(value="name", defaultValue="Default") String name) {
		MaterialDao dao = new MaterialDao();
		dao.init();		
		return dao.getDaos();
	}
	
	@RequestMapping("/materialsbyname")
	public List<Material> materialsByName(@RequestParam(value="name", defaultValue="Default") String name) {
		MaterialDao dao = new MaterialDao();
		dao.init();		
		List<Material> material = dao.getDaos();
		// Otetaan listalta pois ei name:lla alkavat
		for (Iterator<Material> iter = material.listIterator(); iter.hasNext(); ) {
		    Material a = iter.next();
		    if (!a.getName().substring(0, name.length()).equals(name)) {
		        iter.remove();
		    }
		}
		return material;
	}
}













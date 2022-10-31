package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programminglanguages")
public class LanguagesController {

	private final LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
	
		this.languageService = (LanguageService) languageService;
	}

	@GetMapping("/getall")
	public List<ProgrammingLanguage> getall() {
		return languageService.getAll();
	} 

	@GetMapping("/{id}")
	public ProgrammingLanguage getById(@PathVariable int id) {
		return languageService.getById(id);
	}

	@PostMapping("/")
	public void add(@RequestBody ProgrammingLanguage programmingLanguage) {
		languageService.add(programmingLanguage);
	}

	@PutMapping("/{id}")
	public void update(@RequestBody ProgrammingLanguage programmingLanguage, @PathVariable int id) {
		languageService.update(programmingLanguage, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		languageService.delete(id);
	}
}

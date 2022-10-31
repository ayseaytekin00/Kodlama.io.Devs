package Kodlama.io.Devs.business.abstracts;

import java.util.List;


import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface LanguageService {
	public List<ProgrammingLanguage> getAll();

	public ProgrammingLanguage getById(int id);

	public void add(ProgrammingLanguage language);

	public void delete(int id);

	public void update(ProgrammingLanguage language, int id);
	
	//AĞAĞAĞĞAĞAĞAĞAĞA
}

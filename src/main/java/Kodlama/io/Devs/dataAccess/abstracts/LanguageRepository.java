package Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface LanguageRepository {

	public List<ProgrammingLanguage> getAll();

	public ProgrammingLanguage getById(int id);

	public void add(ProgrammingLanguage language);

	public void delete(int id);

	public void update(ProgrammingLanguage language, int id);

	 

}

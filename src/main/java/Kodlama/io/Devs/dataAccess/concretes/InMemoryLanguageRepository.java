package Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

	private List<ProgrammingLanguage> languages;

	public InMemoryLanguageRepository() {
		languages = new ArrayList<ProgrammingLanguage>();
		languages.add(new ProgrammingLanguage(1, "C#"));
		languages.add(new ProgrammingLanguage(2, "Java"));
		languages.add(new ProgrammingLanguage(3, "Python"));

	}

	@Override
	public List<ProgrammingLanguage> getAll() {

		return languages;
	}

	@Override
	public void add(ProgrammingLanguage language) {
		languages.add(language);

	}

	@Override
	public ProgrammingLanguage getById(int id) {
		for (ProgrammingLanguage language : languages) {
			if (language.getId() == id)
				return language;

	}
		return null;
	}

	@Override
	public void delete(int id) {
		ProgrammingLanguage language =getById(id);
		languages.remove(language);

	}

	@Override
	public void update(ProgrammingLanguage language, int id) {
		ProgrammingLanguage updateLanguage = getById(id);
		updateLanguage.setName(language.getName());

	}

}

package Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
@Service
public class LanguageManager implements LanguageService {

	LanguageRepository languageRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {

		this.languageRepository = languageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {

		return languageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) {

		return languageRepository.getById(id);
	}

	@Override
	public void add(ProgrammingLanguage language) {
		if (checkLanguageNameValid(language))
			throw new RuntimeException("Programlama Dili Boş Geçilemez ! ");

		if (isLanguageExists(language))
			throw new RuntimeException("Zaten Programlama dili mevcut.");
		languageRepository.add(language);

	}

	@Override
	public void delete(int id) {
		languageRepository.delete(id);
	}

	@Override
	public void update(ProgrammingLanguage language, int id) {
		if (checkLanguageNameValid(language))
			throw new RuntimeException("Programlama Dili Boş Geçilemez ! ");

		if (isLanguageExists(language))
			throw new RuntimeException("Zaten Programlama dili mevcut.");
		languageRepository.update(language, id);

	}

	public boolean checkLanguageNameValid(ProgrammingLanguage language) {
		return language.getName().isEmpty() || language.getName().isBlank();
	}

	public boolean isLanguageExists(ProgrammingLanguage language) {
		return languageRepository.getAll().stream().anyMatch(x -> x.getName().equals(language.getName()));
	}

}
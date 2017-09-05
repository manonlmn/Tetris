package com.sopra.dao;

import com.sopra.model.Language;

public interface ILanguageDAO extends IDAO<Language> {
	
	public Language searchByCode(String code);

}

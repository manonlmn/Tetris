package com.sopra.dao;

import java.util.List;

import com.sopra.model.FAQ;

public interface IFAQDAO extends IDAO<FAQ> {
	List<FAQ> listByLanguage(String lang);
}

package com.sopra.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.dao.IFAQDAO;
import com.sopra.model.FAQ;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/faq/{lang}")
public class FaqRestController {

	@Autowired private IFAQDAO faqDAO;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<FAQ>> getAll(@PathVariable String lang){
		List<FAQ> listFAQ = this.faqDAO.listByLanguage(lang);	
		return new ResponseEntity<List<FAQ>>(listFAQ, HttpStatus.OK);
	}
	
}

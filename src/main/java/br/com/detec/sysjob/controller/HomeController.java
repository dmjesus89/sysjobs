package br.com.detec.sysjob.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.detec.sysjob.dao.h2.ProfileDAO;
import br.com.detec.sysjob.entity.ProfileEntity;

@RestController
//@CrossOrigin("${origin-allow}")
public class HomeController {

	@Autowired
	private MessageSource msg;

	@Autowired
	ProfileDAO repository;

//	@GetMapping
//	public String hello(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
//		return msg.getMessage("msg.hello", null, locale);
//	}

	@RequestMapping("/profilesx")
	public String process() {
		repository.save(new ProfileEntity("ADMIN"));
		return "Done";
	}

}

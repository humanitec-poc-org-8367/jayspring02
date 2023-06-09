package de.clearco.springify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	@Autowired
	VisitorRepository visitorRepository;

	@GetMapping(value = {"/greeting", "/"})
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("visitors", visitorRepository.findAll());
		Visitor visitor = new Visitor(name);
		visitorRepository.save(visitor);
		return "greeting";
	}

}
package bg.jwd.intern.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.intern.entities.OutgoingCall;
import bg.jwd.intern.entities.Phonebook;
import bg.jwd.intern.services.PhonebookService;

@Controller
public class PhonebookController {

	@Autowired
	private PhonebookService phonebookService;

	@RequestMapping(value = "/PhonebookRegistry", method = RequestMethod.GET)
	public String getPhonebook(Model model) {
		model.addAttribute("Phonebooks", phonebookService.phonebooks());
		return "PhonebookRegistry";
	}

	@RequestMapping(value = "/addPerson", method = RequestMethod.GET)
	public String addPerson() {
		return "addPerson";
	}

	@RequestMapping(value = "/addPersonSave", method = RequestMethod.POST)
	public String addPersonSave(Model model, @ModelAttribute(value = "SpringWeb") Phonebook phonebook) {
		if (phonebook.getFirstLetters(phonebook.getNumber()) == null) {
			return "error";
		}
		phonebookService.adding(phonebook);

		model.addAttribute("Phonebooks", phonebookService.phonebooks());

		return "PhonebookRegistry";
	}

	@RequestMapping(value = "/removePerson", method = RequestMethod.GET)
	public String removePerson() {
		return "removePerson";
	}

	@RequestMapping(value = "/removePersonSave", method = RequestMethod.GET)
	public String removePersonSave(Model model, String name) {

		if (phonebookService.removing(name)) {
			phonebookService.removing(name);
			model.addAttribute("Phonebooks", phonebookService.phonebooks());

			return "PhonebookRegistry";
		} else
			return "error";
	}

	@RequestMapping(value = "/readFromFile", method = RequestMethod.GET)
	public String eadingFile() {
		return "readFromFile";
	}

	@RequestMapping(value = "/readFromFileSave", method = RequestMethod.GET)

	public String readingFileSave(Model model, String name) {

		phonebookService.textFilePhoneBook(name);
		model.addAttribute("Phonebooks", phonebookService.phonebooks());

		return "PhonebookRegistry";
	}

	@RequestMapping(value = "/calling", method = RequestMethod.GET)
	public String call() {

		return "call";
	}

	@RequestMapping(value = "/callSave", method = RequestMethod.POST)

	public String callSave(Model model, @ModelAttribute(value = "SpringWeb") OutgoingCall call) {
		if (phonebookService.callNumber(call)) {
		
			model.addAttribute("outgoingCalls", phonebookService.outgoingCalls());

			return "outgoingcalls";
		} else
			return "error";

	}

}

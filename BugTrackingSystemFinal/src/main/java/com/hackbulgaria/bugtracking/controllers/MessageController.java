package com.hackbulgaria.bugtracking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hackbulgaria.bugtracking.constant.UrlConstants;
import com.hackbulgaria.bugtracking.entities.Message;
import com.hackbulgaria.bugtracking.services.MessageService;

@Controller
public class MessageController {
	@Autowired
	private MessageService msgService;
	
	@RequestMapping(value = UrlConstants.WHITE_BOARD, method = RequestMethod.GET)
	public String getMessages(Model model){
		model.addAttribute("Messages",msgService.getMessages());
		return "whiteBoard";
	}
	
	@RequestMapping(value = UrlConstants.ADD_WHITE_BOARD, method = RequestMethod.GET)
	public String addMessage(){
		return "addWhiteBoard";
	}
	
	
	@RequestMapping(value = UrlConstants.ADD_WHITE_BOARD_SAVE, method = RequestMethod.POST)
	public String addMessageSave(Model model, @ModelAttribute(value= "SpringWeb") Message msg){
		msgService.addMessage(msg);
		model.addAttribute("Messages", msgService.getMessages());
		return "redirect:/whiteBoard";
	}
	
	@RequestMapping(value = UrlConstants.REMOVE_WHITE_BOARD, method = RequestMethod.GET)
	public String removeMessage(){
		return "removeWhiteBoard";
	}
	
	@RequestMapping(value = UrlConstants.REMOVE_MESSAGE_SAVE, method = RequestMethod.POST)
	public String removeMessageSave(Model model, String id){
		msgService.removeMessage(Integer.parseInt(id));
		model.addAttribute("Messages",msgService.getMessages());
		return "redirect:/whiteBoard";
	}
	
	
}

//@RequestMapping(value = UrlConstants.REMOVE_DEV_SAVE_URL, method = RequestMethod.GET)
//public String removeDeveloperSave(Model model, String id) {
//
//	if (devService.deleteDeveloper(Integer.parseInt(id))) {
//		devService.deleteDeveloper(Integer.parseInt(id));
//		model.addAttribute("Devs", devService.getDevelopers());
//
//		return "DevsRegistry";
//	} else
//		return "error";
//}

//@Autowired
//private DeveloperService devService;
//
//@RequestMapping(value = UrlConstants.HOME, method = RequestMethod.GET)
//public String getHome(Model model) {
//	return "home";
//}
//
//@RequestMapping(value = UrlConstants.DEVS_REGISTER_URL, method = RequestMethod.GET)
//public String getDevelopers(Model model) {
//	model.addAttribute("Devs", devService.getDevelopers());
//	return "developers";
//}
//
//@RequestMapping(value = UrlConstants.ACTIONS_URL, method = RequestMethod.GET)
//public String addDev() {
//	return "actionsDeveloper";
//}
//
//@RequestMapping(value = UrlConstants.ADD_DEV_SAVE_URL, method = RequestMethod.GET)
//public String addDeveloper() {
//	return "add_developer";
//}
//
//@RequestMapping(value = UrlConstants.ADD_DEV_SAVE_URL, method = RequestMethod.POST)
//public String addDeveloperSave(Model model, @ModelAttribute(value = "SpringWeb") Developer dev) {
//	devService.addDeveloper(dev);
//
//	model.addAttribute("Devs", devService.getDevelopers());
//
//	return "actionsDeveloper";
//}
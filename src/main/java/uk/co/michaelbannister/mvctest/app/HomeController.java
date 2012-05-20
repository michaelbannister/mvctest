package uk.co.michaelbannister.mvctest.app;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {

        model.addAttribute("message", "displaying form");

        MyCommand command = new MyCommand();
        command.setMyValue("value ok");

        model.addAttribute(command);

        return "home";
    }

    
    
    @RequestMapping(value = "/", method = RequestMethod.POST, params = "model")
    public String postWithSpringProvidedModel(@Valid @ModelAttribute MyCommand command, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            result.reject("haha", "has errors");
        } else {
            result.reject("haha", "has no errors");
        }

        return "home";
    }

    
    @RequestMapping(value = "/", method = RequestMethod.POST, params = "modelNewCommand")
    public String postWithSpringProvidedModelAndCreateNewCommand(@Valid @ModelAttribute MyCommand command, BindingResult result, ModelMap model) {

        MyCommand newCommand = new MyCommand();
        newCommand.setMyValue(command.getMyValue());

        if (result.hasErrors()) {
            result.reject("haha", "has errors");
        } else {
            result.reject("haha", "has no errors");
        }
        model.addAttribute("myCommand", newCommand);
        
        return "home";
    }


    @RequestMapping(value = "/", method = RequestMethod.POST, params = "mav")
    public ModelAndView post(@Valid @ModelAttribute MyCommand command, BindingResult result) {

        ModelAndView mav = new ModelAndView("home");
        if (result.hasErrors()) {
            result.reject("haha", "has errors");
        } else {
            result.reject("haha", "has no errors");
        }
        return mav;
    }


    @RequestMapping(value = "/", method = RequestMethod.POST, params = "mavNewCommand")
    public ModelAndView postAndReturnNewCommand(@Valid @ModelAttribute MyCommand command, BindingResult result) {

        ModelAndView mav = new ModelAndView("home");
        MyCommand newCommand = new MyCommand();
        newCommand.setMyValue(command.getMyValue());

        if (result.hasErrors()) {
            result.reject("haha", "has errors");
        } else {
            result.reject("haha", "has no errors");
        }
        mav.addObject("myCommand", newCommand);
        return mav;
    }

    
    @RequestMapping(value = "/", method = RequestMethod.POST, params = "mavReaddCommand")
    public ModelAndView postAndReturnReinitialisedCommand(@Valid MyCommand command, BindingResult result) {

        ModelAndView mav = new ModelAndView("home");

        if (result.hasErrors()) {
            result.reject("haha", "has errors");
        } else {
            result.reject("haha", "has no errors");
        }
        mav.addObject(command);
        return mav;
    }

}

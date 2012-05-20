package uk.co.michaelbannister.mvctest.app;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;

import org.codehaus.groovy.control.CompilationFailedException;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/script")
public class ScriptController {
	
	@Autowired
	private ApplicationContext ctx;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String display(Model model) {
		return "script";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String run(Model model, @RequestParam("scriptInput") String input) throws UnknownHostException, IOException {
		
		model.addAttribute("scriptInput", input);
		
		ByteArrayOutputStream outData = new ByteArrayOutputStream(1024);
		PrintWriter outPrintWriter = new PrintWriter(outData);

		Binding binding = new Binding();
		binding.setVariable("ctx", ctx);
		binding.setVariable("out", outPrintWriter);
		
		CompilerConfiguration config = new CompilerConfiguration();
		config.setOutput(outPrintWriter);
		
		GroovyShell shell = new GroovyShell(binding, config);
		
		
		try {
			Object val = shell.evaluate(input);
			outPrintWriter.flush();
			
			model.addAttribute("scriptOutput", outData.toString());
			model.addAttribute("returnValue", val == null ? "null" : val.toString());
		}
		catch (CompilationFailedException e) {
			model.addAttribute("exception", e);
		}
		
		return "script";
	}
	
}

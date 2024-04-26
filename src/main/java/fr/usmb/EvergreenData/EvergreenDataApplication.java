package fr.usmb.EvergreenData;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class EvergreenDataApplication {
    public static void main(String[] args) {
      SpringApplication.run(EvergreenDataApplication.class, args);
    }
    @GetMapping("/hello")
    public String hello(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
    	model.addAttribute("name", name);
    	System.out.println(name);
    	return "hello";
    	//return String.format("Hello %s!", name);
    }
    
    @GetMapping("/envoiQuestion")
    public String envoiQuestion() {
    	return "formEnvoiQuestion";
    }
    
    @PostMapping(value = "/addQuestion", params = {"question"})
    public String addQuestion(@RequestParam(name="question", required=true, defaultValue="?") String question, Model model) {
    	model.addAttribute("question", question);
    	System.out.println(question);
    	return "redirect:/envoiQuestion";
    }
}
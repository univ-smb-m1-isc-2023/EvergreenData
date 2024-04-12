package fr.usmb.EvergreenData;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EvergreenDataApplication {
    public static void main(String[] args) {
      SpringApplication.run(EvergreenDataApplication.class, args);
    }
    @GetMapping("/hello")
    public String hello(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
    	model.addAttribute("name", name);
    	return "hello";
    	//return String.format("Hello %s!", name);
    }
}
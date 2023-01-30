package ru.bsa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.bsa.models.Human;
import ru.bsa.services.HumanMethods;

@Controller
public class MainController {
    @Autowired
    private HumanMethods humanMethods;

    public MainController(HumanMethods humanMethods) {
        this.humanMethods = humanMethods;
    }
    @GetMapping("/")
    public String main(){
       return "redirect:/addHuman";
    }
    @GetMapping("/addHuman")
    public String humanForms() {
        return "addHuman";
    }
    @PostMapping("/addHuman")
    public String addHuman(@RequestParam("name") String name,
                                  @RequestParam ("email") String email,
                                  @RequestParam("value") String value) {
       if (name.equals("")||email.equals("")) return "form";
       Human human = Human.builder()
                .name(name)
                .email(email)
                .build();

       humanMethods.save(human);
       Human humanClone = (Human) human.clone();
       if (value.equals("1")) humanMethods.save(humanClone);

       return "addHuman";
    }
    @GetMapping("/showBDHuman")
    public String showBD(Model model) {
        model.addAttribute("humans", humanMethods.listAll());
        return "showBDHuman";
    }
    @GetMapping("/deleteHuman")
    public String deleteHuman(@RequestParam(value = "id") Long id) {
        humanMethods.delete(id);
        return "deleteHuman";
    }
}

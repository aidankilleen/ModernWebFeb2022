package ie.pt.httpstestwebapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("")
    public String home(Model model) {

        List<User> users = userRepository.findAll();

        model.addAttribute("users", users);
        return "index";
    }
}

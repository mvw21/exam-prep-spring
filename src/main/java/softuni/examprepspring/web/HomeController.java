package softuni.examprepspring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.examprepspring.service.ItemService;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    /*
    @GetMapping("/")
    public String index(HttpSession httpSession){
        return httpSession.getAttribute("user") == null
        ? "index" : "home";
    }
    */

    private final ItemService itemService;

    public HomeController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public ModelAndView index(HttpSession httpSession,ModelAndView modelAndView){
       if(httpSession.getAttribute("user") == null){  //ако юзера не е логнат
           modelAndView.setViewName("index");
       }else{  //ако юзъра е логнат
            modelAndView.addObject("items",this.itemService.findAllItems());
            modelAndView.setViewName("home");
       }

        return modelAndView;

    }

}

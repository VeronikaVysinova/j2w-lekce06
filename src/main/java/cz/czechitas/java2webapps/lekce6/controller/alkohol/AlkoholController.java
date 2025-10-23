package cz.czechitas.java2webapps.lekce6.controller.alkohol;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

/**
 *
 */
@Controller
@RequestMapping("/alkohol")
public class AlkoholController {
    private final Random random = new Random();

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/alkohol/formular");
        modelAndView.addObject("form", new AlkoholForm());
        return modelAndView;
    }

    @PostMapping("")
    public Object form(@Valid @ModelAttribute("form") AlkoholForm form, BindingResult bindingResult) { //bindingResult - tam se ulozi zadana data
/*
    if (form.getVek() < 18) {
      return "/alkohol/nizky-vek";
    }
*/

        if (bindingResult.hasErrors()) { //metoda, ktera rika, jestli tam jsou chyby. Kdyz ano, zobrazi se znovu ten formular a zobrazi ty chyby v okne s formularem
            return "/alkohol/formular"; //nemam databazi, tak pouzivam zobrazeni stranky s vysledkem, ale mela bych pouzivat redirect
        }

        return new ModelAndView("/alkohol/objednano")  //vracim hodnoty rovnou z formulare ale do budoucna budeme hodnoty vracet z databaze
                .addObject("kod", Math.abs(random.nextInt()))
                .addObject("email", form.getEmail());
    }
}

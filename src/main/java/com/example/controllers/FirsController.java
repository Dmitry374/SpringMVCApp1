package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/first")
public class FirsController {

    private static final String MULTIPLICATION = "multiplication";
    private static final String ADDITION = "addition";
    private static final String SUBTRACTION = "subtraction";
    private static final String DIVISION = "division";

    /**
     * Если в мктод GET не передать параметры
     * возникнет ошибка
     * чтобы этого избежать добавляем required = false
     */

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

//        System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculate(@RequestParam(value = "action", required = false) String action,
                            @RequestParam(value = "a", required = false, defaultValue = "0") int a,
                            @RequestParam(value = "b", required = false, defaultValue = "0") int b,
                            Model model) {

        double result = 0;

        if (action != null) {
            switch (action) {
                case MULTIPLICATION:
                    result = a * b;
                    break;
                case ADDITION:
                    result = a + b;
                    break;
                case SUBTRACTION:
                    result = a - b;
                    break;
                case DIVISION:
                    if (b != 0) {
                        result = (double) a / (double) b;
                    }
                    break;
            }

            model.addAttribute("calculate_result", "Result of " + action + " " + a + " and " + b + " is: " + result);
        } else {
            model.addAttribute("calculate_result", "Incorrect data");
        }

        return "calculator/calculator";
    }
}
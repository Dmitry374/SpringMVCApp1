package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/first")
public class FirsController {

    /*
     * Если в мктод GET не передать параметры
     * HttpServletRequest request будет равен null
     */

//    @GetMapping("/hello")
//    public String helloPage(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//
//        System.out.println("Hello, " + name + " " + surname);
//        return "first/hello";
//    }

    /**
     * Если в мктод GET не передать параметры
     * возникнет ошибка
     * чтобы этого избежать добавляем required = false
     */

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname) {

        System.out.println("Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
}
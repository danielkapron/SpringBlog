package com.example.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller                  // klasa mapująca żądania protokołu http
public class BlogController {
    @GetMapping("/")        // na adresie URL localhost:8080/
    public String home(){   // wywoływana jest metoda zwracająca String
        // implementacja ???
        return "blog";      // wartością zwracaną jest nazwa szablony Thhymeleaf
                            // -> domyślna lokalizacja to resources/templates
                            // -> nie dopisujemy rozszerzenia .html
    }
}

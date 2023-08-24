package com.hellokoding.springboot.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    /**
     * http://localhost:9000
     * http://localhost:9000/hello
     * http://localhost:9000/hello?name=sonu
     * @param model
     * @param name
     * @return
     */
    @GetMapping({"/", "/hello"})
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    /**
     * http://localhost:9000/json/sonu
     * @param name
     * @return
     */
    @GetMapping("/json/{name}")
    @ResponseBody
    public String json(@PathVariable String name) {
        return "hello:"+name;
    }
}

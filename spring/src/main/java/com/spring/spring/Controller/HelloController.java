package com.spring.spring.Controller;


import com.sun.source.tree.ReturnTree;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "황승열");
        return "hello";
//        hello.html에 데이터 전송 후 hello.html을 다시 반환 함
//        return값이 hello.html 파일 선택하는 것
    }

    @GetMapping("hello-mvc")
    public String hello(@RequestParam(value = "name", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "aaaa";
        }


    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;

    }
        static class Hello{
            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
}

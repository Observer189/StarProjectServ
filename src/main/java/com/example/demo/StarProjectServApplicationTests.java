package com.example.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class StarProjectServApplicationTests extends HttpServlet {
    @RequestMapping("/sash")
    public String index(HttpServletRequest request, HttpServletResponse response) {
    
            String lastname = request.getParameter("lastname");
            String firstname = request.getParameter("firstname");
            firstname = firstname.substring(0, 1);
            return lastname + " " + firstname + ".";
       
    }
}

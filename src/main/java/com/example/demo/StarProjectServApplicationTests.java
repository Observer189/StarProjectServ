package com.example.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class StarProjectServApplicationTests extends HttpServlet {
	public static Integer battleNumber;
    @RequestMapping("/sash")
    public Coord index(HttpServletRequest request, HttpServletResponse response) {
    
            String x = request.getParameter("x");
            String y = request.getParameter("y");
            //Coord coord=new Coord(Integer.valueOf(x),Integer.valueOf(y));
            Coord coord=new Coord(Integer.valueOf((int)(Math.random()*800+1)),Integer.valueOf((int)(Math.random()*800+1)));
            return coord;
       
    }
    @RequestMapping("/battle")
    public Coord createBattle(HttpServletRequest request, HttpServletResponse response)
    {
    	if(battleNumber==null)battleNumber=0;
    	else battleNumber++;
    	Coord coord=new Coord(battleNumber,400);
    	return coord;
    }
}

package com.example.demo;

import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class StarProjectServApplicationTests extends HttpServlet {
	public static Integer battleNumber;
	public ArrayList<String> waitQueue;
    @RequestMapping("/sash")
    public Coord index(HttpServletRequest request, HttpServletResponse response) {
    
            String x = request.getParameter("x");
            String y = request.getParameter("y");
            //Coord coord=new Coord(Integer.valueOf(x),Integer.valueOf(y));
            Coord coord=new Coord(Integer.valueOf((int)(Math.random()*800+1)),Integer.valueOf((int)(Math.random()*800+1)));
            return coord;
       
    }
    @RequestMapping("/battle")
    public BattleStatus createBattle(HttpServletRequest request, HttpServletResponse response)
    {
    	if(battleNumber==null)battleNumber=0;
    	else battleNumber++;
    	
    	return new BattleStatus(battleNumber,"some");
    }
    @RequestMapping("/battle/{battleNumber}")
    public Coord battle(HttpServletRequest request, HttpServletResponse response,@PathVariable("battleNumber")Integer number)
    {
    	Coord coord=new Coord(Integer.valueOf((int)(Math.random()*800+1)),Integer.valueOf((int)(Math.random()*800+1)));
        return coord;
    }
    
}

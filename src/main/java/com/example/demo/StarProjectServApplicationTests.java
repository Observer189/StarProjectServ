package com.example.demo;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class StarProjectServApplicationTests extends HttpServlet {
	public Integer battleNumber=0;
	public LinkedList<String> waitQueue=new LinkedList<String>();
	public boolean battleIsExist=false;
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
    	if(request.getParameter("status").equals("add"))
    	{
    		if(waitQueue.indexOf(request.getParameter("name"))==-1)
    		{
    		waitQueue.add(request.getParameter("name"));
    		}
    		return new BattleStatus(null,waitQueue.size(),"wait",null);
    	}
    	
    	if(request.getParameter("status").equals("wait"))
    	{
    		if((waitQueue.size()>1) || (battleIsExist))
    		{
    			if(waitQueue.get(0).equals(request.getParameter("name")))
    			{		
    			if(battleIsExist)
    			    {
    				waitQueue.remove(0);
    				battleIsExist=false;
    				battleNumber++;
    				return new BattleStatus(battleNumber-1,waitQueue.size(),"ready",1);
    			     }
    			else
    			     {
    				waitQueue.remove(0);
    				battleIsExist=true;
    				return new BattleStatus(battleNumber,waitQueue.size(),"ready",2);
    			      }
    			}
    			else return new BattleStatus(null,waitQueue.size(),"wait",null);
    			
    		}
    		else return new BattleStatus(null,waitQueue.size(),"wait",null);
    	}
    	
    	
    	
    	else { 
    		waitQueue.clear();
    		battleIsExist=false;
    		return new BattleStatus(null,waitQueue.size(),"clear",null);
    		}
    	
    }
    @RequestMapping("/battle/{battleNumber}")
    public Coord battle(HttpServletRequest request, HttpServletResponse response,@PathVariable("battleNumber")Integer number)
    {
        
    	Coord coord=new Coord(Integer.valueOf((int)(Math.random()*800+1)),Integer.valueOf((int)(Math.random()*800+1)));
        return coord;
    }
    
}

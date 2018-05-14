package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
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
    public HashMap<String,Coord> vectorTranslator = new HashMap<String,Coord>();
    static String name1;
    @RequestMapping("/battle")
    public BattleStatus createBattle(HttpServletRequest request, HttpServletResponse response)
    {
    	
    	if(request.getParameter("status").equals("add"))
    	{
    		if(waitQueue.indexOf(request.getParameter("name"))==-1)
    		{
    		waitQueue.add(request.getParameter("name"));
    		}
    		return new BattleStatus(null,waitQueue.size(),null,"wait",null);
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
    				return new BattleStatus(battleNumber-1,waitQueue.size(),name1,"ready",1);
    			     }
    			else
    			     {
    				name1=request.getParameter("name");
    				waitQueue.remove(0);
    				battleIsExist=true;
    				return new BattleStatus(battleNumber,waitQueue.size(),waitQueue.get(0),"ready",2);
    			      }
    			}
    			else return new BattleStatus(null,waitQueue.size(),null,"wait",null);
    			
    		}
    		else return new BattleStatus(null,waitQueue.size(),null,"wait",null);
    	}
    	
    	
    	
    	else { 
    		waitQueue.clear();
    		battleIsExist=false;
    		return new BattleStatus(null,waitQueue.size(),null,"clear",null);
    		}
    	
    }
    @RequestMapping("/battle/{battleNumber}")
    public Coord battle(HttpServletRequest request, HttpServletResponse response,@PathVariable("battleNumber")Integer number)
    {
    	
        vectorTranslator.put(request.getParameter("name"), 
        		new Coord(Float.valueOf(request.getParameter("x")),Float.valueOf(request.getParameter("y"))));
    			
    	if(vectorTranslator.containsKey(request.getParameter("enemyName")))
    	{
    	Coord coord=new Coord(vectorTranslator.get(request.getParameter("enemyName")));
        return coord;
    	}
    	else return new Coord(0f,0f);
    }
    @RequestMapping("/listen")
    public HashMap listen(HttpServletRequest request, HttpServletResponse response)
    {
    	return vectorTranslator;
    }
    
}

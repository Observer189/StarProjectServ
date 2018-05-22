package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class StarProjectServApplicationTests extends HttpServlet {
	public Integer battleNumber=0;
	public LinkedList<Player> waitQueue=new LinkedList<Player>();
	public boolean battleIsExist=false;
    public HashMap<String,Coord> vectorTranslator = new HashMap<String,Coord>();
    static String player1Name;
    static String ship1Name;
    
    @RequestMapping("/battle")
    public BattleStatus createBattle(@RequestParam(name="name")String name,@RequestParam(name="shipName")String shipName,
    		@RequestParam(name="status")String status)
    {
    	
    	switch(status) {
    	case "add":
    		for(Player i:waitQueue)
    		{
    		if(i.name.equals(name))
    		{
    			return new BattleStatus(null,waitQueue.size(),null,null,"wait",null);
    		}
    		}
    		waitQueue.add(new Player(name,shipName));
    		
    		
    	case "wait": 
    		if((waitQueue.size()>1) || (battleIsExist))
    		{
    			if(waitQueue.get(0).name.equals(name))
    			{		
    			if(battleIsExist)
    			    {
    				waitQueue.remove(0);
    				battleIsExist=false;
    				battleNumber++;
    				return new BattleStatus(battleNumber-1,waitQueue.size(),player1Name,ship1Name,"ready",1);
    			     }
    			else
    			     {
    				
    				player1Name=name;
    				ship1Name=shipName;
    				waitQueue.remove(0);
    				battleIsExist=true;
    				return new BattleStatus(battleNumber,waitQueue.size(),waitQueue.get(0).getName(),waitQueue.get(0).getShipName(),"ready",2);
    			      }
    			}
    			else return new BattleStatus(null,waitQueue.size(),null,null,"wait",null);
    			
    		}
    		else return new BattleStatus(null,waitQueue.size(),null,null,"wait",null);
    	   case "delete":
    		   for(Player i:waitQueue)
       		{
       		if(i.name.equals(name))
       		{
       			waitQueue.remove(i);
       			return new BattleStatus(null,waitQueue.size(),null,null,"deleted",null);
       		}
       		}
    		default:
        		waitQueue.clear();
        		battleIsExist=false;
        		return new BattleStatus(null,waitQueue.size(),null,null,"clear",null);
    	}
    	
    	
  	
    }
    @RequestMapping("/battle/{battleNumber}")
    public Coord battle(@RequestParam(name="name") String name,@RequestParam(name="enemyName") String enemyName,@RequestParam(name="x") float x,
    		@RequestParam(name="y") float y,@PathVariable("battleNumber")Integer number)
    {
    	System.err.println("Method battle: "+name+","+enemyName+","+x+","+y);
        vectorTranslator.put(name, new Coord(x,y));
    	if(vectorTranslator.containsKey(enemyName))
    	{
    	Coord coord=new Coord(vectorTranslator.get(enemyName));    	
        return coord;
    	}
    	else return new Coord(333f,333f);
    }
    @RequestMapping("/listen")
    public HashMap listen(HttpServletRequest request, HttpServletResponse response)
    {
    	return vectorTranslator;
    }
    @RequestMapping("/clear")
    public void clear(HttpServletRequest request, HttpServletResponse response)
    {
    	waitQueue.clear();
    	vectorTranslator.clear();
    	battleNumber=0;
    	battleIsExist=false;
    	player1Name=null;
    }
    
}

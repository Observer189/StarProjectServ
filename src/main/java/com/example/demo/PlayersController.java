package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repositories.PlayersRepository;

@RestController
@RequestMapping("players")
public class PlayersController {
	@Autowired
    private PlayersRepository players;
	@RequestMapping("/create")
    public Integer createPlayer(@RequestParam(name="name") String name,@RequestParam(name="password") String password,@RequestParam(name="money") int money)
    {
		if(players.getPlayer(name)==null) {
		players.createPlayer(name,password,money);
    	return 1;
		}
		else 
		{
			return 0;
		}
    }
    @RequestMapping("/update")
    public int updatePlayer(@RequestParam(name="name") String name,@RequestParam(name="money") int money)
    {
    	
    	return players.updatePlayer(name, money);
    }
    @RequestMapping("/delete")
    public int deletePlayer(@RequestParam(name="name") String name)
    {
    	
    	return players.deletePlayer(name);
    }
    @RequestMapping("/getPlayer")
    public Player getPlayer(@RequestParam(name="name") String name)
    {
    	
    	if(players.getPlayer(name)!=null)
    	{
    		return players.getPlayer(name);
    	}
    	else
    	{
    		return null;
    	}
    }
    @RequestMapping("/getPlayerList")
    public List<Player> getPlayerList()
    {
    	
    	return players.getPlayers();
    }
}

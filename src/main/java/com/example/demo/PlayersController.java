package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import repositories.PlayersRepository;

@RestController
@RequestMapping("players")
public class PlayersController {
	@Autowired
    private PlayersRepository players;
	@RequestMapping("/create")
    public int createPlayer(@RequestParam(name="name") String name,@RequestParam(name="money") int money)
    {
		players.createPlayer(name, money);
    	return 1;
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
    	
    	return players.getPlayer(name);
    }
    @RequestMapping("/getPlayerList")
    public List<Player> getPlayerList()
    {
    	
    	return players.getPlayers();
    }
}

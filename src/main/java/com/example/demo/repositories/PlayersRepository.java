package com.example.demo.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.Player;

@Component
public class PlayersRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public PlayersRepository() {
	}
	
	public int createPlayer(String name,String password,int money)
	{
		return jdbcTemplate.update("INSERT INTO \"Players\" (\"Name\",\"Password\",\"Money\") "
				+ "VALUES (?,?,?)",name,password,money);
	}
	public int updatePlayer(String name,int money)
	{
		return jdbcTemplate.update("UPDATE \"Players\" SET \"Money\"=? Where \"Name\"=?",money,name);
	}
	public int deletePlayer(String name)
	{
		return jdbcTemplate.update("DELETE FROM \"Players\" WHERE \"Name\"=?",name);
	}
	public Player getPlayer(String name)
	{
		try {
		return jdbcTemplate.queryForObject("SELECT * FROM \"Players\" WHERE \"Name\"=?",new PlayersMapper(),name);
		}
		catch(EmptyResultDataAccessException e)
		{
			return null;
		}
	}
	public List<Player> getPlayers()
	{
		return jdbcTemplate.query("SELECT * FROM \"Players\"",new PlayersMapper());
	}
}

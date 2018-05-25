package com.example.demo.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.Player;

public class PlayersMapper implements RowMapper<Player> {

	@Override
	public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
		Player player=new Player();
		player.setName(rs.getString("Name"));
		player.setPassword(rs.getString("Password"));
		player.setMoney(rs.getInt("Money"));
		return player;
	}

}

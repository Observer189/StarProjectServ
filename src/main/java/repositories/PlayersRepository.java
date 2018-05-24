package repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.Player;

@Component
public class PlayersRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public PlayersRepository() {
	}
	
	public int createPlayer(String name,int money)
	{
		return jdbcTemplate.update("INSERT INTO \"Players\" (\"Name\",\"Money\") VALUES (?,?)",name,money);
	}
	public int updatePlayer(String name,int money)
	{
		return jdbcTemplate.update("UPDATE \"Players\" SET \"Money\"=? Where \"Name\"=?",money,name);
	}
	public int deletePlayer(String name)
	{
		return jdbcTemplate.update("DELETE FROM \"PLAYERS\" WHERE \"Name\"=?",name);
	}
	public Player getPlayer(String name)
	{
		return jdbcTemplate.queryForObject("SELECT * FROM \"Players\" WHERE \"Name\"=?",new PlayersMapper(),name);
	}
	public List<Player> getPlayers()
	{
		return jdbcTemplate.query("SELECT * FROM \"Players\"",new PlayersMapper());
	}
}

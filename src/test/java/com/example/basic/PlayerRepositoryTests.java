package com.example.basic;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.basic.model.Player;
import com.example.basic.model.Team;
import com.example.basic.repository.PlayerRepository;

@SpringBootTest
public class PlayerRepositoryTests {

	@Autowired
	PlayerRepository playerRepository;
	
	@Test
	void test() {
		Player player =new Player();
		Team team = new Team();
		
		player.setAge(24);
		player.setName("Player2");
		// team 이라는 객체값을 가지는 team 에 team 은 db에 정상적으로 있어야 하며 ID(PK)를 가지고 있어야 정상적으로 들어간다.
			team.setName("Team 1");
			team.setId(1L);
		
		player.setTeam(team);
		playerRepository.save(player);
	}
	
	@Test
	void test2() {
		List<Player> list = playerRepository.findAll();
		System.out.println(list);
		
		Optional<Player> opt = playerRepository.findById(4L);
		Player player= opt.get();
		
		String teamName = player.getTeam().getName(); // 이게 조인이다 이말이야
		System.out.println(player.getTeam());
		System.out.println(teamName);
		System.out.println(player);
	}
}

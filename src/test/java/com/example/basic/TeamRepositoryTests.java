package com.example.basic;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.basic.model.Player;
import com.example.basic.model.Team;
import com.example.basic.repository.TeamRepository;

@SpringBootTest
public class TeamRepositoryTests {

	@Autowired
	TeamRepository teamRepository;
	
	@Test
	public void test() {
		Optional<Team> opt = teamRepository.findById(1L);
		Team team = opt.get();
		String teamName = team.getName();
		System.out.println(teamName);
		List<Player> players = team.getPlayers(); // 1:n 을 사용할때 문제점 => mappedBy 로 지정된 변수를 호출시 오류남.
		//			해당 해결 방법은 1 . Eager Loading 으로 변경		( 오류 나는 이유 mappedby 에 추가 속성 fetch를 추가야해함.)
		//							( fethch=FetchType.EAGER  ) + N의 객체 ToString 막기
		//			해결 방법 2. Session 이 계속 살아 있도록 변경.
		System.out.println(players);
	}
}

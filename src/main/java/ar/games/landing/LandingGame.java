package ar.games.landing;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ar.games.landing.service.LandingPlayer;

public class LandingGame {
	public static void main(String[] args) {

		String name = "landingGameBean";// "questionGameBean";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LandingPlayer player = (LandingPlayer) context.getBean(name);
		player.play();
		context.close();
	}
}

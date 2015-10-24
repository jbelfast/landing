package ar.games.landing;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ar.games.landing.service.Game;

public class App {
	public static void main(String[] args) {

		String name = "landingGameBean";// "questionGameBean";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Game game = (Game) context.getBean(name);
		game.play();
		context.close();
	}
}

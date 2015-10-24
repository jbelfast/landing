package ar.games.landing.service.impl;

import java.util.Scanner;

import ar.games.landing.service.Game;
import ar.games.landing.service.Module;

public class LandingGame implements Game {
	private Module landingModule;
	private String configName;

	public LandingGame(Module landingModule) {
		this.landingModule = landingModule;
	}

	public void play() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter config name: ");
		String in = scan.nextLine();
		this.configName = in;

		landingModule.start(configName);
		while (landingModule.getYt() >= 0) {
			// System.out.println("<");
			String input = scan.nextLine();
			System.out.println(">");
			float ia = Float.parseFloat(input);
			landingModule.setIa(ia);
		}
		scan.close();
	}
}

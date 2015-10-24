package ar.games.landing.service.impl;

import java.util.Scanner;

import ar.games.landing.service.LandingPlayer;
import ar.games.landing.service.LandingModule;

public class HumanLandingPlayer implements LandingPlayer {
	
	private LandingModule landingModule;

	public HumanLandingPlayer(LandingModule landingModule) {
		this.landingModule = landingModule;
	}

	public void play() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter config name: ");
		String configName = scan.nextLine();

		landingModule.start(configName);
		while (landingModule.getYt() >= 0) {			
			String input = scan.nextLine();
			System.out.println(">");
			float ia = Float.parseFloat(input);
			landingModule.setIa(ia);
		}
		scan.close();
	}
}

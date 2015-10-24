package ar.games.landing.service.impl;

import ar.games.landing.service.LandingModuleConfiguration;

public class DefaultLandingModuleConfiguration implements LandingModuleConfiguration {
	private String name;
	private float v0; // initial speed (m/s)
	private float y0; // initial height (m)
	private float g; // acceleration (m/s^2) gravity on Earth = 9.81
	private float m; // mass
	private float ia; // initial inverse acceleration (m/s^2)
	private float maxVt; // maximum vertical speed at landing (m/s)
	private float minVt; // minimum vertical speed at landing (m/s)
	private float maxYt; // maximum height at landing (m/s)
	private float minYt; // minimum height at landing (m/s)
	
	public DefaultLandingModuleConfiguration() {
		this.v0 = 0;
		this.y0 = 200;
		this.g = 9.81f;
		this.m = 100;
		this.ia = 0;
		this.maxVt = 1;
		this.minVt = 0;
		this.maxYt = 0.5f;
		this.maxYt = -0.2f;
	}

	public String getName() {
		return name;
	}

	public float getV0() {
		return v0;
	}

	public float getY0() {
		return y0;
	}

	public float getG() {
		return g;
	}

	public float getM() {
		return m;
	}

	public float getIa() {
		return ia;
	}

	public float getMaxVt() {
		return maxVt;
	}

	public float getMinVt() {
		return minVt;
	}

	public float getMaxYt() {
		return maxYt;
	}

	public float getMinYt() {
		return minYt;
	}

}

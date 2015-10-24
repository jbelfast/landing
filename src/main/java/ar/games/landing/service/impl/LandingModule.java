package ar.games.landing.service.impl;

import ar.games.landing.service.Module;
import ar.games.landing.service.ModuleConfiguration;

public class LandingModule implements Module, Runnable {
	private Thread thread;
	private String name;

	private float v0; // initial speed (m/s)
	private float vt; // vertical speed (m/s) in an instant (-a * t + v0)
	private float y0; // initial height (m)
	private float yt; // height (m) in an instant (-0.5 * a * t^2 + v0 * t + y0)
	private float t; // elapsed time (s)
	private float ia; // inverse acceleration (m/s^2)
	private float F1; // Force 1 (downward) (mass * g)
	private float F2; // Force 2 (upward) (-mass * ia)
	private float F; // Force 1 + Force 2
	private float a; // acceleration (F / mass)

	private ModuleConfiguration config;

	public LandingModule(ModuleConfiguration config) {
		this.config = config;
	}

	private void loadConfig() {
		this.v0 = config.getV0();
		this.y0 = config.getY0();
		this.ia = config.getIa();
	}

	private void doMath() {
		F1 = config.getM() * config.getG();
		F2 = -config.getM() * ia;
		F = F1 + F2;
		a = F / config.getM();
		vt = -a * t + v0;
		yt = -0.5f * a * t * t + v0 * t + y0;
		t++;
	}

	private void updateV0Y0T() {
		v0 = vt;
		y0 = yt;
		t = 1;
	}

	public void setIa(float ia) {
		this.ia = ia;
		updateV0Y0T();
	}

	public float getYt() {
		return yt;
	}

	public void run() {
		do {
			try {
				doMath();
				System.out.printf("vt %.4f, yt %.4f, a %.4f, F1 %.4f, F2 %.4f, F %.4f%n", vt, yt, a, F1, F2, F);
				if (yt <= 0)
					break;
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (true);

		if (config.getMinVt() <= Math.round(vt * 100f) / 100f && Math.round(vt * 100f) / 100f <= config.getMaxVt()
				&& config.getMinYt() <= Math.round(yt * 100f) / 100f
				&& Math.round(yt * 100f) / 100f <= config.getMaxYt())
			System.out.println("Perfect landing.");
		System.out.println("Crash!!!");
	}

	public void start(String configName) {
		this.name = configName;
		loadConfig();
		System.out.println("Starting " + name);
		if (thread == null) {
			thread = new Thread(this, name);
			thread.start();
		}
	}
}

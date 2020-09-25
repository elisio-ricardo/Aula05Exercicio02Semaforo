package Controller;

import java.util.concurrent.Semaphore;

public class Cozinhando extends Thread {
	private Semaphore semaforo;
	private int id;

	public Cozinhando(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		cozinhando();
		try {
			semaforo.acquire();
			Entregando();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}

	private void cozinhando() {
		if (id % 2 == 0) {
			double tempo = ((Math.random() * 300) + 500);
			System.out.println("Cozinhando Sopa de Cebola do cliente " + id);
			try {
				sleep((long) tempo);
				double t = (tempo /4);
				int h = 25;
				while (t <= tempo) {
					System.out.println("O prato do cliente " + id + " esta com " + h + "% preparado");
					t += t;
					h += 25;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} else if (id % 2 != 0) {
			double tempo2 = ((Math.random() * 600) + 600);
			System.out.println("Cozinhando Lasanha a Bolonhesa do cliente " + id);
			try {
				sleep((long) tempo2);
				int h = 25;
				double t = (tempo2 / 4);
				while (t <= tempo2) {
					System.out.println("O prato do cliente " + id + " esta com " + h + "% preparado");
					t += t;
					h += 25;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void Entregando() {
		System.out.println("O prato do cliente " + id + " esta pronto e será levado");
		try {
			sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O prato do cliente " + id + " esta entregue ");

	}
}

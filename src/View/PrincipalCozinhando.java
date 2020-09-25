package View;

import java.util.concurrent.Semaphore;

import Controller.Cozinhando;

public class PrincipalCozinhando {

	public static void main(String[] args) {
		
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int id = 1; id < 6; id ++ ) {
			Thread cliente = new Cozinhando(id, semaforo);
			cliente.start();
		}
	}

}

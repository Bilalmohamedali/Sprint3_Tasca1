package nivel1;

import java.util.ArrayList;

public class Undo {
	private static Undo instancia;
	private ArrayList<String> comando;
	
	private Undo() {
		this.comando= new ArrayList<>();
	}
	public static Undo getInstancia() {
		if(instancia == null) {
			instancia = new Undo();
		}
		return instancia;
	}
	
	public ArrayList<String> getComando(){
		return comando;
	}
	
	public void añadirComando(String comandoNuevo) {
		comando.add(comandoNuevo);
	}
	public void quitarComando() {
		int lenght=comando.size();
		comando.remove(lenght-1);
	}
}

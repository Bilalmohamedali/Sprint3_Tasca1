package nivel1;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
static Scanner scan = new Scanner(System.in);
static String comando = null;
static ArrayList<Undo> undoInstancias = new ArrayList<Undo>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean salir = false;
		
		do {
			switch(menu()) {
			case 1:
				abrirUndo();
				break;
			case 2:
				añadirComando(undoInstancias.get(undoInstancias.size()-1));
				break;
			case 3:
				borrarComando(undoInstancias.get(undoInstancias.size()-1));
				break;
			case 4:
				listarComando(undoInstancias.get(undoInstancias.size()-1));
				break;
			case 0:
				System.out.println("Gracias por la utilizacion");
				salir = true;
				break;
			}
		}while(!salir);
	}
	
	public static byte menu() {
		Scanner entrada = new Scanner(System.in);
		byte opcion;
		final byte MINIMO= 0;
		final byte MAXIMO= 4;
		
		do {
			System.out.println("\nMenu principal");
			System.out.println("1 Undo");
			System.out.println("2 Añadir comando");
			System.out.println("3 Borrar comando");
			System.out.println("4 Listar comandos");
			System.out.println("0 Salir\n");
			opcion = entrada.nextByte();
			if (opcion < MINIMO || opcion > MAXIMO) {
				System.out.println("Escoja una opcion");
			}
		}while (opcion < MINIMO || opcion > MAXIMO);
		return opcion;
	}

	public static void abrirUndo() {
		Undo u = Undo.getInstancia();
		System.out.println("Numero de sesion " + undoInstancias.size() + " identificador " + u);
		undoInstancias.add(u);
	}
	private static void listarComando(Undo u) {
		System.out.println("Comandos listados");
		u.getComando().forEach(value -> System.out.println(value));
	}
	
	private static void borrarComando(Undo u) {
		System.out.println("Se borrara el ultimo comando");
		u.quitarComando();
	}
	
	private static void añadirComando(Undo u) {
		System.out.println("nuevo Comando");
		comando = scan.nextLine();
		u.añadirComando(comando);
	}
}

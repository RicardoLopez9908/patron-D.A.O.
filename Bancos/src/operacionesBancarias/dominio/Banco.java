package operacionesBancarias.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * La clase Banco implementa el patrón de diseño Singleton porque sólo puede
 * haber un objeto del tipo Banco
 */
public class Banco {

	private static List<Cliente> clientes;

	static {
		clientes = new ArrayList<Cliente>(10);
	}

	private Banco() {
	}

	public static void agregaCliente(String nombre, String apellido) {
		clientes.add(new Cliente(nombre, apellido));
	}

	public static Cliente getCliente(int indiceCliente) {
		return clientes.get(indiceCliente);
	}

	public static int getNumeroDeClientes() {
		return clientes.size();
	}

	public static void ordenarClientes() {
		Collections.sort(clientes);
	}

}

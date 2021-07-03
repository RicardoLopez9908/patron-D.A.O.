package datos;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import operacionesBancarias.dominio.Banco;
import operacionesBancarias.dominio.CajaDeAhorro;
import operacionesBancarias.dominio.Cliente;
import operacionesBancarias.dominio.CuentaCorriente;

/**
 * 
 * @author Marcelo Samia 
 * 			DAO (Data Access Object) es un patr�n de dise�o cuya
 *         funci�n es abstraer el acceso y manejo de datos para el resto de la
 *         aplicaci�n. El uso que se le da en esta situaci�n es elemental, pero
 *         sirve como introducci�n al tema
 */
public class DAOClientes {
	private File archivoDeDatos;

	public DAOClientes(String caminoAlArchivoDeDatos) {
		this.archivoDeDatos = new File(caminoAlArchivoDeDatos);
	}

	public void cargarDatos() throws IOException {
		// Variables para acceso a datos
		Scanner lecturaDeDatos = new Scanner(archivoDeDatos);

		// Para que se lea el punto flotante correctamente
		// los puntos deben ser los separadores en lugar
		// de la coma, si el lenguaje por defecto que lee Scanner
		// es espa�ol. Por esto se debe colocar el lenguaje
		// por defecto en ingl�s. Particularmente se
		// utiliza el americano
		lecturaDeDatos.useLocale(Locale.US);

		Cliente cliente;
		int numeroDeClientes = lecturaDeDatos.nextInt();
		
		for (int indice = 0; indice < numeroDeClientes; indice++) {
			// Crear los objetos del tipo Cliente
			String primerNombre = lecturaDeDatos.next();
			String apellido = lecturaDeDatos.next();
			Banco.agregaCliente(primerNombre, apellido);
			cliente = Banco.getCliente(indice);

			// Crear las cuentas de los clientes
			int numDeCuentas = lecturaDeDatos.nextInt();
			while (numDeCuentas-- > 0) {

				// Crear un tipo de cuenta en particular
				char tipoDeCuenta = lecturaDeDatos.next().charAt(0);
				switch (tipoDeCuenta) {
				// Cuentas del tipo caja de ahorro
				case 'A': {
					float balanceInicial = lecturaDeDatos.nextFloat();
					float interes = lecturaDeDatos.nextFloat();
					cliente.agregaCuenta(new CajaDeAhorro(balanceInicial,
							interes));
					break;
				}

				// Cuentas del tipo cuenta corriente
				case 'C': {
					float balanceInicial = lecturaDeDatos.nextFloat();
					float proteccionSobregiro = lecturaDeDatos.nextFloat();
					cliente.agregaCuenta(new CuentaCorriente(balanceInicial,
							proteccionSobregiro));
					break;
				}
				} // Fien del switch
			} // Fin del ciclo para crear cuentas
			Banco.ordenarClientes();
		} // Fin de ciclo para crear clientes
	}
}

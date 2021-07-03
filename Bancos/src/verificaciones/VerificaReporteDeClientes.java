package verificaciones;

import java.io.IOException;

import operacionesBancarias.reportes.ReporteCliente;
import datos.DAOClientes;

public class VerificaReporteDeClientes {
	private static final String USO = "USAR: java verificaciones.VerificaReporteDeClientes <rutaAlArchivoDeDatos>" +
							" o configurar los argumentos por línea de comando en el entorno apropiadamente";

	public static void main(String[] args) {
		// Recuperar el camino al archivo de datos desde la línea de comandos
		if (args.length != 1) {
			System.out.println(USO);
		} else {
			String rutaAlArchivoDeDatos = args[0];

			try {
				System.out.println("Leyendo el archivo de datos: " + rutaAlArchivoDeDatos);
				// Crear la fuente de datos y cargar el objeto de tipo Banco
				DAOClientes fuenteDeDatos = new DAOClientes(rutaAlArchivoDeDatos);
				fuenteDeDatos.cargarDatos();

				// Ejecutar el reporte de clientes
				ReporteCliente reporte = new ReporteCliente();
				reporte.generarReporte();

			} catch (IOException ioe) {
				System.out.println("No se puede cargar el archivo de datos.");
				System.out.println(ioe.getMessage());
				ioe.printStackTrace(System.err);
			}
		}
	}
}

package operacionesBancarias.dominio;

import java.util.ArrayList;
import java.util.List;

public class Cliente implements Comparable<Cliente> {

	private String primerNombre;
	private String apellido;
	private List<Cuenta> cuentas;

	public Cliente(String pn, String a) {
		cuentas = new ArrayList<Cuenta>();
		primerNombre = pn;
		apellido = a;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void agregaCuenta(Cuenta cta) {
		cuentas.add(cta);
	}

	public Cuenta getCuenta(int indice_cuenta) {
		return cuentas.get(indice_cuenta);
	}

	public int getNumeroDeCuentas() {
		return cuentas.size();
	}

	@Override
	public int compareTo(Cliente cliente) {
		int comparacionApellido = this.apellido.compareTo(cliente.apellido);

		if (comparacionApellido != 0) {
			return comparacionApellido;
		} else {
			return this.primerNombre.compareTo(cliente.primerNombre);
		}
	}
}

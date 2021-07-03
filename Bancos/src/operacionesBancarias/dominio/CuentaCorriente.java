package operacionesBancarias.dominio;

public class CuentaCorriente extends Cuenta {
  private static final double SIN_PROTECCION = -1.0;

  private double proteccionSobregiro;

  public CuentaCorriente(double bal, double proteccion) {
    super(bal);
    proteccionSobregiro = proteccion;
  }
  public CuentaCorriente(double bal) {
    this(bal, SIN_PROTECCION);
  }

  public void retira(double cantidad) throws ExcepcionSobregiro {
    if ( balance < cantidad ) {
      double sobregiroNecesario = cantidad - balance;

      if ( proteccionSobregiro == SIN_PROTECCION ) {
	throw new ExcepcionSobregiro("Sin protección para sobregiro", sobregiroNecesario);
	
      } else {

	if ( proteccionSobregiro < sobregiroNecesario ) {
	  throw new ExcepcionSobregiro("Fondos insuficientes para la protección de sobregiro",
				       sobregiroNecesario);
	} else {
	  balance = 0.0;
	  proteccionSobregiro -= proteccionSobregiro ;
	}
      }

    } else {

      balance -= cantidad;
    }
  }
}

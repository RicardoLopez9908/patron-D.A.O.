package operacionesBancarias.dominio;

public class CajaDeAhorro extends Cuenta {

  private double  porcentajeInteres;

  public CajaDeAhorro(double bal, double porcentaje) {
    super(bal);
    porcentajeInteres = porcentaje;
  }
  
  public void acumularInteres() {
      balance += (balance * porcentajeInteres);
  }    
}

package operacionesBancarias.dominio;

public class Cuenta {

  protected double  balance;

  public Cuenta(double bal) {
    balance = bal;
  }

  public double getBalance() {
    return balance;
  }
  public void deposita(double cantidad) {
    balance = balance + cantidad;
  }
  public void retira(double cantidad) throws ExcepcionSobregiro {
    if ( balance < cantidad ) {
      throw new ExcepcionSobregiro("Fondos insuficientes", cantidad - balance);
    } else {
      balance = balance - cantidad;
    }
  }
}

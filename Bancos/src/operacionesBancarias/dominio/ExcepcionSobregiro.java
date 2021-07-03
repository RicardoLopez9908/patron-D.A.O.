package operacionesBancarias.dominio;

public class ExcepcionSobregiro extends Exception {
  private double  deficit;

  public ExcepcionSobregiro(String mensaje, double deficit) {
    super(mensaje);
    this.deficit = deficit;
  }

  public double getDeficit() {
    return deficit;
  }
}

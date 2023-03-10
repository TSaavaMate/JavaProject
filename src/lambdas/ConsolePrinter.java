package lambdas;

public class ConsolePrinter implements lambdas.Printer {
  @Override
  public void print(String message) {
    System.out.println(message);
  }
}

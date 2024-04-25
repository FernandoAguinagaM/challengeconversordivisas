import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorDivisas conversor = new ConversorDivisas();

        int opcion = 0;
        while (opcion != 5) {
            System.out.println("Selecciona la conversión que deseas realizar:");
            System.out.println("1- Dólar a Peso Mexicano");
            System.out.println("2- Peso Mexicano a Dólar");
            System.out.println("3- Peso Mexicano a Yenes");
            System.out.println("4- Yenes a Peso Mexicano");
            System.out.println("5- Salir");

            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    realizarConversion(conversor, "USD", "MXN");
                    break;
                case 2:
                    realizarConversion(conversor, "MXN", "USD");
                    break;
                case 3:
                    realizarConversion(conversor, "MXN", "JPY");
                    break;
                case 4:
                    realizarConversion(conversor, "JPY", "MXN");
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción válida.");
                    break;
            }
        }
    }

    private static void realizarConversion(ConversorDivisas conversor, String de, String a) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la cantidad a convertir:");
        double cantidad = scanner.nextDouble();
        double resultado = conversor.convertirDivisa(de, a, cantidad);
        System.out.println(cantidad + " " + de + " a " + a + ": " + resultado);
    }
}
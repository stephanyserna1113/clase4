
import java.util.Scanner;

public class Ejercicio411switch {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double num1, num2, resultado;
        int seleccionOp;

        System.out.print("Ingrese el primer número: ");
        num1 = sc.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        num2 = sc.nextDouble();

        System.out.println("\nSeleccione la operación:");
        System.out.println("1 - Suma");
        System.out.println("2 - Resta");
        System.out.println("3 - Multiplicación");
        System.out.println("4 - División");
        System.out.print("Opción: ");
        seleccionOp = sc.nextInt();

        switch (seleccionOp) {

            case 1:
                resultado = num1 + num2;
                System.out.println("Resultado de la suma: " + resultado);
                break;

            case 2:
                resultado = num1 - num2;
                System.out.println("Resultado de la resta: " + resultado);
                break;

            case 3:
                resultado = num1 * num2;
                System.out.println("Resultado de la multiplicación: " + resultado);
                break;

            case 4:
                if (num2 != 0) {
                    resultado = num1 / num2;
                    System.out.println("Resultado de la división: " + resultado);
                } else {
                    System.out.println("Error: No se puede dividir entre cero.");
                }
                break;

            default:
                System.out.println("Opción no válida.");
        }

        sc.close();
    }
}
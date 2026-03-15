import java.util.Scanner;

public class Ejercicio411if {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double num1, num2, resultado;
        int seleccionOp;

        System.out.print("Ingrese el primer número: ");
        num1 = sc.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        num2 = sc.nextDouble();

        System.out.println("Seleccione la operación:");
        System.out.println("1 = Suma");
        System.out.println("2 = Resta");
        System.out.println("3 = Multiplicación");
        System.out.println("4 = División");
        seleccionOp = sc.nextInt();

        if (seleccionOp == 1) {
            resultado = num1 + num2;
            System.out.println("Resultado: " + resultado);
        } 
        else if (seleccionOp == 2) {
            resultado = num1 - num2;
            System.out.println("Resultado: " + resultado);
        } 
        else if (seleccionOp == 3) {
            resultado = num1 * num2;
            System.out.println("Resultado: " + resultado);
        } 
        else if (seleccionOp == 4) {
            if (num2 != 0) {
                resultado = num1 / num2;
                System.out.println("Resultado: " + resultado);
            } else {
                System.out.println("Error: no se puede dividir entre 0");
            }
        } 
        else {
            System.out.println("Operación no válida");
        }

        sc.close();
    }
}
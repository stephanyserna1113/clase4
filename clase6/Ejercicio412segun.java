import java.util.Scanner;

public class Ejercicio412segun {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double num1, num2, resultado;
        int codigo;

        System.out.print("Ingrese el primer numero: ");
        num1 = sc.nextDouble();

        System.out.print("Ingrese el segundo numero: ");
        num2 = sc.nextDouble();

        System.out.println("Ingrese el codigo de seleccion:");
        System.out.println("1 = Sumar");
        System.out.println("2 = Multiplicar");
        System.out.println("3 = Dividir");
        codigo = sc.nextInt();

        switch (codigo) {
            case 1:
                resultado = num1 + num2;
                System.out.println("Resultado de la suma: " + resultado);
                break;

            case 2:
                resultado = num1 * num2;
                System.out.println("Resultado de la multiplicacion: " + resultado);
                break;

            case 3:
                if (num2 != 0) {
                    resultado = num1 / num2;
                    System.out.println("Resultado de la division: " + resultado);
                } else {
                    System.out.println("Error: no se puede dividir entre cero.");
                }
                break;

            default:
                System.out.println("Codigo no valido.");
        }

        sc.close();
    }
}
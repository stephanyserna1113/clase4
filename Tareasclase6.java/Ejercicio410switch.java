
import java.util.Scanner;

public class Ejercicio410switch {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numero;

        System.out.print("Ingrese un numero: ");
        numero = sc.nextInt();

        int tipo;

        if (numero > 0) {
            tipo = 1;   // positivo
        } else if (numero < 0) {
            tipo = -1;  // negativo
        } else {
            tipo = 0;   // cero
        }

        switch (tipo) {
            case 1:
                System.out.println("El numero es positivo");
                break;

            case -1:
                System.out.println("El numero es negativo");
                break;

            case 0:
                System.out.println("El numero es cero");
                break;
        }

        sc.close();
    }
}
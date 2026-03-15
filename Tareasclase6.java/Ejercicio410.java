
import java.util.Scanner;

public class Ejercicio410 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numero;

        System.out.print("Ingrese un numero: ");
        numero = sc.nextInt();

        if (numero > 0) {
            System.out.println("El numero es positivo");
        } 
        else if (numero < 0) {
            System.out.println("El numero es negativo");
        } 
        else {
            System.out.println("El numero es cero");
        }

        sc.close();
    }
}
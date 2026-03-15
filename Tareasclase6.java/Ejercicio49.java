

import java.util.Scanner;

public class Ejercicio49 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int nota;

        System.out.print("Ingrese la calificacion (0 - 100): ");
        nota = sc.nextInt();

        switch (nota / 10) {
            case 10:
            case 9:
                System.out.println("Calificacion en letra: A");
                break;

            case 8:
                System.out.println("Calificacion en letra: B");
                break;

            case 7:
                System.out.println("Calificacion en letra: C");
                break;

            case 6:
                System.out.println("Calificacion en letra: D");
                break;

            default:
                System.out.println("Calificacion en letra: F");
        }

        sc.close();
    }
}
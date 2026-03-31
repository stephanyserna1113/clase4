import java.util.Scanner;

public class Ejercicio56 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, nota, contadorAprobados = 0;

        System.out.print("Ingrese la cantidad de alumnos: ");
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Ingrese la nota del alumno " + i + ": ");
            nota = sc.nextInt();

            if (nota >= 5) {
                contadorAprobados++;
            }
        }

        System.out.println("Cantidad de aprobados: " + contadorAprobados);
    }
}
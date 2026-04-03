package Clase7;


    
import java.util.Scanner;

public class Ejercicio510 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalDias;
        double maxima, minima;

        double sumaMax = 0;
        double sumaMin = 0;

        double mayorMax = 0;
        double menorMin = 0;

        int contadorErrores = 0;

        System.out.print("Ingrese la cantidad de días: ");
        totalDias = sc.nextInt();

        for (int i = 1; i <= totalDias; i++) {
            System.out.println("\nDía " + i);

            System.out.print("Temperatura máxima: ");
            maxima = sc.nextDouble();

            System.out.print("Temperatura mínima: ");
            minima = sc.nextDouble();

            // Contar errores (temperatura = 9)
            if (maxima == 9 || minima == 9) {
                contadorErrores++;
            }

            sumaMax += maxima;
            sumaMin += minima;

            // Inicializar en el primer día
            if (i == 1) {
                mayorMax = maxima;
                menorMin = minima;
            } else {
                if (maxima > mayorMax) {
                    mayorMax = maxima;
                }

                if (minima < menorMin) {
                    menorMin = minima;
                }
            }
        }

        double promedioMax = sumaMax / totalDias;
        double promedioMin = sumaMin / totalDias;
        double porcentajeErrores = (contadorErrores * 100.0) / totalDias;

        System.out.println("\n=== RESULTADOS ===");
        System.out.println("Promedio de máximas: " + promedioMax);
        System.out.println("Promedio de mínimas: " + promedioMin);
        System.out.println("Mayor temperatura máxima: " + mayorMax);
        System.out.println("Menor temperatura mínima: " + menorMin);
        System.out.println("Cantidad de errores: " + contadorErrores);
        System.out.println("Porcentaje de errores: " + porcentajeErrores + "%");

        sc.close();
    }
}

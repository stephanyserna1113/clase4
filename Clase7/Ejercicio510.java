import java.util.Scanner;

public class Ejercicio510 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalDias, contadorErrores = 0;
        double maxima, minima;
        double sumaMax = 0, sumaMin = 0;
        double mayorMax = 0, menorMin = 0;

        System.out.print("Ingrese cantidad de días: ");
        totalDias = sc.nextInt();

        for (int i = 1; i <= totalDias; i++) {
            System.out.println("\nDía " + i);

            System.out.print("Ingrese temperatura máxima: ");
            maxima = sc.nextDouble();

            System.out.print("Ingrese temperatura mínima: ");
            minima = sc.nextDouble();

            if (maxima == 9 || minima == 9) {
                contadorErrores++;
            }

            sumaMax += maxima;
            sumaMin += minima;

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

        System.out.println("\nResultados:");
        System.out.println("Promedio máximas: " + promedioMax);
        System.out.println("Promedio mínimas: " + promedioMin);
        System.out.println("Mayor temperatura máxima: " + mayorMax);
        System.out.println("Menor temperatura mínima: " + menorMin);
        System.out.println("Cantidad de errores: " + contadorErrores);
        System.out.println("Porcentaje de errores: " + porcentajeErrores + "%");
    }
}
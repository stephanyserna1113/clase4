import java.util.Scanner;

public class Ejercicio59 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char codigo;
        double precio;
        int cantidad;

        int totalCantidadA = 0;
        int totalCantidadB = 0;

        double totalImporteA = 0;
        double totalImporteB = 0;

        System.out.println("=== CONTROL DE ARTÍCULOS ===");

        while (true) {
            System.out.print("\nIngrese código (A, B o X para terminar): ");
            codigo = sc.next().toUpperCase().charAt(0);

            if (codigo == 'X') {
                break;
            }

            // Validación básica
            if (codigo != 'A' && codigo != 'B') {
                System.out.println("Código inválido. Intente nuevamente.");
                continue;
            }

            System.out.print("Ingrese precio del artículo: ");
            precio = sc.nextDouble();

            System.out.print("Ingrese cantidad de artículos: ");
            cantidad = sc.nextInt();

            if (codigo == 'A') {
                totalCantidadA += cantidad;
                totalImporteA += precio * cantidad;
            } else { // código == 'B'
                totalCantidadB += cantidad;
                totalImporteB += precio * cantidad;
            }
        }

        // Resultados finales
        System.out.println("\n=== RESULTADOS ===");

        System.out.println("\nCategoría A:");
        System.out.println("Cantidad total: " + totalCantidadA);
        System.out.println("Importe total: $" + totalImporteA);

        System.out.println("\nCategoría B:");
        System.out.println("Cantidad total: " + totalCantidadB);
        System.out.println("Importe total: $" + totalImporteB);

        sc.close();
    }
}
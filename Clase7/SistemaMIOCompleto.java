
import java.util.Scanner;

public class SistemaMIOCompleto {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {

            System.out.println("\n+------------------------------+");
            System.out.println("|     SISTEMA MIO CALI        |");
            System.out.println("+------------------------------+");
            System.out.println("| 1. Cobrar tarifa            |");
            System.out.println("| 2. Control de ruta          |");
            System.out.println("| 3. Reporte del dia          |");
            System.out.println("| 0. Salir                    |");
            System.out.println("+------------------------------+");

            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    fase1(sc);
                    break;

                case 2:
                    fase2(sc);
                    break;

                case 3:
                    fase4(sc);
                    fase5(sc);
                    break;

                case 0:
                    System.out.println("Cerrando sistema...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }

    // ================= FASE 1 =================
    public static void fase1(Scanner sc) {

        System.out.print("Ingrese la hora (0-23): ");
        int hora = sc.nextInt();

        System.out.println("Tipo de pasajero:");
        System.out.println("1. Normal");
        System.out.println("2. Estudiante");
        System.out.println("3. Adulto mayor");
        System.out.println("4. Discapacitado");
        System.out.print("Seleccione: ");
        int tipo = sc.nextInt();

        double tarifaBase = 0;
        double descuento = 0;
        double totalPagar;
        String nombreTipo = "";

        boolean esHoraValle = (hora >= 9 && hora <= 16);

        switch (tipo) {

            case 1:
                nombreTipo = "Normal";
                tarifaBase = 3000;
                break;

            case 2:
                nombreTipo = "Estudiante";
                tarifaBase = 1500;
                if (esHoraValle) {
                    descuento = tarifaBase * 0.10;
                }
                break;

            case 3:
                nombreTipo = "Adulto mayor";
                tarifaBase = 0;
                break;

            case 4:
                nombreTipo = "Discapacitado";
                tarifaBase = 0;
                break;

            default:
                System.out.println("Tipo invalido");
                return;
        }

        totalPagar = tarifaBase - descuento;

        System.out.println("\n===== TIQUETE MIO =====");
        System.out.println("Hora: " + hora + ":00");
        System.out.println("Tipo: " + nombreTipo);
        System.out.println("Tarifa base: $" + tarifaBase);
        System.out.println("Descuento: $" + descuento);
        System.out.println("TOTAL: $" + totalPagar);
    }

    // ================= FASE 2 =================
    public static void fase2(Scanner sc) {

        int capacidadMaxima = 80;
        int pasajerosActuales = 0;
        int totalSubieron = 0;
        int totalBajaron = 0;
        int paradasRecorridas = 0;
        int paradasConAforo = 0;
        int parada = 1;
        boolean rutaActiva = true;

        while (parada <= 25 && rutaActiva) {

            System.out.println("\n=== PARADA " + parada + " ===");
            System.out.println("Pasajeros actuales: " + pasajerosActuales);

            System.out.print("SUBEN (-1 para terminar): ");
            int suben = sc.nextInt();

            if (suben == -1) {
                rutaActiva = false;
            } else {

                System.out.print("BAJAN: ");
                int bajan = sc.nextInt();

                // VALIDACION 1
                if (bajan > pasajerosActuales) {
                    System.out.println("Error: bajan mas de los que hay. Se ajusta.");
                    bajan = pasajerosActuales;
                }

                // VALIDACION 2
                if (pasajerosActuales + suben - bajan > capacidadMaxima) {
                    System.out.println("Excede capacidad. Se ajusta.");
                    suben = capacidadMaxima - pasajerosActuales + bajan;
                }

                // ACTUALIZAR
                pasajerosActuales = pasajerosActuales + suben - bajan;
                totalSubieron += suben;
                totalBajaron += bajan;

                // AFORO
                if (pasajerosActuales == 80) {
                    paradasConAforo++;
                }

                double porcentaje = (pasajerosActuales * 100.0) / capacidadMaxima;

                String estado;
                if (pasajerosActuales == 80) {
                    estado = "AFORO MAXIMO";
                } else if (porcentaje >= 60) {
                    estado = "BUS LLENO";
                } else {
                    estado = "NORMAL";
                }

                System.out.println("Estado: " + estado);

                parada++;
                paradasRecorridas++;
            }
        }

        System.out.println("\n===== RESUMEN RUTA =====");
        System.out.println("Paradas recorridas: " + paradasRecorridas);
        System.out.println("Total subieron: " + totalSubieron);
        System.out.println("Total bajaron: " + totalBajaron);
        System.out.println("Pasajeros finales: " + pasajerosActuales);
        System.out.println("Paradas con aforo: " + paradasConAforo);
    }

    // ================= FASE 4 =================
    public static void fase4(Scanner sc) {

        int totalPasajerosDia = 0;
        double totalRecaudoDia = 0;
        int totalVueltas = 0;

        int maxPasajeros = 0;
        int minPasajeros = Integer.MAX_VALUE;
        String rutaMas = "";
        String rutaMenos = "";

        double maxRecaudo = 0;
        String rutaMayorRecaudo = "";

        for (int ruta = 1; ruta <= 3; ruta++) {

            String nombreRuta;
            if (ruta == 1) nombreRuta = "T31";
            else if (ruta == 2) nombreRuta = "A10";
            else nombreRuta = "P22A";

            System.out.println("\n--- Ruta " + nombreRuta + " ---");

            System.out.print("Pasajeros: ");
            int pasajeros = sc.nextInt();

            System.out.print("Vueltas: ");
            int vueltas = sc.nextInt();

            System.out.print("% Normal: ");
            int pctNormal = sc.nextInt();

            int pctEstudiante = 100 - pctNormal;

            double recaudo = pasajeros * (
                    (pctNormal / 100.0) * 3000 +
                    (pctEstudiante / 100.0) * 1500
            );

            totalPasajerosDia += pasajeros;
            totalRecaudoDia += recaudo;
            totalVueltas += vueltas;

            if (pasajeros > maxPasajeros) {
                maxPasajeros = pasajeros;
                rutaMas = nombreRuta;
            }

            if (pasajeros < minPasajeros) {
                minPasajeros = pasajeros;
                rutaMenos = nombreRuta;
            }

            if (recaudo > maxRecaudo) {
                maxRecaudo = recaudo;
                rutaMayorRecaudo = nombreRuta;
            }

            System.out.println("Recaudo: $" + recaudo);
        }

        double promedio = totalPasajerosDia / 3.0;

        System.out.println("\n===== REPORTE DEL DIA =====");
        System.out.println("Total pasajeros: " + totalPasajerosDia);
        System.out.println("Total recaudo: $" + totalRecaudoDia);
        System.out.println("Ruta mas concurrida: " + rutaMas);
        System.out.println("Ruta menos concurrida: " + rutaMenos);
        System.out.println("Ruta mayor recaudo: " + rutaMayorRecaudo);
        System.out.println("Promedio pasajeros: " + promedio);
    }

    // ================= FASE 5 =================
    public static void fase5(Scanner sc) {

        int rutasConAlerta = 0;

        for (int ruta = 1; ruta <= 3; ruta++) {

            String nombreRuta;
            if (ruta == 1) nombreRuta = "T31";
            else if (ruta == 2) nombreRuta = "A10";
            else nombreRuta = "P22A";

            System.out.println("\n--- Analisis " + nombreRuta + " ---");

            System.out.print("Pasajeros: ");
            int pasajeros = sc.nextInt();

            System.out.print("Vueltas: ");
            int vueltas = sc.nextInt();

            System.out.print("Retraso (min): ");
            int retraso = sc.nextInt();

            System.out.print("Recaudo: ");
            double recaudo = sc.nextDouble();

            boolean alertaDemanda = pasajeros < 500;
            boolean alertaVueltas = vueltas > 20;
            boolean alertaRetraso = retraso > 90;
            boolean alertaRecaudo = recaudo < (pasajeros * 1500 * 0.70);

            boolean tieneAlerta = alertaDemanda || alertaVueltas || alertaRetraso || alertaRecaudo;

            if (!tieneAlerta) {
                System.out.println("OK - Sin problemas");
            } else {
                rutasConAlerta++;
                System.out.println("ALERTA DETECTADA");

                if (alertaDemanda) System.out.println("- Baja demanda");
                if (alertaVueltas) System.out.println("- Demasiadas vueltas");
                if (alertaRetraso) System.out.println("- Retraso alto");
                if (alertaRecaudo) System.out.println("- Recaudo bajo");
            }
        }

        System.out.println("\nRutas con alerta: " + rutasConAlerta);

        if (rutasConAlerta == 0)
            System.out.println("Operacion: NORMAL");
        else if (rutasConAlerta == 1)
            System.out.println("Operacion: REVISION MENOR");
        else if (rutasConAlerta == 2)
            System.out.println("Operacion: REVISION URGENTE");
        else
            System.out.println("Operacion: CRITICA");
    }
}
import java.util.Scanner;

class Estudiante {

    private String codigo;
    private String nombre;
    private double promedio;
    private int horasDeporte;
    private int horasCultura;
    private int horasSalud;

    // Constructor
    public Estudiante(String codigo, String nombre, double promedio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.promedio = promedio;

        horasDeporte = 0;
        horasCultura = 0;
        horasSalud = 0;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPromedio() {
        return promedio;
    }

    public int getHorasDeporte() {
        return horasDeporte;
    }

    public int getHorasCultura() {
        return horasCultura;
    }

    public int getHorasSalud() {
        return horasSalud;
    }

    public void sumarHorasDeporte(int horas) {
        this.horasDeporte += horas;
    }

    public void sumarHorasCultura(int horas) {
        this.horasCultura += horas;
    }

    public void sumarHorasSalud(int horas) {
        this.horasSalud += horas;
    }

    public int calcularTotalHoras() {
        return horasDeporte + horasCultura + horasSalud;
    }

    public boolean esAptoParaGrado() {
        int total = calcularTotalHoras();
        if (total >= 30 && horasDeporte >= 10 && horasCultura >= 10 && horasSalud >= 10) {
            return true;
        } else {
            return false;
        }
    }

    public void mostrarInformacion() {
        System.out.println("===== ESTUDIANTE =====");
        System.out.println("Código: " + getCodigo());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Promedio: " + getPromedio());
        System.out.println("Horas Deporte: " + getHorasDeporte() + " / 10");
        System.out.println("Horas Cultura: " + getHorasCultura() + " / 10");
        System.out.println("Horas Salud: " + getHorasSalud() + " / 10");
        System.out.println("Total Horas: " + calcularTotalHoras() + " / 30");

        if (esAptoParaGrado()) {
            System.out.println("Estado: APTO PARA GRADO");
        } else {
            System.out.println("Estado: NO APTO");
        }
    }
}

class Actividad {

    private int id;
    private String nombre;
    private String categoria;
    private int horasQueDa;
    private int cuposDisponibles;
    private String horario;

    // Constructor
    public Actividad(int id, String nombre, String categoria, int horasQueDa, int cuposDisponibles, String horario) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.horasQueDa = horasQueDa;
        this.cuposDisponibles = cuposDisponibles;
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getHorasQueDa() {
        return horasQueDa;
    }

    public int getCuposDisponibles() {
        return cuposDisponibles;
    }

    public void reducirCupo() {
        if (cuposDisponibles > 0) {
            this.cuposDisponibles--;
        }
    }

    public void mostrarInformacion() {
        System.out.println("===== ACTIVIDAD =====");
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Categoría: " + getCategoria());
        System.out.println("Horas que otorga: " + getHorasQueDa());
        System.out.println("Cupos disponibles: " + getCuposDisponibles());
        System.out.println("Horario: " + horario);
    }
}

public class SistemaBienestarUNIAJC {
    static Scanner entrada = new Scanner(System.in);

    static Estudiante[] listaEstudiantes = new Estudiante[3];
    static Actividad[] listaActividades = new Actividad[4];

    static int[][] inscripciones = new int[3][4];

    public static void main(String[] args) {
        cargarDatosIniciales();
        int opcion;

        do {
            // Menú principal
            System.out.println("\n===== BIENESTAR UNIAJC =====");
            System.out.println("1. Ver todos los estudiantes");
            System.out.println("2. Ver todas las actividades");
            System.out.println("3. Inscribir estudiante");
            System.out.println("4. Ver reporte de un estudiante");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");

            while (!entrada.hasNextInt()) {
                System.out.print("Dato inválido. Escriba un número: ");
                entrada.next();
            }
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    mostrarEstudiantes();
                    break;
                case 2:
                    mostrarActividades();
                    break;
                case 3:
                    inscribirEstudiante();
                    break;
                case 4:
                    verReporte();
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }

        } while (opcion != 0);

        entrada.close();
    }

    public static void cargarDatosIniciales() {

        listaEstudiantes[0] = new Estudiante("1001", "Danna Velasco", 4.8);
        listaEstudiantes[1] = new Estudiante("1002", "Francia Serna", 3.9);
        listaEstudiantes[2] = new Estudiante("1003", "Stephanya Serna", 5.0);

        listaActividades[0] = new Actividad(1, "Fútbol", "Deporte", 5, 2, "Lunes 8AM");
        listaActividades[1] = new Actividad(2, "Danza", "Cultura", 5, 2, "Martes 10AM");
        listaActividades[2] = new Actividad(3, "Nutrición", "Salud", 5, 2, "Miércoles 9AM");
        listaActividades[3] = new Actividad(4, "Ajedrez", "Cultura", 10, 1, "Viernes 7AM");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                inscripciones[i][j] = 0;
            }
        }
    }

    public static void mostrarEstudiantes() {
        for (int i = 0; i < 3; i++) {
            listaEstudiantes[i].mostrarInformacion();
        }
    }

    public static void mostrarActividades() {
        for (int i = 0; i < 4; i++) {
            listaActividades[i].mostrarInformacion();
        }
    }

    public static int buscarEstudiante(String codigo) {
        for (int i = 0; i < 3; i++) {

            if (listaEstudiantes[i].getCodigo().equals(codigo)) {
                return i;
            }
        }
        return -1;
    }

    public static int buscarActividad(int id) {
        for (int i = 0; i < 4; i++) {

            if (listaActividades[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public static void inscribirEstudiante() {
        System.out.print("Escriba el código del estudiante: ");
        String codigoIngresado = entrada.nextLine();
        int posicionEst = buscarEstudiante(codigoIngresado);

        if (posicionEst == -1) {
            System.out.println("El estudiante no existe.");
            return;
        }

        System.out.print("Escriba el ID de la actividad: ");
        while (!entrada.hasNextInt()) {
            System.out.print("ID inválido, escriba un número: ");
            entrada.next();
        }
        int idIngresado = entrada.nextInt();
        entrada.nextLine();
        int posicionAct = buscarActividad(idIngresado);

        if (posicionAct == -1) {
            System.out.println("La actividad no existe.");
            return;
        }

        if (inscripciones[posicionEst][posicionAct] == 1) {
            System.out.println("Ya está inscrito en esa actividad.");
            return;
        }

        if (listaActividades[posicionAct].getCuposDisponibles() <= 0) {
            System.out.println("No hay cupos disponibles.");
            return;
        }

        inscripciones[posicionEst][posicionAct] = 1;
        listaActividades[posicionAct].reducirCupo();

        String categoria = listaActividades[posicionAct].getCategoria();
        int horas = listaActividades[posicionAct].getHorasQueDa();

        if (categoria.equalsIgnoreCase("Deporte")) {
            listaEstudiantes[posicionEst].sumarHorasDeporte(horas);
        } else if (categoria.equalsIgnoreCase("Cultura")) {
            listaEstudiantes[posicionEst].sumarHorasCultura(horas);
        } else if (categoria.equalsIgnoreCase("Salud")) {
            listaEstudiantes[posicionEst].sumarHorasSalud(horas);
        }

        System.out.println("¡Inscripción realizada con éxito!");
    }

    public static void verReporte() {
        System.out.print("Escriba código del estudiante: ");
        String codigo = entrada.nextLine();
        int posicion = buscarEstudiante(codigo);

        if (posicion == -1) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        listaEstudiantes[posicion].mostrarInformacion();

        System.out.println("\nActividades inscritas:");
        boolean tiene = false;

        for (int j = 0; j < 4; j++) {
            if (inscripciones[posicion][j] == 1) {

                System.out.println(
                        "- " + listaActividades[j].getNombre() + " (" + listaActividades[j].getCategoria() + ")");
                tiene = true;
            }
        }

        if (!tiene) {
            System.out.println("- Ninguna actividad registrada.");
        }
    }
}
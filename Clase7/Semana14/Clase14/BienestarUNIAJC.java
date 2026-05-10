package Clase14;

import java.util.*;

class Estudiante {
    private String codigo;
    private String nombre;
    private double promedio;

    private int horasDeporte;
    private int horasCultura;
    private int horasSalud;

    private int totalHoras;

    private List<Inscripcion> inscripciones;

    public Estudiante(String codigo, String nombre, double promedio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.promedio = promedio;
        this.inscripciones = new ArrayList<>();
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

    public int getTotalHoras() {
        return totalHoras;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void agregarHoras(String categoria, int horas) {
        totalHoras += horas;

        switch (categoria.toLowerCase()) {
            case "deporte":
                horasDeporte += horas;
                break;
            case "cultura":
                horasCultura += horas;
                break;
            case "salud":
                horasSalud += horas;
                break;
        }
    }

    public void restarHoras(int horas) {
        totalHoras -= horas;

        if (totalHoras < 0) {
            totalHoras = 0;
        }
    }

    public boolean cumpleCategorias() {
        return horasDeporte >= 10 && horasCultura >= 10 && horasSalud >= 10;
    }

    public void agregarInscripcion(Inscripcion i) {
        inscripciones.add(i);
    }

    public boolean tieneCruceHorario(Actividad nueva) {
        for (Inscripcion i : inscripciones) {
            if (i.isActiva()) {
                Actividad a = i.getActividad();

                if (a.getHorario().equalsIgnoreCase(nueva.getHorario())) {
                    return true;
                }
            }
        }

        return false;
    }

    public int contarActividadesCategoria(String categoria) {
        int contador = 0;

        for (Inscripcion i : inscripciones) {
            if (i.isActiva() && i.getActividad().getCategoria().equalsIgnoreCase(categoria)) {
                contador++;
            }
        }

        return contador;
    }

    public boolean esAptoGrado() {
        return totalHoras >= 30 && cumpleCategorias();
    }

    public void mostrarInformacion() {
        System.out.println("\n===== INFORMACIÓN DEL ESTUDIANTE =====");
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Promedio: " + promedio);
        System.out.println("Horas deporte: " + horasDeporte);
        System.out.println("Horas cultura: " + horasCultura);
        System.out.println("Horas salud: " + horasSalud);
        System.out.println("Total horas: " + totalHoras);
        System.out.println("Cumple categorías: " + (cumpleCategorias() ? "Sí" : "No"));
        System.out.println("Apto para grado: " + (esAptoGrado() ? "Sí" : "No"));
    }
}

class Actividad {
    private int id;
    private String nombre;
    private String categoria;
    private int horas;
    private int cupoMaximo;
    private String horario;
    private boolean altoImpacto;

    private List<Estudiante> inscritos;
    private Queue<Estudiante> listaEspera;
    private List<Integer> calificaciones;

    public Actividad(int id, String nombre, String categoria, int horas,
                     int cupoMaximo, String horario, boolean altoImpacto) {

        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.horas = horas;
        this.cupoMaximo = cupoMaximo;
        this.horario = horario;
        this.altoImpacto = altoImpacto;

        inscritos = new ArrayList<>();
        listaEspera = new LinkedList<>();
        calificaciones = new ArrayList<>();
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

    public int getHoras() {
        return horas;
    }

    public String getHorario() {
        return horario;
    }

    public boolean isAltoImpacto() {
        return altoImpacto;
    }

    public boolean hayCupo() {
        return inscritos.size() < cupoMaximo;
    }

    public void agregarInscrito(Estudiante e) {
        inscritos.add(e);
    }

    public void agregarListaEspera(Estudiante e) {
        listaEspera.offer(e);
    }

    public void removerInscrito(Estudiante e) {
        inscritos.remove(e);

        if (!listaEspera.isEmpty()) {
            Estudiante nuevo = listaEspera.poll();
            inscritos.add(nuevo);

            System.out.println("\n>>> El estudiante " + nuevo.getNombre() +
                    " salió de la lista de espera y obtuvo un cupo.");
        }
    }

    public void agregarCalificacion(int nota) {
        calificaciones.add(nota);
    }

    public double promedioCalificaciones() {
        if (calificaciones.isEmpty()) {
            return 0;
        }

        int suma = 0;

        for (int nota : calificaciones) {
            suma += nota;
        }

        return (double) suma / calificaciones.size();
    }

    public void mostrarActividad() {
        System.out.println("\n===== ACTIVIDAD =====");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Categoría: " + categoria);
        System.out.println("Horas: " + horas);
        System.out.println("Horario: " + horario);
        System.out.println("Cupos disponibles: " + (cupoMaximo - inscritos.size()));
        System.out.println("Lista espera: " + listaEspera.size());
        System.out.println("Promedio satisfacción: " + promedioCalificaciones());
    }
}

class Inscripcion {
    private Estudiante estudiante;
    private Actividad actividad;
    private boolean activa;

    public Inscripcion(Estudiante estudiante, Actividad actividad) {
        this.estudiante = estudiante;
        this.actividad = actividad;
        this.activa = true;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public boolean isActiva() {
        return activa;
    }

    public void cancelar() {
        activa = false;
    }
}

public class BienestarUNIAJC {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    static ArrayList<Actividad> actividades = new ArrayList<>();

    public static void main(String[] args) {

        cargarDatos();

        int opcion;

        do {
            System.out.println("\n=========== BIENESTAR UNIAJC ===========");
            System.out.println("1. Ver estudiantes");
            System.out.println("2. Ver actividades");
            System.out.println("3. Inscribir estudiante");
            System.out.println("4. Cancelar inscripción");
            System.out.println("5. Calificar actividad");
            System.out.println("6. Reporte final estudiante");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    mostrarEstudiantes();
                    break;

                case 2:
                    mostrarActividades();
                    break;

                case 3:
                    realizarInscripcion();
                    break;

                case 4:
                    cancelarInscripcion();
                    break;

                case 5:
                    calificarActividad();
                    break;

                case 6:
                    generarReporte();
                    break;

                case 0:
                    System.out.println("\nSistema finalizado correctamente.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    public static void cargarDatos() {

        estudiantes.add(new Estudiante("1001", "Juan Pérez", 4.5));
        estudiantes.add(new Estudiante("1002", "Laura Gómez", 3.7));
        estudiantes.add(new Estudiante("1003", "Camilo Torres", 4.2));

        actividades.add(new Actividad(1, "Fútbol", "Deporte", 5, 2,
                "Lunes 8AM", false));

        actividades.add(new Actividad(2, "Danza", "Cultura", 5, 2,
                "Martes 10AM", false));

        actividades.add(new Actividad(3, "Yoga", "Salud", 5, 1,
                "Lunes 8AM", false));

        actividades.add(new Actividad(4, "Viaje Cultural", "Cultura", 10,
                1, "Viernes 7AM", true));
    }

    public static void mostrarEstudiantes() {

        for (Estudiante e : estudiantes) {
            e.mostrarInformacion();
        }
    }

    public static void mostrarActividades() {

        for (Actividad a : actividades) {
            a.mostrarActividad();
        }
    }

    public static Estudiante buscarEstudiante(String codigo) {

        for (Estudiante e : estudiantes) {
            if (e.getCodigo().equals(codigo)) {
                return e;
            }
        }

        return null;
    }

    public static Actividad buscarActividad(int id) {

        for (Actividad a : actividades) {
            if (a.getId() == id) {
                return a;
            }
        }

        return null;
    }

    public static void realizarInscripcion() {

        System.out.print("Ingrese código estudiante: ");
        String codigo = sc.next();

        Estudiante e = buscarEstudiante(codigo);

        if (e == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        System.out.print("Ingrese ID actividad: ");
        int id = sc.nextInt();

        Actividad a = buscarActividad(id);

        if (a == null) {
            System.out.println("Actividad no encontrada.");
            return;
        }

        if (a.isAltoImpacto() && e.getPromedio() < 4.0) {
            System.out.println("No puede ingresar a eventos de alto impacto.");
            return;
        }

        if (e.tieneCruceHorario(a)) {
            System.out.println("Existe cruce de horarios.");
            return;
        }

        Inscripcion inscripcion = new Inscripcion(e, a);
        e.agregarInscripcion(inscripcion);

        if (a.hayCupo()) {
            a.agregarInscrito(e);
            e.agregarHoras(a.getCategoria(), a.getHoras());

            System.out.println("Inscripción realizada correctamente.");

            validarBono(e, a.getCategoria());

        } else {
            a.agregarListaEspera(e);
            System.out.println("No hay cupos. Estudiante agregado a lista de espera.");
        }
    }

    public static void cancelarInscripcion() {

        System.out.print("Ingrese código estudiante: ");
        String codigo = sc.next();

        Estudiante e = buscarEstudiante(codigo);

        if (e == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        System.out.print("Ingrese ID actividad: ");
        int id = sc.nextInt();

        for (Inscripcion i : e.getInscripciones()) {

            if (i.getActividad().getId() == id && i.isActiva()) {

                i.cancelar();
                i.getActividad().removerInscrito(e);

                e.restarHoras(2);

                System.out.println("Inscripción cancelada.");
                System.out.println("Penalización aplicada: -2 horas.");

                return;
            }
        }

        System.out.println("No se encontró la inscripción.");
    }

    public static void validarBono(Estudiante e, String categoria) {

        int cantidad = e.contarActividadesCategoria(categoria);

        if (cantidad >= 3) {
            e.agregarHoras(categoria, 5);

            System.out.println("\n>>> Bono UNIAJC aplicado: +5 horas adicionales.");
        }
    }

    public static void calificarActividad() {

        System.out.print("Ingrese ID actividad: ");
        int id = sc.nextInt();

        Actividad a = buscarActividad(id);

        if (a == null) {
            System.out.println("Actividad no encontrada.");
            return;
        }

        System.out.print("Ingrese calificación (1-5): ");
        int nota = sc.nextInt();

        if (nota < 1 || nota > 5) {
            System.out.println("Calificación inválida.");
            return;
        }

        a.agregarCalificacion(nota);

        System.out.println("Calificación registrada correctamente.");
    }

    public static void generarReporte() {

        System.out.print("Ingrese código estudiante: ");
        String codigo = sc.next();

        Estudiante e = buscarEstudiante(codigo);

        if (e == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        System.out.println("\n========= REPORTE FINAL =========");
        System.out.println("Estudiante: " + e.getNombre());
        System.out.println("Código: " + e.getCodigo());
        System.out.println("Promedio académico: " + e.getPromedio());

        System.out.println("\nHoras acumuladas:");
        System.out.println("Deporte: " + e.getHorasDeporte());
        System.out.println("Cultura: " + e.getHorasCultura());
        System.out.println("Salud: " + e.getHorasSalud());
        System.out.println("Total: " + e.getTotalHoras());

        System.out.println("\nEstado categorías: " +
                (e.cumpleCategorias() ? "Cumple" : "No cumple"));

        System.out.println("Estado final: " +
                (e.esAptoGrado() ? "APTO PARA GRADO" : "NO APTO"));
    }
}




    
import java.io.*;
import java.util.*;

// --- ENUMS ---
enum Categoria implements Serializable {
    DEPORTE, CULTURA, SALUD
}

// --- CLASE ESTUDIANTE ---
class Estudiante implements Serializable {
    private String id, nombre;
    private double promedio;
    private Map<Categoria, Integer> horas = new EnumMap<>(Categoria.class);
    private Map<Categoria, Integer> aprobadas = new EnumMap<>(Categoria.class);

    public Estudiante(String id, String nombre, double promedio) {
        this.id = id;
        this.nombre = nombre;
        this.promedio = promedio;
        for (Categoria c : Categoria.values()) {
            horas.put(c, 0);
            aprobadas.put(c, 0);
        }
    }

    public void sumarHoras(Categoria cat, int h) {
        horas.put(cat, horas.get(cat) + h);
    }

    public void restarHoras(int h) {
        for (Categoria c : Categoria.values()) {
            horas.put(c, Math.max(0, horas.get(c) - h));
        }
    }

    public void registrarAprobacion(Categoria cat) {
        int total = aprobadas.get(cat) + 1;
        aprobadas.put(cat, total);
        if (total % 3 == 0) {
            sumarHoras(cat, 5);
            System.out.println("¡Bono de 5 horas aplicado en " + cat + "!");
        }
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPromedio() { return promedio; }
    public int getHoras(Categoria c) { return horas.get(c); }

    public void mostrarHoras() {
        System.out.println("Horas por categoría:");
        for (Categoria c : Categoria.values()) {
            System.out.println(" - " + c + ": " + horas.get(c));
        }
    }
}

// --- CLASE ACTIVIDAD ---
class Actividad implements Serializable {
    private String nombre;
    private Categoria categoria;
    private int cupoMaximo;
    private boolean esAltoImpacto;
    private List<Estudiante> inscritos = new ArrayList<>();

    public Actividad(String nombre, Categoria cat, int cupo, boolean altoImpacto) {
        this.nombre = nombre;
        this.categoria = cat;
        this.cupoMaximo = cupo;
        this.esAltoImpacto = altoImpacto;
    }

    public boolean validarInscripcion(Estudiante e) {
        if (esAltoImpacto && e.getPromedio() < 4.0)
            return false;
        return inscritos.size() < cupoMaximo;
    }

    public void inscribirEstudiante(Estudiante e) {
        if (validarInscripcion(e)) {
            inscritos.add(e);
            e.registrarAprobacion(categoria);
            System.out.println(e.getNombre() + " inscrito en " + nombre + " (Categoría: " + categoria + ")");
        } else {
            System.out.println("No se puede inscribir a " + e.getNombre() + " en " + nombre);
        }
    }

    public String getNombre() { return nombre; }
    public Categoria getCategoria() { return categoria; }
}

// --- CLASE PRINCIPAL ---
public class Proyectobienestar implements Serializable {
    private Map<String, Estudiante> estudiantes = new HashMap<>();
    private List<Actividad> actividades = new ArrayList<>();

    public static void main(String[] args) {
        Proyectobienestar sistema = new Proyectobienestar();
        sistema.cargarActividades();
        sistema.ejecutarMenu();
    }

    private void cargarActividades() {
        // Crear algunas actividades de ejemplo
        actividades.add(new Actividad("Fútbol", Categoria.DEPORTE, 10, false));
        actividades.add(new Actividad("Teatro", Categoria.CULTURA, 5, false));
        actividades.add(new Actividad("Yoga Avanzado", Categoria.SALUD, 5, true));
    }

    public void ejecutarMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- SISTEMA BIENESTAR UNIAJC ---");
            System.out.println("1. Registrar Estudiante");
            System.out.println("2. Consultar Estudiante");
            System.out.println("3. Inscribir en Actividad");
            System.out.println("4. Salir");
            System.out.print("Seleccione opción: ");
            String op = sc.nextLine();

            switch (op) {
                case "1":
                    registrarEstudiante(sc);
                    break;
                case "2":
                    consultarEstudiante(sc);
                    break;
                case "3":
                    inscribirActividad(sc);
                    break;
                case "4":
                    guardarDatos();
                    System.out.println("Datos guardados. Saliendo...");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void registrarEstudiante(Scanner sc) {
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Promedio: ");
        double prom = Double.parseDouble(sc.nextLine());
        estudiantes.put(id, new Estudiante(id, nombre, prom));
        System.out.println("Estudiante registrado.");
    }

    private void consultarEstudiante(Scanner sc) {
        System.out.print("ID a consultar: ");
        String id = sc.nextLine();
        Estudiante e = estudiantes.get(id);
        if (e != null) {
            System.out.println("Nombre: " + e.getNombre() + " | Promedio: " + e.getPromedio());
            e.mostrarHoras();
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    private void inscribirActividad(Scanner sc) {
        System.out.print("ID del estudiante: ");
        String id = sc.nextLine();
        Estudiante e = estudiantes.get(id);
        if (e == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        System.out.println("Actividades disponibles:");
        for (int i = 0; i < actividades.size(); i++) {
            Actividad a = actividades.get(i);
            System.out.println((i + 1) + ". " + a.getNombre() + " (" + a.getCategoria() + ")");
        }

        System.out.print("Seleccione actividad: ");
        int actIndex = Integer.parseInt(sc.nextLine()) - 1;
        if (actIndex >= 0 && actIndex < actividades.size()) {
            actividades.get(actIndex).inscribirEstudiante(e);
        } else {
            System.out.println("Actividad no válida.");
        }
    }

    private void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sistema.dat"))) {
            oos.writeObject(this);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

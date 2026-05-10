
import java.io.*;
import java.time.*;
import java.util.*;

// MODELOS
enum Categoria implements Serializable {
    DEPORTE, CULTURA, SALUD
}

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
        for (Categoria c : Categoria.values())
            horas.put(c, Math.max(0, horas.get(c) - h));
    }

    public void registrarAprobacion(Categoria cat) {
        int total = aprobadas.get(cat) + 1;
        aprobadas.put(cat, total);
        if (total % 3 == 0) {
            sumarHoras(cat, 5);
            System.out.println("!Bono de 5 horas aplicado en " + cat + "!");
        }
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPromedio() {
        return promedio;
    }

    public int getHoras(Categoria c) {
        return horas.get(c);
    }
}

class Actividad {
    String nombre;
    Categoria categoria;
    int cupoMaximo;
    boolean esAltoImpacto;
    List<Estudiante> inscritos = new ArrayList<>();

    public Actividad(String nombre, Categoria categoria, int cupo, boolean altoImpacto) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.cupoMaximo = cupo;
        this.esAltoImpacto = altoImpacto;
    }

    public boolean validarInscripcion(Estudiante e) {
        if (esAltoImpacto && e.getPromedio() < 4.0)
            return false;
        return inscritos.size() < cupoMaximo;
    }

    public String getNombre() {
        return nombre;
    }
}

// CLASE PRINCIPAL
public class SistemaBienestarUNIAJC {
    private Map<String, Estudiante> estudiantes = new HashMap<>();

    public static void main(String[] args) {
        SistemaBienestarUNIAJC sistema = new SistemaBienestarUNIAJC();
        sistema.ejecutarMenu();
    }

    public void ejecutarMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nSISTEMA BIENESTAR UNIAJC");
            System.out.println("1. Registrar Estudiante");
            System.out.println("2. Consultar Estudiante");
            System.out.println("3. Salir");

            String op = sc.nextLine();
            switch (op) {
                case "1":
                    System.out.print("IDENTIFICACION: ");
                    String id = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nom = sc.nextLine();
                    estudiantes.put(id, new Estudiante(id, nom, 4.2));
                    System.out.println("Estudiante registrado.");
                    break;
                case "2":
                    System.out.print("ID a Consultar: ");
                    Estudiante e = estudiantes.get(sc.nextLine());
                    if (e != null)
                        System.out.println("Nombre: " + e.getNombre() + ", Promedio: " + e.getPromedio());
                    else
                        System.out.println("No existe.");
                    break;
                case "3":
                    guardarDatos();
                    System.exit(0);
            }
        }
    }

    private void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sistema.dat"))) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

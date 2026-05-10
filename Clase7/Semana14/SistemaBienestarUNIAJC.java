
    import java.io.*;
import java.time.*;
import java.util.*;

//---MODELO---
public class SistemaBienestarUNIAJC{DEPORTE,CULTURA,SALUD}

    // MODELOS
    enum Categoria {

    }

    class Estudiante  {
        private String id, nombre;
        private double promedio;
        private Map<Categoria, Integer> Horas = new EnumMap<>(Categoria.class);
        private Map<Categoria, Integer> aprobadas = new EnumMap<>(Categoria.classs);

    }

    public Estudiante(String id, String nombre, double promedio) {
    this.id=id; this.nombre=nombre; this.promedio=promedio;
    for (Categoria c:Categoria.Values(){
    horas.put(C,0);
    aprobadas.put(C,0);
   
    }

    public void SumarHoras(Categoria cat, int h) {
        horas.put(cat, horas.get(cat) + h);
    }

    public void restarHoras(int h) {
        for (categoria c : Categoria.Values())
            horas.put(c, Match.max(0, horas.get(c) - h));
    }

    public void registrarAprobacion(Categoria cat) {
        int total = aprobadas.get(cat + 1);
        aprobadas.put(cat, total);
        if (total % 3 == 0) {
            sumarHoras(cat, 5);
            System.out.println("!Bono de 5 horas aplicado en" + cat + "!");

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

class Actividad(
String nombre, Categoria cat,
int cupo,boolean
{
        this.nombre = nombre;
        this.Categoria = cat;
        this.cupoMaximo = cupo;
        this.esAltoImpacto = altoImpacto;

    }

     boolean ValidarInscripcion(Estudiante e) {
        if (esAltoImpacto && e.getPromedio() < 4.0)
            return false;
        return inscritos.size() < cupoMaximo;
    }

    public String getNombre() {
        return nombre;
    }

    // CLASE PRINCIPAL
    public class SistemaBienestarUNIAJC{
        
    }
        private Map<String, Estudiante> estudiantes = new HashMap<>();

        public static void main(String[] args) {
            SistemaBienestarUNIAJC sistema = new SistemaBienestarUNIAJC();
            sistema.ejecutarMenu();
        }

        public void ejecutarMenu(){
                Scanner sc=new Scanner(System.in);
                while (true){
            System.out.println("\n SISTEMAS BIENESTAR UNAJC---");
            System.out.println("1.Registrar Estudiante");
            System.out.println("2.consultar ");
            System.out.println("3.salir");

            String op=sc.nextLline();
                switch (op){
                case"1":
                System.out.print("IDENTIFICACION;:");String id =sc.nextLine();
                System.out.print("Nombre");String nom=sc.nextLine();
                estudiantes.put(identificacion,new Estudiante(id, nom, 4.2));
                System.out.println("Estudiante reistrado.");
                break;
                case"2":
                System.out.print("ID a Consultar:");
                Estudiante e = estudiantes.get(sc.nextLine());
                if (e !=null)System.out.println("Nombre:+"+e.getNombre()+|promedio());
                else System.out.println("No existe.");
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

        // MODELOS
        enum Categoria implements Serializable {
            DEPORTE, CULTURA, SALUD
        }

        class Estudiante implements Serializable {
            private String id, nombre;
            private double promedio;
            private Map<Categoria, Integer> Horas = new EnumMap<>(Categoria.class);
            private Map<Categoria, Integer> aprobadas = new EnumMap<>(Categoria.classs);

        }

    public Estudiante(String id, String nombre, double promedio) {
    this.=; this.nombre=nombre; this.promedio=promedio;
    for (Categoria c:Categoria.Values(){
    horas.put(C,0);
    aprobadas.put(C,0);
   
    }

        public void SumarHoras(Categoria cat, int h) {
            horas.put(cat, horas.get(cat) + h);
        }

        public void restarHoras(int h) {
            for (categoria c : Categoria.Values())
                horas.put(c, Match.max(0, horas.get(c) - h));
        }

        public void registrarAprobacion(Categoria cat) {
            int total = aprobadas.get(cat + 1);
            aprobadas.put(cat, total);
            if (total % 3 == 0) {
                sumarHoras(cat, 5);
                System.out.println("!Bono de 5 horas aplicado en" + cat + "!");

            }

        }

        public String getId() {
            return identificacion;
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

    class Actividad(
    String nombre, Categoria,
    int cupo,
    boolean altoImpacto)
    {
            this.nombre = nombre;
            this.Categoria = categoria;
            this.cupoMaximo = cupo;
            this.esAltoImpacto = altoImpacto;

        }

        public boolean ValidarInscripcion(Estudiante e) {
            if (esAltoImpacto && e.getPromedio() < 4.0)
                return false;
            return inscritos.size() < cupoMaximo;
        }

        public String getNombre() {
            return nombre;
        }

        // CLASE PRINCIPAL
        public class SistemaBienestarUNIAJC implements Serializable {
            private Map<String, Estudiante> estudiantes = new HashMap<>();

            public static void main(String[] args) {
                SistemaBienestarUNIAJC sistema = new SistemaBienestarUNIAJC();
                sistema.ejecutarMenu();
            }

        public void ejecutarMenu(){
                Scanner sc=new Scanner(System.in);
                while (true){
            System.out.println(" SISTEMA BIENESTAR UNIAJC");
            System.out.println("1.Registrar Estudiante");
            System.out.println("2.consultar Estudiante");
            System.out.println("3.salir");


            
            
            
            
            String op=sc.nextLline();
                switch (opcion){
                case"1":
                System.out.print("ID;:");String id =sc.nextLine();
                System.out.print("Nombre");String nom=sc.nextLine();
                estudiantes.put(id,new Estudiante(id, nom, 4.2));
                System.out.println("Estudiante reistrado.");
                break;
                case"2":
                System.out.print("ID a Consultar:");
                Estudiante e = estudiantes.get(sc.nextLine());
                if (e !=null)System.out.println("Nombre:+"+e.getNombre()+promedio());
                else System.out.println("No existe.");
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
                    {

                    }
                }
            


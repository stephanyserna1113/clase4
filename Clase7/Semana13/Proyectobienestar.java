package Clase7.Semana13;

public class Proyectobienestar {

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

// MODELOS
enum Categoria implements Serializable {
    DEPORTE, CULTURA, SALUD
};

class Estudiante implements Serializable {
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

}

    public void SumarHoras(Categorias cat, int h) {
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

class Acividad(
String nombre, Categoria cat,
int cupo,
boolean altoImpacto){
        this.nombre=nombre; this.Categoria=cat;
        this.cupoMaximo=cupo; this.esAltoImpacto=altoImpacto;

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
            System.out.println("\n SISTEMAS BIENESTAR UNAJC---");
            System.out.println("1.Registrar Estudiante"|2.Consultar|3.Salir");
                String op=sc.nextLline();
                switch (op){
                case"1":
                System.out.print("ID;:");String id =sc.nextLine();
                System.out.print("Nombre");String nom=sc.nextLine();
                estudiantes.put(id,new Estudiante(id, nom, 4.2));
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
            try (ObjectOutputStream oos = new ObjectOutputStream(new fileOutputStream("sistema.dat"))) {
                oos.writeObject(this);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}}

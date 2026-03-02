import java.util.Scanner;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el valor de x:");
        int x = sc.nextInt();

        System.out.println("Ingrese el valor de y:");
        int y = sc.nextInt();

        System.out.println("Ingrese el valor de z:");
        int z = sc.nextInt();

        if (x > y && z < 20) {
            System.out.println("Ingrese el valor de p:");
            int p = sc.nextInt();
            System.out.println("Valor de p ingresado: " + p);
        } else {
            System.out.println("No se cumplen las condiciones (x > y y z < 20).");
        }

        sc.close();
    }

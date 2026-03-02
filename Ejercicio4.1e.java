
    

import java.util.Scanner;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese la distancia:");
        int distancia = sc.nextInt();

        if (distancia > 20 && distancia < 35) {
            System.out.println("Ingrese el tiempo:");
            int tiempo = sc.nextInt();
            System.out.println("Tiempo ingresado: " + tiempo);
        } else {
            System.out.println("La distancia no está entre 20 y 35.");
        }

        sc.close();
    }

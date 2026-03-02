
import java.util.Scanner;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese dos números:");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        if (num1 > num2) {
            System.out.println("El primer número es el mayor");
        } else if (num1 < num2) {
            System.out.println("El primer número es el más pequeño");
        } else {
            System.out.println("Ambos números son iguales");
        }

        sc.close();
    }

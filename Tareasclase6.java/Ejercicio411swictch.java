import java.util.Scanner;

public class Ejercicio411swictch {
    public static void main(String[] args) {
        
        Scanner = new Scanner(System.in);

        double num1, num2, resultado;
        int seleccionop;

        System.out.println("Digite el primer numero ");
        Object sc;
        num1 = sc.nextDouble();

        System.out.println("Digite el segundo número");
        num2 =  sc.nextDouble();

        System.out.println("seleccione la operacion");
        System.out.println("1 == suma");
        System.out.println("2 == resta");
        System.out.println("3 == multiplicación");
        System.out.println("4 == division");
        seleccionop = sc. nextInt();

        switch(seleccionop){

            case 1: resultado = num1+num2;
            System.out.println("Resultado de la suma:"+ resultado);
            break;

            case 2:resultado = num1-num2;
            System.out.println("Resultado de la resta"+resultado);
            break;

            case 3: resultado= num1*num2;
            System.out.println("resultado de la multiplicación"+ resultado);
            break;

            case 4: 
              
              if (num2 ! =0){

                resultado = num1/num2;
                System.out.println("Resultado de la división"+resultado);

                }else{

                    System.out.println("Error: no se puede dividir entre cero.");

                }
                break;

                default:System.out.println("Opción no válida");



                sc.close();



                }





              }





        }

    
    


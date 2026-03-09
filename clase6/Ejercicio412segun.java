package clase6;

public class Ejercicio412segun {

    public static void main(String[] args) {
        num1 = sc.nextDouble();
        System.out.println("Digite número 2");
        num2= sc.nextDouble();
        System.out.println("Digite la seleccion 1, 2 o 3 ");
        seleccion = sc.nextInt();

        switch (seleccion) {
            case 1:
                System.out.println("La suma es "+ (num1+num2));
            
                
                break;
        
            case 2 :
                System.out.println("la multiplicacion es"+(num1*num2));
                break;

                case 3 : 
                System.out.println("La division es;"+(num1/num2));
                break,





            default:
                System.out.println("opcion no valida");
                break;
        
            sc.close();
           
            }
    }
    
}

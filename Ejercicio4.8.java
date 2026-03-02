
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese dos números:");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        if (num1 % num2 == 0) {
            System.out.println(num2 + " es divisor de " + num1);
        } else if (num2 % num1 == 0) {
            System.out.println(num1 + " es divisor de " + num2);
        } else {
            System.out.println("Ninguno es divisor del otro");
        }

        sc.close();
    }

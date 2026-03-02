
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese tres números:");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        int menor;

        if (num1 <= num2 && num1 <= num3) {
            menor = num1;
        } else if (num2 <= num1 && num2 <= num3) {
            menor = num2;
        } else {
            menor = num3;
        }

        System.out.println("El número menor es: " + menor);

        sc.close();
    }

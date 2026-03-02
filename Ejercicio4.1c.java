
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalPositivos = 0;
        int totalNegativos = 0;

        System.out.println("Ingrese un número:");
        int numero = sc.nextInt();

        if (numero > 0) {
            totalPositivos += numero;
        } else {
            totalNegativos += numero;
        }

        System.out.println("Total positivos: " + totalPositivos);
        System.out.println("Total negativos: " + totalNegativos);

        sc.close();
    }

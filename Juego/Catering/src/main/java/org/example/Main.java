package org.example;

import java.util.Scanner;

public class Main {

    static int [] precios = {2500, 5000, 10000, 15000};
    static int [][] chefsyPlatos = {
            {1, 2, 3, 5},
            {6, 7, 8, 9},
            {10, 11, 12, 13}
    };
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int cont = 0;

        while (cont != 6) {
            System.out.println("Elegi una opcion para seguir: ");
            System.out.println("1: Registrar produccion");
            System.out.println("2: Ver total de ventas");
            System.out.println("3: Ver bonos por produccion");
            System.out.println("4: Ver plato mas popular");
            System.out.println("5: Ver chef del mes");
            System.out.println("6: Salir");
            int opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    registrarProduccion();
                    break;
                case 2:
                    verTotalVentas();
                    break;
                case 3:
                    double[] bonos = verBonosPorProduccion();
                    for (int i = 0; i < bonos.length; i++) {
                        System.out.println("Bono Chef " + (i+1) + ": $" + bonos[i]);
                    }
                    break;
                case 4:
                    verPlatoMasPopular();
                    break;
                case 5:
                    chefDelMes();
                    break;
                case 6:
                    salir();
            }
        }

    }
    static void registrarProduccion() {
        for (int a = 0; a < chefsyPlatos.length; a++) {
            System.out.println("Chef " + (a + 1) + ":");
            for (int b = 0; b < chefsyPlatos[a].length; b++) {
                System.out.print(" Plato " + (b + 1) + ": ");
                chefsyPlatos[a][b] = sc.nextInt();
            }
        }

    }
    static void verTotalVentas () {
        int contador = 0;
        for (int c = 0; c < chefsyPlatos.length; c++) {
            int totalChef = 0;
            System.out.println("El chef " + (c + 1) + " hizo: ");
            for (int d = 0; d < chefsyPlatos[c].length; d++) {
                contador += chefsyPlatos[c][d] * precios[d];
                int valorPlato = chefsyPlatos[c][d] * precios[d];
                totalChef += valorPlato;
                System.out.println("Plato " + (d+1) + ": $" + valorPlato);

            }
            System.out.println("Total chef " + (c+1) + ": $" + totalChef);
        }
        System.out.println("Total de pesos generados por todos: " + " $" + contador);
    }


    static double[] verBonosPorProduccion() {
        double[] bonos = new double[3];
        for (int c = 0; c < chefsyPlatos.length; c++) {
            int totalChef = 0;
            for (int d = 0; d < chefsyPlatos[c].length; d++) {
                int valorPlato = chefsyPlatos[c][d] * precios[d];
                totalChef += valorPlato;
            }
            bonos[c] = totalChef * 0.05;
        }
        return bonos;
    }

    static void chefDelMes () {
        int indiceChef = 0;
        double mayorBono = 0;
        double bonos[] = verBonosPorProduccion();

        for (int a = 0; a < bonos.length; a++) {
            if (mayorBono < bonos[a]) {
                mayorBono = bonos[a];
                indiceChef = a;
            }
        }
        System.out.println("El chef del mes fue el: " + (indiceChef + 1));

    }

    static void verPlatoMasPopular() {
        int maxSuma = 0;
        int indicePlato = 0;

        for (int col = 0; col < chefsyPlatos[0].length; col++) {
            int suma1 = 0;
            for (int fil = 0; fil < chefsyPlatos.length; fil++) {
                suma1 += chefsyPlatos[fil][col];
            }
            if (suma1 > maxSuma) {
                maxSuma = suma1;
                indicePlato = col;
            }
        }
        System.out.println("El plato mas popular es: Plato " + (indicePlato + 1));
            }

    static void salir () {
        System.out.println("ciao! ");
        System.exit(0);
    }
}
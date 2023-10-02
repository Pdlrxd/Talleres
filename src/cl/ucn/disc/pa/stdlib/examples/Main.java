package cl.ucn.disc.pa.stdlib.examples;
import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import edu.princeton.cs.stdlib.StdDraw;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Rango del dibujo
        double min = -100.0;
        double max = 100.0;

        // Definicion de la escala del lienzo de dibujo
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);

        // Evitar el parpadeo de la pantalla
        StdDraw.enableDoubleBuffering();

        while (true) {
            // Abrir menu
            int dess = Menu();

            // Elecciones de desiciones
            if (dess == 1) {
                Eleccion1();
            } else if (dess == 2) {
                Eleccion2();
            } else if (dess == 3) {
                Eleccion3();
            } else if (dess == 4) {
                Eleccion4();
            } else if (dess == 5) {
                StdDraw.clear();
                StdDraw.show();
            } else if (dess == 6) {
                Eleccion6();
            } else if (dess == 7) {
                Eleccion7();
            } else if (dess == 8) {
                Eleccion8();
            } else if (dess == 9) {
                Eleccion9();
            }
        }
    }
    /**
     * Subprograma Menu
     */
    public static int Menu() {
        Scanner s = new Scanner(System.in);
        System.out.println("Bienvenido\nQue desea hacer?\n1. Dibujar una línea\n2. Dibujar una circunferencia\n3. Cambiar de color\n4. Dibujar anillos en capa\n5. Limpiar Hoja\n6. Dibujar texto\n7. Dibujar una circunferencia pintada\n8. Dibujar una ACPIA\n9. Dibujar circunferencia con una línea (Efecto Relog)");

        while (true) {
            try {
                int des_menu = s.nextInt();
                if (des_menu == 1 || des_menu == 2 || des_menu == 3 || des_menu == 4 || des_menu == 5 || des_menu == 6 || des_menu == 7 || des_menu == 8 || des_menu == 9) {
                    return des_menu;
                } else {
                    System.out.println("Ingreso un valor fuera de rango de opciones");
                }
            } catch (InputMismatchException e) {
                System.out.println("Dato ingresado no es valido ");
                s.nextLine();
            }
        }
    }
    /**
     * Subprograma Manejo de error
     * @return
     */
    public static double ExceptDouble() {
        Scanner s = new Scanner(System.in);
        while (true) {
            try {
                double a = s.nextDouble();
                if (a <= 100 && a >= -100){
                    return a;
                }else{
                    System.out.println("Ingreso un valor fuera del rango de la hoja\nIntente nuevamente");
                }
            } catch (InputMismatchException e) {
                System.out.println("Dato ingresado no es valido\nIntente nuevamente");
                s.nextLine();
            }
        }
    }
    public static int ExceptInt() {
        Scanner s = new Scanner(System.in);
        while (true) {
            try {
                int b = s.nextInt();
                return b;
            } catch (InputMismatchException e) {
                System.out.println("Dato ingresado no es valido ");
                s.nextLine();
            }
        }
    }
    /**
     * Subprogramas Elecciones
     */
    public static void Eleccion1() {
        System.out.println("Recuerde usar valores desde -100 hasta 100");

        // Pedir coordenadas
        System.out.println("Ingrese las primeras coordenadas X,Y");
        System.out.println("X: ");
        double x1 = ExceptDouble();
        System.out.println("Y: ");
        double y1 = ExceptDouble();
        System.out.println("Ingrese las segundas coordenadas X,Y");
        System.out.println("X: ");
        double x2 = ExceptDouble();
        System.out.println("Y: ");
        double y2 = ExceptDouble();

        // imprimir pantalla
        StdDraw.line(x1, y1, x2, y2);
        StdDraw.show();
    }
    public static double[] Eleccion2() {
        System.out.println("Recuerde interfaz con intervalo de -100 hasta 100");

        // Ubicacion
        System.out.println("Ingrese las coordenadas X,Y");
        System.out.println("X: ");
        double x1 = ExceptDouble();
        System.out.println("Y: ");
        double y1 = ExceptDouble();

        // Radio circunferencia
        System.out.println("Ingrese valor radio: ");
        double radio = ExceptDouble();

        // Dibujar Circunferencia
        StdDraw.circle(x1, y1, radio);
        StdDraw.show();

         // Variables estrategicas
        double[] valores = {x1, y1, radio};
        return valores;
    }
    public static void Eleccion3() {
        // Designar colores
        Color[] colores = {Color.black, Color.WHITE, Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};

        //Pedir color para poder usar
        System.out.println("Ingrese Color\n1. Negro\n2. Blanco\n3. Rojo\n4. Azul\n5. Verde\n6. Amarillo");
        while (true) {
            int dess_col = ExceptInt();
            if (dess_col == 1 || dess_col == 2 || dess_col == 3 || dess_col == 4 || dess_col == 5 || dess_col == 6) {
                StdDraw.setPenColor(colores[dess_col - 1]);
                break;
            } else {
                System.out.println("Ingreso una opcion fuera del rango");
            }
        }
    }
    public static void Eleccion4() {
        // Crear Circunferencia
        Scanner s = new Scanner(System.in);
        double[] val = Eleccion2();

        // Asignar radios
        double rad1 = 0;
        double rad2 = 0;

        // Pedir radio menor a el radio creado anteriormente
        System.out.println("Ingrese un radio menor a " + val[2] + " para crear nuevo circulo");
        while (true) {
            rad1 = ExceptDouble();
            if (rad1 < val[2]){
                System.out.println("Correcto");
                break;
            }
            else{
                System.out.println("Ingreso un radio invalido");
            }
        }
        // dibujar Circunferencia
        StdDraw.circle(val[0], val[1], rad1);
        StdDraw.show();

        // Pedir Radio menor a el radio ingresado anteriormente
        System.out.println("Ingrese un radio menor a " + rad1 + " para crear nuevo circulo");
        while (true) {
            rad2 = ExceptDouble();
            if (rad2 < rad1){
                System.out.println("Correcto");
                break;
            }
            else{
                System.out.println("Ingreso un radio invalido");
            }
        }
        // Dibujar circunferencia
        StdDraw.circle(val[0], val[1], rad2);
        StdDraw.show();
    }
    public static void Eleccion6(){
        Scanner s = new Scanner(System.in);

        // Pedir coordenadas
        System.out.println("Ingrese las coordenadas X,Y");
        System.out.println("X: ");
        double x1 = ExceptDouble();
        System.out.println("Y: ");
        double y1 = ExceptDouble();

        // Pedir Texto
        System.out.println("Ingrese texto:");
        String text = s.nextLine();

        // Dibujar Texto
        StdDraw.text(x1,y1,text);
        StdDraw.show();
    }
    public static double[] Eleccion7(){
        // Crear Datos circulo
        double[] val = Eleccion2();

        // Dibujar Circulo Pintado
        StdDraw.filledCircle(val[0], val[1], val[2]);
        StdDraw.show();

        // Variables Estrategicas
        double[] valores = {val[0], val[1], val[2]};
        return valores;

    }
    public static void Eleccion8(){
        // Estrategias
        Color[] colores = {Color.black, Color.WHITE, Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
        Scanner s = new Scanner(System.in);
        double[] val = Eleccion7();
        double rad = 0;
        int dess = 0;

        // Programa
        while (true){
            System.out.println("Ingrese Radio menor a "+val[2]+" para dibujar\nRadio cero para terminar");
            rad = ExceptDouble();
            if(rad < val[2]){
                StdDraw.setPenColor(colores[(int) (Math.random() * colores.length)]);
                StdDraw.filledCircle(val[0], val[1], rad);
                StdDraw.show();
                val[2] = rad;

                if (val[2] == 0){
                    System.out.println("Radio Cero\nFin del dibujo");
                    break;
                }
                System.out.println("¿Deseas dibujar otro circulo mas pequeño?\n1. Si\n2. No");
                while (true) {
                    dess = ExceptInt();
                    if (dess == 1 || dess == 2){
                        break;
                    }else {
                        System.out.println("Ingreso opcion invalida");
                    }
                }
                if (dess == 2){
                    break;
                }
            }
            else{
                System.out.println("Ingreso un radio no valido");
            }
        }
    }
    public static void Eleccion9(){
        //Peticion de datos para las variables
        double[] val = Eleccion2();
        double angulo = 0;
        float Contador = 0;
        double salida = 0;
        StdDraw.enableDoubleBuffering();

        while (salida != 1) {
            angulo -= 0.01;
            Contador += 0.01;
            if (Contador >= 15) {
                System.out.println("Deseas volver al menu principal?\n1. Si\n2. No");
                while (true){
                    int dess = ExceptInt();
                    if (dess == 1){
                        System.out.println("Saliendo..");
                        salida = 1;
                        break;
                    }else if (dess == 2){
                        Contador = 0;
                        break;
                    }else{
                        System.out.println("Ingreso una opcion no disponible");
                    }
                }
            }
            //Limpiar Hoja cada ciclo
            StdDraw.clear();

            //Dibujar circulo
            StdDraw.circle(val[0], val[1], val[2]);
            double radio = val[2];

            //dibujar linea
            StdDraw.line(val[0], val[1], (Math.cos(angulo) * radio) + val[0], (Math.sin(angulo) * radio) + val[1]);
            StdDraw.show();
        }
        StdDraw.clear();
        StdDraw.show();
    }
}//Corchete main
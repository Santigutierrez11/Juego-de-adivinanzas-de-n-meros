import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Random random = new Random();
        Scanner in = new Scanner(System.in);
        int numAleatorio = random.nextInt(0, 101);
        byte intentos;

        System.out.println("\t\t¡Bienvenidos al juego de adivinar números!");
        System.out.println("\t+--------------------------------------------------------+");
        System.out.println("\t|Estoy pensando en un número entre 1 y 100.              |");
        System.out.println("\t|Tienes 5 oportunidades para adivinar el número correcto |");
        System.out.println("\t+--------------------------------------------------------+");
        
        intentos = nivelDificultad();
        byte totalIntentos = intentos;
        do {
            intentos -= 1;
            try {
                System.out.print("\nIngresa tu respuesta: ");
                int respuesta = Integer.parseInt(in.nextLine());
                
                if (numAleatorio > respuesta){
                    System.out.println("\nEl número es mayor que " + respuesta);
                    System.out.println("Le quedan: " + intentos);
                } else if(numAleatorio < respuesta){
                    System.out.println("\nEl número es menor que " + respuesta);
                    System.out.println("Le quedan: " + intentos + " intentos");
                } else {
                    System.out.println("Felicidades, acertaste el número en " + (totalIntentos - intentos) + " intentos");
                    break;
                }

            } catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        } while(intentos >= 1);
    }

    public static byte nivelDificultad(){
        Scanner in = new Scanner(System.in);

        System.out.println("\n* Selecciona un nivel de dificulta *");
        System.out.println("\t1. Facil (10 oportunidades)");
        System.out.println("\t2. Intermedio (5 oportunidades)");
        System.out.println("\t3. Dificil (3 oportunudades)");
        
        do {
            try {
                System.out.print("Elige una opción: ");
                byte opcion = Byte.parseByte(in.nextLine());

                switch (opcion) {
                    case 1 : return 10;
                    case 2 : return 5;
                    case 3 : return 3;
                    default: System.out.println("Opción no validad\n");
                }
            } catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        } while(true);

    }
}
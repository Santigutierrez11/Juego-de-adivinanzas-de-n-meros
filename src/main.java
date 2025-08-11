import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Random random = new Random();
        Scanner in = new Scanner(System.in);
        int numAleatorio;
        byte intentos;
        byte jugarOtraVez = 1;
        long lapsoInicio;
        long lapsoFin;
        
        while(jugarOtraVez == 1) {
            numAleatorio = random.nextInt(0, 101);
            intentos = 0;
            lapsoInicio = System.currentTimeMillis();

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
                        lapsoFin = System.currentTimeMillis();
                        System.out.println("Felicidades, acertaste el número en " + (totalIntentos - intentos) + " intentos y en " + (lapsoFin - lapsoInicio) / 1000 + " segundos");
                        break;
                    }

                    if (intentos == 0)
                        System.out.println("\nEl número era: " + numAleatorio);

                } catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
            } while(intentos >= 1);

            jugarOtraVez = jugarNuevamente();
            
        }
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

    public static byte jugarNuevamente(){
        Scanner in = new Scanner(System.in);
        byte jugarOtraVez = 0;
        while (true) {
            try {
                System.out.println("\nDecea jugar otra vez: (1. Si / 0. No)");
                jugarOtraVez = Byte.parseByte(in.nextLine());

                if (jugarOtraVez == 1 || jugarOtraVez == 0){
                    return jugarOtraVez;
                } else {
                    System.out.println("Opción no valida");
                }
            } catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
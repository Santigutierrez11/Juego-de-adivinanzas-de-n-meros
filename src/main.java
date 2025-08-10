import java.util.Scanner;

public class main {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        byte intentos;

        System.out.println("\t\t¡Bienvenidos al juego de adivinar números!");
        System.out.println("\t+--------------------------------------------------------+");
        System.out.println("\t|Estoy pensando en un número entre 1 y 100.              |");
        System.out.println("\t|Tienes 5 oportunidades para adivinar el número correcto |");
        System.out.println("\t+--------------------------------------------------------+");
        
        intentos = nivelDificultad();
        do {
            System.out.println(intentos);
            intentos -= 1;
        } while(intentos >= 0);
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
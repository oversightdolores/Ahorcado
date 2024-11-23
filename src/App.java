import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String palabraSecreta = "Futbol".toLowerCase();
        int intentosMax = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        char[] letrasAdivinadas = new char[palabraSecreta.length()];
        Set<Character> letrasIngresadas = new HashSet<>(); // Para rastrear letras ingresadas

        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        while (!palabraAdivinada && intentos < intentosMax) {
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length()  + " Letras)");
            System.out.println("Introduce una letra, por favor:");

            char letra = Character.toLowerCase(scanner.next().charAt(0)); // Convertir a minúscula

            // Verificar si la letra ya fue ingresada
            if (letrasIngresadas.contains(letra)) {
                System.out.println("¡Ya ingresaste esa letra! Elige otra.");
                continue; // Saltar a la siguiente iteración del bucle
            }

            letrasIngresadas.add(letra); // Añadir la letra al conjunto

            boolean letraCorrecta = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }

            if (!letraCorrecta) {
                intentos++;
                System.out.println("¡Incorrecto! Te quedan " + (intentosMax - intentos) + " intentos.");
            }

            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinada = true;
                System.out.println("¡Felicidades, has adivinado la palabra " + palabraSecreta + "!");
            }
        }

        if (!palabraAdivinada) {
            System.out.println("Perdiste, te quedaste sin intentos.");
        }

        scanner.close();
    }
}

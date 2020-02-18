import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] palabras = {"Berenjena", "Arbol", "Amazonas", "Papel", "Rinoceronte", "Muro", "Lapida", "Raiz", "Tulipan"};
        String palabra = "";
        ArrayList<String> letrasAcertadas = new ArrayList<String>();
        int numVidas = 4;
        boolean encontrado = false;
        Scanner console = new Scanner(System.in);

        palabra = elegirPalabra(palabras);
        iniciarPalabra(palabra, letrasAcertadas);

        while (numVidas > 0 && !hasGanado(palabra, letrasAcertadas)) {
            mostrarPalabraOculta(letrasAcertadas);
            encontrado = false;
            System.out.print("Introduce una letra: ");
            String letraUsuario = console.nextLine().substring(0, 1);
            String letraPalabra = "";
            for (int i = 0; i < palabra.length(); i++) {

                letraPalabra = palabra.substring(i, i+1);

                if (letraUsuario.equals(letraPalabra.toLowerCase())) {
                    encontrado = true;
                    letrasAcertadas.set(i, letraPalabra);
                }
            }

            if (!encontrado) numVidas--;

            switch (numVidas) {
                case 3:
                    dibujarCabeza();
                    break;
                case 2:
                    dibujarBrazos();
                    break;
                case 1:
                    dibujarCuerpo();
                    break;
            }

        }

        if (numVidas > 0) {
            System.out.println("¡HAS GANADO! La palabra era: " + palabra);
        } else {
            System.out.println("Has perdido :( Para saber qué palabra era, tendrás que jugar de nuevo y adivinarla jeje");
            dibujarPiernas();
        }



    }

    public static void iniciarPalabra(String palabra, ArrayList<String> letrasAcertadas) {
        for (int i = 0; i < palabra.length(); i++) {
            letrasAcertadas.add("_ ");
        }
    }

    public static void mostrarPalabraOculta(ArrayList<String> letrasAcertadas) {

        for (int i = 0; i < letrasAcertadas.size(); i++) {
            System.out.print(letrasAcertadas.get(i));
        }

        System.out.println();
    }

    public static boolean hasGanado(String palabra, ArrayList<String> letrasAcertadas) {

        boolean victoria = true;

        for (int i = 0; i < palabra.length(); i++) {
            if (!letrasAcertadas.get(i).equals(palabra.substring(i, i+1))) victoria = false;
        }

        return victoria;
    }

    public static String elegirPalabra(String[] palabras) {
        Random rand = new Random();
        int palabraElegida = rand.nextInt(palabras.length);

        return palabras[palabraElegida];
    }

    public static void dibujarCabeza() {
        System.out.println("      _________\n" +
                "     |/      |\n" +
                "     |      (_)\n" +
                "     |      \n" +
                "     |       \n" +
                "     |     \n" +
                "     |\n" +
                "    _|___");
    }

    public static void dibujarBrazos() {
        System.out.println("      _________\n" +
                "     |/      |\n" +
                "     |      (_)\n" +
                "     |      \\|/\n" +
                "     |       \n" +
                "     |      \n" +
                "     |\n" +
                "    _|___");
    }

    public static void dibujarCuerpo() {
        System.out.println("      _________\n" +
                "     |/      |\n" +
                "     |      (_)\n" +
                "     |      \\|/\n" +
                "     |       |\n" +
                "     |      \n" +
                "     |\n" +
                "    _|___");
    }

    public static void dibujarPiernas() {
        System.out.println("      _________\n" +
                "     |/      |\n" +
                "     |      (_)\n" +
                "     |      \\|/\n" +
                "     |       |\n" +
                "     |      / \\\n" +
                "     |\n" +
                "    _|___");
    }
}

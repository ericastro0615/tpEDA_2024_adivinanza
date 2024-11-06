package entidades;

import java.util.Scanner;

public class ArbolBinario {

    private String[] decisiones;

    public ArbolBinario() {
        decisiones = new String[63];
        inicializar();
    }

    public void inicializar() {
        try {
            decisiones[0] = "¿Es un mamifero?";
            decisiones[1] = "¿Suele ser utilizado para transporte?";
            decisiones[2] = "¿Este animal pasa mucho tiempo en el agua?";
            decisiones[3] = "¿Tiene orejas y dientes grandes?";
            decisiones[4] = "¿Produce leche?";
            decisiones[5] = "¿Vive en el agua salada?";
            decisiones[6] = "¿Este animal puede volar?";
            decisiones[7] = "BURRO 🫏";
            decisiones[8] = "CABALLO 🐎";
            decisiones[9] = "VACA 🐮";
            decisiones[10] = "¿Produce lana?";
            decisiones[21] = "OVEJA 🐑";
            decisiones[22] = "CABRA 🐐";
            decisiones[11] = "TIBURON";
            decisiones[12] = "RANA 🐸";
            decisiones[13] = "CONDOR ";
            decisiones[14] = "¿Tiene escamas?";
            decisiones[29] = "SERPIENTE 🐍";
            decisiones[30] = "¿Tiene caparazon?";
            decisiones[61] = "TORTUGA 🐢";
            decisiones[62] = "COCODRILO 🐊";
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: El índice en el array de decisiones está fuera de los límites. Revise la estructura del árbol.");
        } catch (Exception e) {
            System.out.println("Error: Se produjo un problema al inicializar las decisiones: " + e.getMessage());
        }
    }

    private boolean esPregunta(int index) {
        int izquierdo = 2 * index + 1;
        int derecho = 2 * index + 2;
        return (izquierdo < decisiones.length && decisiones[izquierdo] != null) ||
                (derecho < decisiones.length && decisiones[derecho] != null);
    }


    public void jugarAdivinanza() {
        Scanner sc = new Scanner(System.in);
        int punteroArbol = 0;

        while (punteroArbol < decisiones.length && decisiones[punteroArbol] != null) {
            if (esPregunta(punteroArbol)) {
                // Si es una pregunta, hacemos la pregunta al usuario
                System.out.println(decisiones[punteroArbol]);
                String respuestaUsuario = sc.nextLine().toLowerCase().trim();
                if (respuestaUsuario.equals("si")) {
                    punteroArbol = 2 * punteroArbol + 1; // nodo izq
                } else {
                    punteroArbol = 2 * punteroArbol + 2; // nodo der
                }
            } else {
                // Si es una respuesta (hoja), confirmamos el animal
                System.out.println("¿El animal que estás pensando es " + decisiones[punteroArbol] + "?");
                String rptaComprobandoAnimal = sc.nextLine().trim();

                if (rptaComprobandoAnimal.equalsIgnoreCase("si")) {
                    System.out.println("Excelente! 🎉");
                } else {
                    System.out.println("Lo lamento, mi conocimiento es limitado 😔");
                }
                break;
            }
        }
    }

    public void mostrarAnimales() {
        System.out.println("\n Animales cargados en el sistema : 🔎🌳 \n");
        for (int i = 0; i < decisiones.length; i++) {
            if (decisiones[i] != null && !esPregunta(i)) {
                System.out.println("- " + decisiones[i]);
            }
        }
    }


}

package piedrapapeltijera;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PiedraPapelTijera {
    public static void main(String[] args) {
    	System.out.println(PiedraPapelTijera.class.getResource("/images/piedra.jpg"));
    	System.out.println(PiedraPapelTijera.class.getResource("/images/lagarto-spcok.jpg"));
    	System.out.println(PiedraPapelTijera.class.getResource("/images/papel.jpg"));
    	System.out.println(PiedraPapelTijera.class.getResource("/images/tijera.jpg"));
    	System.out.println(PiedraPapelTijera.class.getResource("/images/lagarto.jpg"));
    	System.out.println(PiedraPapelTijera.class.getResource("/images/spock.jpg"));
        // Carga de imágenes
        ImageIcon icono = new ImageIcon(PiedraPapelTijera.class.getResource("/images/lagarto-spcok.jpg")); // asegúrate de que el nombre esté bien
        ImageIcon imagenPiedra = new ImageIcon(PiedraPapelTijera.class.getResource("/images/piedra.jpg"));

        ImageIcon imagenPapel = new ImageIcon(PiedraPapelTijera.class.getResource("/images/papel.jpg"));
        ImageIcon imagenTijera = new ImageIcon(PiedraPapelTijera.class.getResource("/images/tijera.jpg"));
        ImageIcon imagenLagarto = new ImageIcon(PiedraPapelTijera.class.getResource("/images/lagarto.jpg"));
        ImageIcon imagenSpock = new ImageIcon(PiedraPapelTijera.class.getResource("/images/spock.jpg"));
      

        // Mostrar reglas
        JOptionPane.showMessageDialog(
            null,
            "Bienvenido al juego Piedra, Papel, Tijera, Lagarto o Spock.\n\n"
            + "Es una versión extendida del clásico juego inventado por Sheldon Cooper.\n\n"
            + "Reglas:\n"
            + "- Tijera corta a Papel\n"
            + "- Papel tapa a Piedra\n"
            + "- Piedra aplasta a Lagarto\n"
            + "- Lagarto envenena a Spock\n"
            + "- Spock rompe Tijera\n"
            + "- Tijera decapita a Lagarto\n"
            + "- Lagarto se come a Papel\n"
            + "- Papel refuta a Spock\n"
            + "- Spock vaporiza a Piedra\n"
            + "- Piedra aplasta a Tijera\n\n"
            + "Cada elemento gana contra dos y pierde contra otros dos.\n"
            + "Si ambos eligen lo mismo, es empate.",
            "Reglas del Juego",
            JOptionPane.INFORMATION_MESSAGE,
            icono
        );

        int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese:\n1 - Para empezar a jugar\n0 - Para salir"));

        while (opcion != 0) {
            int puntosJugador = 0, puntosMaquina = 0;

            while (puntosJugador < 3 && puntosMaquina < 3) {
                int jugador = Integer.parseInt(JOptionPane.showInputDialog(
                    "Elija una opción:\n1 - Piedra\n2 - Papel\n3 - Tijera\n4 - Lagarto\n5 - Spock"
                ));

                int maquina = (int)(Math.random() * 5 + 1);

                // Mostrar imágenes de elección
                ImageIcon imagenJugador = getImagen(jugador, imagenPiedra, imagenPapel, imagenTijera, imagenLagarto, imagenSpock);
                ImageIcon imagenMaquina = getImagen(maquina, imagenPiedra, imagenPapel, imagenTijera, imagenLagarto, imagenSpock);

                JOptionPane.showMessageDialog(null, "Tu elección:", "Jugador", JOptionPane.INFORMATION_MESSAGE, imagenJugador);
                JOptionPane.showMessageDialog(null, "Elección de la máquina:", "Máquina", JOptionPane.INFORMATION_MESSAGE, imagenMaquina);

                // Evaluar resultado
                if (jugador == maquina) {
                    JOptionPane.showMessageDialog(null, "Empate");
                } else if (
                    (jugador == 1 && (maquina == 3 || maquina == 4)) ||  // Piedra vence a Tijera o Lagarto
                    (jugador == 2 && (maquina == 1 || maquina == 5)) ||  // Papel vence a Piedra o Spock
                    (jugador == 3 && (maquina == 2 || maquina == 4)) ||  // Tijera vence a Papel o Lagarto
                    (jugador == 4 && (maquina == 2 || maquina == 5)) ||  // Lagarto vence a Papel o Spock
                    (jugador == 5 && (maquina == 1 || maquina == 3))     // Spock vence a Piedra o Tijera
                ) {
                    JOptionPane.showMessageDialog(null, "¡Ganaste esta ronda!");
                    puntosJugador++;
                } else {
                    JOptionPane.showMessageDialog(null, "La máquina ganó esta ronda.");
                    puntosMaquina++;
                }

                JOptionPane.showMessageDialog(null, "Puntaje: Jugador " + puntosJugador + " - Máquina " + puntosMaquina);
            }

            // Mostrar resultado final de la partida
            if (puntosJugador == 3) {
                JOptionPane.showMessageDialog(null, "¡Ganaste la partida!");
            } else {
                JOptionPane.showMessageDialog(null, "La máquina ganó la partida.");
            }

            opcion = Integer.parseInt(JOptionPane.showInputDialog("¿Desea jugar otra vez?\n1 - Sí\n0 - No"));
        }

        JOptionPane.showMessageDialog(null, "¡Gracias por jugar!");
    }

    // Método para obtener la imagen correspondiente según la elección
    private static ImageIcon getImagen(int eleccion, ImageIcon piedra, ImageIcon papel, ImageIcon tijera, ImageIcon lagarto, ImageIcon spock) {
        switch (eleccion) {
            case 1: return piedra;
            case 2: return papel;
            case 3: return tijera;
            case 4: return lagarto;
            case 5: return spock;
            default: return null;
        }
    }
}




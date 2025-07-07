package quienesquien;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

class Quienesquien {
    public static void main(String[] args) {
        String[] personas = { "Paul", "Dora", "Sam", "Ted", "Katia", "Alain", "Bob", "Sophie", "Natacha", "Chris",
                "Denis", "Lou", "Eric", "Alice", "Franck", "Gregory", "Hugo", "Samira", "Ilian", "Jeremy", "Lisa",
                "Kevin", "Caroline", "Laurent", "Melanie", "Marie", "Rachid", "Marc", "Eloide", "Matehau" };

        String[] preguntas = { "¿Tiene anteojos?", "¿Es mujer?", "¿Tiene el pelo corto?",
                "¿Su piel es de color morena?", "¿Tiene barba?", "¿Su pelo es de color negro?",
                "¿Su pelo es de color anaranjado?" };

        String[][] respuestas = {
                {"si", "no", "si", "no", "no", "si", "no" }, // Paul
                {"si", "si", "no", "no", "no", "no", "no" }, // Dora
                {"no", "no", "si", "no", "si", "no", "no" }, // Sam
                {"no", "no", "si", "si", "no", "si", "no" }, // Ted
                {"no", "si", "si", "no", "no", "no", "no" }, // Katia
                {"si", "no", "si", "no", "no", "no", "si" }, // Alain
                {"si", "no", "si", "si", "no", "no", "no" }, // Bob
                {"si", "si", "si", "si", "no", "si", "no" }, // Sophie
                {"no", "si", "no", "no", "no", "no", "no" }, // Natacha
                {"no", "no", "si", "si", "si", "si", "no" }, // Chris
                {"si", "no", "si", "no", "no", "no", "no" }, // Denis
                {"no", "si", "no", "no", "no", "no", "no" }, // Lou
                {"no", "no", "si", "no", "no", "si", "no" }, // Eric
                {"no", "si", "si", "no", "no", "si", "no" }, // Alice
                {"no", "no", "si", "no", "si", "no", "no" }, // Franck
                {"no", "no", "si", "no", "si", "no", "no" }, // Gregory
                {"si", "no", "si", "no", "no", "si", "no" }, // Hugo
                {"si", "si", "no", "no", "no", "si", "no" }, // Samira
                {"si", "no", "si", "no", "si", "no", "si" }, // Ilian
                {"no", "no", "si", "no", "no", "no", "si" }, // Jeremy
                {"si", "si", "no", "no", "no", "si", "no" }, // Lisa
                {"no", "no", "si", "no", "no", "si", "no" }, // Kevin
                {"si", "si", "si", "no", "no", "no", "si" }, // Caroline
                {"no", "no", "si", "no", "si", "si", "no" }, // Laurent
                {"si", "si", "si", "no", "no", "no", "si" }, // Melanie
                {"no", "si", "no", "no", "no", "no", "no" }, // Marie
                {"no", "no", "si", "si", "no", "no", "no" }, // Rachid
                {"no", "no", "si", "no", "si", "si", "no" }, // Marc
                {"si", "si", "si", "si", "no", "si", "no" }, // Eloide
                {"no", "no", "si", "no", "no", "si", "no" }  // Matehau
        };

        String respuesta = "";
        int arriesga;
        ImageIcon imagen = new ImageIcon(Quienesquien.class.getResource("/images/quienes.jpg"));

        JOptionPane.showMessageDialog(null, "Bienvenidos a 'Adivina quién es'\nEl juego consiste en adivinar el personaje a través de las pistas.");
        JOptionPane.showMessageDialog(null, "¿Estás listo? ¡Empecemos!");
        
        int opcion = Integer.parseInt(JOptionPane.showInputDialog("Elige una opción:\n0 - Salir\n1 - Empezar el juego"));

        while (opcion != 0) {
            int indice = (int)(Math.random() * personas.length);
            String personaElegida = personas[indice];
            String historial = ""; 

            for (int i = 0; i < preguntas.length; i++) {
                String pregunta = preguntas[i];
                String respuestaPista = respuestas[indice][i];

                historial += pregunta + "\nRespuesta: " + respuestaPista + "\n\n";

                JOptionPane.showMessageDialog(null, historial, "Pistas acumuladas", JOptionPane.INFORMATION_MESSAGE, imagen);

                arriesga = Integer.parseInt(JOptionPane.showInputDialog("¿Qué desea hacer?\n1 - Arriesgar\n2 - Más pistas"));

                if (arriesga == 1) {
                    respuesta = JOptionPane.showInputDialog("Ingrese el personaje que cree que es:");
                    if (respuesta.equalsIgnoreCase(personaElegida)) {
                        JOptionPane.showMessageDialog(null, "¡Siii! El personaje era: " + personaElegida, "Ganaste", JOptionPane.INFORMATION_MESSAGE, imagen);
                    } else {
                        JOptionPane.showMessageDialog(null, "Perdiste. El personaje era: " + personaElegida, "Perdiste", JOptionPane.ERROR_MESSAGE, imagen);
                    }
                    break; 
                }
            }

            
            
            respuesta = (String) JOptionPane.showInputDialog(
            	    null,
            	    "Se terminaron las pistas. ¿Quién es el personaje?\n\n" + historial,
            	    "Última oportunidad",
            	    JOptionPane.QUESTION_MESSAGE,
            	    imagen,
            	    null,
            	    null
            	);
                if (respuesta.equalsIgnoreCase(personaElegida)) {
                    JOptionPane.showMessageDialog(null, "¡Ganaste! El personaje era: " + personaElegida, "Acierto", JOptionPane.INFORMATION_MESSAGE, imagen);
                } else {
                    JOptionPane.showMessageDialog(null, "No era. El personaje era: " + personaElegida, "Fallaste", JOptionPane.ERROR_MESSAGE, imagen);
                }
            

            // Repetir el juego o salir
            opcion = Integer.parseInt(JOptionPane.showInputDialog("¿Desea jugar otra vez?\n0 - Salir\n1 - Jugar de nuevo"));
        }
    }
}




package piedrapapeltijera1906;
import java.util.*;

public class PiedraPapelTijera1906 {

   
    public static void main(String[] args) {
      Scanner leer = new Scanner(System.in);
      Random RD = new Random();
      
      String jugador1;
      String jugador2 = "R2D2";
      String resp1;
      String resp2 = "";
      
      int numeroRandom;
      int jugadas = 0;
      int puntosJugador1= 0;
      int puntosJugador2 = 0;
      int maxJugadas = 5;
      int[][] tablero= new int [maxJugadas][2];
      //int[] tableroJugador2= new int[10];
      
      
      System.out.println("PIEDRA, PAPEL o TIJERA\n");
      // Pedir a los jugadores su nombre
      System.out.print("Ingrese el nombre del Jugador 1: ");
        jugador1 = leer.next();
      System.out.println("¡Hola, "+jugador1+"! Vas a jugar contra "+jugador2+". \n");
      System.out.println();
      System.out.println("REGLAS DEL JUEGO \n"
              + "Posees 3 jugadas y deberás ingresar tu opción de la siguiente forma:\n"
              + "P para Piedra\nL para Papel\nT para Tijera\n"
              + "Escribí cualquier tecla+ENTER para iniciar el juego");
            String rta= leer.next();//no hace nada, solo es para continuar
      
        // Inicio del juego
        // se corta si alguien hizo +2 puntos
        // se corta a las 3 jugadas si hay ganador
        // si estan empatadxs se sigue hasta que alguien gane
        
        while(/*condicion1*/((jugadas<3)&& (!(puntosJugador1==2 || puntosJugador2==2))) ||
              /*condicion2*/((jugadas>2) && (puntosJugador1 == puntosJugador2))){
            
            // Resolucion EMPATE
            if((jugadas>2) && (puntosJugador1 == puntosJugador2)){
                System.out.println();
                System.out.println("RESOLUCIÓN DE EMPATE: ");
            }
            
            //INICIO DE JUGADA 
            jugadas++;
            System.out.println();
            System.out.println("JUGADA " +(jugadas)); 
            
            // respuesta del jugador 1
            //solo sigue si escribe P, L o T
            do{
                System.out.println("¿PIEDRA(P), PAPEL(L) O TIJERA(T)?");
                System.out.print(jugador1 +": ");
                resp1 = leer.next();
                if(!(resp1.equalsIgnoreCase("p")||resp1.equalsIgnoreCase("l")||resp1.equalsIgnoreCase("t"))){
                    System.out.println("\n -- Por favor ingresá una respuesta válida --");
                }
            }while(!(resp1.equalsIgnoreCase("p")||resp1.equalsIgnoreCase("l")||resp1.equalsIgnoreCase("t")));
            
            //respuesta de jugador 2
            numeroRandom = (RD.nextInt(3) +1);
            switch (numeroRandom){
                case 1: 
                    resp2 = "P";
                        break;
                case 2: 
                    resp2 = "T";
                        break;
                case 3: 
                    resp2 = "L";
                        break;
            }
            System.out.println("Respuesta de "+jugador2+": " + resp2);
            
            //comparar respuestas e indicar los resultados
            //empate
            if((resp1.equalsIgnoreCase("P") && resp2.equalsIgnoreCase("P")) ||
                (resp1.equalsIgnoreCase("L") && resp2.equalsIgnoreCase("L"))||
                (resp1.equalsIgnoreCase("T") && resp2.equalsIgnoreCase("T"))){
                System.out.println("\n----- EMPATE -----");
                
                tablero[jugadas-1][0] = 0;
                tablero[jugadas-1][1] = 0;
            }
            //gana jugador 1
            if((resp1.equalsIgnoreCase("P") && resp2.equalsIgnoreCase("T"))||
                (resp1.equalsIgnoreCase("L") && resp2.equalsIgnoreCase("P"))||
                (resp1.equalsIgnoreCase("T") && resp2.equalsIgnoreCase("L"))){
                    
                    System.out.println("\n----- GANADOR JUGADA "+(jugadas)+": "+jugador1+" -----");
                    puntosJugador1++;
                    
                    tablero[jugadas-1][0] = 1;
                    tablero[jugadas-1][1] = 0;
            }
            //gana jugador 2
            if((resp1.equalsIgnoreCase("P") && resp2.equalsIgnoreCase("L"))||
                (resp1.equalsIgnoreCase("L") && resp2.equalsIgnoreCase("T"))||
                (resp1.equalsIgnoreCase("T") && resp2.equalsIgnoreCase("P"))){
                    
                    System.out.println("\n----- GANADOR JUGADA "+(jugadas)+": "+jugador2+" -----");
                    puntosJugador2++;
                    
                    tablero[jugadas-1][0] = 0;
                    tablero[jugadas-1][1] = 1;
            } 
            
            //registro de los puntos
            System.out.println(jugador1+": "+puntosJugador1+" punto(s).");
            System.out.println(jugador2+": "+puntosJugador2+" punto(s).");
        }
        System.out.println();
        
      
        //Tablero
        System.out.println("            "+jugador1+"       "+jugador2);
        
        for(int i=0; i<jugadas;i++){
            System.out.print("JUGADA "+(i+1)+"   ");
            System.out.print("|    "+tablero[i][0]+"    |");
            System.out.print("    "+tablero[i][1]+"    |");
            System.out.println("");
            
        }
        System.out.println("            PUNTOS:"+puntosJugador1+"  PUNTOS:"+puntosJugador2);
        if(puntosJugador1>puntosJugador2){
            System.out.println("          ---GANADOR---");
            System.out.println("\n===== ¡¡¡Felicitaciones, "+jugador1+"!!! =====");
        } else{
            System.out.println("                     ---GANADOR---");
        }
        System.out.println("\n ==== GRACIAS POR PARTICIPAR ==== ");
        //fin
        
    }
}

        
    
    


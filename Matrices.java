import java.util.Scanner;
import java.util.Random;
public class Matrices{
 public static void main(String args[]){
  
  Scanner entrada = new Scanner(System.in);
  String nombre = "";
  int filas = 0, columnas = 0, contador = 1, NumCuadrosAjedrez = 0, TorresUsuario = 0, NumAsteriscos = 0, Asteriscos = 0, numeroaleatorio = 0, NumTorres = 0, numeroaleatorioLetras = 0;
  int BanderaAleatorio = 0;

  System.out.println("Cual es tu nombre?");
  nombre = entrada.nextLine();
  
  System.out.println("¿Cuantas Filas Deseas?");
  filas = entrada.nextInt();

  System.out.println("¿Cuantas Columnas Deseas?");
  columnas = entrada.nextInt();

  NumCuadrosAjedrez = filas * columnas;
  
  System.out.println("¿Cuantas Torres Deseas? recuerda que debe ser un valor entre 1 y " + NumCuadrosAjedrez);
  TorresUsuario = entrada.nextInt();

  while (TorresUsuario > NumCuadrosAjedrez || TorresUsuario < 1){
   System.out.println("recuerda que debe ser un valor entre 1 y " + NumCuadrosAjedrez);
   TorresUsuario = entrada.nextInt();
  }

  String tablero [][] = new String [filas][columnas];
  NumAsteriscos = NumCuadrosAjedrez - TorresUsuario;

  for (int i = 0; i < tablero.length; i++) {
   for (int j = 0; j < tablero[i].length; j++) {
    if (NumAsteriscos == 0){
     numeroaleatorio = 1;
     BanderaAleatorio = 1;
    }
    if (BanderaAleatorio == 0)
    { 
      Random rand = new Random();
      numeroaleatorio = rand.nextInt() % 2;
    }
    if (numeroaleatorio == 0){
     if (Asteriscos < NumAsteriscos){
      tablero[i][j] = ".";
      Asteriscos++;
      if (Asteriscos == NumAsteriscos){
       numeroaleatorio = 1;
       BanderaAleatorio = 1;
      }
     }
    }
    else{
     if (NumTorres < TorresUsuario){
      Random rand = new Random();
      numeroaleatorioLetras = rand.nextInt() % 2;
      if (numeroaleatorioLetras == 0)
       tablero[i][j] = "B";
      else
       tablero[i][j] = "N";
      NumTorres++;
      if (NumTorres == TorresUsuario){
       numeroaleatorio = 0;
       BanderaAleatorio = 1;
      }
     }
    }    
   }
  }

  for (int i = 0; i < tablero.length; i++) {
        for (int j = 0; j < tablero[i].length; j++) {
            System.out.printf(tablero[i][j] + "       ");
        }
        System.out.println("");
    }

  System.out.println("Ejecutar Ataque");

  for (int i = 0; i < tablero.length; i++) {
   for (int j = 0; j < tablero[i].length; j++) {
    if (tablero[i][j] == "B"){
     for (int recorrecolumna = 0; recorrecolumna < tablero[i].length; recorrecolumna++) {
      if (tablero[i][recorrecolumna] == "N"){
       System.out.println(tablero[i][j] + " en la posicion: (" + i + "," + j + ") ataca a " + tablero[i][recorrecolumna] + " en la posicion: (" + i + "," + recorrecolumna + ")");
      }
     }
     for (int recorrefila = 0; recorrefila < tablero[i].length; recorrefila++) {
      if (tablero[recorrefila][j] == "N"){
       System.out.println(tablero[i][j] + " en la posicion: (" + i + "," + j + ") ataca a " + tablero[recorrefila][j] + " en la posicion: (" + recorrefila + "," + j + ")");
      }
     }
    }
    else if (tablero[i][j] == "N"){
     for (int recorrecolumna = 0; recorrecolumna < tablero[i].length; recorrecolumna++) {
      if (tablero[i][recorrecolumna] == "B"){
       System.out.println(tablero[i][j] + " en la posicion: (" + i + "," + j + ") ataca a " + tablero[i][recorrecolumna] + " en la posicion: (" + i + "," + recorrecolumna + ")");
      }
     }
     for (int recorrefila = 0; recorrefila < tablero[i].length; recorrefila++) {
      if (tablero[recorrefila][j] == "B"){
       System.out.println(tablero[i][j] + " en la posicion: (" + i + "," + j + ") ataca a " + tablero[recorrefila][j] + " en la posicion: (" + recorrefila + "," + j + ")");
      }
     }
    }
   }
  }


  System.out.println("Gracias " + nombre + " fue un placer ayudarte");
 }
}
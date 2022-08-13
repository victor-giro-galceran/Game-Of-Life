
import java.util.Arrays;
import java.util.Scanner;

/* 
Author:		green-vibes-coding
URL:		-
Version:	1.0
*/

public class Juego_Vida {
	
	Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {

		Juego_Vida juego = new Juego_Vida();
		juego.principal();

	}


	// ----------------------------------  P R I N C I P A L  ---------------------------------- \\
	///////////////////////////////////////////////////////////////////////////////////////////////

	
	public void principal() {
		
		
		menu();


	}

	//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	// -------------------------------- / P R I N C I P A L  ---------------------------------- //

	

	// =================================  M A I N    C O D E  ================================= \\
	
	
	// ------------------------------------- M E T H O D S ------------------------------------- //

	public int[][] metodo_automatico(int[][] cuadricula) {
				
		int contador = 0;
		int generaciones = 0;
		int grupos = 0;
		
		
		System.out.println("¿Cuántos grupos de células quieres introducir?");
		System.out.print("N = ");
		grupos = scan.nextInt();
		
		
		do {
			
			for (contador = 0; contador <= grupos; contador++) {
			
				int fila = 0;
				int columna = 0;
				
				fila = generar_numero_aleatorio(0, 12);
				columna = generar_numero_aleatorio(0, 12);
				
				for (int x = 1; x < cuadricula.length - 1; x++) {
		
					for (int y = 1; y < cuadricula[0].length - 1; y++) {
						
						cuadricula[fila][columna] = 1;

					}
		
				}

			}
			
			System.out.println("\nSe han introducido [" + grupos + "] células\n");
			imprimir_cuadricula(cuadricula);
			
		} while (contador < 5);

		
		System.out.println("\n¿Cuántas generaciones quieres simular?");
		System.out.print(">> ");
		generaciones = scan.nextInt();
		
		for (int i = 0; i < generaciones; i ++) {
			
			sleep(2000);
			imprimir_cuadricula(cuadricula);
			evolucion(cuadricula);
			System.out.println("Generación [" + i + "]\n");
			
		}
		
		return cuadricula;
		
	}
	
	public int[][] metodo_manual(int[][] cuadricula) {
		
		int contador = 0;
		int generaciones = 0;
				
		do {
			
			for (contador = 0; contador < 5; contador++) {
			
				int fila = 0;
				int columna = 0;
				
				if (contador == 0) {
					imprimir_cuadricula(cuadricula);
				}
				
				System.out.println("\n¿En qué fila quieres introducir una célula?");
				System.out.print(">> ");
				fila = scan.nextInt();

				
				System.out.println("\n¿En qué columna quieres introducir una célula?");
				System.out.print(">> ");
				columna = scan.nextInt();
				
				System.out.println("\n\nHas introducido una célula en la posición [" + fila + "][" + columna + "]\n");
				
				for (int x = 1; x < cuadricula.length - 1; x++) {
		
					for (int y = 1; y < cuadricula[0].length - 1; y++) {
						
						cuadricula[fila][columna] = 1;
						
					}
		
				}
				
				imprimir_cuadricula(cuadricula);
			}
			
			System.out.println("\nHas introducido 5 células\n");
			
		} while (contador < 5);
			
		
		System.out.println("¿Cuántas generaciones quieres simular?");
		System.out.print(">> ");
		generaciones = scan.nextInt();
		System.out.print("\n");
		
		for (int i = 0; i < generaciones; i ++) {
			
			sleep(2000);
			imprimir_cuadricula(cuadricula);
			evolucion(cuadricula);
			System.out.println("Generación [" + i + "]\n");
			
		}
		
		return cuadricula;
		
	}
	

	// --------------------------------------- R U L E S --------------------------------------- //
	
	public int reglas_primera_letra() {
		
		int primera_letra = 2;		
		return primera_letra;
	}
	
	public int reglas_segunda_letra() {
		int segunda_letra = 3;
		return segunda_letra;
	}
	
	public int reglas_tercera_letra() {
		int tercera_letra = 3;
		return tercera_letra;
	}
	
	public void configurar_reglas() {
		
		System.out.println("Las reglas predeterminadas són: [23/3]");
		
		System.out.println("\n¿Quieres cambiar las reglas? (\"yes\" / \"no\")");
		System.out.print(">> ");
		String opcion = scan.next();
		
		int primera_letra_A = 0;
		int segunda_letra_A = 0;
		int tercera_letra_B = 0;
		
		if (opcion.equalsIgnoreCase("Yes")) {
			
			System.out.print("\nIntroduce un valor para la primera letra ");
			sleep(400);
			System.err.print("A");
			sleep(400);
			System.out.print("|-|-\n");
			System.out.print(">> ");
			primera_letra_A = scan.nextInt();

			if (primera_letra_A >= 0 && primera_letra_A <= 9) {

				System.out.print("\n~~~~~~~~~~~ Valor asignado, " + primera_letra_A + "|-|- ~~~~~~~~~~~\n");

			} else {

				System.out.print("\nIntroduce un valor válido\n");

			}
	
			System.out.print("\n\nIntroduce un valor para la segunda letra " + primera_letra_A + "|");
			sleep(400);
			System.err.print("A");
			sleep(400);
			System.out.print("|-\n");
			System.out.print(">> ");
			segunda_letra_A = scan.nextInt();
	
			if (segunda_letra_A >= 0 && segunda_letra_A <= 9) {
					
				System.out.println("\n~~~~~~~~~~~ Valor asignado, " + primera_letra_A + "|" + segunda_letra_A + "|- ~~~~~~~~~~~");

			} else {
	
				System.out.print("\nIntroduce un valor válido\n");
	
			}
	
			System.out.print("\n\nIntroduce el valor de la tercera letra " + primera_letra_A + "|" + segunda_letra_A + "|");
			sleep(400);
			System.err.print("B");
			sleep(400);
			System.out.print("\n>> ");
			tercera_letra_B = scan.nextInt();
	
			if (tercera_letra_B >= 0 && tercera_letra_B <= 9) {
	
				System.out.print("\n~~~~~~~~~~~ Valor asignado, " + primera_letra_A + "|" + segunda_letra_A + "|" + tercera_letra_B + " ~~~~~~~~~~~\n");
	
			} else {
	
				System.out.print("\nIntroduce un valor válido\n");
	
			}

			
			
			System.out.print("\nGuardando la configuración");
			
			for (int i = 0; i < 3; i++) {
				
				System.out.print(".");
				sleep(2000);
			
			}
			
			System.out.println("");
	
		} else if (opcion.equalsIgnoreCase("No")) {
			
			System.out.println("\nSe mantienen las reglas predeterminadas");
		
		} else {
			
			System.out.println("\nTienes que introducir \"yes\" o \"no\"");
		
		}		
		
	}

	// ------------------------------------ T E M P O R A L ------------------------------------ //
	
	int[][] cuadricula = new int[2 + 12][2 + 12];
	
	int cuadricula_filas = 12;
	int cuadricula_columnas = 12; 
	final int[][] cuadricula_temporal = new int[cuadricula_filas][cuadricula_columnas];
	

	// ------------------------------- C O N W A Y ' S   G A M E ------------------------------- //
	
	public int estudiar_vecinos(int columna, int fila, int cuadricula[][]) {

		int suma = 0;

		for (int y = -1; y <= 1; y++) {

			for (int x = -1; x <= 1; x++) {

				if (x != 0 || y != 0) {

					try {
	                    
						suma += cuadricula[y + fila][x + columna];
	                  
					} catch (ArrayIndexOutOfBoundsException e) {
	                  
					}

				}

			}
		
		}
		return suma;

	}
		
	public void evolucion(int cuadricula[][]) {

		for (int fila = 1; fila < cuadricula_filas - 1; fila++) {

			for (int columna = 1; columna < cuadricula_columnas - 1; columna++) {

				int suma = estudiar_vecinos(columna, fila, cuadricula);

				if (cuadricula[fila][columna] == 0 && suma == reglas_tercera_letra()) {

					cuadricula_temporal[fila][columna] = 1;

				} else if (cuadricula[fila][columna] == 1 && (suma == reglas_primera_letra() || suma == reglas_segunda_letra())) {

					cuadricula_temporal[fila][columna] = 1;

				} else {

					cuadricula_temporal[fila][columna] = 0;

				}

			}

		}

		for (int fila = 0; fila < cuadricula_temporal.length; fila++) {

			int columnas[] = cuadricula_temporal[fila];
			System.arraycopy(columnas, 0, cuadricula[fila], 0, columnas.length);
		}

	}
	
	public void imprimir_cuadricula(int cuadricula[][]) {

		System.out.println(Arrays.deepToString(cuadricula)

				.replace("],", "],\n")
				.replaceAll("[ ,\\[\\]]", "")
				.replace("1", " ⬛") // ■ ◼ ⬛ ■ ▦ ⬛
				.replace("0", " ⛶")); // ⛶ ⬜

	}
	
	
	// --------------------------------------- M E N U S --------------------------------------- //
		
	public void menu_bienvenida() {
		
		System.out.println("\nBienvenido/a al juego de la vida de Conway\n");
		System.out.print("Mapa configurado a 12 x 12");
		
		for (int i = 0; i < 3; i++) {
			System.out.print(".");
			sleep(2000);
		}
		
		System.out.println("\n\nReglas de evolución: ");
		System.out.println("- Cada célula viva con 2 o 3 células vecinas sobrevive");
		System.out.println("- Cada célula con 4 o más vecinos muere por \"sobrepoblación\"");
		System.out.println("- Cada célula con 1 o ninguna vecina muere por \"soledad\"");
		System.out.println("- Cada célula muerta con 3 células vivas vecinas, \"revive\"");
		sleep(9000);
	}
	
	public void menu_formato() {
		
		System.out.println("\nA continuacuión, tienes que escoger el formato de impresión del mapa");
		
		int[][] formato_cuadricula = { 
		        {1,1,0,1,1,1},
		        {1,0,0,1,0,0},
		        {1,1,0,1,0,0},
		        {1,0,0,0,0,1},
		        {0,0,1,0,1,0},
		        {1,0,1,0,0,0}
			    
		};
		
		imprimir_formato_cuadricula_03(formato_cuadricula);
		
		System.out.println("\n");
		
		imprimir_formato_cuadricula_02(formato_cuadricula);

		System.out.println("\n");
		
		imprimir_formato_cuadricula_04(formato_cuadricula);
	}
		
	public void menu() {
		
		// menu_bienvenida();
		
		int opcion = 0;		
		String nombre_poblacion = "0. Poner nombre a la población";
		
		do {
			System.out.println("\n==================================\n");
			System.out.println(nombre_poblacion);
			System.out.println("1. Configurar reglas");
			System.out.println("2. Manual");
			System.out.println("3. Automático");
			System.out.println("4. Patrones");
			System.out.println("5. Salir");
			System.out.print(">> ");
			opcion = scan.next().charAt(0);

			System.out.println("\n==================================\n");

			switch (opcion) {

				case '0': // ================================  O P C I Ó N  0  ================================
					
					System.out.println("_____________________________________________________________\n");
					System.out.println("Has seleccionado la opción 0: \"Poner nombre a la población\"\n");
					
					nombre_poblacion = "Tu población es " + nombre_poblacion() + "\n";
					
					
					System.out.println("_____________________________________________________________\n");
					break;
					
					
				case '1': // ================================  O P C I Ó N  1  ================================
					
					System.out.println("_____________________________________________________________\n");
					System.out.println("Has seleccionado la opción 1: \"Configurar reglas\"\n");

					configurar_reglas();
					
					System.out.println("_____________________________________________________________\n");
					break;

			
				case '2': // ================================  O P C I Ó N  2  ================================

					System.out.println("_____________________________________________________________\n");
					System.out.println("Has seleccionado la opción 2: \"Manual\"\n");

					
					int[][] cuadricula_manual = metodo_manual(cuadricula);
					imprimir_cuadricula(cuadricula_manual);
					

					System.out.println("_____________________________________________________________\n");
					break;
				
		
				case '3': // ================================  O P C I Ó N  3  ================================
				
					System.out.println("_____________________________________________________________\n");
					System.out.println("Has seleccionado la opción 3: \"Automático\"\n");
				
					
					int[][] cuadricula_automatica = metodo_automatico(cuadricula);
					imprimir_cuadricula(cuadricula_automatica);

					
					System.out.println("_____________________________________________________________\n");
					break;
			
		
				case '4': // ================================  O P C I Ó N  4  ================================
				
					System.out.println("_____________________________________________________________\n");
					System.out.println("Has seleccionado la opción 4: \"Patrones\"\n");
				
					final int[][] cuadricula_patron_01 = { 
							
						{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					        {0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},
					        {0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
					        {0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},
					        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
					        
					    };
					
					for (int i = 0; i <= 9; i++) {
						
						System.out.println("================================");
						imprimir_cuadricula(cuadricula_patron_01);
						evolucion(cuadricula_patron_01);
						System.out.println("================================");
						sleep(2000);
						
					}
					
					
					System.out.println("_____________________________________________________________\n");
					break;
					
				case '5': // ================================  O P C I Ó N  5  ================================
					
					System.out.println("_____________________________________________________________\n");
					System.out.println("Has seleccionado la opción 5: \"Salir\"\n");
				
					System.out.print("Saliendo de la simulación");
					
					for (int i = 0; i < 3; i++) {
						
						sleep(1000);
						System.out.print(".");
					
					}
					
					System.out.println("");
					
					System.out.println("_____________________________________________________________\n");
					break;
					
			
				default:
					System.out.println("¡Introduce números del 0 al 5!");
			}

		} while (opcion != '5');
		
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
		System.out.println("=================== Simulacion finalizada ===================");
		
		scan.close();
	}
	

	// ---------------------------------- A E S T H E T I C ------------------------------------ //
	
	public void sleep(int time) {
	
		try {
			
			Thread.sleep(time);
			
		} catch (InterruptedException e) {
				
		}
		
	}
	
	public String nombre_poblacion() {
		
		String nombre_poblacion = "";
		int definir_generar;
		
		System.out.println("1. Generar una población aleatoria");
		System.out.println("2. Definir un nombre a la población");
		System.out.print(">> ");
		definir_generar = scan.nextInt();
		
		if (definir_generar == 2) {
			
			System.out.println("\n¿Cómo quieres que se llame la población?");
			System.out.print(">> ");
			nombre_poblacion = scan.next();
			
			System.out.println("\n¡Veamos cómo evoluciona " + nombre_poblacion + "!");
			
		} else if (definir_generar == 1) {
			
			int random = 0;
			random = generar_numero_aleatorio(0, 9);
		
			if (random == 0) {
				
				nombre_poblacion = "China";
				System.out.println("\n¡Te ha tocado " + nombre_poblacion + "!");
				
			} else if (random == 1) {
				
				nombre_poblacion = "España";
				System.out.println("\n¡Te ha tocado " + nombre_poblacion + "!");
				
			} else if (random == 2) {
				
				nombre_poblacion = "Estados Unidos";
				System.out.println("\n¡Te ha tocado " + nombre_poblacion + "!");
				
			} else if (random == 3) {
				
				nombre_poblacion = "Rusia";
				System.out.println("\n¡Te ha tocado " + nombre_poblacion + "!");
				
			} else if (random == 4) {
				
				nombre_poblacion = "Antigua y Barbuda";
				System.out.println("\n¡Te ha tocado " + nombre_poblacion + "!");		
				
			} else if (random == 5) {
				
				nombre_poblacion = "Alemania";
				System.out.println("\n¡Te ha tocado " + nombre_poblacion + "!");
				
			} else if (random == 6) {
				
				nombre_poblacion = "Japón";
				System.out.println("\n¡Te ha tocado " + nombre_poblacion + "!");
				
			} else {
				
				nombre_poblacion = "Ucrania";
				System.out.println("\n¡Te ha tocado " + nombre_poblacion + "!");
				
			}
		
		} else {
			
			System.out.println("Debes introducir 1 o 2");
		}
		
		return nombre_poblacion;
		
	}
	
	public void imprimir_formato_cuadricula_02(int formato_cuadricula[][]) {
		System.err.println(Arrays.deepToString(formato_cuadricula)
				
				.replace("],", "],\n")
				.replaceAll("[ ,\\[\\]]", "")
				.replace("1", " ⬛") // ■ ◼ ⬛ ■ ▦ ⬛
				.replace("0", "  ")); // ⛶ ⬜
		
	}
	
	public void imprimir_formato_cuadricula_03(int formato_cuadricula[][]) {
		System.out.println(Arrays.deepToString(formato_cuadricula)
				
				.replace("],", "],\n")
				.replaceAll("[ ,\\[\\]]", "")
				.replace("1", " ⬛") // ■ ◼ ⬛ ■ ▦ ⬛
				.replace("0", " ⛶")); //  ⬜
		
	}
	
	public void imprimir_formato_cuadricula_04(int formato_cuadricula[][]) {
		System.out.println(Arrays.deepToString(formato_cuadricula)
				
				.replace("],", "],\n")
				.replaceAll("[ ,\\[\\]]", "")
				.replace("1", " ■") // ■ ◼ ⬛ ■ ▦ ⬛
				.replace("0", " ⛶")); //  ⬜
		
	}
	
	
	// ------------------------------------ A L E A T O R Y ------------------------------------ //

	public int generar_numero_aleatorio(int minimo, int maximo) {

		return (int) Math.floor(Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
		
	}

}

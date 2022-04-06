
import java.util.Arrays;
import java.util.Scanner;


public class Game_Of_Life {
	
	Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {

		Game_Of_Life game = new Game_Of_Life();
		game.principal();

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

	public int[][] automatic_method(int[][] grid) {
				
		int counter = 0;
		int generations = 0;
		int groups = 0;
		
		
		System.out.println("How many groups of cells do you want to introduce?");
		System.out.print("Groups = ");
		groups = scan.nextInt();
		
		
		do {
			
			for (counter = 0; counter <= groups; counter++) {
			
				int row = 0;
				int column = 0;
				
				row = generate_random_number(0, 12);
				column = generate_random_number(0, 12);
				
				for (int x = 1; x < grid.length - 1; x++) {
		
					for (int y = 1; y < grid[0].length - 1; y++) {
						
						grid[row][column] = 1;

					}
		
				}

			}
			
			System.out.println("\n[" + groups + "] cells have been inserted\n");
			print_grid(grid);
			
		} while (counter < 5);

		
		System.out.println("\nHow many generations do you want to simulate?");
		System.out.print(">> ");
		generations = scan.nextInt();
		
		for (int i = 0; i < generations; i ++) {
			
			sleep(2000);
			print_grid(grid);
			evolution(grid);
			System.out.println("Generation [" + i + "]\n");
			
		}
		
		return grid;
		
	}
	
	public int[][] manual_method(int[][] grid) {
		
		int counter = 0;
		int generations = 0;
				
		do {
			
			for (counter = 0; counter < 5; counter++) {
			
				int row = 0;
				int column = 0;
				
				if (counter == 0) {
					print_grid(grid);
				}
				
				System.out.println("\nIn which row do you want to insert a cell?");
				System.out.print(">> ");
				row = scan.nextInt();

				
				System.out.println("\nIn which column do you want to enter a cell?");
				System.out.print(">> ");
				column = scan.nextInt();
				
				System.out.println("\n\nYou have entered a cell at position [" + row + "][" + column + "]\n");
				
				for (int x = 1; x < grid.length - 1; x++) {
		
					for (int y = 1; y < grid[0].length - 1; y++) {
						
						grid[row][column] = 1;
						
					}
		
				}
				
				print_grid(grid);
			}
			
			System.out.println("\nYou have entered 5 cells\n");
			
		} while (counter < 5);
			
		
		System.out.println("How many generations do you want to simulate?");
		System.out.print(">> ");
		generations = scan.nextInt();
		System.out.print("\n");
		
		for (int i = 0; i < generations; i ++) {
			
			sleep(2000);
			print_grid(grid);
			evolution(grid);
			System.out.println("Generation [" + i + "]\n");
			
		}
		
		return grid;
		
	}
	

	// --------------------------------------- R U L E S --------------------------------------- //
	
	public int rules_first_letter() {
		
		int first_letter = 2;		
		return first_letter;
	}
	
	public int rules_second_letter() {
		int second_letter = 3;
		return second_letter;
	}
	
	public int rules_third_letter() {
		int third_letter = 3;
		return third_letter;
	}
	
	public void configure_rules() {
		
		System.out.println("The default rules are: [23/3]");
		
		System.out.println("\nDo you want to change the rules? (\"yes\" / \"no\")");
		System.out.print(">> ");
		String option = scan.next();
		
		int first_letter_A = 0;
		int second_letter_A = 0;
		int third_letter_B = 0;
		
		if (option.equalsIgnoreCase("Yes")) {
			
			System.out.print("\nEnter a value for the first letter ");
			sleep(400);
			System.err.print("A");
			sleep(400);
			System.out.print("|-|-\n");
			System.out.print(">> ");
			first_letter_A = scan.nextInt();

			if (first_letter_A >= 0 && first_letter_A <= 9) {

				System.out.print("\n~~~~~~~~~~~ Assigned value, " + first_letter_A + "|-|- ~~~~~~~~~~~\n");

			} else {

				System.out.print("\nPlease enter a valid value\n");

			}
	
			System.out.print("\n\nEnter a value for the second letter " + first_letter_A + "|");
			sleep(400);
			System.err.print("A");
			sleep(400);
			System.out.print("|-\n");
			System.out.print(">> ");
			second_letter_A = scan.nextInt();
	
			if (second_letter_A >= 0 && second_letter_A <= 9) {
					
				System.out.println("\n~~~~~~~~~~~ Assigned value, " + first_letter_A + "|" + second_letter_A + "|- ~~~~~~~~~~~");

			} else {
	
				System.out.print("\nPlease enter a valid value\n");
	
			}
	
			System.out.print("\n\nEnter a value for the third letter " + first_letter_A + "|" + second_letter_A + "|");
			sleep(400);
			System.err.print("B");
			sleep(400);
			System.out.print("\n>> ");
			third_letter_B = scan.nextInt();
	
			if (third_letter_B >= 0 && third_letter_B <= 9) {
	
				System.out.print("\n~~~~~~~~~~~ Assigned value, " + first_letter_A + "|" + second_letter_A + "|" + third_letter_B + " ~~~~~~~~~~~\n");
	
			} else {
	
				System.out.print("\nPlease enter a valid value\n");
	
			}

			
			
			System.out.print("\nSaving the configuration");
			
			for (int i = 0; i < 3; i++) {
				
				System.out.print(".");
				sleep(2000);
			
			}
			
			System.out.println("");
	
		} else if (option.equalsIgnoreCase("No")) {
			
			System.out.println("\nDefault rules are kept");
		
		} else {
			
			System.out.println("\nYou need to enter \"yes\" or \"no\"");
		
		}		
		
	}

	// ------------------------------------ T E M P O R A L ------------------------------------ //
	
	int[][] grid = new int[2 + 12][2 + 12];
	
	int grid_rows = 12;
	int grid_columns = 12; 
	final int[][] temporal_grid = new int[grid_rows][grid_columns];
	

	// ------------------------------- C O N W A Y ' S   G A M E ------------------------------- //
	
	public int study_neighbors(int column, int row, int grid[][]) {

		int sum = 0;

		for (int y = -1; y <= 1; y++) {

			for (int x = -1; x <= 1; x++) {

				if (x != 0 || y != 0) {

					try {
	                    
						sum += grid[y + row][x + column];
	                  
					} catch (ArrayIndexOutOfBoundsException e) {
	                  
					}

				}

			}
		
		}
		return sum;

	}
		
	public void evolution(int grid[][]) {

		for (int row = 1; row < grid_rows - 1; row++) {

			for (int column = 1; column < grid_columns - 1; column++) {

				int sum = study_neighbors(column, row, grid);

				if (grid[row][column] == 0 && sum == rules_third_letter()) {

					temporal_grid[row][column] = 1;

				} else if (grid[row][column] == 1 && (sum == rules_first_letter() || sum == rules_second_letter())) {

					temporal_grid[row][column] = 1;

				} else {

					temporal_grid[row][column] = 0;

				}

			}

		}

		for (int row = 0; row < temporal_grid.length; row++) {

			int columns[] = temporal_grid[row];
			System.arraycopy(columns, 0, grid[row], 0, columns.length);
		}

	}
	
	public void print_grid(int grid[][]) {

		System.out.println(Arrays.deepToString(grid)

				.replace("],", "],\n")
				.replaceAll("[ ,\\[\\]]", "")
				.replace("1", " ⬛") // ■ ◼ ⬛ ■ ▦ ⬛
				.replace("0", " ⛶")); // ⛶ ⬜

	}
	
	
	// --------------------------------------- M E N U S --------------------------------------- //
		
	public void menu_welcome() {
		
		System.out.println("\nWelcome to Conway's Game of Life\n");
		System.out.print("Map set to 12 x 12");
		
		for (int i = 0; i < 3; i++) {
			System.out.print(".");
			sleep(2000);
		}
		
		System.out.println("\n\nEvolution rules: ");
		System.out.println("- Every living cell with 2 or 3 neighboring cells \"survives\"");
		System.out.println("- Every cell with 4 or more neighbors dies from \"overpopulation\"");
		System.out.println("- Every cell with 1 or no neighbors dies from \"loneliness\"");
		System.out.println("- Each dead cell with 3 neighboring live cells, \"revive\"");
		sleep(9000);
	}
	
	public void menu_format() {
		
		System.out.println("\nNext, you have to choose the print format of the map");
		
		int[][] grid_format = { 
		        {1,1,0,1,1,1},
		        {1,0,0,1,0,0},
		        {1,1,0,1,0,0},
		        {1,0,0,0,0,1},
		        {0,0,1,0,1,0},
		        {1,0,1,0,0,0}
			    
		};
		
		print_grid_format_03(grid_format);
		
		System.out.println("\n");
		
		print_grid_format_02(grid_format);

		System.out.println("\n");
		
		print_grid_format_04(grid_format);
	}
		
	public void menu() {
		
		menu_welcome();
		
		int option = 0;		
		String population_name = "0. Name the population";
		
		do {
			System.out.println("\n==================================\n");
			System.out.println(population_name);
			System.out.println("1. Configure rules");
			System.out.println("2. Manual");
			System.out.println("3. Automatic");
			System.out.println("4. Patterns");
			System.out.println("5. Leave");
			System.out.print(">> ");
			option = scan.next().charAt(0);

			System.out.println("\n==================================\n");

			switch (option) {

				case '0': // ================================  O P T I O N  0  ================================
					
					System.out.println("_____________________________________________________________\n");
					System.out.println("You have selected the option 0: \"Name the population\"\n");
					
					population_name = "Your population is " + population_name() + "\n";
					
					
					System.out.println("_____________________________________________________________\n");
					break;
					
					
				case '1': // ================================  O P T I O N  1  ================================
					
					System.out.println("_____________________________________________________________\n");
					System.out.println("You have selected the option 1: \"Configure rules\"\n");

					configure_rules();
					
					System.out.println("_____________________________________________________________\n");
					break;

			
				case '2': // ================================  O P T I O N 2  ================================

					System.out.println("_____________________________________________________________\n");
					System.out.println("You have selected the option 2: \"Manual\"\n");

					
					int[][] manual_grid = manual_method(grid);
					print_grid(manual_grid);
					

					System.out.println("_____________________________________________________________\n");
					break;
				
		
				case '3': // ================================  O P C I Ó N  3  ================================
				
					System.out.println("_____________________________________________________________\n");
					System.out.println("You have selected the option 3: \"Automatic\"\n");
				
					
					int[][] automatic_grid = automatic_method(grid);
					print_grid(automatic_grid);

					
					System.out.println("_____________________________________________________________\n");
					break;
			
		
				case '4': // ================================  O P T I O N  4  ================================
				
					System.out.println("_____________________________________________________________\n");
					System.out.println("You have selected the option 4: \"Patterns\"\n");
				
					final int[][] grid_pattern_01 = { 
							
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
						print_grid(grid_pattern_01);
						evolution(grid_pattern_01);
						System.out.println("================================");
						sleep(2000);
						
					}
					
					
					System.out.println("_____________________________________________________________\n");
					break;
					
				case '5': // ================================  O P T I O N  5  ================================
					
					System.out.println("_____________________________________________________________\n");
					System.out.println("You have selected the option 5: \"Leave\"\n");
				
					System.out.print("Leaving the simulation");
					
					for (int i = 0; i < 3; i++) {
						
						sleep(1000);
						System.out.print(".");
					
					}
					
					System.out.println("");
					
					System.out.println("_____________________________________________________________\n");
					break;
					
			
				default:
					System.out.println("¡Enter numbers from 0 to 5!");
			}

		} while (option != '5');
		
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
		System.out.println("==================== Simulation finished ====================");
		
		scan.close();
	}
	

	// ---------------------------------- A E S T H E T I C ------------------------------------ //
	
	public void sleep(int time) {
	
		try {
			
			Thread.sleep(time);
			
		} catch (InterruptedException e) {
				
		}
		
	}
	
	public String population_name() {
		
		String population_name = "";
		int define_generate;
		
		System.out.println("1. Generate a random population");
		System.out.println("2. Define a name to the population");
		System.out.print(">> ");
		define_generate = scan.nextInt();
		
		if (define_generate == 2) {
			
			System.out.println("\nWhat do you want the town to be called?");
			System.out.print(">> ");
			population_name = scan.next();
			
			System.out.println("\nLet's see how it evolves " + population_name + "!");
			
		} else if (define_generate == 1) {
			
			int random = 0;
			random = generate_random_number(0, 9);
		
			if (random == 0) {
				
				population_name = "China";
				System.out.println("\nYou got " + population_name + "!");
				
			} else if (random == 1) {
				
				population_name = "Spain";
				System.out.println("\nYou got " + population_name + "!");
				
			} else if (random == 2) {
				
				population_name = "United States";
				System.out.println("\nYou got " + population_name + "!");
				
			} else if (random == 3) {
				
				population_name = "Russia";
				System.out.println("\nYou got " + population_name + "!");
				
			} else if (random == 4) {
				
				population_name = "Antigua y Barbuda";
				System.out.println("\nYou got " + population_name + "!");		
				
			} else if (random == 5) {
				
				population_name = "Germany";
				System.out.println("\nYou got " + population_name + "!");
				
			} else if (random == 6) {
				
				population_name = "Japan";
				System.out.println("\nYou got " + population_name + "!");
				
			} else {
				
				population_name = "Ukraine";
				System.out.println("\nYou got " + population_name + "!");
				
			}
		
		} else {
			
			System.out.println("You must enter 1 or 2");
		}
		
		return population_name;
		
	}
	
	public void print_grid_format_02(int grid_format[][]) {
		System.err.println(Arrays.deepToString(grid_format)
				
				.replace("],", "],\n")
				.replaceAll("[ ,\\[\\]]", "")
				.replace("1", " ⬛") // ■ ◼ ⬛ ■ ▦ ⬛
				.replace("0", "  ")); // ⛶ ⬜
		
	}
	
	public void print_grid_format_03(int grid_format[][]) {
		System.out.println(Arrays.deepToString(grid_format)
				
				.replace("],", "],\n")
				.replaceAll("[ ,\\[\\]]", "")
				.replace("1", " ⬛") // ■ ◼ ⬛ ■ ▦ ⬛
				.replace("0", " ⛶")); //  ⬜
		
	}
	
	public void print_grid_format_04(int grid_format[][]) {
		System.out.println(Arrays.deepToString(grid_format)
				
				.replace("],", "],\n")
				.replaceAll("[ ,\\[\\]]", "")
				.replace("1", " ■") // ■ ◼ ⬛ ■ ▦ ⬛
				.replace("0", " ⛶")); //  ⬜
		
	}
	
	
	// ------------------------------------ A L E A T O R Y ------------------------------------ //

	public int generate_random_number(int minimo, int maximo) {

		return (int) Math.floor(Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
		
	}

}

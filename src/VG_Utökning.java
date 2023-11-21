import java.io.*; // beh�vs f�r att kunna anv�nda filer
import java.util.ArrayList; // beh�vs f�r att kunna anv�nda listor
import java.util.Scanner; // beh�vs f�r att kunna anv�nda Scanner / l�sa in inmatning

/**
 * VG_Ut�kning-klassen skapar en fil med tal som matats in av anv�ndaren
 * och visar sedan det st�rsta och minsta talet utifr�n filens inneh�ll.
 */
public class VG_Ut�kning {

	public static void main(String[] args) throws IOException {
		
		// starta programmet med startmetoden och skapa en lista av tal baserat p� inmatningen
		ArrayList<Double> numbers = startAndInput();
		
		// skapa en ny fil som du kan lagra information i
		PrintWriter numbersFile = new PrintWriter("numbers.txt");
		
		// skapa en tom str�ng
		String numbersString = "";
		
		/* l�gg till talen i �nskat format i b�de filen och str�ngen
		 * (detta g�rs eftersom en fil som man infogar information i inte kan anv�ndas med Scanner
		 *  - vilket betyder att vi b�de skapar en fil och en str�ng som vi kan extrahera
		 *  information ifr�n)
		 */
		for (double d : numbers) {
			numbersFile.println(d + ";");
			numbersString += d + ";";
		}
		
		// hitta filen som skall anv�ndas och l�s inneh�llet med Scanner
		Scanner inputFile = new Scanner(numbersString);

		// extrahera information fr�n filen och skriv ut inneh�llet
		String fileContents = inputFile.nextLine();
		System.out.println("File contents:\n" + fileContents);

		// st�ng filerna d� de inte anv�nds mer
		numbersFile.close();
		inputFile.close();
		
		// g�r en vektor av siffrorna i filens inneh�ll
		String[] numbersInFile = fileContents.split(";");

		// r�kna ut det st�rsta och minsta talet bland siffrorna med ber�kningsmetoden
		double[] results = calculation(numbersInFile);
		
		//Utmatning av text med resultaten, det st�rsta och det minsta talet i filen
		System.out.println("\nLargest number: " + results[0] + "\nSmallest number: " + results[1]);

	}
	/**
	 * startAndInput-metoden ber anv�ndaren att mata in valfritt antal nummer och skapar sedan
	 * - en lista av dessa nummer
	 * @return En lista med alla nummer som anv�ndaren matat in.
	 */
	public static ArrayList<Double> startAndInput() {
		
		// Fr�ga anv�ndaren hur m�nga nummer som den skall
		System.out.println("Enter as many numbers as you want below: \t(Press [Enter] to stop)");

		// f�rbered en lista med nummer
		ArrayList<Double> numbers = new ArrayList();
		
		// medan loopen inte avbryts - allts� n�r anv�ndaren tryckt Enter
		while (true) {
			// skapa ett Scanner-objekt f�r att kunna lagra inmatning
			Scanner input = new Scanner(System.in);
			
			// skapa en str�ng av inmatningen / svaret
			String answer = input.nextLine();
			
			// om str�ngen / svaret �r "blankt" - som n�r anv�ndaren trycker p� Enter
			if (answer.isBlank()) {
				break; // h�r anv�nds break, break l�mnar en loop, continue d�remot hoppar till n�sta iteration
			}
			// annars
			else {
				// l�gg till nummret i listan
				numbers.add(Double.parseDouble(answer));
				continue; // h�r anv�nds continue, break l�mnar en loop, continue d�remot hoppar till n�sta iteration
			}
		}
		return numbers;
	}
	
	/**
	 * calculation-metoden ber�knar det st�rsta och minsta talet i dess parameter.
	 * @param numbersInFile En str�ngvektor med alla nummer som extraherats fr�n en vald fils
	 * - inneh�ll.
	 * @return En double-vektor med det st�rsta och minsta talet - resultaten.
	 */
	public static double[] calculation(String[] numbersInFile) {

		// f�rberedelse av utmaningen f�r det st�rsta talet och det minsta talet

		/* smallest f�r det st�rsta m�jliga v�rdet som kan lagras s� att korrekt
		 * j�mf�relse �r m�jlig
		 */
		double smallest = Double.MAX_VALUE;
		
		/* largest f�r det minsta m�jliga v�rdet som kan lagras s� att korrekt
		 * j�mf�relse �r m�jlig
		 */
		double largest = -Double.MAX_VALUE;

		// f�r varje nummer som vi hittade i filen
		for (String n : numbersInFile) {

			// g�r om nummerstr�ngen till ett tal
			double num = Double.parseDouble(n);

			/*
			 * ger largest v�rdet av det st�rsta talet vid j�mf�relse av largest och det
			 * nuvarande numret
			 */
			largest = Math.max(largest, num);

			/*
			 * ger smallest v�rdet av det minsta talet vid j�mf�relse av smallest och det
			 * nuvarande numret
			 */
			smallest = Math.min(smallest, num);
		}
		
		// skapa en vektor av resultaten
		double[] results = {largest, smallest}; //largest = results[0], smallest = results[1]
		
		return results;
	}

}

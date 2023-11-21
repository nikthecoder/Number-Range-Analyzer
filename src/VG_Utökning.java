import java.io.*; // behövs för att kunna använda filer
import java.util.ArrayList; // behövs för att kunna använda listor
import java.util.Scanner; // behövs för att kunna använda Scanner / läsa in inmatning

/**
 * VG_Utökning-klassen skapar en fil med tal som matats in av användaren
 * och visar sedan det största och minsta talet utifrån filens innehåll.
 */
public class VG_Utökning {

	public static void main(String[] args) throws IOException {
		
		// starta programmet med startmetoden och skapa en lista av tal baserat på inmatningen
		ArrayList<Double> numbers = startAndInput();
		
		// skapa en ny fil som du kan lagra information i
		PrintWriter numbersFile = new PrintWriter("numbers.txt");
		
		// skapa en tom sträng
		String numbersString = "";
		
		/* lägg till talen i önskat format i både filen och strängen
		 * (detta görs eftersom en fil som man infogar information i inte kan användas med Scanner
		 *  - vilket betyder att vi både skapar en fil och en sträng som vi kan extrahera
		 *  information ifrån)
		 */
		for (double d : numbers) {
			numbersFile.println(d + ";");
			numbersString += d + ";";
		}
		
		// hitta filen som skall användas och läs innehållet med Scanner
		Scanner inputFile = new Scanner(numbersString);

		// extrahera information från filen och skriv ut innehållet
		String fileContents = inputFile.nextLine();
		System.out.println("File contents:\n" + fileContents);

		// stäng filerna då de inte används mer
		numbersFile.close();
		inputFile.close();
		
		// gör en vektor av siffrorna i filens innehåll
		String[] numbersInFile = fileContents.split(";");

		// räkna ut det största och minsta talet bland siffrorna med beräkningsmetoden
		double[] results = calculation(numbersInFile);
		
		//Utmatning av text med resultaten, det största och det minsta talet i filen
		System.out.println("\nLargest number: " + results[0] + "\nSmallest number: " + results[1]);

	}
	/**
	 * startAndInput-metoden ber användaren att mata in valfritt antal nummer och skapar sedan
	 * - en lista av dessa nummer
	 * @return En lista med alla nummer som användaren matat in.
	 */
	public static ArrayList<Double> startAndInput() {
		
		// Fråga användaren hur många nummer som den skall
		System.out.println("Enter as many numbers as you want below: \t(Press [Enter] to stop)");

		// förbered en lista med nummer
		ArrayList<Double> numbers = new ArrayList();
		
		// medan loopen inte avbryts - alltså när användaren tryckt Enter
		while (true) {
			// skapa ett Scanner-objekt för att kunna lagra inmatning
			Scanner input = new Scanner(System.in);
			
			// skapa en sträng av inmatningen / svaret
			String answer = input.nextLine();
			
			// om strängen / svaret är "blankt" - som när användaren trycker på Enter
			if (answer.isBlank()) {
				break; // här används break, break lämnar en loop, continue däremot hoppar till nästa iteration
			}
			// annars
			else {
				// lägg till nummret i listan
				numbers.add(Double.parseDouble(answer));
				continue; // här används continue, break lämnar en loop, continue däremot hoppar till nästa iteration
			}
		}
		return numbers;
	}
	
	/**
	 * calculation-metoden beräknar det största och minsta talet i dess parameter.
	 * @param numbersInFile En strängvektor med alla nummer som extraherats från en vald fils
	 * - innehåll.
	 * @return En double-vektor med det största och minsta talet - resultaten.
	 */
	public static double[] calculation(String[] numbersInFile) {

		// förberedelse av utmaningen för det största talet och det minsta talet

		/* smallest får det största möjliga värdet som kan lagras så att korrekt
		 * jämförelse är möjlig
		 */
		double smallest = Double.MAX_VALUE;
		
		/* largest får det minsta möjliga värdet som kan lagras så att korrekt
		 * jämförelse är möjlig
		 */
		double largest = -Double.MAX_VALUE;

		// för varje nummer som vi hittade i filen
		for (String n : numbersInFile) {

			// gör om nummersträngen till ett tal
			double num = Double.parseDouble(n);

			/*
			 * ger largest värdet av det största talet vid jämförelse av largest och det
			 * nuvarande numret
			 */
			largest = Math.max(largest, num);

			/*
			 * ger smallest värdet av det minsta talet vid jämförelse av smallest och det
			 * nuvarande numret
			 */
			smallest = Math.min(smallest, num);
		}
		
		// skapa en vektor av resultaten
		double[] results = {largest, smallest}; //largest = results[0], smallest = results[1]
		
		return results;
	}

}

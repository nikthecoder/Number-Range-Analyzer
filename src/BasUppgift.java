import java.io.*; // behövs för att kunna använda filer
import java.util.Scanner; // behövs för att kunna använda Scanner / läsa in inmatning

/** 
 * BasUppgift-klassen utgör ett program som visar det största och minsta talet
 * utifrån en vald fils innehåll.
 */

public class BasUppgift {

	public static void main(String[] args) throws IOException {

		// hitta filen som skall användas och läs innehållet med Scanner
		File filename = new File("C:\\Users\\Computer\\Desktop\\numbers.txt");
		Scanner inputFile = new Scanner(filename);
		
		// gör om innehållet till en sträng och skriv ut innehållet
		String fileContents = inputFile.nextLine();
		System.out.println("File contents:\n" + fileContents);
		
		// stäng filen då den inte används mer
		inputFile.close();
		
		// extrahera siffrorna ur filens innehåll
		String[] numbers = fileContents.split(";");
		
		// förberedelse av utmaningen för det största talet och minsta talet
		
		// smallest får det största möjliga värdet som kan lagras så att korrekt jämförelse är möjlig
		double smallest = Double.MAX_VALUE;
		// largest får det minsta möjliga värdet som kan lagras så att korrekt jämförelse är möjlig
		double largest = -Double.MAX_VALUE;
		
		// för varje nummer som vi hittade i filen
		for (String n : numbers) {
			
			// gör om nummersträngen till ett tal
			double num = Double.parseDouble(n);
			
			// ger largest värdet av det största talet vid jämförelse av largest och det nuvarande numret
			largest = Math.max(largest, num);
			
			// ger smallest värdet av det minsta talet vid jämförelse av smallest och det nuvarande numret
			smallest = Math.min(smallest, num);
		}
		
		//Utmatning av text med resultaten, det största och det minsta talet i filen
		System.out.println("\nLargest number: " + largest + "\nSmallest number: " + smallest);
	}

}

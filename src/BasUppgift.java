import java.io.*; // beh�vs f�r att kunna anv�nda filer
import java.util.Scanner; // beh�vs f�r att kunna anv�nda Scanner / l�sa in inmatning

/** 
 * BasUppgift-klassen utg�r ett program som visar det st�rsta och minsta talet
 * utifr�n en vald fils inneh�ll.
 */

public class BasUppgift {

	public static void main(String[] args) throws IOException {

		// hitta filen som skall anv�ndas och l�s inneh�llet med Scanner
		File filename = new File("C:\\Users\\Computer\\Desktop\\numbers.txt");
		Scanner inputFile = new Scanner(filename);
		
		// g�r om inneh�llet till en str�ng och skriv ut inneh�llet
		String fileContents = inputFile.nextLine();
		System.out.println("File contents:\n" + fileContents);
		
		// st�ng filen d� den inte anv�nds mer
		inputFile.close();
		
		// extrahera siffrorna ur filens inneh�ll
		String[] numbers = fileContents.split(";");
		
		// f�rberedelse av utmaningen f�r det st�rsta talet och minsta talet
		
		// smallest f�r det st�rsta m�jliga v�rdet som kan lagras s� att korrekt j�mf�relse �r m�jlig
		double smallest = Double.MAX_VALUE;
		// largest f�r det minsta m�jliga v�rdet som kan lagras s� att korrekt j�mf�relse �r m�jlig
		double largest = -Double.MAX_VALUE;
		
		// f�r varje nummer som vi hittade i filen
		for (String n : numbers) {
			
			// g�r om nummerstr�ngen till ett tal
			double num = Double.parseDouble(n);
			
			// ger largest v�rdet av det st�rsta talet vid j�mf�relse av largest och det nuvarande numret
			largest = Math.max(largest, num);
			
			// ger smallest v�rdet av det minsta talet vid j�mf�relse av smallest och det nuvarande numret
			smallest = Math.min(smallest, num);
		}
		
		//Utmatning av text med resultaten, det st�rsta och det minsta talet i filen
		System.out.println("\nLargest number: " + largest + "\nSmallest number: " + smallest);
	}

}

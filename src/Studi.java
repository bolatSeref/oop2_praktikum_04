/**
 * Definition einer einfachen Nutzlast-Klasse
 * @author serefbolat
 *
 */
public class Studi {

	//Aufgabe 0a
	private String name;
	private int martikelNummer;
	
	
	/**
	 * Constructor ist definiert und die Werte "name" und "martikel nummer" sind eingesetzt.
	 * @param _name
	 * @param _martikelNummer
	 */
	//Aufgabe 0a
	public Studi (String _name, int _martikelNummer) 
	{
		this.name=_name;
		this.martikelNummer=_martikelNummer;
	}
	
	/**
	 * toString Funktion ist definiert um Eigenschaften der Klasse
	 * auf der Konsole auf zu geben.
	 * @return alle Eigenschaften der Klasse als String
	 */
	//Aufgabe 0b
	public String toString() 
	{
		return "Name ist: " + this.name + ", Martikel Nummer ist: " + this.martikelNummer;
	}
	
	//Aufgabe 5a
	/**
	 * equals Methode ist definiert, um Studi-Objekte zu vergleichen. 
	 *
	 *@param _studi
	 */
	
	public boolean equals (Studi _studi) 
	{
		return (this.name==_studi.name) && (this.martikelNummer==_studi.martikelNummer);
	}
	

	
}



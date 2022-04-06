

/**
 *  Die Klasse verwaltet eine
 *  doppelt verkettete Liste von Node-Objekts
 * @author serefbolat
 *
 */
public class DoLiStudi {
	
	/** Klasse-DoLiStudi kennt nur das erste und das
	 * letzte Node-Objekt in der Liste*/
	private Node first, last;
	
	/**
	 * Ein Node ist ein Element in einer Doppelt Verketteten Liste
	 * @author serefbolat
	 *
	 */
	//Aufgabe 1C
	public DoLiStudi () 
	{
		first=null;
		last=null;
 	}
	
	/**
	 * Main Methode für DoLiStudi
	 * @param args
	 */
	public static void main (String[] args)
	{
		
		//START - Aufgabe 3D
		DoLiStudi d1=new DoLiStudi();
		Studi s1=new Studi("Müller",1234);
		d1.insert(s1);
		System.out.println(d1.printNodes());
		
		
		Studi s2=new Studi("Mayer", 3456);
		d1.insert(s2);
		System.out.println(d1.printNodes());

		Studi s3=new Studi("Mark", 789);
		d1.insert(s3);
		System.out.println(d1.printNodes());
		//END - Aufgabe 3D
		
		 	
		//START - Aufgabe 4D
		Studi s4=new Studi("Tim", 777);
		d1.append(s4);
		
		System.out.println("****  Aufgabe: 4D ****");
		System.out.println(d1.printNodes());
		//END - Aufgabe 4D
		
		
		
		
		//START - Aufgabe 5A
		System.out.println("****  Aufgabe: 5A ****");
		System.out.println(s4.equals(s3));
		//END - Aufgabe 5A
		
		
		//START - Aufgabe 5B
		System.out.println("****  Aufgabe: 5B ****");
		System.out.println(d1.nodeOf(s4).toString());
		//END - Aufgabe 5B
		
		
		//START - Aufgabe 5C
		System.out.println("****  Aufgabe: 5C ****");
		System.out.println(d1.istStudiVorhanden(s3));
		//END - Aufgabe 5C
		
		
		//START - Aufgabe 5D
		System.out.println("****  Aufgabe: 5D ****");
		d1.loescheKnote(s4);
		System.out.println(d1.printNodes());
		//END - Aufgabe 5D
			
	}
	


	
	
	//Aufgabe 2B 
	//Frage zur Reflexion: Wir müssen diese Methode
	//in Klasse DoLiStudi definieren weil wir die
	// Eigenschaften first und last brauchen.
	/**
	 * 
	 * @author serefbolat
	 * @return konkatenierteString
	 */
	
	public String printNodes () 
	{
		Node currentNode=this.first;
		if(first==null)
		{	
			return "Double Verkettete Liste ist leer."; // Wenn die Liste leer ist
		}
		System.out.println("Nodes: "); // title 
		String konkatenierteString="";
		
		while (currentNode !=null) // iterieren alle Node-Objekte
		{
			konkatenierteString+=currentNode.nutzLastStudi.toString()+ "\n";
			currentNode=currentNode.next; 
		}
		return konkatenierteString;
	}
		
	
	// Aufgabe 5B
	/**
	 * 
	 * @param _studi
	 * @return
	 * ??? Wenn gesuchte Studi Objekt nicht vorhanden ist
	 * bekomme ich NullPointerException, wie kann ich 
	 * diese Fehler beheben?? 
	 */
	private Node nodeOf (Studi _studi)
	{
				
		Node currentNode=this.first;
		Node gesuchteNode=null;
		
		while(currentNode!=null)
		{			
			if(currentNode.nutzLastStudi.equals(_studi))
			{
				gesuchteNode=currentNode;
			}
			currentNode=currentNode.next;
		}
		return gesuchteNode;
		
	}
	
	//Aufgabe 5C
	/**
	 * Diese Methode prüft ob ein übergebenes Studi-Objekt
	 * in der Liste vorhanden ist.
	 * 
	 */
	
	public boolean istStudiVorhanden (Studi _studi)
	{
		return (nodeOf(_studi)!=null);
	}
	
	//Aufgabe 5D
	/**
	 * Diese Methode löscht ein Node-Objekt aus der Liste
	 */
	
	public void loescheKnote (Studi _studi)
	{
		//Node currentNode=this.first;
		Node gesuchteNode=nodeOf(_studi);
		if(gesuchteNode.prev!=null)
		{
			gesuchteNode.prev.next=gesuchteNode.next;
		}
		
		if (gesuchteNode.next!=null)
		{
			gesuchteNode.next.prev=gesuchteNode.prev;
		}
		
	}
	
	//Aufgabe 2c 
	/**
	 * zur Umwandlung eines Objekts in einen String 
	 * in der Klasse DoLiStudi
	 * @author serefbolat
	 *  ??? null muss kontrolliert werden!!!
	 */
	
	public String toString()
	{   
		return printNodes();
	}
	
	//Aufgabe 3c
	/**
	 * Fügt ein neues Node am Anfang der Liste,
	 * und aktualisiert first node in der Liste.
	 * ?? Letzte Element bleibt unverändert.
	 * 
	 * @param _neuStudi
	 *  
	 */
 
	public void insert(Studi _neuStudi) 
	{
		Node n1=new Node(_neuStudi);
		
		if(this.first==null) this.last=n1;
		else 
		{	
			this.first.insert(n1);
		}
		this.first=n1;
	
			
	}
 
	//Aufgabe 4c
	/**
	 * Anhängens am Ende der Liste
	 * @param _neuStudi
	 */
 
	public void append(Studi _neuStudi) 
	{
		Node n1=new Node(_neuStudi);
		
		if(this.first==null) 
		{
			this.first=n1;
		}
		else 
		{	
			this.last.appendTest(n1);
		}
		this.last=n1;
	
			
	}
	/**
	 * Klasse-Node ist als private Innere Klasse definiert.
	 * Diese Klasse ist verantwörtlich die Verkettung 
	 * der Elemente der Liste.
	 * @author serefbolat
	 *
	 */
	private class Node {
		
		private Node next, prev;
		private Studi nutzLastStudi;
		
		/**
		 * Constructor bekommt als parameter nur ein Studi-Objekt als nutzlast.
		 * @param _studi
		 */
		//Aufgabe 1b
		public Node (Studi _nutzLastStudi) 
		{
			this.next=null;
			this.prev=null;
			this.nutzLastStudi=_nutzLastStudi;
			
		}
		
		/**
		 * Überschreiben der toString() Methode,
		 * um Eigenschaften als String zurück zu geben.
		 */
		//Aufgabe2a
		
		public String toString ()
		{
			return this.nutzLastStudi.toString();
		}
		
		//Aufgabe 3b
		/**
		 * Zum einfügen ein Node-Objekt vor dem Ziel-Node-Objekt.
		 * Nicht am Anfang oder Ende
		 */

		private void insert(Node _neu) 
		{
			
				first.prev=_neu;
				_neu.next=first;
			
				
		}
		
		private void insertTest(Node _neu) 
		{
			
			_neu.prev=this.prev;
			_neu.next=this;
			this.prev=_neu;
			
			if(_neu.prev!=null)
			{
				_neu.prev.next=_neu;
			}			
		}
		
		
		//Aufgabe 4b
		/**
		 * Zum einfügen ein Node-Objekt nach dem Ziel-Node-Objekt.
		 * Nicht am Ende
		 * @param _neuNode
		 */
		
		private void appendTest (Node _neuNode)
		{
			_neuNode.prev=this;
			_neuNode.next=this.next;
			
			
			if(this.next!=null)
			{
				this.next.prev=_neuNode;
			}
			
			this.next=_neuNode;
		}
		
		
		//Aufgabe 4b
		/**
		 * Zum einfügen ein Node-Objekt nach dem Ziel-Node-Objekt.
		 * Nicht am Ende
		 * @param _neuNode
		 */
		
		
		private void append (Node _neuNode)
		{
			last.next=_neuNode;
			_neuNode.prev=last;
			
		}
		
		
		// Aufgabe 5B
		/**
		 * 
		 * @param _studi
		 * @return
		 */
		private Node nodeOf (Studi _studi)
		{
			return null;
		}

		
	}
}

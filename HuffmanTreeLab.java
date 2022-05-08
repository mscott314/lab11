import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class HuffmanTreeLab {

	public static void main(String[] args) {
		String fileName = args[0];
		int[] charCounts = getCharacterFrequency(fileName);
		Node root = getHuffmanTree(charCounts);
		String[] huffCode = getCodes(root);

		// Display chart of ASCII code, Character, Frequency, Huffman Code
		System.out.printf("%-15s%-15s%-15s%-15s\n", "ASCII Code", "Character", "Frequency", "Code");
		for(int i = 0; i < charCounts.length; i++) {
			if(charCounts[i] != 0) {
				System.out.printf("%-15s%-15s%-15s%-15s\n", i, (char)i, charCounts[i], huffCode[i]);
			}
		} 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} // end main

	//	Get codes for each letter
	public static String[] getCodes(Node root) {
		if(root == null) {
			return null;
		}
		String[] result = new String[256];
		assignCodes(root, result);
		return result;
	}

	// Assigns the Huffman code to each node in the Huffman Code Tree 
	// and records the code in code array 
	private static void assignCodes(Node root, String[] codes) {
		// TODO 

	}

	/** Get a Huffman tree from the codes */  
	  public static Node getHuffmanTree(int[] counts) {
		  

		  
		  Node T = new Node(2, 'T');
		  Node L = new Node(3, 'L');
		  Node C = new Node(4, 'C');
		  Node H = new Node(4, 'H');
		  Node S = new Node(9, 'S');
		  Node E = new Node(14, 'E');
	    // Create a Dictionary to hold the forest of trees
	    SortedLinkedDictionary<Integer, Node> forest = new SortedLinkedDictionary<>();
	    	forest.add(2, T);
	    	forest.add(3, L);
	    	forest.add(4, C);
	    	forest.add(4, H);
	    	forest.add(9, S);
	    	forest.add(14, E);
	    	
	    // TODO 

	    
	    // combine trees in the forest into a single tree
	    // TODO 
	    	Iterator<Integer> keyIt = forest.getKeyIterator();
	    	Iterator<Node> valIt = forest.getValueIterator();
	    	


	    return forest.remove(forest.getKeyIterator().next()); // The final tree
	  }
	  
	/** Get the frequency of the characters */
	public static int[] getCharacterFrequency(String filename) {    
		int[] counts = new int[256]; // 256 ASCII characters

		try {
			FileInputStream input = new FileInputStream(filename);
			int inputByte = input.read();

			while (inputByte != -1) {
				if(Character.isLetter((char)inputByte))
					counts[inputByte]++;
				inputByte = input.read();
			}
			input.close();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}

		return counts;
	}
	  
	  
	static class Node implements Comparable<Node>{
		char element;     // Stores the character for a leaf node
		int weight;       // weight of the subtree rooted at this node
		Node left;        // Reference to the left subtree
		Node right;       // Reference to the right subtree
		String code = ""; // The code of this node from the root
		
		/** Create an empty node */
		public Node() {
			
		}

		/** Create a node with the specified weight and character */
		public Node(int weight, char element) {
			this.weight = weight;
			this.element = element;
		}
			

		@Override /** Compare trees based on their weights */
		public int compareTo(Node o) {
			if (this.weight < o.weight) { // Purposely reverse the order
				return 1;
			}
			else if (this.weight == o.weight) {
				return 0;
			}
			else {
				return -1;
			}
		}
	}

}

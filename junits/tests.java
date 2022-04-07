import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

class tests {

	private BinaryTree bst;
	private BinaryTree word;

	ArrayList<String> original = new ArrayList<String>();
	ArrayList<String> translation = new ArrayList<String>();
	
   
    // Se agregan los elementos a traducir en los arraylists
    translation.add("gracias");
    translation.add("pueblo");
    translation.add("tarea");
    original.add("thank you");
    original.add("town");
    original.add("homework");
	
	public void search() {
		bst.insertar(original);
		word.insertar(translation);
		
	}
	
	@Test
	void insert() {
		assertEquals(original,bst);
	}
}
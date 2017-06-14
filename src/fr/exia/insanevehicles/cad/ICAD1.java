package fr.exia.insanevehicles.cad;

import java.io.FileNotFoundException;
import java.io.IOException;

import fr.exia.insanevehicles.model.element.IElement;

public interface ICAD1 {
	
	public Boolean open();
	public Boolean close();
	public IElement[][] getCircuit(String acces) throws IOException;
	public void saveCircuit(String cicuit, int x, int y) throws IOException;
	public void addCircuit(IElement[][] tableCircuit, String nomCircuit) throws IOException;
	
}

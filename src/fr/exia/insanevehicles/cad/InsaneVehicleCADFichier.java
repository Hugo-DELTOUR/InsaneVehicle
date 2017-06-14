package fr.exia.insanevehicles.cad;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import fr.exia.insanevehicles.model.element.IElement;
import fr.exia.insanevehicles.model.element.motionless.MotionlessElementsFactory;

public abstract class InsaneVehicleCADFichier implements ICAD1{
	
	private String Direction;
	
	public InsaneVehicleCADFichier(String Direction){
		this.Direction = Direction;
	}
	
	public void Connect() throws Exception{
		throw new Exception();
	}
	
	public void saveCircuit(String nomCircuit, int x, int y) throws IOException {
		FileWriter File = new FileWriter(nomCircuit + ".save");
	}
	
	
	public IElement[][] getCircuit(String acces) throws IOException {
		
		int Longueur;
		int Largeur;
		IElement[][] tableCircuit;
		
		final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(acces)));
		String ligne;
		ligne = buffer.readLine();
		Largeur = Integer.parseInt(ligne);
		ligne = buffer.readLine();
		Longueur = Integer.parseInt(ligne);
		
		tableCircuit = new IElement[Longueur][Largeur];
		
		ligne = buffer.readLine();
		
		int y = 0;
		
		while(ligne != null){
			for(int x = 0; x<ligne.toCharArray().length; x++){
				tableCircuit[x][y] = MotionlessElementsFactory.getFromFileSymbol(ligne.toCharArray()[x]);
			}
			ligne = buffer.readLine();
			y++;
		}
		buffer.close();
		return tableCircuit;
		
	}
	
	public void addCircuit(IElement[][] tableCircuit, String nomCircuit) throws IOException{
		
		FileWriter File = new FileWriter(nomCircuit);
		int Longueur = tableCircuit.length;
		int Largeur = tableCircuit[0].length;
		
		File.write(Largeur);
		File.write('\n');
		File.write(Longueur);
		File.write('\n');
		
		for(int x = 0; x<Longueur; x++){
			File.write('\n');
			for(int y = 0; y<Largeur; y++){
				File.write(tableCircuit[x][y].getSprite().getConsoleImage());
			}
		}
		File.close();
	}
	
}

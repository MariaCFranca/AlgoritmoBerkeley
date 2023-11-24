// Maria Clara França, Rossana Rocha da Silva, Victor do Amaral

package relogioCliente;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import relogioServidor.RelogioInterface;

public class Main {
	public static void main(String[] args) throws RemoteException {
		int total = 0;
		int media = 0;
		ArrayList<RelogioInterface> servers = new ArrayList();
		
		try {
			Registry registry = LocateRegistry.getRegistry("localhost");
			RelogioInterface c = (RelogioInterface) registry.lookup("RelogioImpl");
			System.out.println("O objeto servidor " + c + " foi encontrado com sucesso.\n");
			System.out.println(c.getTime());
			servers.add(c);
			
			registry = LocateRegistry.getRegistry("201.54.201.34");
			c = (RelogioInterface) registry.lookup("RelogioImpl");
			servers.add(c);
			System.out.println(c.getTime());
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		for (RelogioInterface a : servers) {
			a.setDiferenca(a.getTime() - servers.get(0).getTime());
			total += a.getDiferenca();
		}
		
		if (servers.size() != 0) {
			media = total / servers.size();			
		}
		
		System.out.println("Média = " + media);
		
		for (RelogioInterface a : servers) {
			a.setTime(media + (-1 * a.getDiferenca()));
		}
		
		for (RelogioInterface a : servers) {
			int inteira = a.getTime() / 60;
			int resto = a.getTime() % 60;
			
			System.out.println(inteira + ":" + resto);
		}
		
		for (RelogioInterface a : servers) {
			a.random();
		}
	}
}

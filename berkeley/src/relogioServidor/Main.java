package relogioServidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) {
    	try {
    		RelogioInterface sdrmi = new RelogioImpl();
    		Registry registry = LocateRegistry.getRegistry();
    		registry.rebind("RelogioImpl", sdrmi);
    		System.out.println("Servidor Relógio " + sdrmi + " registrado e pronto para aceitar solicitações.");;
    		
    	} catch (Exception ex) {
    		System.out.println("Houve um erro: " + ex.getMessage());
    	}
    }
}

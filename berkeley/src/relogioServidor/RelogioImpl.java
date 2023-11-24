package relogioServidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RelogioImpl extends UnicastRemoteObject implements RelogioInterface {

	private static final long serialVersionUID = 1L;
	private int hora;
	private int diferenca;
	
	public RelogioImpl() throws RemoteException {
		int i = (int) (Math.random() * 23);
		int j = (int) (Math.random() * 59);
		
		hora = (i * 60) + j;
	}
	
	@Override
	public int getTime() throws RemoteException {
		return hora;
	}

	@Override
	public void setTime(int t) throws RemoteException {
		this.hora += t;
	}

	@Override
	public void setDiferenca(int di) throws RemoteException {
		this.diferenca = di;
	}

	@Override
	public int getDiferenca() throws RemoteException {
		return diferenca;
	}

	@Override
	public void random() throws RemoteException {
		int i = (int) (Math.random() * 23);
		int j = (int) (Math.random() * 59);
		
		hora = (i * 60) + j;
	}
}

package relogioServidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RelogioInterface extends Remote {

	public int getTime() throws RemoteException;
	public void setTime(int t) throws RemoteException;
	public void setDiferenca(int di) throws RemoteException;
	public int getDiferenca() throws RemoteException;
	public void random() throws RemoteException;
}

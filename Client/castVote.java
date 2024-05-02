import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remote interface for the voting system.
 * Defines the methods that can be invoked remotely by clients.
 */
public interface castVote extends Remote {
    // Method for clients to register and receive a unique client ID.
    String registerClient() throws RemoteException;

    // Method for casting a vote. Requires the unique client ID and the choice number.
    void vote(String clientID, int choice) throws RemoteException;

    // Method for retrieving voting results. Requires the unique client ID.
    String getVotingResults(String clientID) throws RemoteException;
}

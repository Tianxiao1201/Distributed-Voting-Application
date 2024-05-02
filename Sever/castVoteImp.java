import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.UUID;

/**
 * The implementation of the castVote remote interface.
 * This class handles the logic for client registration, voting, and result tallying.
 */
public class castVoteImp extends UnicastRemoteObject implements castVote {
    private HashMap<String, Boolean> clientVoted; // Tracks whether a client has voted.
    private int[] votes; // Stores the vote count for each choice.

    // Constructor
    public castVoteImp() throws RemoteException {
        super();
        votes = new int[3]; // Assuming 3 choices for the vote.
        clientVoted = new HashMap<>(); // Maps client IDs to their voting status.
    }

    // Registers a new client and assigns a unique ID.
    @Override
    public String registerClient() throws RemoteException {
        String clientID = UUID.randomUUID().toString();
        clientVoted.put(clientID, false); // Indicates the client has not yet voted.
        return clientID;
    }

    // Casts a vote for a specific choice using the client's unique ID.
    @Override
    public void vote(String clientID, int choice) throws RemoteException {
        Boolean hasVoted = clientVoted.get(clientID);
        if (hasVoted == null) {
            throw new RemoteException("Client ID not registered.");
        }
        if (!hasVoted) {
            if (choice >= 1 && choice <= 3) {
                votes[choice - 1]++;
                clientVoted.put(clientID, true); // Mark as having voted.
                System.out.println("Client " + clientID + " voted for choice: " + choice);
            } else {
                System.out.println("Invalid choice: " + choice);
            }
        } else {
            throw new RemoteException("Client has already voted.");
        }
    }

    // Retrieves the voting results if the client has voted.
    @Override
    public String getVotingResults(String clientID) throws RemoteException {
        Boolean hasVoted = clientVoted.get(clientID);
        if (hasVoted == null || !hasVoted) {
            throw new RemoteException("Client has not voted or ID not registered.");
        }
        return "Voting results: Choice 1: " + votes[0] + ", Choice 2: " + votes[1] + ", Choice 3: " + votes[2];
    }
}

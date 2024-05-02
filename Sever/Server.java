import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * The server application for the voting system.
 * Binds the voting implementation to the RMI registry for clients to access.
 */
public class Server {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099); // Start the RMI registry on port 1099.
            castVote voteServer = new castVoteImp(); // Create an instance of the implementation.
            Naming.rebind("castVoteServer", voteServer); // Bind the instance to the registry.
            System.out.println("VoteServer is ready.");
        } catch (Exception e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

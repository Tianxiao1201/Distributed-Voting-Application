import java.rmi.Naming;
import java.util.Scanner;

/**
 * The client application for the voting system.
 * Allows users to register, vote, and view voting results.
 */
public class Client {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter client ID (1-5): ");
            String clientID = "Client" + scanner.nextLine();

            // Look up the remote voting service
            castVote voteService = (castVote) Naming.lookup("rmi://localhost/castVoteServer");

            // Register with the voting service and obtain a unique client ID
            String clientUniqueID = voteService.registerClient();

            // Prompt user for their voting choice and submit the vote
            System.out.print("Enter your voting choice (1-3): ");
            int choice = scanner.nextInt();
            voteService.vote(clientUniqueID, choice);

            // Request and display voting results
            String results = voteService.getVotingResults(clientUniqueID);
            System.out.println(results);
        } catch (Exception e) {
            System.out.println("Client exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

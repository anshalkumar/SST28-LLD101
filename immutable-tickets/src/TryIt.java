import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;

import java.util.List;

public class TryIt {

    public static void main(String[] args) {
        TicketService service = new TicketService();

        IncidentTicket t1 = service.createTicket("TCK-1001", "reporter@example.com", "Payment failing on checkout");
        System.out.println("Created: " + t1);

        IncidentTicket t2 = service.assign(t1, "agent@example.com");
        IncidentTicket t3 = service.escalateToCritical(t2);
        System.out.println("\nAfter assign + escalate (new ticket): " + t3);
        System.out.println("Original ticket unchanged: " + t1);

        List<String> tags = t3.getTags();
        try {
            tags.add("HACKED_FROM_OUTSIDE");
            System.out.println("\nShould not reach here");
        } catch (UnsupportedOperationException e) {
            System.out.println("\nExternal tag mutation blocked: " + e.getClass().getSimpleName());
        }
        System.out.println("Tags still safe: " + t3.getTags());
    }
}

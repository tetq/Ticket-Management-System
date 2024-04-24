import java.util.ArrayList;

public class TicketManagementSystem {
    private ArrayList<Event> events;

    public TicketManagementSystem() {
        this.events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public Event findEventByID(int eventID) {
        for (Event event : events) {
            if (event.getEventID() == eventID) {
                return event;
            }
        }
        return null;
    }

    public Event[] getAllEvents() {
        return events.toArray(new Event[0]);
    }
}
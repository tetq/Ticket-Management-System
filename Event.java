import java.util.LinkedList;
import java.util.Queue;

public class Event {
    private int eventID;
    private String name;
    private String venue;
    private String date;
    private String time;
    private int totalSeats;
    private int availableSeats;
    private Queue<User> ticketQueue;

    public Event(int eventID, String name, String venue, String date, String time, int totalSeats) {
        this.eventID = eventID;
        this.name = name;
        this.venue = venue;
        this.date = date;
        this.time = time;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.ticketQueue = new LinkedList<>();
    }

    public int getEventID() {
        return eventID;
    }

    public String getName() {
        return name;
    }

    public String getVenue() {
        return venue;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public Queue<User> getTicketQueue() {
        return ticketQueue;
    }

    public void setEventID(int eventID) {
        if (eventID == 0)
            this.eventID = eventID;
    }

    public void setName(String name) {
        if (name.isEmpty())
            this.name = name;
    }

    public void setVenue(String venue) {
        if (venue.isEmpty())
            this.venue = venue;
    }

    public void setDate(String date) {
        if (date.isEmpty())
            this.date = date;
    }

    public void setTime(String time) {
        if (time.isEmpty())
            this.time = time;
    }

    public void setTotalSeats(int totalSeats) {
        if (totalSeats == 0)
            this.totalSeats = totalSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        if (availableSeats == 0)
            this.availableSeats = availableSeats;
    }

    public void setTicketQueue(Queue<User> ticketQueue) {
        this.ticketQueue = ticketQueue;
    }

    public boolean hasAvailableSeats() {
        return availableSeats > 0;
    }

    public void bookTicket(User user) {
        if (hasAvailableSeats()) {
            ticketQueue.add(user);
            availableSeats--;
            System.out.println("ticket booked successfully for " + user.getName() + " for event: " + name);
        } else {
            System.out.println("sorry, no available seats for event: " + name);
        }
    }

    public void cancelTicket() {
        if (!ticketQueue.isEmpty()) {
            User user = ticketQueue.poll();
            availableSeats++;
            System.out.println("ticket canceled successfully for " + user.getName() + " for event: " + name);
        } else {
            System.out.println("no tickets to cancel for event: " + name);
        }
    }

    public static void heapSort(Event[] events) {
        int n = events.length;

        // build heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(events, n, i);

        // one by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // move current root to end
            Event temp = events[0];
            events[0] = events[i];
            events[i] = temp;

            // call max heapify on the reduced heap
            heapify(events, i, 0);
        }
    }

    private static void heapify(Event[] events, int n, int i) {
        int largest = i; // initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // if left child is larger than root
        if (left < n && events[left].getDate().compareTo(events[largest].getDate()) > 0)
            largest = left;

        // if right child is larger than largest so far
        if (right < n && events[right].getDate().compareTo(events[largest].getDate()) > 0)
            largest = right;

        // if largest is not root
        if (largest != i) {
            Event swap = events[i];
            events[i] = events[largest];
            events[largest] = swap;

            // recursively heapify the affected sub-tree
            heapify(events, n, largest);
        }
    }
}
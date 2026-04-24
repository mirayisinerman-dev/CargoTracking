import java.util.ArrayList;

public class Cargo {

    String trackingNumber;
    String sender;
    String receiver;
    String fromCity;
    String toCity;

    Status currentStatus;

    ArrayList<String> history = new ArrayList<>();

    public Cargo(String trackingNumber, String sender, String receiver,
                 String fromCity, String toCity) {

        this.trackingNumber = trackingNumber;
        this.sender = sender;
        this.receiver = receiver;
        this.fromCity = fromCity;
        this.toCity = toCity;

        currentStatus = Status.PREPARING;
        history.add("PREPARING");
    }

    public void updateStatus(Status newStatus) {
        currentStatus = newStatus;
        history.add(newStatus.toString());
    }

    public void showInfo() {
        System.out.println("Tracking No: " + trackingNumber);
        System.out.println("Sender: " + sender);
        System.out.println("Receiver: " + receiver);
        System.out.println("Route: " + fromCity + " -> " + toCity);
        System.out.println("Current Status: " + currentStatus);
        System.out.println("Estimated Delivery: " + estimateDays() + " day(s)");
        System.out.println("History: " + history);
        System.out.println("------------------------");
    }

    public int estimateDays() {
        if (fromCity.equalsIgnoreCase(toCity))
            return 1;
        return 2;
    }
}
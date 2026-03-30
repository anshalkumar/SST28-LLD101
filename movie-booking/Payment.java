public class Payment {
    int id;
    double amount;
    String status;

    public Payment(int id, double amount) {
        this.id = id;
        this.amount = amount;
        this.status = "PAID";
    }

    public void refund() {
        status = "REFUNDED";
        System.out.println("Refund done");
    }
}
public class VendingMachine {
    private VendingMachineState currentState;
    private int inventory;
    private double balance;

    public VendingMachine(int inventory) {
        this.inventory = inventory;
        this.balance = 0.0;
        this.currentState = (inventory > 0) ? new IdleState() : new OutOfOrderState();
    }

    // Delegation Methods
    public void selectItem() { currentState.selectItem(this); }
    public void insertCoin() { currentState.insertCoin(this); }
    public void dispenseItem() { currentState.dispenseItem(this); }
    public void setOutOfOrder() { currentState.setOutOfOrder(this); }

    // Getters and Setters
    public void setState(VendingMachineState state) { this.currentState = state; }
    public VendingMachineState getState() { return currentState; }
    public int getInventory() { return inventory; }
    public void decrementInventory() { inventory--; }
    public double getBalance() { return balance; }
    public void addBalance(double amount) { balance += amount; }
    public void resetBalance() { balance = 0; }
}

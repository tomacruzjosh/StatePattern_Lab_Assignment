public class ItemSelectedState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine) {
        System.out.println("Item already selected.");
    }

    @Override
    public void insertCoin(VendingMachine machine) {
        machine.addBalance(1.0); // Simplified logic
        System.out.println("Coin inserted. Current balance: " + machine.getBalance());
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        if (machine.getInventory() > 0) {
            machine.setState(new DispensingState());
            machine.getState().dispenseItem(machine);
        } else {
            System.out.println("Out of stock!");
            machine.setState(new OutOfOrderState());
        }
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        machine.setState(new OutOfOrderState());
    }
}

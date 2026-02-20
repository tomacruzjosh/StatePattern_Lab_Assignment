public class DispensingState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine) { System.out.println("Busy dispensing..."); }

    @Override
    public void insertCoin(VendingMachine machine) { System.out.println("Busy dispensing..."); }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Dispensing item... Enjoy!");
        machine.decrementInventory();
        machine.resetBalance();
        machine.setState(new IdleState());
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        machine.setState(new OutOfOrderState());
    }
}

package LINTCODE8;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE712 {
    /*Description
    *Vending Machine一共有三种状态：NoSelection, HasSelection, InsertedMoney
    * Vending Machine一共卖三种饮料：Coke, Sprite和MountainDew
    * 要求Vending Machine在正确的状态要有正确的输出
    * */
}

class VendingMachine {
    private String currentSelectedItem;
    private int currentInsertedMoney;
    private AbstractState state;
    private NoSelectionState noSelectionState;
    private HasSelectionState hasSelectionState;
    private InsertedMoneyState insertedMoneyState;
    private Map<String, Integer> itemPrice;

    public VendingMachine() {
        currentInsertedMoney = 0;
        currentSelectedItem = null;
        noSelectionState = new NoSelectionState(this);
        hasSelectionState = new HasSelectionState(this);
        insertedMoneyState = new InsertedMoneyState(this);
        state = noSelectionState;

        itemPrice = new HashMap<>();
        itemPrice.put("Coke", 199);
        itemPrice.put("Sprite", 299);
        itemPrice.put("MountainDew", 399);
    }

    public void setSelectedItem(String item) {
        this.currentSelectedItem = item;
    }

    public String getSelectedItem() {
        return currentSelectedItem;
    }

    public void insertMoney(int amount) {
        this.currentInsertedMoney += amount;
    }

    public void emptyInsertedMoney() {
        this.currentInsertedMoney = 0;
    }

    public int getInsertedMoney() {
        return currentInsertedMoney;
    }

    public int getSalePrice() {
        if (currentSelectedItem == null) {
            System.out.println("Please make a selection before asking price");
            return 0;
        } else {
            return itemPrice.get(currentSelectedItem);
        }
    }

    public void changeToNoSelectionState() {
        state = noSelectionState;
    }

    public void changeToHasSelectionState() {
        state = hasSelectionState;
    }

    public void changeToInsertedMoneyState() {
        state = insertedMoneyState;
    }

    public void selectItem(String selection) {
        state.selectItem(selection);
    }

    public void addMoney(int value) {
        state.insertMoney(value);
    }

    public void executeTransaction() {
        state.executeTransaction();
    }

    public int cancelTransaction() {
        return state.cancelTransaction();
    }

    public String printState() {
        String res = "";

        res = "Current selection is: " + currentSelectedItem + ", current inserted money: " + currentInsertedMoney
                + ", current state is : " + state;

        return res;
    }
}

interface State {
    public void selectItem(String selection);
    public void insertMoney(int value);
    public void executeTransaction();
    public int cancelTransaction();
    public String toString();
}

abstract class AbstractState implements State {
    protected VendingMachine vendingMachine;

    public AbstractState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
}

class NoSelectionState extends AbstractState{

    public NoSelectionState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectItem(String selection) {
        vendingMachine.setSelectedItem(selection);
        vendingMachine.changeToHasSelectionState();
    }

    @Override
    public void insertMoney(int value) {
        System.out.println("Please make a selection first");
    }

    @Override
    public void executeTransaction() {
        System.out.println("Please make a selection first");
    }

    @Override
    public int cancelTransaction() {
        System.out.println("Please make a selection first");
        return 0;
    }

    @Override
    public String toString(){
        return "NoSelection";
    }
}

class HasSelectionState extends AbstractState{

    public HasSelectionState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectItem(String selection) {
        vendingMachine.setSelectedItem(selection);
    }

    @Override
    public void insertMoney(int value) {
        vendingMachine.insertMoney(value);
        vendingMachine.changeToInsertedMoneyState();
        // TODO
    }

    @Override
    public void executeTransaction() {
        System.out.println("You need to insert money first");
    }

    @Override
    public int cancelTransaction() {
        System.out.println("Transaction canceled");
        vendingMachine.selectItem(null);
        vendingMachine.changeToNoSelectionState();
        return 0;
    }
    @Override
    public String toString(){
        return "HasSelection";
    }
}

class InsertedMoneyState extends AbstractState{

    public InsertedMoneyState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectItem(String selection) {
        System.out.println("Already has a selection, please cancel transaction to make a new selection");
    }

    @Override
    public void insertMoney(int value) {
        vendingMachine.insertMoney(value);
    }

    @Override
    public void executeTransaction() {
        int diff=vendingMachine.getInsertedMoney()- vendingMachine.getSalePrice();
        if(diff>=0){
            System.out.println("Executing transaction, will return you : " + diff + " money and item: " + vendingMachine.getSelectedItem());
            vendingMachine.setSelectedItem(null);
            vendingMachine.emptyInsertedMoney();
            vendingMachine.changeToNoSelectionState();
        }
        else{
            System.out.println("Not enough money, please insert " + (-diff) + " more.");
        }
    }

    @Override
    public int cancelTransaction() {
        // TODO
        int money= vendingMachine.getInsertedMoney();
        vendingMachine.emptyInsertedMoney();
        vendingMachine.setSelectedItem(null);
        return money;
    }

    @Override
    public String toString(){
        return "InsertedMoney";
    }
}
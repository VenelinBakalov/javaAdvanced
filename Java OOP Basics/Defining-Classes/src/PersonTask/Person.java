package PersonTask;


import BankTasks.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private int age;
    private List<BankAccount> accounts;

    public Person(String name, int age) {
        this(name, age, new ArrayList<>());
    }

    public Person(String name, int age, List<BankAccount> accounts) {
        this.name = name;
        this.age = age;
        this.accounts = accounts;
    }

    public double getBalance() {
        return this.accounts.stream().mapToDouble(BankAccount::getBalance).sum();
    }
}

package Week_06.Exercise1;

import java.util.concurrent.atomic.AtomicInteger;

public class Account {
    private final AtomicInteger balace;
    private final String name;

    public Account(String name, int balace) {
        this.name = name;
        this.balace = new AtomicInteger(balace);
    }

    public void withdraw(int amount){
        balace.addAndGet(-amount);
    }

    public void deposit(int amount){
        balace.addAndGet(amount);
    }

    public String getName(){
        return name;
    }
}

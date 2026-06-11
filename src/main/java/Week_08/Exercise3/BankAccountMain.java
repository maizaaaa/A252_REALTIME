package Week_08.Exercise3;

public class BankAccountMain {
    public static void main(String[] args){
        BankAccountWithLock account = new BankAccountWithLock(1000.00);

        //create thread for reading, deposit and withdraw
        Runnable readTask = () -> account.getBalance();
        Runnable depositTask = () -> account.deposit(500.00);
        Runnable withdrawTask = () -> account.withdraw(1200.00);


        Thread t1 = new Thread(readTask, "Thread-Reader1");
        Thread t2 = new Thread(readTask, "Thread-Reader2");
        Thread t3 = new Thread(depositTask, "Thread-Depositor");
        Thread t4 = new Thread(withdrawTask, "Thread-Withdrawer");
        Thread t5 = new Thread(readTask, "Thread-Reader3");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final balance: " + account.getBalance());
    }
}

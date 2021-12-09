import main.Account;

public class App {
    public static void main(String[] args) throws Exception {
        Account ac = new Account(123);
        ac.credit(20);
        ac.credit(20);
        ac.debit(20);

        ac.getExtract();
    }
}

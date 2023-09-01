public class BankAccount {

    private double checkingBalance;
    private double savingBalance;
    public static int accountTotal = 0;
    public static double totalMoneyAvail = 0;

    public BankAccount(double checkingBalance, double savingBalance) {
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;

        accountTotal += 1;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingBalance;
    }

    public void deposit(double amount, String account) {
        if (account.equals("checking")) {
            checkingBalance += amount;
            totalMoneyAvail += amount;
        } else if (account.equals("saving")) {
            savingBalance += amount;
            totalMoneyAvail += amount;
        } else {
            System.out.println("Please enter either checking or saving.");
        }
    }

    public void withdraw(double amount, String account) {
        if (amount <= 0) {
            System.out.println("You are broke");
        } else if (account.equals("checking")) {
            if(checkingBalance >= amount) {
                checkingBalance -= amount;
                totalMoneyAvail -= amount;
            } else {
                System.out.println("You are broke");
            }
        } else if (account.equals("saving")) {
            if(savingBalance >= amount) {
                savingBalance -= amount;
                totalMoneyAvail -= amount;
            } else {
                System.out.println("You are broke");
            }
        }
    }

    public double getUserTotalBalance() {
            return checkingBalance + savingBalance;
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount(2000, 3000);
        acc1.deposit(500, "checking");
        acc1.withdraw(100, "savings");

        System.out.println("Checking: " + acc1.getCheckingBalance());
        System.out.println("Savings: " + acc1.getSavingsBalance());
    }
}

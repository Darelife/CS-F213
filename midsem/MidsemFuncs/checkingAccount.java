package MidsemFuncs;

public class checkingAccount extends bankAccount {
  private double myInterest;

  public checkingAccount(double interest) {
  }

  public double getInterest() {
    return myInterest;
  }

  public double getInterest(int a) {
    return a;
  }

  public void deposit(double amount) {
    double newBalance = getBalance() + amount;
    setBalance(newBalance);
  }

  public void applyInterest() {
    double newBalance = getBalance() + (getBalance() * myInterest / 100);
    setBalance(newBalance);
  }

  // Static nested class
  public static class AccountHelper {
    public static void printAccountDetails(checkingAccount account) {
      // Can access private members of the enclosing class
      System.out.println("Account Balance: $" + account.getBalance());
      System.out.println("Interest Rate: " + account.getInterest() + "%");
    }
  }

  public static void main(String[] args) {
    checkingAccount account = new checkingAccount(5.0);
    account.deposit(1000); // Assuming deposit method exists in bankAccount
    account.applyInterest();
    checkingAccount.AccountHelper.printAccountDetails(account);
  }
}

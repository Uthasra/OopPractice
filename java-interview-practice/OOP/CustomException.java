class InsufficientBalanceException extends Exception { // checked
 InsufficientBalanceException(String msg) { super(msg); }
}
void withdraw(double amount) throws InsufficientBalanceException {
 if (amount > balance)
 throw new InsufficientBalanceException("Balance " + balance + " < " + amount);
 balance -= amount;
}
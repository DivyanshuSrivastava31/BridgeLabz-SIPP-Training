interface SensitiveData { }  // Marker interface

class BankAccount implements SensitiveData {
    String accountNumber;
    String pin;
}
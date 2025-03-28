package atmAdvance1;

public sealed interface Transaction permits Deposit, Withdraw, BalanceCheck  {

}

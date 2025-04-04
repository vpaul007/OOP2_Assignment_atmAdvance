package atmAdvance1;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public sealed interface Transaction permits Deposit, Withdraw, BalanceCheck  {
    LocalDateTime timestamp();


    }


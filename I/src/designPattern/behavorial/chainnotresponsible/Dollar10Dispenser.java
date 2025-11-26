package designPattern.behavorial.chainnotresponsible;

public class Dollar10Dispenser implements DispenseChain{
    private DispenseChain dispenseChain;
    @Override
    public void setNextChain(DispenseChain dispenseChain) {
        this.dispenseChain = dispenseChain;
    }

    @Override
    public void dispenseCurrency(Currency currency) {
        if (currency.getAmount() >= 10) {
            int num = currency.getAmount() / 10;
            int remainder = currency.getAmount() % 10;
            System.out.println("Dispensing: "  + num + " 10$ note" );

            if (remainder != 0) {

                this.dispenseChain.dispenseCurrency(new Currency(remainder));
            } else {
                this.dispenseChain.dispenseCurrency(currency);
            }
        }
    }
}

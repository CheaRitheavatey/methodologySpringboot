package designPattern.behavorial.chainnotresponsible;

public interface DispenseChain {
    // set the next process
    void setNextChain(DispenseChain dispenseChain);

    // process
    void dispenseCurrency(Currency currency);

}

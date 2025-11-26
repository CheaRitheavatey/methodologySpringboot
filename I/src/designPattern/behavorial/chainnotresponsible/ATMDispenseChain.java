package designPattern.behavorial.chainnotresponsible;

public class ATMDispenseChain {
    public DispenseChain d1;

    public ATMDispenseChain() {
        this.d1 = new Dollar20Dispenser();
        DispenseChain d2 = new Dollar10Dispenser();

//        d1.setNextChain(d2);
    }
}

package designPattern.structural.adapter;

public interface SocketAdapter {
    public Volt get120volt();
    public Volt get12volt();
    public Volt get3volt();
}

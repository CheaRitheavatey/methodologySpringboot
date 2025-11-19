package designPattern.structural.adapter;

public class SocketAdapterImplementation implements SocketAdapter{
    // use composition; one class compose of one or more instance
    // of other classes and relies on these implementation
    private Socket socket = new Socket();
    @Override
    public Volt get120volt() {
        return socket.getVolt();
    }

    @Override
    public Volt get12volt() {
        // we need to do conversion for 12 and 3v
        Volt v = socket.getVolt();
        return convertVolt(v,10);
    }

    @Override
    public Volt get3volt() {
        Volt v = socket.getVolt();
        return convertVolt(v,40);
    }

    public Volt convertVolt(Volt volt, int i){
        return new Volt(volt.getVolt()/i);
    }
}

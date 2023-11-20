package lesson31.adapter;

public class Client {

    public static void main(String[] args) {
        Adapter adapter = new ConcreateAdapter(new Adaptee());
        adapter.operation();
    }
}

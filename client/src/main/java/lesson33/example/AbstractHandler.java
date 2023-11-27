package lesson33.example;

public abstract class AbstractHandler implements Handler {

    @Override
    public void handle() {
        System.out.println("run handle method");
        process();
    }

    protected abstract void process();
}

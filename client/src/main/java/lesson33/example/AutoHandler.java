package lesson33.example;

public class AutoHandler extends AbstractHandler {
    @Override
    protected void process() {
        System.out.println("auto running job");
    }

    @Override
    public void handle() {
        process();
        super.handle();
    }
}

package lesson33.example;

public class ManualHandler extends AbstractHandler {
    @Override
    protected void process() {
        System.out.println("this job was done by hand");
    }

    @Override
    public void handle() {
        process();
        super.handle();
    }
}

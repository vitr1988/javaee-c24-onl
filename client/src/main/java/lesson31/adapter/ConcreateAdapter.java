package lesson31.adapter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConcreateAdapter implements Adapter {

    private final Adaptee adaptee;

    @Override
    public void operation() {
        adaptee.adaptedOperation();
        System.out.println("Вызов из конкретного адаптера");
    }
}

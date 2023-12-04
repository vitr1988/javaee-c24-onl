package lesson34.example;

@FunctionalInterface
public interface TriConsumer<S, T1, T2> {

    void consume(S s, T1 t1, T2 t2);
}

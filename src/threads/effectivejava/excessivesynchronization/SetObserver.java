package threads.effectivejava.excessivesynchronization;

@FunctionalInterface
public interface SetObserver<E> {

    void added(ObservableSet<E> set, E element);
}

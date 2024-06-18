import java.util.List;

public interface QueueBehaviour {

    void takeInQueue(Actor actor);

    void takeOrders(Actor actor); //забрать заказы

    void buyProducts(Actor actor); // сделать заказы

    void releaseFromQueue(Actor actor); // выйти из очереди
}


import java.util.ArrayList;
import java.util.List;

public class Market implements MarketBehaviour, QueueBehaviour {

    private List<Actor> actors;

    public Market() {
        this.actors = new ArrayList<>();
    }

    public Market(List<Actor> actors) {
        this.actors = actors;
    }

    public void addQueue(List<Actor> actors) {
        this.actors.addAll(actors);
    }

    @Override
    public void acceptToMarket(Actor actor) {
        if (actor.getState() == State.NOT_READY) {
            actor.setState(State.READY_BUY_OR_LEAVE_MARKET);
            System.out.println("Посетитель " + actor + " зашел в магазин");
        } else {
            System.out.println("Посетитель " + actor + " уже находится в магазине");
        }
    }

    @Override
    public void releaseFromMarket(Actor actor) {
        if (actor.getState() == State.READY_BUY_OR_LEAVE_MARKET) {
            actors.remove(actor);
            actor.setState(State.NOT_READY);
            System.out.println(actor + " покинул магазин");
        } else {
            System.out.println("Посетитель " + actor + " не может покинуть магазин, так как он еще не зашел,или не оплатил покупки.");
        }
    }

    private void update(boolean flag) {
        if (flag) {
            System.out.println("Касса свободна");
        } else {
            System.out.println("Касса занята");
        }
    }

    @Override
    public void takeInQueue(Actor actor) {
        if (actor.getState() == State.READY_TO_TAKE_IN_QUEUE) {
            System.out.println("Посетитель " + actor + " встал в очередь");
            boolean flag = false;
            update(flag);
            System.out.println(actor + " ожидает свои заказы...");
            actor.setState(State.READY_TO_TAKE_ORDER);
            takeOrders(actor);
        } else {
            System.out.println(actor + " не готов встать в очередь");
        }
    }

    @Override
    public void takeOrders(Actor actor) {
        if (actor.getState() == State.READY_TO_TAKE_ORDER) {
            System.out.println(actor + " оплатил и взял свои заказы");
            actor.setState(State.RELEASE_FROM_QUEUE);
            releaseFromQueue(actor);
        } else {
            System.out.println(actor + " не готов принимать заказы");
        }
    }

    @Override
    public void buyProducts(Actor actor) {
        if (actor.getState() == State.READY_BUY_OR_LEAVE_MARKET) {
            System.out.println(actor + " сделал покупки");
            actor.setState(State.READY_TO_TAKE_IN_QUEUE);
        } else {
            System.out.println(actor + " не готов сделать покупки");
        }
    }

    @Override
    public void releaseFromQueue(Actor actor) {
        if (actor.getState() == State.RELEASE_FROM_QUEUE) {
            System.out.println(actor + " покинул очередь");
            boolean flag = true;
            update(flag);
            actor.setState(State.READY_BUY_OR_LEAVE_MARKET);
        } else {
            System.out.println(actor + " не готов покинуть очередь");
        }
    }
}

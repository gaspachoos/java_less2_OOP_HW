public abstract class Actor implements ActorBehavior{

    protected String name;
    protected State state;
    protected boolean isMakeOrder;
    protected boolean isTakeOrder;

    public Actor(String name) {
        this.name = name;
        this.state = State.NOT_READY;
    }

    public abstract String getName();

    public abstract void setMakeOrder(boolean flag);

    public abstract void setTakeOrder(boolean flag);

    public abstract boolean isMakeOrder();

    public abstract boolean isTakeOrder();

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return name;
    }
}

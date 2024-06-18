public interface ActorBehavior {

    void setMakeOrder(boolean flag);

    void setTakeOrder(boolean flag);

    boolean isMakeOrder();

    boolean isTakeOrder();
}

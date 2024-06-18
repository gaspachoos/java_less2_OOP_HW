import java.util.List;

public interface MarketBehaviour {

    void acceptToMarket(Actor actor); //входит в магазин

    void releaseFromMarket(Actor actor); //выходит из магазина

}

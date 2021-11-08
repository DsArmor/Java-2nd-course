package ex2;

public class ChairFactory extends AbstractChairFactory{

    @Override
    public VictorianChair createVictorianChair() {
        return new VictorianChair(124);
    }

    @Override
    public MagicChair createMagicChair() {
        return new MagicChair();
    }

    @Override
    public FunctionalChair createFunctionalChair() {
        return new FunctionalChair();
    }
}

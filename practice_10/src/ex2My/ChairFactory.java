package ex2My;

public class ChairFactory {
    public Chair createChair(ChairType chairType)
    {
        Chair chair = null;

        switch (chairType){
            case MAGIC -> chair = new MagicChair();
            case VICTORIAN -> chair = new VictorianChair();
            case FUNCTIONAL -> chair = new FunctionalChair();
        }
        return chair;
    }
}


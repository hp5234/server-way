package app.ingredient.bread;

public class HoneyOat extends Bread{

    public HoneyOat(boolean bake, int length) {
        super("허니오트", 103, bake, length);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getKcal() {
        return super.getKcal();
    }

    @Override
    public boolean getBake() {
        return super.getBake();
    }

    @Override
    public int getLength() {
        return super.getLength();
    }
}

package app.ingredient.bread;

public class WheatBread extends Bread{

    public WheatBread(boolean bake, int length) {
        super("위트브레드", 101, bake, length);
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

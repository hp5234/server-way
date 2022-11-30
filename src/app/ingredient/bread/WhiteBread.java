package app.ingredient.bread;

public class WhiteBread extends Bread{

    public WhiteBread(boolean bake, int length) {
        super("화이트브레드", 100, bake, length);
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

package app.ingredient.bread;

// 빵 길이 정보 
public enum BreadLength {
    SHORT(15), LONG(30);

    private final int length;

    BreadLength(int length){
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}

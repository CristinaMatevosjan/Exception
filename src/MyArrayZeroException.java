public class MyArrayZeroException extends Exception {
    private int index;

    public MyArrayZeroException(int index) {
        this.index = index;
    }
    @Override
    public String getMessage(){
        return "На 0 делить нельзя. 0 на позиции "+ index;
    }
}

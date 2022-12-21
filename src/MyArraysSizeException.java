public class MyArraysSizeException  extends Exception{
    @Override
    public String getMessage(){
        return "Длины массивов не равны";
    }
}

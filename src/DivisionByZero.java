public class DivisionByZero {
    int[] intArray;

    public DivisionByZero(int[] intArray) {
        this.intArray = intArray;
    }

    public void division(){
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }catch (IndexOutOfBoundsException ex){
            System.out.println("Вышли за пределы массива "+ ex);
        }catch (NullPointerException exp){
            System.out.println("передан null "+ exp);
        }
    }
}


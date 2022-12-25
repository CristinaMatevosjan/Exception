public class FixCode {
    public void fix() {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            // printSum(23, 234);
            int[] abc = {1, 2};
            abc[3] = 9;
//        } catch (Throwable ex) {
//            System.out.println("Что-то пошло не так...");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }
    }


    public void printSum(Integer a, Integer b){  //throws FileNotFoundException {
        try {
            System.out.println(a + b);
        }catch (NullPointerException ex){
            System.out.println("указатель не может указывать на null");
        }
    }
}



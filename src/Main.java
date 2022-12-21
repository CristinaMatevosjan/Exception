import java.util.Arrays;

//Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
//
//Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
// и возвращающий новый массив, каждый элемент которого равен разности элементов двух
// входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя.
//
//Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
// каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
// Если длины массивов не равны, необходимо как-то оповестить пользователя.
// Важно: При выполнении метода единственное исключение, которое пользователь может увидеть
// - RuntimeException, т.е. ваше.
//

        public class Main {
            public static void main(String[] args) {
                int[] array1={1,64,67688,33};

                int[] array2={45,553,868,0};

                int[] wrongArray=new int[6];

                try {
                    getDifferenceOfElementsArray(array1,wrongArray);
                }catch (MyArraysSizeException ex){
                    System.out.println(ex.getMessage());
                }

                try {
                    System.out.println(Arrays.toString(getDifferenceOfElementsArray(array1,array2)));
                }catch (MyArraysSizeException ex){
                    System.out.println(ex.getMessage());
                }




                try {
                    getDividingOfElementsArray(array1,wrongArray);
                }catch (MyArraysSizeException | MyArrayZeroException exception){
                    System.out.println(exception.getMessage());
                }

                try {
                    System.out.println(Arrays.toString(getDividingOfElementsArray(array1,array2)));
                }catch (MyArraysSizeException|MyArrayZeroException exception){
                    System.out.println(exception.getMessage());
                }
            }



            public static int[] getDifferenceOfElementsArray(int[] arr1,int[] arr2) throws MyArraysSizeException{
                if(arr1.length!=arr2.length){
                    throw new MyArraysSizeException();
                }
                int[] arrayResult = new int[arr1.length];
                for (int i = 0; i < arr1.length; i++) {
                    arrayResult[i] = arr1[i] - arr2[i];
                }
                return arrayResult;

            }

            public static  int[] getDividingOfElementsArray(int[] arr1,int[] arr2) throws MyArrayZeroException,MyArraysSizeException{
                if(arr1.length!=arr2.length){
                    throw new MyArraysSizeException();
                }
                int[] arrayRes = new int[arr1.length];
                for (int i = 0; i < arr1.length; i++){
                    try {
                        arrayRes[i] = arr1[i] / arr2[i];
                    }catch (ArithmeticException ex){
                        throw new MyArrayZeroException(i);
                    }
                }

                return arrayRes;
            }

        }



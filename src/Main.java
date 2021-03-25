import java.util.Scanner;

public class Main {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int size = 10;
        int[] res = getFilledArray(size, input, Integer::sum);
        printArr(res);
        int[] res1 = getFilledArray(size, input, (arrIndex, inputFunc) -> (arrIndex * inputFunc));
        printArr(res1);
        int[] res2 = getFilledArray(size, input, (arrIndex, inputFunc) -> {
            if (arrIndex % 2 == 0) {
                return (arrIndex / 2 + inputFunc);
            }
            return (arrIndex * arrIndex - inputFunc);
        });
        printArr(res2);
        // складывает индекс и модуль вводимого числа
        int[] res3 = getFilledArray(size, input, (arrIndex, inputFunc) -> {
            if (inputFunc >= 0) {
                return (arrIndex + inputFunc);
            }
            return (-arrIndex + inputFunc);
        });
        printArr(res3);
        // Заполняет результатом деления индекса на введенное число (в случае нуля - заполняет нулями)
        int[] res4 = getFilledArray(size, input, (arrIndex, inputFunc) -> {
            if (inputFunc == 0) {
                return (0);
            }
            return (arrIndex / inputFunc);
        });
        printArr(res4);
        // Заполняет тройками чисел - индекс, квадрат индекса, куб введенного числа
        int[] res5 = getFilledArray(size, input, (arrIndex, inputFunc) -> {
            if (arrIndex % 3 == 0) {
                return (arrIndex);
            } else if (arrIndex % 3 == 1) {
                return (arrIndex * arrIndex);
            }
            return (inputFunc * inputFunc * inputFunc);
        });
        printArr(res5);
        scanner.close();
    }

    protected static int[] getFilledArray(final int size, final int input, final FunctInterface func) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = func.process(i, input);
        }
        return arr;
    }

    private static void printArr(final int[] arr) {
        System.out.print("[");
        int i;
        for (i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[i] + "]");
    }
}

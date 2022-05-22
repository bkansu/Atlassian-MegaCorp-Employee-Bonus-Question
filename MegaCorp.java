
import java.util.Arrays;
import java.util.HashMap;

public class MegaCorp {

    public void MegaCorp(int[] array) {
        int[] bonusArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                if (array[i] < array[i + 1]) {
                    bonusArray[i] = 1;
                } else if (array[i] > array[i + 1]) {
                    bonusArray[i] = 2;
                    bonusArray[i + 1] = 1;
                } else {
                    bonusArray[i] = 1;
                    bonusArray[i + 1] = 1;
                }
            } else if (i != array.length - 1) {
                if (array[i] > array[i - 1]) {
                    bonusArray[i] = bonusArray[i - 1] + 1;
                } else if (array[i] < array[i - 1]) {
                    if (array[i] > array[i + 1]) {
                        bonusArray[i] = bonusArray[i - 1] - 1;
                    } else if (array[i] < array[i + 1]) {
                        bonusArray[i] = 1;
                    }
                }

            } else {
                if (array[i] > array[i - 1]) {
                    bonusArray[i] = bonusArray[i - 1] + 1;
                } else if (array[i] < array[i - 1]) {
                    bonusArray[i] = 1;
                }
            }
        }
        bonusArray = minimizeTheBonusArray(bonusArray);
        for (int i = 0; i < bonusArray.length; i++) {
            System.out.println(bonusArray[i]);
        }

    }

    public static int[] minimizeTheBonusArray(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] < arr[i - 1] && arr[i] > arr[i + 1]) {
                arr[i] = arr[i + 1] + 1;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {10, 40, 200, 1000, 60, 30} //SampleInput
        int[] arr2 = {1, 2, 3, 4, 2, 1} //ExpectedOutput
        MegaCorp(arr)
    }
}

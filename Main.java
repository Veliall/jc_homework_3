package jc_homework_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);

        //В задании не сказано необходимо ли сохранить данные в отдельный лист, или изменить имеющийся
        // делаю отдельный
        List<Integer> result = new ArrayList<>();
        for (int integer : integerList) {
            if (integer > 0 && (integer % 2 == 0)) {
                result.add(integer);
            }
        }
        quickSort(result, 0, result.size() - 1);
        for (int integer : result) {
            System.out.println(integer);
        }

    }

    public static void quickSort(List<Integer> array, int low, int high) {
        if (array.size() == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        int opora = array.get(middle);

        int i = low, j = high;
        while (i <= j) {
            while (array.get(i) < opora) {
                i++;
            }

            while (array.get(j) > opora) {
                j--;
            }

            if (i <= j) {
                int temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
}

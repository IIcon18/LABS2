package Labs.lab4;

public class ArrayAverage {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "4", "5"};
        int sum = 0;
        int count = 0;

        try {
            for (int i = 0; i <= arr.length; i++) {
                int num = Integer.parseInt(arr[i]);
                sum += num;
                count++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: Выход за границы массива");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Неверные данные в массиве");
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка" + e.getMessage());
        }

        if (count > 0) {
            double average = sum / count;
            System.out.println("Среднее арифметическое: " + average);
        } else {
            System.out.println("Невозможно вычислить среднее арифметическое");
        }
    }
}

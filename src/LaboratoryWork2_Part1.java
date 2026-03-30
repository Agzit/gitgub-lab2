import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;

public class LaboratoryWork2_Part1 {
    private static Scanner scanner = new Scanner(System.in);
    private static int[] array = null;
    private static int arraySize = 0;

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║   ЛАБОРАТОРНАЯ РАБОТА №2. ЧАСТЬ 1                  ║");
        System.out.println("║   Работа с одномерными массивами                   ║");
        System.out.println("╚════════════════════════════════════════════════════╝");

        boolean exit = false;

        // === ГЛАВНОЕ МЕНЮ (Уровень 1) ===
        do {
            displayMainMenu();
            int mainChoice = getValidatedInt(1, 8);

            switch (mainChoice) {
                case 1:
                    taskCreateArray();
                    break;
                case 2:
                    taskPrintArray();
                    break;
                case 3:
                    taskDeleteElement();
                    break;
                case 4:
                    taskAddElement();
                    break;
                case 5:
                    taskSwapMinMax();
                    break;
                case 6:
                    taskLinearSearch();
                    break;
                case 7:
                    taskBinarySearch();
                    break;
                case 8:
                    exit = true;
                    System.out.println("\nПрограмма завершена. До свидания!");
                    break;
            }

            if (!exit) {
                System.out.print("\nПродолжить работу? (1 - Да, 0 - Нет): ");
                int cont = getValidatedInt(0, 1);
                if (cont == 0) exit = true;
            }
        } while (!exit);
    }

    private static void displayMainMenu() {
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║              ГЛАВНОЕ МЕНЮ                          ║");
        System.out.println("╠════════════════════════════════════════════════════╣");
        System.out.println("║ 1. Создать массив                                  ║");
        System.out.println("║ 2. Распечатать массив                              ║");
        System.out.println("║ 3. Удалить элемент (минимальный)                   ║");
        System.out.println("║ 4. Добавить элемент (с номером К)                  ║");
        System.out.println("║ 5. Перестановка (мин ↔ макс)                       ║");
        System.out.println("║ 6. Линейный поиск (среднее арифметическое)         ║");
        System.out.println("║ 7. Бинарный поиск (в отсортированном)              ║");
        System.out.println("║ 8. Выход                                           ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
        System.out.print("Выберите пункт меню (1-8): ");
    }

    private static void displayCreateSubMenu() {
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║         СПОСОБ СОЗДАНИЯ МАССИВА                    ║");
        System.out.println("╠════════════════════════════════════════════════════╣");
        System.out.println("║ 1. Случайные числа                                 ║");
        System.out.println("║ 2. Ввод с клавиатуры                               ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
        System.out.print("Выберите способ (1-2): ");
    }


    private static int getValidatedInt(int min, int max) {
        int value = 0;
        boolean isValid = false;

        while (!isValid) {
            try {
                value = scanner.nextInt();
                if (value >= min && value <= max) {
                    isValid = true;
                } else {
                    System.out.print("Введите число от " + min + " до " + max + ": ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Ошибка! Введите целое число: ");
                scanner.next();
            }
        }
        return value;
    }

    private static int getValidatedIntPositive(String prompt) {
        int value = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);
            try {
                value = scanner.nextInt();
                if (value > 0) {
                    isValid = true;
                } else {
                    System.out.print("Число должно быть положительным: ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Ошибка! Введите целое число: ");
                scanner.next();
            }
        }
        return value;
    }

    private static int getValidatedIntRange(String prompt, int min, int max) {
        int value = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);
            try {
                value = scanner.nextInt();
                if (value >= min && value <= max) {
                    isValid = true;
                } else {
                    System.out.printf("Введите число от %d до %d: ", min, max);
                }
            } catch (InputMismatchException e) {
                System.out.print("Ошибка! Введите целое число: ");
                scanner.next();
            }
        }
        return value;
    }



    private static void taskCreateArray() {
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║   ЗАДАЧА 1: СОЗДАНИЕ МАССИВА                       ║");
        System.out.println("╚════════════════════════════════════════════════════╝");

        displayCreateSubMenu();
        int createChoice = getValidatedInt(1, 2);

        System.out.print("Введите размер массива n: ");
        int n = getValidatedIntPositive("");

        array = new int[n];
        arraySize = n;

        switch (createChoice) {
            case 1:
                createArrayRandom(n);
                break;
            case 2:
                createArrayInput(n);
                break;
        }

        System.out.println("\n✓ Массив успешно создан!");
        printArray("Созданный массив", array, arraySize);
    }

    private static void createArrayRandom(int n) {
        System.out.println("\nГенерация случайных чисел от -100 до 100...");
        for (int i = 0; i < n; i++) {
            array[i] = (int)(Math.random() * 201) - 100;
        }
    }

    private static void createArrayInput(int n) {
        System.out.println("\nВведите " + n + " элементов массива:");
        for (int i = 0; i < n; i++) {
            System.out.print("  a[" + i + "] = ");
            array[i] = getValidatedInt(-10000, 10000);
        }
    }


    private static void taskPrintArray() {
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║   ЗАДАЧА 2: ПЕЧАТЬ МАССИВА                         ║");
        System.out.println("╚════════════════════════════════════════════════════╝");

        if (array == null || arraySize == 0) {
            System.out.println("⚠ Массив не создан!");
            return;
        }

        printArray("Текущий массив", array, arraySize);
    }

    private static void printArray(String title, int[] arr, int size) {
        System.out.println("\n" + title + ":");
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("Размер: " + size);
    }


    private static void taskDeleteElement() {
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║   ЗАДАЧА 3: УДАЛЕНИЕ МИНИМАЛЬНОГО ЭЛЕМЕНТА         ║");
        System.out.println("╚════════════════════════════════════════════════════╝");

        if (array == null || arraySize == 0) {
            System.out.println("⚠ Массив не создан!");
            return;
        }

        int[] result = deleteMinElement(array, arraySize);

        if (result != null) {
            array = result;
            arraySize = result.length;
            printArray("Массив после удаления минимума", array, arraySize);
        } else {
            System.out.println("Не удалось удалить элемент.");
        }
    }

    private static int[] deleteMinElement(int[] arr, int size) {
        if (size == 0) return null;

        int minIndex = 0;
        for (int i = 1; i < size; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }

        System.out.println("Минимальный элемент: " + arr[minIndex] + " (индекс " + minIndex + ")");

        int[] result = new int[size - 1];
        for (int i = 0, j = 0; i < size; i++) {
            if (i != minIndex) {
                result[j++] = arr[i];
            }
        }

        return result;
    }



    private static void taskAddElement() {
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║   ЗАДАЧА 4: ДОБАВЛЕНИЕ ЭЛЕМЕНТА                    ║");
        System.out.println("╚════════════════════════════════════════════════════╝");

        if (array == null || arraySize == 0) {
            System.out.println("⚠ Массив не создан!");
            return;
        }

        System.out.print("Введите значение элемента К: ");
        int k = getValidatedInt(-10000, 10000);

        int position = getValidatedIntRange("Введите позицию для вставки (0-" + arraySize + "): ", 0, arraySize);

        int[] result = addElement(array, arraySize, k, position);
        array = result;
        arraySize = result.length;

        printArray("Массив после добавления", array, arraySize);
    }

    private static int[] addElement(int[] arr, int size, int value, int position) {
        int[] result = new int[size + 1];

        for (int i = 0; i < position; i++) {
            result[i] = arr[i];
        }

        result[position] = value;

        for (int i = position; i < size; i++) {
            result[i + 1] = arr[i];
        }

        return result;
    }



    private static void taskSwapMinMax() {
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║   ЗАДАЧА 5: ПЕРЕСТАНОВКА MIN ↔ MAX                 ║");
        System.out.println("╚════════════════════════════════════════════════════╝");

        if (array == null || arraySize == 0) {
            System.out.println("⚠ Массив не создан!");
            return;
        }

        printArray("Исходный массив", array, arraySize);

        swapMinMax(array, arraySize);

        printArray("Массив после перестановки", array, arraySize);
    }

    private static void swapMinMax(int[] arr, int size) {
        if (size == 0) return;

        int minIndex = 0, maxIndex = 0;

        for (int i = 1; i < size; i++) {
            if (arr[i] < arr[minIndex]) minIndex = i;
            if (arr[i] > arr[maxIndex]) maxIndex = i;
        }

        System.out.println("Минимум: " + arr[minIndex] + " (индекс " + minIndex + ")");
        System.out.println("Максимум: " + arr[maxIndex] + " (индекс " + maxIndex + ")");

        int temp = arr[minIndex];
        arr[minIndex] = arr[maxIndex];
        arr[maxIndex] = temp;
    }



    private static void taskLinearSearch() {
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║   ЗАДАЧА 6: ЛИНЕЙНЫЙ ПОИСК                         ║");
        System.out.println("║   Поиск элемента = среднему арифметическому        ║");
        System.out.println("╚════════════════════════════════════════════════════╝");

        if (array == null || arraySize == 0) {
            System.out.println("⚠ Массив не создан!");
            return;
        }

        double avg = calculateAverage(array, arraySize);
        System.out.printf("Среднее арифметическое: %.2f%n", avg);

        int[] searchResult = linearSearch(array, arraySize, avg);

        if (searchResult[0] != -1) {
            System.out.println("✓ Элемент найден!");
            System.out.println("  Индекс: " + searchResult[0]);
            System.out.println("  Значение: " + array[searchResult[0]]);
            System.out.println("  Количество сравнений: " + searchResult[1]);
        } else {
            System.out.println("✗ Элемент не найден.");
            System.out.println("  Количество сравнений: " + searchResult[1]);
        }
    }

    private static double calculateAverage(int[] arr, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
        }
        return (double) sum / size;
    }

    private static int[] linearSearch(int[] arr, int size, double target) {
        int comparisons = 0;

        for (int i = 0; i < size; i++) {
            comparisons++;
            if (arr[i] == target) {
                return new int[]{i, comparisons};
            }
        }

        return new int[]{-1, comparisons};
    }



    private static void taskBinarySearch() {
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║   ЗАДАЧА 7: БИНАРНЫЙ ПОИСК                         ║");
        System.out.println("║   Поиск в отсортированном массиве                  ║");
        System.out.println("╚════════════════════════════════════════════════════╝");

        if (array == null || arraySize == 0) {
            System.out.println("⚠ Массив не создан!");
            return;
        }

        int[] sortedArray = array.clone();
        Arrays.sort(sortedArray);

        printArray("Отсортированный массив", sortedArray, arraySize);

        System.out.print("Введите искомое значение: ");
        int target = getValidatedInt(-10000, 10000);

        int[] searchResult = binarySearch(sortedArray, arraySize, target);

        if (searchResult[0] != -1) {
            System.out.println("✓ Элемент найден!");
            System.out.println("  Индекс в отсортированном массиве: " + searchResult[0]);
            System.out.println("  Значение: " + sortedArray[searchResult[0]]);
            System.out.println("  Количество сравнений: " + searchResult[1]);
        } else {
            System.out.println("✗ Элемент не найден.");
            System.out.println("  Количество сравнений: " + searchResult[1]);
        }
    }

    private static int[] binarySearch(int[] arr, int size, int target) {
        int left = 0, right = size - 1;
        int comparisons = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            comparisons++;

            if (arr[mid] == target) {
                return new int[]{mid, comparisons};
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new int[]{-1, comparisons};
    }
}
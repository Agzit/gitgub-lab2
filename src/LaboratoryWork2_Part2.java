import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;

public class LaboratoryWork2_Part2 {
    private static Scanner scanner = new Scanner(System.in);
    private static int[][] matrix2D = null;
    private static int[][] jaggedArray = null;
    private static int rows2D = 0, cols2D = 0;

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║   ЛАБОРАТОРНАЯ РАБОТА №2. ЧАСТЬ 2                    ║");
        System.out.println("║   Работа с многомерными массивами                    ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");

        boolean exit = false;

        do {
            displayMainMenu();
            int mainChoice = getValidatedInt(1, 5);

            switch (mainChoice) {
                case 1:
                    task2DArray();
                    break;
                case 2:
                    taskJaggedArray();
                    break;
                case 3:
                    displayBothArrays();
                    break;
                case 4:
                    resetArrays();
                    break;
                case 5:
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


    // МЕТОДЫ МЕНЮ


    private static void displayMainMenu() {
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("║              ГЛАВНОЕ МЕНЮ                            ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("║ 1. Работа с двумерным массивом                       ║");
        System.out.println("║ 2. Работа с рваным массивом                          ║");
        System.out.println("║ 3. Показать оба массива                              ║");
        System.out.println("║ 4. Сбросить массивы                                  ║");
        System.out.println("║ 5. Выход                                             ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        System.out.print("Выберите пункт меню (1-5): ");
    }

    private static void display2DSubMenu() {
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("║         ДВУМЕРНЫЙ МАССИВ                             ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("║ 1. Создать и заполнить матрицу                       ║");
        System.out.println("║ 2. Вывести матрицу                                   ║");
        System.out.println("║ 3. Добавить строки после чётных строк                ║");
        System.out.println("║ 4. Назад                                             ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        System.out.print("Выберите пункт меню (1-4): ");
    }

    private static void displayJaggedSubMenu() {
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("║         РВАНЫЙ МАССИВ                                ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("║ 1. Создать и заполнить рваный массив                 ║");
        System.out.println("║ 2. Вывести рваный массив                             ║");
        System.out.println("║ 3. Добавить строку в конец                           ║");
        System.out.println("║ 4. Назад                                             ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        System.out.print("Выберите пункт меню (1-4): ");
    }


    // МЕТОДЫ ПРОВЕРКИ ВВОДА


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


    // ОСНОВНЫЕ ЗАДАЧИ


    private static void task2DArray() {
        boolean back = false;

        do {
            display2DSubMenu();
            int choice = getValidatedInt(1, 4);

            switch (choice) {
                case 1:
                    createAndFill2DArray();
                    break;
                case 2:
                    print2DArray();
                    break;
                case 3:
                    addRowsAfterEvenRows();
                    break;
                case 4:
                    back = true;
                    break;
            }

            if (!back) {
                System.out.print("\nПродолжить работу с 2D массивом? (1 - Да, 0 - Нет): ");
                int cont = getValidatedInt(0, 1);
                if (cont == 0) back = true;
            }
        } while (!back);
    }

    private static void taskJaggedArray() {
        boolean back = false;

        do {
            displayJaggedSubMenu();
            int choice = getValidatedInt(1, 4);

            switch (choice) {
                case 1:
                    createAndFillJaggedArray();
                    break;
                case 2:
                    printJaggedArray();
                    break;
                case 3:
                    addRowToJaggedArray();
                    break;
                case 4:
                    back = true;
                    break;
            }

            if (!back) {
                System.out.print("\nПродолжить работу с рваным массивом? (1 - Да, 0 - Нет): ");
                int cont = getValidatedInt(0, 1);
                if (cont == 0) back = true;
            }
        } while (!back);
    }


    // ДВУМЕРНЫЙ МАССИВ - МЕТОДЫ


    private static void createAndFill2DArray() {
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("║   СОЗДАНИЕ ДВУМЕРНОГО МАССИВА                        ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");

        System.out.print("Введите количество строк: ");
        rows2D = getValidatedIntPositive("");

        System.out.print("Введите количество столбцов: ");
        cols2D = getValidatedIntPositive("");

        matrix2D = new int[rows2D][cols2D];

        System.out.println("\nЗаполнение случайными числами от -50 до 50...");
        for (int i = 0; i < rows2D; i++) {
            for (int j = 0; j < cols2D; j++) {
                matrix2D[i][j] = (int)(Math.random() * 101) - 50;
            }
        }

        System.out.println("✓ Матрица " + rows2D + "×" + cols2D + " создана и заполнена!");
        printMatrix("Результат", matrix2D, rows2D, cols2D);
    }

    private static void print2DArray() {
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("║   ПЕЧАТЬ ДВУМЕРНОГО МАССИВА                          ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");

        if (matrix2D == null) {
            System.out.println("⚠ Матрица не создана!");
            return;
        }

        printMatrix("Текущая матрица", matrix2D, rows2D, cols2D);
    }

    private static void printMatrix(String title, int[][] matrix, int rows, int cols) {
        System.out.println("\n" + title + " (" + rows + "×" + cols + "):");
        System.out.println("┌" + "─".repeat(cols * 5) + "┐");

        for (int i = 0; i < rows; i++) {
            System.out.print("│");
            for (int j = 0; j < cols; j++) {
                System.out.printf("%4d ", matrix[i][j]);
            }
            System.out.println("│");
        }

        System.out.println("└" + "─".repeat(cols * 5) + "┘");
    }

    private static void addRowsAfterEvenRows() {
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("║   ДОБАВЛЕНИЕ СТРОК ПОСЛЕ ЧЁТНЫХ СТРОК                ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");

        if (matrix2D == null) {
            System.out.println("⚠ Матрица не создана!");
            return;
        }

        printMatrix("Исходная матрица", matrix2D, rows2D, cols2D);

        // Подсчёт чётных строк
        int evenRowsCount = 0;
        for (int i = 0; i < rows2D; i += 2) {
            evenRowsCount++;
        }

        System.out.println("\nНайдено чётных строк (по индексу): " + evenRowsCount);
        System.out.println("Добавление пустых строк (заполненных нулями)...");

        // Новая матрица с добавленными строками
        int newRows = rows2D + evenRowsCount;
        int[][] newMatrix = new int[newRows][cols2D];

        int newRowIdx = 0;
        for (int i = 0; i < rows2D; i++) {
            // Копируем текущую строку
            for (int j = 0; j < cols2D; j++) {
                newMatrix[newRowIdx][j] = matrix2D[i][j];
            }
            newRowIdx++;

            // Если строка чётная (по индексу), добавляем после неё новую строку
            if (i % 2 == 0) {
                System.out.println("  Добавлена строка после строки с индексом " + i);
                // Новая строка уже заполнена нулями по умолчанию
                newRowIdx++;
            }
        }

        matrix2D = newMatrix;
        rows2D = newRows;

        printMatrix("Результат после добавления строк", matrix2D, rows2D, cols2D);
    }



    private static void createAndFillJaggedArray() {
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("║   СОЗДАНИЕ РВАНОГО МАССИВА                           ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");

        int numStrings = getValidatedIntPositive("Введите количество строк: ");

        jaggedArray = new int[numStrings][];

        System.out.println("\nВведите длину каждой строки:");
        for (int i = 0; i < numStrings; i++) {
            int length = getValidatedIntPositive("  Длина строки " + i + ": ");
            jaggedArray[i] = new int[length];

            // Заполняем случайными числами
            for (int j = 0; j < length; j++) {
                jaggedArray[i][j] = (int)(Math.random() * 101) - 50;
            }
        }

        System.out.println("\n✓ Рваный массив создан и заполнен!");
        printJaggedArrayContent("Результат", jaggedArray);
    }

    private static void printJaggedArray() {
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("║   ПЕЧАТЬ РВАНОГО МАССИВА                             ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");

        if (jaggedArray == null) {
            System.out.println("⚠ Рваный массив не создан!");
            return;
        }

        printJaggedArrayContent("Текущий рваный массив", jaggedArray);
    }

    private static void printJaggedArrayContent(String title, int[][] array) {
        System.out.println("\n" + title + ":");
        System.out.println("┌" + "─".repeat(40) + "┐");

        for (int i = 0; i < array.length; i++) {
            System.out.printf("│[%2d] │", i);
            System.out.print(" [");
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%4d", array[i][j]);
                if (j < array[i].length - 1) System.out.print(",");
            }
            System.out.println("] │");
        }

        System.out.println("└" + "─".repeat(40) + "┘");
        System.out.println("Всего строк: " + array.length);
    }

    private static void addRowToJaggedArray() {
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("║   ДОБАВЛЕНИЕ СТРОКИ В КОНЕЦ                          ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");

        if (jaggedArray == null) {
            System.out.println("⚠ Рваный массив не создан!");
            return;
        }

        printJaggedArrayContent("Исходный массив", jaggedArray);

        int newLength = getValidatedIntPositive("Введите длину новой строки: ");

        // Создаём новый массив с одной дополнительной строкой
        int[][] newArray = Arrays.copyOf(jaggedArray, jaggedArray.length + 1);

        // Создаём и заполняем новую строку
        newArray[newArray.length - 1] = new int[newLength];
        System.out.println("\nЗаполнение новой строки случайными числами...");
        for (int j = 0; j < newLength; j++) {
            newArray[newArray.length - 1][j] = (int)(Math.random() * 101) - 50;
        }

        jaggedArray = newArray;

        System.out.println("✓ Строка длиной " + newLength + " добавлена в конец!");
        printJaggedArrayContent("Результат", jaggedArray);
    }



    private static void displayBothArrays() {
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("║   ПОКАЗАТЬ ОБА МАССИВА                               ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");

        if (matrix2D != null) {
            printMatrix("Двумерный массив", matrix2D, rows2D, cols2D);
        } else {
            System.out.println("⚠ Двумерный массив не создан");
        }

        System.out.println();

        if (jaggedArray != null) {
            printJaggedArrayContent("Рваный массив", jaggedArray);
        } else {
            System.out.println("⚠ Рваный массив не создан");
        }
    }

    private static void resetArrays() {
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("║   СБРОС МАССИВОВ                                     ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");

        matrix2D = null;
        jaggedArray = null;
        rows2D = 0;
        cols2D = 0;

        System.out.println("✓ Все массивы сброшены!");
    }
}
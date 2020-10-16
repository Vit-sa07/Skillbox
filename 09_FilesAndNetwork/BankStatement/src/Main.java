import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

    final static String MOVEMENT_LIST_FILE = "movementList.csv";
    final static int NUMBER_COLUMNS = 11;
    final static int INDEX_INCOME = 9;
    final static int INDEX_EXPENSE = 10;
    final static int INDEX_TYPE_INCOME_EXPENSE = 6;

    public static void main(String[] args) {
        double totalIncomeRUR = 0;
        double totalExpenseRUR = 0;
        List<Operations> listLines = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Path.of(MOVEMENT_LIST_FILE));
            for (int i = 1; i < lines.size(); i++) {

                String[] fragments = lines.get(i).replaceAll("\"", "")
                        .replaceAll(" \\(.*?\\)", "")
                        .replaceAll("\\s{3,}", ",")
                        .split(",", NUMBER_COLUMNS);

                double income = Double.parseDouble(fragments[INDEX_INCOME]);
                double expense = Double.parseDouble(fragments[INDEX_EXPENSE].replaceAll("\\,", "."));
                totalIncomeRUR += income;
                totalExpenseRUR += expense;
                listLines.add(new Operations(fragments[INDEX_TYPE_INCOME_EXPENSE], income, expense));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Общий приход: " + totalIncomeRUR + " рублей");
        System.out.println("Общий расход: " + totalExpenseRUR + " рублей");

        System.out.println("Сумма общего поступления:");
        listLines.stream()
                .filter(line -> line.income > 0)
                .collect(Collectors.groupingBy(Operations::getClient, Collectors.summingDouble(Operations::getIncome)))
                .forEach((a, income) -> System.out.println(a + " : " + income + " рублей"));

        System.out.println("Суммы расходов по организациям:");
        listLines.stream()
                .filter(line -> line.expense > 0)
                .collect(Collectors.groupingBy(Operations::getClient, Collectors.summingDouble(Operations::getExpense)))
                .forEach((a, expense) -> System.out.println(a + " : " + expense + " рублей"));
    }
}
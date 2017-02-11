import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class OfficeStuff {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "^\\|(?<company>\\w+) - (?<amount>\\d+) - (?<product>\\w+)\\|$";
        Pattern pattern = Pattern.compile(regex);

        int orders = Integer.parseInt(reader.readLine());

        Map<String, Map<String, Integer>> companies = new HashMap<>();

        for (int i = 0; i < orders; i++) {
            String order = reader.readLine();

            Matcher matcher = pattern.matcher(order);

            if (matcher.find()) {
                String company = matcher.group("company");
                String product = matcher.group("product");
                Integer amount = Integer.valueOf(matcher.group("amount"));

                companies.putIfAbsent(company, new LinkedHashMap<>());
                companies.get(company).putIfAbsent(product, 0);
                companies.get(company).put(product, companies.get(company).get(product) + amount);
            }
        }

        companies.entrySet().stream()
                .sorted((c1, c2) -> c1.getKey().compareTo(c2.getKey()))
                .forEach(company -> {
                    System.out.print(company.getKey() + ": ");
                    System.out.println(company.getValue().entrySet().stream().map(p -> p.getKey() + "-" + p.getValue()).collect(Collectors.joining(", ")));
//
//                    StringBuilder sb = new StringBuilder();
//                    company.getValue().entrySet().forEach(product -> {
//                        sb.append(product.getKey()).append("-").append(product.getValue()).append(", ");
//                    });
//                    sb.delete(sb.length() - 2, sb.length());
//                    System.out.println(sb);
                });
    }
}

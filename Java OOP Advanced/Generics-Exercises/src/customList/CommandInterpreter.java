package customList;

/**
 * Created by Venelin on 17.3.2017 г..
 */
public class CommandInterpreter {

    private CustomList<String> list;

    public CommandInterpreter() {
        this.list = new CustomList<>();
    }

    public void readCommand(String[] commandArgs) {
        String type = commandArgs[0];

        switch (type) {
            case "Add":
                this.list.add(commandArgs[1]);
                break;
            case "Remove":
                this.list.remove(Integer.parseInt(commandArgs[1]));
                break;
            case "Contains":
                if (this.list.contains(commandArgs[1])) {
                    System.out.println(true);
                } else {
                    System.out.println(false);
                }
                break;
            case "Swap":
                this.list.swap(Integer.parseInt(commandArgs[1]), Integer.parseInt(commandArgs[2]));
                break;
            case "Greater":
                System.out.println(this.list.countGreaterThan(commandArgs[1]));
                break;
            case "Max":
                System.out.println(this.list.getMax());
                break;
            case "Min":
                System.out.println(this.list.getMin());
                break;
            case "Print":
                this.list.getData().forEach(System.out::println);
                break;
        }
    }
}

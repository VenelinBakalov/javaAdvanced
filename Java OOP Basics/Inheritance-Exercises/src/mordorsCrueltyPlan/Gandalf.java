package mordorsCrueltyPlan;

/**
 * Created by Venelin on 3.3.2017 г..
 */
public class Gandalf {

    private int happiness;

    @Override
    public String toString() {
        return this.getHappiness() + System.lineSeparator() + this.getMood();
    }

    public void eat(String food) {
        switch (food.toLowerCase()) {
            case "cram":
                this.happiness += 2;
                break;
            case "lembas":
                this.happiness += 3;
                break;
            case "melon":
            case "apple":
                this.happiness += 1;
                break;
            case "honeycake":
                this.happiness += 5;
                break;
            case "mushrooms":
                this.happiness -= 10;
                break;
            default:
                this.happiness -= 1;
                break;
        }
    }

    private String getMood() {
        int happiness = this.getHappiness();
        if (happiness < -5) {
            return "Angry";
        } else if (happiness < 0) {
            return "Sad";
        } else if (happiness < 15) {
            return "Happy";
        }
            return "JavaScript";
    }

    private int getHappiness() {
        return this.happiness;
    }
}

package averageGrades;

import java.util.List;

/**
 * Created by Venelin on 4.7.2017 г..
 */
public class Student {

    private String name;
    private List<Double> grades;
    private double averageGrade;

    public Student(String name, List<Double> grades) {
        this.name = name;
        this.grades = grades;
    }

    public void addGrades(List<Double> grades) {
        this.grades.addAll(grades);
    }

    public String getName() {
        return name;
    }

    public void calculateAverageGrade() {
        this.averageGrade = this.grades.stream().mapToDouble(g -> g).average().getAsDouble();
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public String toString() {
        return String.format("%s -> %.2f", this.getName(), this.getAverageGrade());
    }
}

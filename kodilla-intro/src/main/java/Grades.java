public class Grades {
    private int[] grades;
    public int size;
    public int counter;
    public double average;

    public Grades() {
        this.grades = new int[10];
        this.size = 0;
    }

    public void add(int value) {
        if (this.size == 10) {
            return;
        }
        this.grades[this.size] = value;
        this.size++;
    }

    public int checkLastGrade() {
        return this.grades[this.size - 1];
    }

    public double checkGradesAverage() {
        for (int i = 0; i < this.size; i++) {
            counter = counter + this.grades[i];
        }
        return (double) counter / this.size;
    }
}

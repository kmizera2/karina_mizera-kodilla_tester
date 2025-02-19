public class callingGrades {
    public static void main(String[] args) {
        Grades grades = new Grades();
        grades.add(12);
        grades.add(7);
        grades.add(6);

        System.out.println(grades.checkLastGrade());
        System.out.println(grades.checkGradesAverage());
        System.out.println(grades.size);
    }
}

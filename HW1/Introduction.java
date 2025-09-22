public class Introduction {
    public static void main(String[] args) {

        String fullName = "Trịnh Tuấn Anh";
        String studentId = "24020032";
        String className = "INT2204_11";
        String githubUsername = "Anhtrinh2516";
        String email = "24020032@vnu.edu.vn";
        System.out.println(fullName + "\t" + studentId + "\t" + className + "\t" + githubUsername + "\t" + email);


        for (int i = 9; i >= 1; i--) {
            if (i > 1) {
                System.out.println(i + " bottles of beer on the wall, " + i + " bottles of beer.");
            } else {
                System.out.println(i + " bottle of beer on the wall, " + i + " bottle of beer.");
            }
            System.out.println("Take one down, pass it around,");
        }
        System.out.println("No more bottles of beer on the wall.");
    }
}
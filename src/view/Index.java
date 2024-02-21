package view;
import java.sql.SQLException;
import java.util.*;

public class Index {
    public Index() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("1.Sign In \n2.Sign Up\n3.Admin\n4.Quit\n");
        System.out.println("\t-----------------");
        System.out.println("\tSelect the option");
        System.out.println("\t-----------------");
        int n = sc.nextInt();
        System.out.println("--------------------------------");
        if(n==4) {
            System.out.println("--------------------------------");
            System.out.println("    Thank you for using         ");
            System.out.println("--------------------------------");
            return;
        }
        sc.nextLine();
        new fontview(n);
    }
    public static void main(String[] args) throws SQLException {
        System.out.println("******  WELCOME  ******");
        new Index();
    }
}

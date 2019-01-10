package hieu071218;

import java.text.DecimalFormat;

import java.util.Scanner;

public class ptbac1 {

    public static void main(String[] args) {

        int aNumber, bNumber;

        double nghiem;

        DecimalFormat decimalFormat = new DecimalFormat("#.##");  

        Scanner scanner = new Scanner(System.in);

      

        System.out.println("Nhap a: ");

        aNumber = scanner.nextInt();

        System.out.println("Nhap b: ");

        bNumber = scanner.nextInt();

        System.out.println("PT ban nhap la: " + aNumber + "x + " + bNumber + " = 0.");

        if (aNumber == 0) {

            if (bNumber == 0) {

                System.out.println("PT co vo so nghiem");

            } else {

                System.out.println("PT vo nghiem");

            }

        } else {

            nghiem = (double) -bNumber / aNumber;  

            System.out.println("PT co nghiem x = " + decimalFormat.format(nghiem) + ".");

        }

    }

}
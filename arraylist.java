/*
 * tạo 1 danh sách array hoặc aray list gồm 10 phần tử
sử dụng hàm random nhập dữ liệu cho danh sách này
sau đó đếm xem có bao nhiêu số chẵn, bao nhiêu số lẻ

cách làm:
1. khởi tạo mảng
2. sử dụng hàm random, sử dụng vòng lặp for để nhập dữ liệu
3. thực hiện in ra
4. đếm xem có bao nhiêu số chẵn, số lẻ
 */

package hieu071218;

import java.util.ArrayList;
import java.util.Random;

//đầu tiên, cần import thư viện random

//khai báo class
public class arraylist {
	 static int totalNumber1;
	static  int totalNumber2;
	//khai báo method
	public static void main(String[] args) {

		ArrayList<Integer> arrn = new ArrayList<Integer>();
		Random r = new Random();
		for(int i = 0; i<10; i++) {
			int number=r.nextInt();
			arrn.add(number);
		}
		
		for (int number:arrn)
		{
			System.out.println(number);
			if(number%2==0)
				totalNumber1++;
			else
				totalNumber2++;
		}

		System.out.println("Co "+ totalNumber1 + " so chan va "+ totalNumber2);
	}
}

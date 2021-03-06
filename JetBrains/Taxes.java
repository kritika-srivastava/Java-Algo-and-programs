/*
In some country, there are N companies, and the law of that country says that the taxes of each company are individual and appointed by a president. President wants to know which company pays the most taxes. But sadly, none of the president's proxies know math very well, so this work is transferred to you. Can you solve this problem?

The first line of the input contains N which is the number of companies in this country.
The second line contains the yearly incomes of each company. All numbers are non-negative integers.
The third line contains individual taxes for each company in percent of the company's income. All numbers are integers from 0 to 100 inclusive.

You should output № of the company that pays the most taxes. Keep in mind that the enumeration of the companies starts with number 1. If there are several companies with the same payment sizes, output the number of the company with the lowest number.

Note: be careful not to lose fractional parts while performing your calculations. All input and output numbers are integers, but you may have to use a different type for storing intermediate values.
*/
import java.util.Scanner;
class Taxes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCompanies = sc.nextInt();
        double[] yrIncomeArr = new double[numOfCompanies];
        double[] taxPercentArr = new double[numOfCompanies];
        double[] taxAmount = new double[numOfCompanies];

        for (int i = 0; i < yrIncomeArr.length; i++) {
            yrIncomeArr[i] = sc.nextDouble();
        }
        for (int i = 0; i < taxPercentArr.length; i++) {
            taxPercentArr[i] = sc.nextDouble();
        }

        for (int i = 0; i < yrIncomeArr.length; i++) {
            
            taxAmount[i] = (yrIncomeArr[i] * taxPercentArr[i]) / 100; 
        }
        

        double highestTax = 0;
        int k = 1;
        for (int i = 0; i < yrIncomeArr.length; i++) {
            if (taxAmount[i] > highestTax) {
                highestTax = taxAmount[i];
                k = i + 1;
            }
        }
        System.out.println(k);
    }
}

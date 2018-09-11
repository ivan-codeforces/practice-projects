package ru.ivan.calc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        while (true){
            Scanner scanner = new Scanner(System.in);
            double first, second;
//            try {
//                System.out.println("Введите первое число:");
//                first = scanner.nextDouble();
//                System.out.println("Введите второе число:");
//                second = scanner.nextDouble();
//            }catch (InputMismatchException exception){
//                System.out.println("Вы ввели не число");
//                continue;
//            }

            System.out.println("Введите первое число:");
            first = scanner.nextDouble();
            System.out.println("Введите второе число:");
            second = scanner.nextDouble();

            System.out.println("Что вы хотите выполнить? Введите нужное число:");
            System.out.println("1. сложение");
            System.out.println("2. вычетание");
            System.out.println("3. умножение");
            System.out.println("4. деление");
            System.out.println("5. выход");

            char action = ' ';
            double result = 0;
            int variable= scanner.nextInt();
            switch(variable){
                case 1:
                    action='+';
                    result = first+second;
                    break;
                case 2:
                    action='-';
                    result = first-second;
                    break;
                case 3:
                    action='*';
                    result = first*second;
                    break;
                case 4:
                    action='/';
                    if(second==0){
                        System.out.println("Делить на 0 нельзя");
                        continue;
                    }
                    result = first/second;
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Число не равно 1, 2, 3, 4");
            }


            System.out.println(String.valueOf(first)+" "+ action +" "+second +" = " +result);
        }
    }
}

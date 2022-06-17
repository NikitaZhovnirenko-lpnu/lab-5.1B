package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Rational {
    private int a;
    private int b;
    Scanner sc = new Scanner(System.in);

    public Rational(int a, int b) { //конструктор з параметрами
        this.a = a;
        if (b != 0)
            this.b = b;
        else {
            System.out.println("Знаменник не може бути нулем.");
            System.exit(0);
        }
    }
    public Rational(){} //пустий конструктор

    public Rational(Rational rational){ //конструктор копіювання
        this.a = rational.getA();
        if (b != 0)
            this.b = rational.getB();
        else {
            System.out.println("Знаменник не може бути нулем.");
            System.exit(0);
        }
    }

    public double value(Rational rational){
        double value;
        value = (double) rational.getA() / rational.getB();
        System.out.println("Value: " + value);
        return value;
    }

    public Rational add(Rational firstRational, Rational secondRational){
        Rational result = new Rational(); //перевантаження методів

        result.setB(firstRational.getB() * secondRational.getB()); //спільний знаменник

        result.setA((result.getB() / firstRational.getB() * firstRational.getA()) +
                (result.getB() / secondRational.getB() * secondRational.getA())); //чисельник

        System.out.println("Result: " + result.getA() + "/" + result.getB());
        return result.simplify(result);
    }

    public Rational sub(Rational firstRational, Rational secondRational){
        Rational result = new Rational(); //перевантаження методів

        result.setB(firstRational.getB() * secondRational.getB()); //спільний знаменник

        result.setA((result.getB() / firstRational.getB() * firstRational.getA()) -
                (result.getB() / secondRational.getB() * secondRational.getA())); //чисельник

        System.out.println("Result: " + result.getA() + "/" + result.getB());
        return result.simplify(result);
    }

    public Rational mul(Rational firstRational, Rational secondRational){
        Rational result = new Rational(); //перевантаження методів

        result.setB(firstRational.getB() * secondRational.getB()); //знаменник

        result.setA(firstRational.getA() * secondRational.getA()); //чисельник

        System.out.println("Result: " + result.getA() + "/" + result.getB());
        return simplify(result);
    }

    public Rational div(Rational firstRational, Rational secondRational){
        Rational result = new Rational(); //перевантаження методів

        result.setB(firstRational.getB() * secondRational.getA()); //спільний знаменник

        result.setA(firstRational.getA() * secondRational.getB()); //чисельник

        simplify(result);
        return result;
    }



    public Rational simplify(Rational rational){
        Rational result = new Rational(); //перевантаження методів

        int n1 = rational.getA();
        int n2 = rational.getB();
        int temp1 = n1;
        int temp2 = n2;

        while (n1 != n2){
            if(n1 > n2)
                n1 = n1 - n2;
            else
                n2 = n2 - n1;
        }

        int n3 = temp1 / n1 ;
        int n4 = temp2 / n1 ;

        System.out.print("\n Result :\n");

        result.setA(n3);
        result.setB(n4);
        System.out.print(n3 + "/" + n4 + "\n\n" );
        System.out.println("Результат у вигляді десяткового числа: " + (double)n3 / (double)n4);
        return result;
    }


    public int getA() {
        return a;
    }

    public void setA(double a) {
        this.a = (int) a;
    }

    public int getB() {
        return b;
    }

    public void setB(double b) {
        this.b = (int) b;
       if(b == 0){
            System.out.println("Знаменник не може бути нулем.");
            System.exit(0);
        }

    }

    public void inputA(){
        System.out.println("Уведіть значення чисельника: ");
        this.a = sc.nextInt();
    }

    public void inputB() throws IOException {
        System.out.println("Уведіть значення знаменника: ");
        this.b = sc.nextInt();
        if(this.b == 0){
            throw new IOException("Знаменник не може бути нулем");
        }
    }

}

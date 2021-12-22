/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapp;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.Math;

public class Customer extends Account {

    private String status;
    private int points;
    private int id;

    public Customer(String username, String password) {
        super(username, password);
        this.points = 0;
    }

    public int setPoints(int points) {
        this.points = points;
        return points;
    }

    public String checkMember() {
        if (this.points >= 1000) {
            this.status = "Gold";
        } else {
            this.status = "Silver";
        }
        return status;
    }

    public void buy(Book book) {
        this.points += (int) Math.floor(book.getPrice()) * 10;
        int i;
        System.out.println(super.books.size());
        for (i = 0; i < super.books.size(); i++) {
            System.out.println("3");
            if (book.getName().equals(super.books.get(i).getName())) {
                super.books.remove(i);

            }
        }

    }

    public void pointsbuy(Book book) {
        int points = (int) Math.floor(book.getPrice()) * 10;
        if (this.points >= points) {
            this.points = this.points - points;
            int i;
            for (i = 0; i < super.books.size(); i++) {
                System.out.println("2");
                if (book.getName().equals(super.books.get(i).getName())) {
                    super.books.remove(i);
                    System.out.println("1");
                }
            }

        } else {
            System.out.println("ur broke");
        }
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Welcome " + super.getUser() + "You have " + super.getPoints() + " points. Your status is " + this.status;
    }
}
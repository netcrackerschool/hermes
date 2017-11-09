package com.hermes.userinterface;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleView {

    private final PrintStream ps;
    private final Scanner sc;

    public ConsoleView(InputStream in, PrintStream ps) {
        this.ps = ps;
        sc = new Scanner(in);
    }

    public String[] readLine() {
        String s = sc.nextLine();
        String[] splitted = s.split("\\s+");
        return splitted;
    }

    public String readWholeLine() {
        return sc.nextLine();
    }

    public String readLogin() {
        String regex = "[\\w\\-_]+";
        String s = sc.nextLine();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        if (matcher.matches()) {
            return s;
        } else {
            return null;
        }
    }

    public int readInt() {
        return sc.nextInt();
    }

    public double readDouble() {
        return sc.nextDouble();
    }

    public String readPassword() {
        String regex = "\\w{3,20}";
        String s = sc.nextLine();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        if (matcher.matches()) {
            return s;
        } else {
            return null;
        }
    }

    public void println(String s) {
        ps.println(s);
    }

    public void println() {
        ps.println();
    }

    public void printf(String format, String s) {
        ps.printf(format, s);
    }

    public void printf(String format, long s) {
        ps.printf(format, s);
    }

    public void print(String s) {
        ps.print(s);
    }
}
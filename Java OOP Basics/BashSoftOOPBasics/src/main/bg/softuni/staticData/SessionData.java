package main.bg.softuni.staticData;

import java.util.HashSet;

public class SessionData {
    public static String currentPath = System.getProperty("user.dir");
    public static HashSet<Thread> threadPool = new HashSet<>();
}


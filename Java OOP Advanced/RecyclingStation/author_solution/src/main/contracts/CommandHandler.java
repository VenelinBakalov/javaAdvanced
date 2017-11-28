package main.contracts;


import main.wasteDisposal.Contracts.GarbageProcessor;

import java.lang.reflect.InvocationTargetException;

public interface CommandHandler {

    GarbageProcessor getGarbageProcessor();

    BalanceManager getBalanceManager();

    String ProcessGarbage(String[] parameters) throws
            ClassNotFoundException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException;

    String ChangeManagementRequirement(String[] parameters) throws ClassNotFoundException;

    String Status();
}

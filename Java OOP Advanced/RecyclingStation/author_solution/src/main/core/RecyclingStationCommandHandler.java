package main.core;


import main.contracts.BalanceManager;
import main.contracts.CommandHandler;
import main.contracts.ManagementRequirement;
import main.models.RecyclingStationManagementRequirement;
import main.wasteDisposal.Contracts.GarbageDisposalStrategy;
import main.wasteDisposal.Contracts.GarbageProcessor;
import main.wasteDisposal.Contracts.ProcessingData;
import main.wasteDisposal.Contracts.Waste;
import main.wasteDisposal.DefaultGarbageProcessor;
import main.wasteDisposal.annotations.Disposable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class RecyclingStationCommandHandler implements CommandHandler {
    private GarbageProcessor garbageProcessor;
    private BalanceManager balanceManager;
    private Map<Class,Class> primitiveMapping;
    private HashSet<Class> addedStrategies;

    public RecyclingStationCommandHandler(BalanceManager balanceManager, GarbageProcessor garbageProcessor) {
        this.setBalanceManager(balanceManager);
        this.setGarbageProcessor(garbageProcessor);
        this.initializePrimitiveMapping();
        this.addedStrategies = new HashSet<>();
    }

    public RecyclingStationCommandHandler() {
        this(new RecyclingStationBalanceManager(), new DefaultGarbageProcessor());
    }

    @Override
    public BalanceManager getBalanceManager() {
        return balanceManager;
    }

    private void setBalanceManager(BalanceManager balanceManager) {
        this.balanceManager = balanceManager;
    }

    @Override
    public GarbageProcessor getGarbageProcessor() {
        return garbageProcessor;
    }

    private void setGarbageProcessor(GarbageProcessor garbageProcessor) {
        this.garbageProcessor = garbageProcessor;
    }

    @Override
    public String ProcessGarbage(String[] parameters)
            throws
            ClassNotFoundException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException {
        Waste garbage = this.instantiateWaste(parameters);

        if (this.getBalanceManager().checkWasteForProcessing(garbage)) {
            ProcessingData result = this.getGarbageProcessor().processWaste(garbage);
            this.getBalanceManager().applyProcessingResult(result);
            return String.format("%.2f kg of %s successfully processed!", garbage.getWeight(), garbage.getName());
        }

        return "Processing Denied!";
    }

    @Override
    public String ChangeManagementRequirement(String[] parameters) throws ClassNotFoundException{
        ManagementRequirement requirement = this.instantiateManagementRequirement(parameters);
        this.getBalanceManager().setManagementRequirement(requirement);
        return "Management requirement changed!";
    }

    @Override
    public String Status() {
        return String.format("Energy: %.2f Capital: %.2f", this.getBalanceManager().getEnergyBalance(),
                this.getBalanceManager().getCapitalBalance());
    }

    private Waste instantiateWaste(String[] parameters)
            throws ClassNotFoundException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException {
        String type = parameters[3];
        String garbageTypeName = type + "Garbage";
        String path = "main.models.waste.";
        Class garbageType = null;
        try {
            garbageType = Class.forName(path + garbageTypeName);
        } catch (ClassNotFoundException ex) {
            throw new IllegalArgumentException("Unsupported garbage type passed!");
        }

        this.ensureDisposalStrategy(type,garbageType);

        Constructor constructor = garbageType.getConstructors()[0];
        constructor.setAccessible(true);
        Class[] paramTypes = constructor.getParameterTypes();
        Object[] convertedParameters = new Object[paramTypes.length];
        for (int i = 0; i < convertedParameters.length; i++) {
            Class<?> parameterType = paramTypes[i].isPrimitive()? this.mapPrimitivesToObjects(paramTypes[i]) : paramTypes[i];
            Constructor paramTypeCtr = parameterType.getConstructor(String.class);
            paramTypeCtr.setAccessible(true);
            convertedParameters[i] = paramTypeCtr.newInstance(parameters[i]);
        }

        return (Waste) constructor.newInstance(convertedParameters);
    }

    private ManagementRequirement instantiateManagementRequirement(String[] parameters) throws ClassNotFoundException
    {
        String type = parameters[2];
        String garbageTypeName = type + "Garbage";
        Class garbageType = Class.forName("main.models.waste." + garbageTypeName);
        double minEnergyBalance = Double.parseDouble(parameters[0]);
        double minCapitalBalance = Double.parseDouble(parameters[1]);
        return new RecyclingStationManagementRequirement(minEnergyBalance, minCapitalBalance, garbageType);

    }

    private void ensureDisposalStrategy(String garbageTypeName, Class garbageType)
            throws ClassNotFoundException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException
    {
        if(this.addedStrategies.contains(garbageType)){
            return;
        }

        Class disposalAnnotationClass = null;
        try{
            disposalAnnotationClass =
                    Arrays.stream(garbageType.getAnnotations()).filter(x->x.annotationType().isAnnotationPresent(Disposable.class)).findFirst().get().annotationType();
        }catch (NoSuchElementException ex){
            throw new IllegalArgumentException("The provided garbage type does not implement the Disposable Attribute!");
        }

        if (!this.getGarbageProcessor().getStrategyHolder().getDisposalStrategies().containsKey(disposalAnnotationClass))
        {
            String strategyName = garbageTypeName + "Strategy";
            Class<?> disposalStrategy = Class.forName("main.models.strategies." + strategyName);
            Constructor disposalStratCtor = disposalStrategy.getConstructors()[0];
            GarbageDisposalStrategy strategy = (GarbageDisposalStrategy)disposalStratCtor.newInstance();
            this.getGarbageProcessor().getStrategyHolder().addStrategy(disposalAnnotationClass, strategy);
            this.addedStrategies.add(garbageType);
        }
    }

    private void initializePrimitiveMapping(){
        this.primitiveMapping = new LinkedHashMap<>();
        this.primitiveMapping.put(int.class,Integer.class);
        this.primitiveMapping.put(float.class,Float.class);
        this.primitiveMapping.put(double.class,Double.class);
        this.primitiveMapping.put(long.class,Long.class);
    }

    private Class mapPrimitivesToObjects(Class primitive){
        return this.primitiveMapping.get(primitive);
    }


}

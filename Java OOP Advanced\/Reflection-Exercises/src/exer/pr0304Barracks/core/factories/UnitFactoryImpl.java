package exer.pr0304Barracks.core.factories;

import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.regex.Pattern;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME = initializePath(System.getProperty("user.dir"));

    private static String initializePath(String path) {
        File file = new File(path);

        for (File file1 : file.listFiles()) {
            if (file1.isFile()) continue;
            if (file.isDirectory()) {
                if (file1.getName().equals("unit")) {
                    String separator = System.getProperty("file.separator");

                    return path.replaceAll(Pattern.quote(separator), "\\.");
                }
            }
        }
         return initializePath(file.getAbsolutePath());

//   if (file.isDirectory()) {
//       String fileName = file.getName();
//       if (fileName.equals("units")) {
//           String separator = System.getProperty("file.separator");

//           String directoryPath =
//                   file.getAbsolutePath().replaceAll(Pattern.quote(separator), "\\.");
//           int srcIndex = directoryPath.indexOf("src");
//           if (srcIndex != -1) {
//               return directoryPath.substring(srcIndex + 4);
//           }
//       } else {
//           for (File currentFile : file.listFiles()) {
//               return initializePath(currentFile.getAbsolutePath());
//           }
//       }
//   } else {

//   }

//   return null;

    }
    //"exer.pr0304Barracks.models.units.";

    @Override
    @SuppressWarnings("unchecked")
    public Unit createUnit(String unitType) {
        try {
            Class<? extends Unit> unitClass =
                    (Class<? extends Unit>) Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor<? extends Unit> unitConstructor = unitClass.getDeclaredConstructor();
            unitConstructor.setAccessible(true);
            return unitConstructor.newInstance();


        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}

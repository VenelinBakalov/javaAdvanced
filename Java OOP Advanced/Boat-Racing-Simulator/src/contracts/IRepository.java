package contracts;

import exeptions.DuplicateModelException;
import exeptions.NonExistantModelException;

public interface IRepository<T extends IModelable> {
    void Add(T item) throws DuplicateModelException;

    T GetItem(String model) throws NonExistantModelException;
}

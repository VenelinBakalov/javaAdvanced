package database;

import utility.Constants;
import contracts.Modelable;
import contracts.Repository;
import exeptions.DuplicateModelException;
import exeptions.NonExistantModelException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RepositoryImpl<T extends Modelable> implements Repository<T> {

    private Map<String, T> itemsByModel;

    public RepositoryImpl() {
        this.itemsByModel = new HashMap<>();
    }

    @Override
    public void add(T item) throws DuplicateModelException {
        if (this.itemsByModel.containsKey(item.getModelName())) {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }

        this.itemsByModel.put(item.getModelName(), item);
    }

    @Override
    public T getItem(String model) throws NonExistantModelException {
        if (!this.itemsByModel.containsKey(model)) {
            throw new NonExistantModelException(Constants.NON_EXISTENT_MODEL_MESSAGE);
        }

        return this.itemsByModel.get(model);
    }

    @Override
    public Collection<T> getAll() {
        return this.itemsByModel.values();
    }

}

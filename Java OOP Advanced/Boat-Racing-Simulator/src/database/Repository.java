package database;

import Utility.Constants;
import contracts.IModelable;
import contracts.IRepository;
import exeptions.DuplicateModelException;
import exeptions.NonExistantModelException;

import java.util.HashMap;

public class Repository<T extends IModelable> implements IRepository {
    private HashMap<String, T> itemsByModel;

    public Repository()
    {
        this.setItemsByModel(new HashMap<String, T>());
    }

    protected HashMap<String, T> getItemsByModel() {
        return this.itemsByModel;
    }

    protected void setItemsByModel(HashMap<String, T> itemsByModel) {
        this.itemsByModel = itemsByModel;
    }

    @Override
    public void Add(IModelable item) throws DuplicateModelException {
        if (this.itemsByModel.containsKey(item.getModel()))
        {
            throw new DuplicateModelException(Constants.DuplicateModelMessage);
        }

    }

    @Override
    public T GetItem(String model) throws NonExistantModelException {
        if (!this.itemsByModel.containsKey(model))
        {
            throw new NonExistantModelException(Constants.NonExistantModelMessage);
        }

        return this.itemsByModel.get(model);
    }

}

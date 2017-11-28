package commands;

import core.ManagementSystem;

/**
 * Created by Venelin on 18.4.2017 г..
 */
public abstract class BaseCommand implements Executable {

    private ManagementSystem managementSystem;

    protected BaseCommand(ManagementSystem managementSystem) {
        this.managementSystem = managementSystem;
    }

    protected ManagementSystem getManagementSystem() {
        return this.managementSystem;
    }
}

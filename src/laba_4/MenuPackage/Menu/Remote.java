package laba_4.MenuPackage.Menu;


import laba_4.MenuPackage.CommandsPackage.Command;

public class Remote {//створює команду і встановлює її одержувача за допомогою методу SetCommand ().
    // Потім переходить до виконання цієї команди за допомогою commandExecute()
    private Command slot;

    public void setCommand(Command command) {
        slot = command;
    }

    public void commandExecute() {
        slot.execute();
    }
}

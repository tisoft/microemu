package org.microemu.iphone.device.ui;

import org.microemu.device.ui.CommandUI;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Image;

public class IPhoneCommandUI implements CommandUI{
    private Command command;

    public IPhoneCommandUI(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }


    public void setImage(Image image) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

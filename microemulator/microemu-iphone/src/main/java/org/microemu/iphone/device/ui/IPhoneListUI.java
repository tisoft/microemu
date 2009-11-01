package org.microemu.iphone.device.ui;

import org.microemu.device.ui.ListUI;
import org.microemu.iphone.MicroEmulator;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;

public class IPhoneListUI extends AbstractDisplayableUI<List> implements ListUI{
    public IPhoneListUI(MicroEmulator microEmulator, List displayable) {
        super(microEmulator, displayable);
    }

    public int append(String stringPart, Image imagePart) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int getSelectedIndex() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String getString(int elementNum) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setSelectCommand(Command command) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setSelectedIndex(int elementNum, boolean selected) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void delete(int elementNum) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void deleteAll() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void hideNotify() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void showNotify() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void invalidate() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

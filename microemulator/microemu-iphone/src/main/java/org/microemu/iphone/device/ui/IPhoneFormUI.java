package org.microemu.iphone.device.ui;

import org.microemu.device.ui.FormUI;
import org.microemu.device.ui.ItemUI;
import org.microemu.iphone.MicroEmulator;

import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.ItemStateListener;

public class IPhoneFormUI extends AbstractDisplayableUI<Form> implements FormUI{
    public IPhoneFormUI(MicroEmulator microEmulator, Form displayable) {
        super(microEmulator, displayable);
    }

    public int append(ItemUI item) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void delete(int itemNum) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void deleteAll() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void insert(int itemNum, ItemUI item) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void set(int itemNum, ItemUI item) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void hideNotify() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void showNotify() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setItemStateListener(ItemStateListener itemStateListener) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void invalidate() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public ItemStateListener getItemStateListener() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

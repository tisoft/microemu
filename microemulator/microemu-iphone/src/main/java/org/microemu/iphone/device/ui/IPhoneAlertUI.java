package org.microemu.iphone.device.ui;

import org.microemu.device.ui.AlertUI;
import org.microemu.iphone.MicroEmulator;

import javax.microedition.lcdui.Alert;

public class IPhoneAlertUI extends AbstractDisplayableUI<Alert> implements AlertUI{


    public IPhoneAlertUI(MicroEmulator microEmulator, Alert displayable) {
        super(microEmulator, displayable);
    }

    public void setString(String str) {
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

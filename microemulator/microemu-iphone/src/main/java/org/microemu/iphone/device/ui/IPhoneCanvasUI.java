package org.microemu.iphone.device.ui;

import org.microemu.device.ui.CanvasUI;
import org.microemu.iphone.MicroEmulator;

import javax.microedition.lcdui.Canvas;

public class IPhoneCanvasUI extends AbstractDisplayableUI<Canvas> implements CanvasUI{
    public IPhoneCanvasUI(MicroEmulator microEmulator, Canvas displayable) {
        super(microEmulator, displayable);
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

package org.microemu.iphone.device.ui;

import org.microemu.device.ui.AlertUI;
import org.microemu.iphone.MicroEmulator;
import org.xmlvm.iphone.UIAlertView;
import org.xmlvm.iphone.UIAlertViewDelegate;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Command;

public class IPhoneAlertUI extends AbstractDisplayableUI<Alert> implements AlertUI{

    private UIAlertViewDelegate alertViewDelegate;
    private UIAlertView alertView;

    public IPhoneAlertUI(MicroEmulator microEmulator, Alert displayable) {
        super(microEmulator, displayable);

        alertViewDelegate=new UIAlertViewDelegate(){
            @Override
            public void clickedButtonAtIndex(UIAlertView alertView, int buttonIndex) {
                if(getCommandListener()!=null)
                    getCommandListener().commandAction((Command)getCommandsUI().get(buttonIndex), getDisplayable());
            }
        };
    }

    public void setString(String str) {
        if(alertView!=null)
            alertView.setMessage(str);
    }

    public void hideNotify() {
        if(alertView!=null){
            //alertView.(0, true);
            alertView=null;
        }
    }

    public void showNotify() {
        alertView=new UIAlertView(getDisplayable().getTitle(),getDisplayable().getString(),alertViewDelegate,((IPhoneCommandUI)getCommandsUI().firstElement()).getCommand().getLabel());
        alertView.show();
    }

    public void invalidate() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

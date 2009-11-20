package org.microemu.iphone.device.ui;

import org.microemu.device.ui.ImageStringItemUI;
import org.microemu.iphone.MicroEmulator;
import org.xmlvm.iphone.UIColor;
import org.xmlvm.iphone.UILabel;
import org.xmlvm.iphone.UITextView;
import org.xmlvm.iphone.UIView;

import javax.microedition.lcdui.*;

public class IPhoneImageStringItemUI extends AbstractItemUI<Item> implements ImageStringItemUI{
    private UILabel textView;

    private Introspect.StringComponent stringComponent=new Introspect.StringComponent(){
        @Override
        public void setText(String text) {
            super.setText(text);
            IPhoneImageStringItemUI.this.setText(text);
        }
    };

    public IPhoneImageStringItemUI(MicroEmulator microEmulator, Item item) {
        super(microEmulator, item);
    }

    public void setLabel(String label) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setText(String text) {
        System.out.println(item.getLabel()+": "+text);
        if(textView!=null)
            textView.setText(item.getLabel()+": "+text);
    }

    public void setImage(Image image) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public UIView getView() {
        if(textView==null) {
            textView = new UILabel();
            if(item instanceof StringItem){
                StringItem stringItem = (StringItem) item;
                String text=stringItem.getText();
                Introspect.setStringComponent(stringItem, stringComponent);
                stringItem.setText(text);
            }
        }

        return textView;
    }
}

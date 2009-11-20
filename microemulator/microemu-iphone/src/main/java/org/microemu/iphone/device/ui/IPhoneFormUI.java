package org.microemu.iphone.device.ui;

import org.microemu.device.ui.FormUI;
import org.microemu.device.ui.ItemUI;
import org.microemu.iphone.MicroEmulator;
import org.xmlvm.iphone.*;

import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Introspect;
import javax.microedition.lcdui.ItemStateListener;

public class IPhoneFormUI extends AbstractDisplayableUI<Form> implements FormUI{
    public IPhoneFormUI(MicroEmulator microEmulator, Form displayable) {
        super(microEmulator, displayable);
    }

    private UIView view;

    private UINavigationBar navigationBar;

    private UIView formView;

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
        System.out.println("showNotify");

        System.out.println(displayable.size());

        if (view==null) {
            view = new UIView(microEmulator.getWindow().getBounds());


            navigationBar = new UINavigationBar(new CGRect(0, 0,
                    microEmulator.getWindow().getBounds().size.width, NAVIGATION_HEIGHT));
            UINavigationItem title = new UINavigationItem(displayable.getTitle());
        //	title.setBackBarButtonItem();.setTitle("Back");
            navigationBar.pushNavigationItem(title, false);
            view.addSubview(navigationBar);

            formView = new UIView(
                    new CGRect(0, NAVIGATION_HEIGHT, microEmulator.getWindow().getBounds().size.width,
                            microEmulator.getWindow().getBounds().size.height - NAVIGATION_HEIGHT - TOOLBAR_HEIGHT));

            int y=0;
            for(int i=0;i<displayable.size();i++){
                ItemUI ui=Introspect.getUI(displayable.get(i));
                if (ui instanceof AbstractItemUI){
                    UIView itemView = ((AbstractItemUI) ui).getView();
                    itemView.setSize(microEmulator.getWindow().getBounds().size.width, 40);
                    itemView.setLocation(0, y);
                    formView.addSubview(itemView);
                    y+=itemView.getBounds().size.height;
                }
            }

            view.addSubview(formView);
            toolbar = new UIToolbar(new CGRect(0,
                    microEmulator.getWindow().getBounds().size.height - TOOLBAR_HEIGHT, microEmulator.getWindow().getBounds().size.width,
                    TOOLBAR_HEIGHT));
            view.addSubview(toolbar);
            updateToolbar();
        }
        
//		tableView.reloadData();

//		view.retain();
        microEmulator.getWindow().addSubview(view);
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

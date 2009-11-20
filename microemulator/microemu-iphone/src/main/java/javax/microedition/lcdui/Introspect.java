package javax.microedition.lcdui;

import org.microemu.device.ui.FormUI;
import org.microemu.device.ui.ItemUI;
import org.microemu.iphone.device.ui.IPhoneTextBoxUI;

public class Introspect {
    public static class StringComponent extends javax.microedition.lcdui.StringComponent{

     }

    public static void setStringComponent(StringItem stringItem, StringComponent stringComponent) {
        stringItem.stringComponent=stringComponent;
    }

    public static ChoiceGroup getChoiceGroup(List list) {
        return list.choiceGroup;
    }

    public static void setChoiceGroup(List list, ChoiceGroup cg) {
        list.choiceGroup = cg;
    }

    public static void setType(ChoiceGroup cg, int type){
        cg.choiceType=type;
    }

    public static int getType(ChoiceGroup cg){
        return cg.choiceType;
    }

    public static TextField getTextField(TextBox textBox) {
        return textBox.tf;
    }

    public static void setTextField(TextBox textBox, TextField textField) {
        textBox.tf=textField;
    }

    public static ItemUI getUI(Item item) {
        return item.ui;
    }
}

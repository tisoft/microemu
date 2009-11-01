/**
 *  MicroEmulator
 *  Copyright (C) 2008 Markus Heberling <markus@heberling.net>
 *
 *  It is licensed under the following two licenses as alternatives:
 *    1. GNU Lesser General Public License (the "LGPL") version 2.1 or any newer version
 *    2. Apache License (the "AL") Version 2.0
 *
 *  You may not use this file except in compliance with at least one of
 *  the above two licenses.
 *
 *  You may obtain a copy of the LGPL at
 *      http://www.gnu.org/licenses/old-licenses/lgpl-2.1.txt
 *
 *  You may obtain a copy of the AL at
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the LGPL or the AL for the specific language governing permissions and
 *  limitations.
 *
 *  @version $Id$
 */
package org.microemu.iphone.device.ui;

import java.lang.reflect.Field;

import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;


import org.microemu.device.ui.TextBoxUI;
import org.microemu.iphone.MicroEmulator;
import org.xmlvm.iphone.UITextView;

public class IPhoneTextBoxUI extends AbstractUI<TextBox> implements TextBoxUI {

    private final class TextBoxField extends TextField {
        public TextBoxField(TextField textField) {
            super(textField.getLabel(), textField.getString(), textField.getMaxSize(), textField.getConstraints());
        }

        @Override
        public void setString(String text) {
            super.setString(text);
            if (textView != null)
                textView.setText(text);
        }

        @Override
        public int getCaretPosition() {
            return 0;
        }

    }

    private TextBoxField textField;
    private UITextView textView;

    public IPhoneTextBoxUI(MicroEmulator microEmulator, TextBox textBox) {
        super(microEmulator);

//        try {
//            Field tf = TextBox.class.getDeclaredField("tf");
//            tf.setAccessible(true);
//            textField = new TextBoxField((TextField) tf.get(textBox));
//            tf.set(textBox, textField);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
    }

    public int getCaretPosition() {
        return textField.getCaretPosition();
    }

    public String getString() {
        return textField.getString();
    }

    public void setString(String text) {
        textField.setString(text);
    }

    public void hideNotify() {
        // TODO Auto-generated method stub

    }

    public void invalidate() {
        // TODO Auto-generated method stub

    }

    public void showNotify() {
        System.out.println("IPhoneTextBoxUI.showNotify()");
        if (textView == null) {
            textView = new UITextView(microEmulator.getWindow().getBounds());

            textView.setText("Test");
            microEmulator.getWindow().addSubview(textView);
        }
    }
}

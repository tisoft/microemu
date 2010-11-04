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

import org.microemu.device.ui.TextBoxUI;
import org.microemu.iphone.MicroEmulator;
import org.xmlvm.iphone.*;

import javax.microedition.lcdui.Introspect;
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;

public class IPhoneTextBoxUI extends AbstractDisplayableUI<TextBox> implements TextBoxUI {

    final class TextBoxField extends TextField {
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
    private UIView view;
    private UINavigationBar navigationBar;

    public IPhoneTextBoxUI(MicroEmulator microEmulator, TextBox textBox) {
        super(microEmulator, textBox);
        textField=new TextBoxField(Introspect.getTextField(textBox));
        Introspect.setTextField(textBox, textField);
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

    public void insert(String text, int position) {
        textField.insert(text, position);
    }

	public void delete(int offset, int length) {
		textField.delete(offset, length);
	}

	public void hideNotify() {
        // TODO Auto-generated method stub

    }

    public void invalidate() {
        // TODO Auto-generated method stub

    }

	public void showNotify() {
		System.out.println("IPhoneTextBoxUI.showNotify()");
		if (view == null) {
			view = new UIView(microEmulator.getWindow().getBounds());

			navigationBar = new UINavigationBar(new CGRect(0, 0,
					microEmulator.getWindow().getBounds().size.width, NAVIGATION_HEIGHT));
            UINavigationItem title = new UINavigationItem(getDisplayable().getTitle());
            title.setRightBarButtonItem(new UIBarButtonItem("Done", 0, new UIBarButtonItemDelegate() {
                public void clicked() {
                    //close keyboard
                    textView.resignFirstResponder();
                }
            }));
            navigationBar.pushNavigationItem(title, false);
            view.addSubview(navigationBar);

			textView = new UITextView(new CGRect(0, NAVIGATION_HEIGHT, microEmulator.getWindow().getBounds().size.width, microEmulator
					.getWindow().getBounds().size.height
					- NAVIGATION_HEIGHT - TOOLBAR_HEIGHT));




			textView.setText(textField.getString());
//			textView.setDelegate$(new NSObject(){
//				@SuppressWarnings("unused")
//				@Message(name="textViewDidChange:")
//				public void textViewDidChange$(UITextView textView) {
//				textField.setStringSilent(textView.text().toString());
//
//			}});
			view.addSubview(textView);

			toolbar = new UIToolbar(new CGRect(0,
					microEmulator.getWindow().getBounds().size.height - TOOLBAR_HEIGHT,
					microEmulator.getWindow().getBounds().size.width, TOOLBAR_HEIGHT));
			view.addSubview(toolbar);
			updateToolbar();
        }

		microEmulator.getWindow().addSubview(view);
    }
}

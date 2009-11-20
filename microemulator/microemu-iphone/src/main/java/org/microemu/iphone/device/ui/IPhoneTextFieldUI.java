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
import org.microemu.device.ui.TextFieldUI;
import org.microemu.iphone.MicroEmulator;
import org.xmlvm.iphone.UITextView;
import org.xmlvm.iphone.UIView;

import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;
import java.lang.reflect.Field;

public class IPhoneTextFieldUI extends AbstractItemUI<TextField> implements TextFieldUI {

    public IPhoneTextFieldUI(MicroEmulator microEmulator, TextField item) {
        super(microEmulator, item);
    }

    public void setLabel(String label) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setConstraints(int constraints) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setString(String text) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public String getString() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public UIView getView() {
        UITextView textView= new UITextView();

        textView.setText(item.getString());

        return textView;
    }
}
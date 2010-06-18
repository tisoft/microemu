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

import org.microemu.device.ui.CommandUI;
import org.microemu.device.ui.DisplayableUI;
import org.microemu.device.ui.ItemUI;
import org.microemu.iphone.MicroEmulator;
import org.xmlvm.iphone.UIBarButtonItem;
import org.xmlvm.iphone.UIBarButtonItemDelegate;
import org.xmlvm.iphone.UIToolbar;
import org.xmlvm.iphone.UIView;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Item;
import java.util.ArrayList;
import java.util.Vector;

public abstract class AbstractItemUI<T extends Item> implements ItemUI {
    final MicroEmulator microEmulator;

    final T item;

	AbstractItemUI(MicroEmulator microEmulator, T item) {
		super();
		this.microEmulator = microEmulator;
        this.item = item;
    }

    public T getItem() {
        return item;
    }


    public abstract UIView getView();

    public void setDefaultCommand(Command cmd) {
    }
}
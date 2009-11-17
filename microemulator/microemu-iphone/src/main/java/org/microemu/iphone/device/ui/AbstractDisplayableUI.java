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

import java.util.Vector;

import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;

import org.microemu.device.ui.CommandUI;
import org.microemu.device.ui.DisplayableUI;
import org.microemu.iphone.MicroEmulator;

public abstract class AbstractDisplayableUI<T extends Displayable> implements DisplayableUI {

    public static final int TOOLBAR_HEIGHT = 40;

    public static final int NAVIGATION_HEIGHT = 40;


	private final Vector<CommandUI> commands = new Vector<CommandUI>();

    final MicroEmulator microEmulator;

    final T displayable;

    private CommandListener commandListener;

	AbstractDisplayableUI(MicroEmulator microEmulator, T displayable) {
		super();
		this.microEmulator = microEmulator;
        this.displayable = displayable;
    }

    public T getDisplayable() {
        return displayable;
    }

    public void addCommandUI(CommandUI cmd) {
		commands.add(cmd);
//		ThreadDispatcher.dispatchOnMainThread(new Runnable() {
//			public void run() {
//				updateToolbar();
//			}
//		}, false);
	}

    public void removeCommandUI(CommandUI cmd) {
		commands.remove(cmd);
//		ThreadDispatcher.dispatchOnMainThread(new Runnable() {
//			public void run() {
//				updateToolbar();
//			}
//		}, false);
	}

    protected CommandListener getCommandListener() {
        return commandListener;
    }

    public void setCommandListener(CommandListener l) {
        this.commandListener=l;
    }

    public Vector getCommandsUI() {
		return commands;
	}
}

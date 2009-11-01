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
package org.microemu.iphone.device;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.microedition.lcdui.*;

import org.microemu.CustomItemAccess;
import org.microemu.device.Device;
import org.microemu.device.DeviceDisplay;
import org.microemu.device.FontManager;
import org.microemu.device.InputMethod;
import org.microemu.device.ui.*;
import org.microemu.iphone.MicroEmulator;
import org.microemu.iphone.device.ui.IPhoneTextBoxUI;
import org.microemu.iphone.device.ui.IPhoneTextFieldUI;

public class IPhoneDevice implements Device {
	private final UIFactory ui = new UIFactory() {

		public EventDispatcher createEventDispatcher(Display display) {
			final EventDispatcher eventDispatcher = new EventDispatcher() {

				@Override
				public void run() {
					//super.run();
				}

                @Override
                public void put(Runnable runnable) {
                    runnable.run();
                }

                @Override
                public void put(Event event) {
                    event.run();
                }

                @Override
				protected void post(Event event) {
					//ThreadDispatcher.dispatchOnMainThread(event, false);
                    event.run();
				}

			};

//			Thread thread = new Thread(eventDispatcher, EventDispatcher.EVENT_DISPATCHER_NAME);
//			thread.setDaemon(true);
//			thread.start();

			return eventDispatcher;
		}

		public AlertUI createAlertUI(Alert alert) {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
		}

		public CanvasUI createCanvasUI(Canvas canvas) {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
		}

		public FormUI createFormUI(Form form) {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
		}

		public ListUI createListUI(List list) {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
		}

		public TextBoxUI createTextBoxUI(TextBox textBox) {
			return new IPhoneTextBoxUI(microEmulator, textBox);
		}
		public CommandUI createCommandUI(Command command) {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
		}

        public ChoiceGroupUI createChoiceGroupUI(ChoiceGroup choiceGroup, int choiceType) {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        public CustomItemUI createCustomItemUI(CustomItemAccess customItemAccess) {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        public DateFieldUI createDateFieldUI(DateField dateField) {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        public GaugeUI createGaugeUI(Gauge gauge) {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        public ImageStringItemUI createImageStringItemUI(Item item) {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        public TextFieldUI createTextFieldUI(TextField textField) {
            return new IPhoneTextFieldUI();
        }
    };

	private final MicroEmulator microEmulator;

	private final Map systemProperties = new HashMap();

	private final Vector softButtons = new Vector();

	public IPhoneDevice(MicroEmulator microEmulator) {
		this.microEmulator = microEmulator;
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public Vector getButtons() {
		// TODO Auto-generated method stub
		return null;
	}

	public DeviceDisplay getDeviceDisplay() {
		return microEmulator.getDeviceDisplay();
	}

	public FontManager getFontManager() {
		return microEmulator.getFontManager();
	}

	public InputMethod getInputMethod() {
		return microEmulator.getInputMethod();
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Image getNormalImage() {
		// TODO Auto-generated method stub
		return null;
	}

	public Image getOverImage() {
		// TODO Auto-generated method stub
		return null;
	}

	public Image getPressedImage() {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector getSoftButtons() {
		return softButtons;
	}

	public Map getSystemProperties() {
		return systemProperties;
	}

	public UIFactory getUIFactory() {
		return ui;
	}

	public boolean hasPointerEvents() {
		return true;
	}

	public boolean hasPointerMotionEvents() {
		return true;
	}

	public boolean hasRepeatEvents() {
		// TODO Auto-generated method stub
		return false;
	}

	public void init() {
		// TODO Auto-generated method stub

	}

	public boolean vibrate(int duration) {
		// TODO Auto-generated method stub
		return false;
	}

}

/**
 *  MicroEmulator
 *  Copyright (C) 2008 Bartek Teodorczyk <barteo@barteo.net>
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
package org.microemu.iphone;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.microedition.midlet.MIDlet;

import org.microemu.MIDletBridge;
import org.microemu.MIDletContext;
import org.microemu.RecordStoreManager;
import org.microemu.app.CommonInterface;
import org.microemu.app.launcher.Launcher;
import org.microemu.device.Device;
import org.microemu.device.DeviceFactory;
import org.microemu.iphone.device.IPhoneDevice;
import org.microemu.iphone.device.IPhoneDeviceDisplay;
import org.microemu.iphone.device.IPhoneFontManager;
import org.microemu.iphone.device.IPhoneInputMethod;
import org.microemu.iphone.device.IPhoneRecordStoreManager;
import org.microemu.iphone.device.ui.AbstractDisplayableUI;
import org.xmlvm.iphone.*;


public class MicroEmulator {
    private final class IPhoneCommon implements CommonInterface, org.microemu.MicroEmulator {

        public IPhoneCommon(Device device) {
            DeviceFactory.setDevice(device);

            MIDletBridge.setMicroEmulator(this);
        }

        public MIDlet initMIDlet(boolean startMidlet) {
            try {
                MIDlet midlet = (MIDlet) Class.forName(new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("microemu.iphone.midlet"))).readLine()).newInstance();
                //set the classloader, so that resource loading works
                MIDletBridge.getMIDletAccess(midlet).startApp();
                return midlet;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

        public void destroyMIDletContext(MIDletContext midletContext) {
            // TODO Auto-generated method stub

        }

        public String getAppProperty(String key) {
            // TODO Auto-generated method stub
            return null;
        }

        public Launcher getLauncher() {
            return null;
        }

        public RecordStoreManager getRecordStoreManager() {
            // TODO Auto-generated method stub
            return new IPhoneRecordStoreManager();
        }


        public InputStream getResourceAsStream(Class origClass, String name) {
            return MIDletBridge.getCurrentMIDlet().getClass().getResourceAsStream(name);
        }

        public void notifyDestroyed(MIDletContext midletContext) {
            System.out.println("IPhoneCommon.notifyDestroyed()");
            initMIDlet(true);
        }

        public int checkPermission(String permission) {
            // TODO

            return 0;
        }

        public boolean platformRequest(String URL) {
            // TODO Auto-generated method stub
            return false;
        }


    }

    private final IPhoneInputMethod inputMethod = new IPhoneInputMethod();

    private IPhoneDeviceDisplay deviceDisplay;

    private final IPhoneFontManager fontManager = new IPhoneFontManager();

    private UIWindow window;

    void init(List<String> params) {
        final IPhoneCommon common = new IPhoneCommon(new IPhoneDevice(this));
        deviceDisplay = new IPhoneDeviceDisplay(common);
        deviceDisplay.displayRectangleWidth = (int) getWindow().getBounds().size.width;
        deviceDisplay.displayRectangleHeight = (int) getWindow().getBounds().size.height - AbstractDisplayableUI.TOOLBAR_HEIGHT;

        System.setProperty("microedition.platform", "microemulator-iphone");
        System.setProperty("microedition.locale", "en-us");

        Launcher.setSuiteName("MicroEmulator for iPhone");

        common.initMIDlet(true);

    }


    public UIWindow getWindow() {
        return window;
    }

    public IPhoneFontManager getFontManager() {
        return fontManager;
    }

    public IPhoneInputMethod getInputMethod() {
        return inputMethod;
    }

    public IPhoneDeviceDisplay getDeviceDisplay() {
        return deviceDisplay;
    }

    public void applicationDidFinishLaunching(Object app) {
        UIScreen screen = UIScreen.mainScreen();
        CGRect rect = screen.getApplicationFrame();
        System.out.println(rect.origin.x + " " + rect.origin.y + " " + rect.size.width + " " + rect.size.height);
        window = new UIWindow(rect);
        init(new ArrayList<String>());
        window.makeKeyAndVisible();

    }
}
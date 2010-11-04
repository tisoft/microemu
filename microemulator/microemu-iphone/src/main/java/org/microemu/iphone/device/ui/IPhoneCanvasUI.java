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

import org.microemu.MIDletAccess;
import org.microemu.MIDletBridge;
import org.microemu.device.ui.CanvasUI;
import org.microemu.iphone.MicroEmulator;
import org.microemu.iphone.device.IPhoneDisplayGraphics;
import org.microemu.iphone.device.IPhoneMutableImage;
import org.xmlvm.iphone.*;

import javax.microedition.lcdui.Canvas;

public class IPhoneCanvasUI extends AbstractDisplayableUI<Canvas> implements CanvasUI {

	enum Touch {
		BEGIN, END, DRAG
	}

	private final class CanvasView extends UIView {
		private final Canvas canvas;
		private UITextField keyboardHandler;
		private String oldText = "";
		private boolean keybordVisible=false;
		private IPhoneMutableImage offscreen;

		private CanvasView(CGRect bounds, Canvas canvas) {
            super(bounds);
			this.canvas = canvas;
			//setMultipleTouchEnabled(true);
			setUserInteractionEnabled(true);
			setClearsContextBeforeDrawing(false);
//			setClearsContext$(Static.NO);
			setBackgroundColor(UIColor.clearColor);

			offscreen=new IPhoneMutableImage(canvas.getWidth(), canvas.getHeight());
		}


		@Override
		public void drawRect(CGRect arg0) {
			System.out.println("drawRect: " + canvas + " " + this);
			MIDletAccess ma = MIDletBridge.getMIDletAccess();
			if (ma == null) {
				return;
			}
			CGContext context = UIGraphics.getCurrentContext();
            context.translate(0, canvas.getHeight());
            context.scale(1.0f, -1.0f);

			context.storeState();
			IPhoneDisplayGraphics g = new IPhoneDisplayGraphics(context, canvas.getWidth(), canvas.getHeight(), false);
            ma.getDisplayAccess().paint(g);
            g.flushRenderQueue();
			ma.getDisplayAccess().paint(offscreen.getGraphics());

//			CGRect rect=new CGRect(0, 0, offscreen.getWidth(), offscreen.getHeight());
//	        CGImage bitmap = offscreen.getBitmap();
//            context.drawImage(rect, bitmap);
//			CoreGraphics.CGImageRelease(bitmap);
//			g.drawString("XXX", 100, 100, 0);
			context.restoreState();
		}
	}

	private UIView canvasView;

	private UIView view;

	public IPhoneCanvasUI(MicroEmulator microEmulator, final Canvas canvas) {
		super(microEmulator, canvas);
	}

	public void hideNotify() {
		// TODO Auto-generated method stub

	}

	public void invalidate() {
		// TODO Auto-generated method stub

	}

	public void showNotify() {
		if (view == null) {
			canvasView = new CanvasView(microEmulator.getWindow().getBounds(), displayable);

			view = new UIView(microEmulator.getWindow().getBounds());
			// tableView = new UITableView().initWithFrame$style$(
			// new CGRect(0, 0, microEmulator.getWindow().bounds().size.width,
			// microEmulator.getWindow().bounds().size.height - 40), 0);
			view.addSubview(canvasView);
			toolbar = (UIToolbar) new UIToolbar(new CGRect(0,
					microEmulator.getWindow().getBounds().size.height - TOOLBAR_HEIGHT,
					microEmulator.getWindow().getBounds().size.width, TOOLBAR_HEIGHT));
			view.addSubview(toolbar);
			updateToolbar();
		}
		microEmulator.getWindow().addSubview(view);
	}

	public UIView getCanvasView() {
		return canvasView;
	}

}
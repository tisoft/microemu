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

import javax.microedition.lcdui.*;


import org.microemu.device.ui.ListUI;
import org.microemu.iphone.MicroEmulator;
import org.xmlvm.iphone.*;

public class IPhoneListUI extends AbstractDisplayableUI<List> implements ListUI{

	private final class ChoiceGroupDelegate extends ChoiceGroup {
		private int type;
		public ChoiceGroupDelegate(ChoiceGroup cg, int type) {
			super(cg.getLabel(), List.EXCLUSIVE);
			Introspect.setType(cg, type); 
			
			this.type=type;
			for(int i=0;i<cg.size();i++){
				this.append(cg.getString(i), cg.getImage(i));
			}
		}
		
		@Override
		public void delete(int itemNum) {
			super.delete(itemNum);
			doReload();
		}
		
		@Override
		public void deleteAll() {
			super.deleteAll();
			doReload();
		}
		
		@Override
		public void insert(int elementNum, String stringPart, Image imagePart) {
			super.insert(elementNum, stringPart, imagePart);
			doReload();
		}
		@Override
		public void set(int elementNum, String stringPart, Image imagePart) {
			super.set(elementNum, stringPart, imagePart);
			doReload();
		}
		
		@Override
		public void setSelectedIndex(int elementNum, boolean selected) {
			super.setSelectedIndex(elementNum, selected);
			doReload();
		}
		public int getType() {
			return type;
		}
		
		protected void doReload() {
			if(tableView!=null)
//				ThreadDispatcher.dispatchOnMainThread(new Runnable() {
//					public void run() {
						tableView.reloadData();
//					}
//				}, false);
		}
	}

	static final int UIViewAutoresizingFlexibleHeight =  1 << 4;

	static final int UIViewAutoresizingFlexibleWidth =  1 << 1;

	private UITableView tableView;

	private Command selectCommand=List.SELECT_COMMAND;
	
	private UIView view;

    private UINavigationBar navigationBar;

	private ChoiceGroupDelegate choiceGroup;

    private UITableViewDataSource dataSource=new UITableViewDataSource(){
        @Override
        public UITableViewCell cellForRowAtIndexPath(UITableView table, NSIndexPath idx) {
//       UITableViewCell cell = (UITableViewCell) table.dequeueReusableCellWithIdentifier$("reuse");
//        if (cell == null) {
                UITableViewCell cell = new UITableViewCell();
//            cell.setReuseIdentifier("reuse");
//        }
            cell.getTextLabel().setText(displayable.getString(idx.getRow()));
        if(choiceGroup.getType()==List.MULTIPLE&&displayable.isSelected(idx.getRow()))
            cell.setAccessoryType(3);
        else
            cell.setAccessoryType(0);
            return cell;
        }

        @Override
        public int numberOfRowsInSection(UITableView table, int section) {
            return displayable.size();
        }

    };


    private UITableViewDelegate delegate=new UITableViewDelegate(){
        @Override
        public float heightForRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
            return dataSource.cellForRowAtIndexPath(tableView, indexPath).getBounds().size.height;
        }


        @Override
        public void didSelectRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
            System.out.println(displayable.getString(indexPath.getRow()) + " selected");
            if(choiceGroup.getType()==List.MULTIPLE){
                displayable.setSelectedIndex(indexPath.getRow(), !displayable.isSelected(indexPath.getRow()));
            }else{
                displayable.setSelectedIndex(indexPath.getRow(),true);
            }
            System.out.println(indexPath.getRow());
            System.out.println(choiceGroup.getType());
    		if(getCommandListener()!=null&&selectCommand!=null&&choiceGroup.getType()==List.IMPLICIT)
    			getCommandListener().commandAction(selectCommand, displayable);
        }
    };
	
	public IPhoneListUI(MicroEmulator microEmulator, List list) {
		super(microEmulator, list);
	}


	public int append(String stringPart, Image imagePart) {
		// TODO Auto-generated method stub
		return 0;
	}


    public void setSelectedIndex(int elementNum, boolean selected) {
        displayable.setSelectedIndex(elementNum, selected);
    }

    public void delete(int elementNum) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void deleteAll() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

	public int getSelectedIndex() {
		return displayable.getSelectedIndex();
	}

	public String getString(int elementNum) {
		return displayable.getString(elementNum);
	}

	public void setSelectCommand(Command command) {
		System.out.println("setSelectCommand"+command);
		this.selectCommand=command;
	}

    public int size() {
        return displayable.size();
    }

    public void hideNotify() {
	}

	public void invalidate() {
		// TODO Auto-generated method stub

	}

	public void showNotify() {
		System.out.println("showNotify");

		if (view==null) {
			view = new UIView(microEmulator.getWindow().getBounds());

            ChoiceGroup cgO = Introspect.getChoiceGroup(displayable);
            choiceGroup=new ChoiceGroupDelegate(cgO,Introspect.getType(cgO));
            Introspect.setChoiceGroup(displayable, choiceGroup);
            

			navigationBar = new UINavigationBar(new CGRect(0, 0,
					microEmulator.getWindow().getBounds().size.width, NAVIGATION_HEIGHT));
			UINavigationItem title = new UINavigationItem(displayable.getTitle());
		//	title.setBackBarButtonItem();.setTitle("Back");
			navigationBar.pushNavigationItem(title, false);
			view.addSubview(navigationBar);
			
			tableView = new UITableView(
					new CGRect(0, NAVIGATION_HEIGHT, microEmulator.getWindow().getBounds().size.width,
							microEmulator.getWindow().getBounds().size.height - NAVIGATION_HEIGHT - TOOLBAR_HEIGHT), 0);

            tableView.setDataSource(dataSource);
            tableView.setDelegate(delegate);

			view.addSubview(tableView);
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
}


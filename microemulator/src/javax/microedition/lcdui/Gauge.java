/*
 * @(#)Gauge.java  30.08.2001
 *
 * Copyright (c) 2001 Bartek Teodorczyk <barteo@it.pl>. All Rights Reserved.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */

package javax.microedition.lcdui;


public class Gauge extends Item
{


  public Gauge(String label, boolean interactive, int maxValue, int initialValue)
  {
    super(label);
  }


  public void setValue(int value)
  {
  }


  public int getValue()
  {
    return -1;
  }


  public void setMaxValue(int maxValue)
  {
  }


  public int getMaxValue()
  {
    return -1;
  }


  public boolean isInteractive()
  {
    return false;
  }


  public void setLabel(String label)
  {
  }


  int paint(Graphics g)
  {
    return 0;
  }

}
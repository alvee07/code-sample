//: innerclasses/controller/Event.java
// The common methods for any control event.
// From 'Thinking in Java, 4th ed.' (c) Bruce Eckel 2005
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

/***********************************************************************
 * Adapated for COMP308 Java for Programmer, 
 *		SCIS, Athabasca University
 *
 * Assignment: TME3
 * @author: Steve Leung
 * @date  : Oct. 21, 2006
 *
 * Description: Event abstract class
 *
 */

package tme3;

import javax.crypto.KeyAgreement;
import java.io.*;
import java.lang.management.GarbageCollectorMXBean;

// added Serializable
public abstract class Event implements Runnable, Serializable {
  private long eventTime;
  protected long delayTime;

  public Event(long delayTime) {
    this.delayTime = delayTime;
    start();
  }
  public void start() { // Allows restarting
    eventTime = System.currentTimeMillis() + delayTime;
  }
  public boolean ready() {
    return System.currentTimeMillis() >= eventTime;
  }
  public abstract void action();

  public abstract long getDelayTime();

  @Override
  public void run() {

  }
} ///:~

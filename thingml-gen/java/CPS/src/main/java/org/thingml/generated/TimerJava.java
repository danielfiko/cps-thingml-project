/**
 * File generated by the ThingML IDE
 * /!\Do not edit this file/!\
 * In case of a bug in the generated code,
 * please submit an issue on our GitHub
 **/

package org.thingml.generated;

import no.sintef.jasm.*;
import no.sintef.jasm.ext.*;

import org.thingml.generated.api.*;
import org.thingml.generated.messages.*;

import java.util.*;

/**
 * Definition for type : TimerJava
 **/
public class TimerJava extends Component implements ITimerJava_timer {

private boolean debug = false;
public boolean isDebug() {return debug;}
public void setDebug(boolean debug) {this.debug = debug;}
public String toString() {
String result = "instance " + getName() + "\n";
result += "\ttimer = " + TimerJava_timer_var;
result += "\ttimer_task = " + TimerJava_timer_task_var;
result += "";
return result;
}

public synchronized void timer_start_via_timer(int TimerMsgs_timer_start_delay_var){
final Event _msg = timer_startType.instantiate(TimerMsgs_timer_start_delay_var);
_msg.setPort(timer_port);
receive(_msg);
}

public synchronized void timer_cancel_via_timer(){
final Event _msg = timer_cancelType.instantiate();
_msg.setPort(timer_port);
receive(_msg);
}

private void sendTimer_timeout_via_timer(){
timer_port.send(timer_timeoutType.instantiate());
}

//Attributes
private java.util.Timer TimerJava_timer_var;
private java.util.TimerTask TimerJava_timer_task_var;
//Ports
private Port timer_port;
//Message types
protected final Timer_startMessageType timer_startType = new Timer_startMessageType();
protected final Timer_cancelMessageType timer_cancelType = new Timer_cancelMessageType();
protected final Timer_timeoutMessageType timer_timeoutType = new Timer_timeoutMessageType();
//Empty Constructor
public TimerJava() {
super();
}

//Getters and Setters for non readonly/final attributes
public java.util.Timer getTimerJava_timer_var() {
return TimerJava_timer_var;
}

public void setTimerJava_timer_var(java.util.Timer TimerJava_timer_var) {
this.TimerJava_timer_var = TimerJava_timer_var;
}

public TimerJava initTimerJava_timer_var(java.util.Timer TimerJava_timer_var) {
this.TimerJava_timer_var = TimerJava_timer_var;
return this;
}

public java.util.TimerTask getTimerJava_timer_task_var() {
return TimerJava_timer_task_var;
}

public void setTimerJava_timer_task_var(java.util.TimerTask TimerJava_timer_task_var) {
this.TimerJava_timer_task_var = TimerJava_timer_task_var;
}

public TimerJava initTimerJava_timer_task_var(java.util.TimerTask TimerJava_timer_task_var) {
this.TimerJava_timer_task_var = TimerJava_timer_task_var;
return this;
}

//Getters for Ports
public Port getTimer_port() {
return timer_port;
}
private CompositeState buildTimerJava_SoftTimer(){
final AtomicState state_TimerJava_SoftTimer_default = new AtomicState("default");
Handler h552606102 = new Handler();
h552606102.from(state_TimerJava_SoftTimer_default);
h552606102.event(timer_startType);
h552606102.guard((Event e)->{
final Timer_startMessageType.Timer_startMessage timer_start = (Timer_startMessageType.Timer_startMessage) e;
return timer_start.delay > 0;
});

h552606102.port(timer_port);
h552606102.action((Event e)->{
final Timer_startMessageType.Timer_startMessage timer_start = (Timer_startMessageType.Timer_startMessage) e;
startTimer((int) (timer_start.delay));
});

Handler cancel = new Handler();
cancel.from(state_TimerJava_SoftTimer_default);
cancel.event(timer_cancelType);
cancel.port(timer_port);
cancel.action((Event e)->{
cancel();
});

final CompositeState state_TimerJava_SoftTimer = new CompositeState("SoftTimer");
state_TimerJava_SoftTimer.onEntry(()->{
});
state_TimerJava_SoftTimer.add(state_TimerJava_SoftTimer_default);
state_TimerJava_SoftTimer.initial(state_TimerJava_SoftTimer_default);
return state_TimerJava_SoftTimer;
}

public Component buildBehavior(String session, Component root) {
if (root == null) {
//Init ports
timer_port = new Port("timer", this);
} else {
timer_port = ((TimerJava)root).timer_port;
}
if (session == null){
//Init state machine
behavior = buildTimerJava_SoftTimer();
}
return this;
}

 void startTimer(final int TimerJava_startTimer_delay_var) {
TimerJava_timer_var = (java.util.Timer) (new java.util.Timer());
java.util.TimerTask temp_task = new java.util.TimerTask(){public void run(){
sendTimer_timeout_via_timer();
}};
TimerJava_timer_task_var = (java.util.TimerTask) (temp_task);
getTimerJava_timer_var().schedule(getTimerJava_timer_task_var(), TimerJava_startTimer_delay_var);
}
 void cancel() {
if( !((getTimerJava_timer_task_var() == null))) {
getTimerJava_timer_task_var().cancel();
getTimerJava_timer_var().purge();

}
}
}

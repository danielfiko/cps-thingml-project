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
 * Definition for type : TraceOnly
 **/
public class TraceOnly extends Component implements ITraceOnly_trace_lum_motion {

private boolean debug = false;
public boolean isDebug() {return debug;}
public void setDebug(boolean debug) {this.debug = debug;}
public String toString() {
String result = "instance " + getName() + "\n";
result += "";
return result;
}

public synchronized void luminance_via_trace_lum_motion(int LuminanceMsg_luminance_id_var, double LuminanceMsg_luminance_lum_var){
final Event _msg = luminanceType.instantiate(LuminanceMsg_luminance_id_var, LuminanceMsg_luminance_lum_var);
_msg.setPort(trace_lum_motion_port);
receive(_msg);
}

public synchronized void motion_via_trace_lum_motion(int MotionMsg_motion_id_var){
final Event _msg = motionType.instantiate(MotionMsg_motion_id_var);
_msg.setPort(trace_lum_motion_port);
receive(_msg);
}

public synchronized void nomotion_via_trace_lum_motion(int MotionMsg_nomotion_id_var){
final Event _msg = nomotionType.instantiate(MotionMsg_nomotion_id_var);
_msg.setPort(trace_lum_motion_port);
receive(_msg);
}

private void sendAdd_lightsensor_via_build(int LuminanceMsg_add_lightsensor_id_var){
build_port.send(add_lightsensorType.instantiate(LuminanceMsg_add_lightsensor_id_var));
}

private void sendAdd_motionsensor_via_build(int MotionMsg_add_motionsensor_id_var){
build_port.send(add_motionsensorType.instantiate(MotionMsg_add_motionsensor_id_var));
}

//Attributes
//Ports
private Port build_port;
private Port trace_lum_motion_port;
//Message types
protected final LuminanceMessageType luminanceType = new LuminanceMessageType();
protected final Add_lightsensorMessageType add_lightsensorType = new Add_lightsensorMessageType();
protected final Set_luminanceMessageType set_luminanceType = new Set_luminanceMessageType();
protected final MotionMessageType motionType = new MotionMessageType();
protected final NomotionMessageType nomotionType = new NomotionMessageType();
protected final Add_motionsensorMessageType add_motionsensorType = new Add_motionsensorMessageType();
//Empty Constructor
public TraceOnly() {
super();
}

//Getters and Setters for non readonly/final attributes
//Getters for Ports
public Port getBuild_port() {
return build_port;
}
public Port getTrace_lum_motion_port() {
return trace_lum_motion_port;
}
public Component buildBehavior(String session, Component root) {
if (root == null) {
//Init ports
build_port = new Port("build", this);
trace_lum_motion_port = new Port("trace_lum_motion", this);
} else {
build_port = ((TraceOnly)root).build_port;
trace_lum_motion_port = ((TraceOnly)root).trace_lum_motion_port;
}
if (session == null){
//Init state machine
}
return this;
}

}

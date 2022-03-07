/**
 * File generated by the ThingML IDE
 * /!\Do not edit this file/!\
 * In case of a bug in the generated code,
 * please submit an issue on our GitHub
 **/

package org.thingml.generated.messages;

import no.sintef.jasm.*;
import no.sintef.jasm.ext.*;

import java.util.*;
import java.nio.*;

public class ResetTotalPowerMessageType extends EventType {
public ResetTotalPowerMessageType(short code) {super("ResetTotalPower", code);
}

public ResetTotalPowerMessageType() {
super("ResetTotalPower", (short) 0);
}

public Event instantiate(final int did) { return new ResetTotalPowerMessage(this, did); }
public Event instantiate(Map<String, Object> params) {return instantiate((Integer) params.get("did"));
}

public class ResetTotalPowerMessage extends Event implements java.io.Serializable {

public final int did;
public String toString(){
return "ResetTotalPower (" + "did: " + did + ")";
}

protected ResetTotalPowerMessage(EventType type, final int did) {
super(type);
this.did = did;
}
public Event clone() {
return instantiate(this.did);
}}

}


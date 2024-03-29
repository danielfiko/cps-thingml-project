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

public class Add_motion_sensorMessageType extends EventType {
public Add_motion_sensorMessageType(short code) {super("add_motion_sensor", code);
}

public Add_motion_sensorMessageType() {
super("add_motion_sensor", (short) 0);
}

public Event instantiate(final int did) { return new Add_motion_sensorMessage(this, did); }
public Event instantiate(Map<String, Object> params) {return instantiate((Integer) params.get("did"));
}

public class Add_motion_sensorMessage extends Event implements java.io.Serializable {

public final int did;
public String toString(){
return "add_motion_sensor (" + "did: " + did + ")";
}

protected Add_motion_sensorMessage(EventType type, final int did) {
super(type);
this.did = did;
}
public Event clone() {
return instantiate(this.did);
}}

}


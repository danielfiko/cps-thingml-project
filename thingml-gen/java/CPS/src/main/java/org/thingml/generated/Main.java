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
import org.thingml.generated.gui.*;
import org.thingml.generated.network.*;
public class Main {
//Things
public static TimerJava TimerJava_g_humn;
public static TraceOnlyMock TraceOnly_trace;
public static PIM PIM_pim;
public static TimerJava TimerJava_g_switch;
public static TimerJava TimerJava_g_temp;
public static MQTTDriver MQTTDriver_T1;
public static HumanMock Human_myself;
public static void main(String args[]) {
//Things
TimerJava_g_humn = (TimerJava) new TimerJava();
TimerJava_g_humn.buildBehavior(null, null);
TimerJava_g_humn.init();
TraceOnly_trace = (TraceOnlyMock) new TraceOnlyMock("TraceOnly_trace").buildBehavior(null, null);
PIM_pim = (PIM) new PIM();
PIM_pim.buildBehavior(null, null);
PIM_pim.init();
TimerJava_g_switch = (TimerJava) new TimerJava();
TimerJava_g_switch.buildBehavior(null, null);
TimerJava_g_switch.init();
TimerJava_g_temp = (TimerJava) new TimerJava();
TimerJava_g_temp.buildBehavior(null, null);
TimerJava_g_temp.init();
MQTTDriver_T1 = (MQTTDriver) new MQTTDriver();
MQTTDriver_T1.buildBehavior(null, null);
MQTTDriver_T1.init();
Human_myself = (HumanMock) new HumanMock("Human_myself").buildBehavior(null, null);
//Connecting internal ports...
//Connectors
PIM_pim.getRequest_sensor_port().addListener(MQTTDriver_T1.getRequire_val_port());
TraceOnly_trace.getBuild_port().addListener(MQTTDriver_T1.getRequire_val_port());
TimerJava_g_temp.getTimer_port().addListener(PIM_pim.getGuard_temperature_port());
PIM_pim.getGuard_temperature_port().addListener(TimerJava_g_temp.getTimer_port());
TimerJava_g_switch.getTimer_port().addListener(PIM_pim.getGuard_switch_port());
PIM_pim.getGuard_switch_port().addListener(TimerJava_g_switch.getTimer_port());
PIM_pim.getRequest_actuator_port().addListener(MQTTDriver_T1.getRequire_val_port());
TimerJava_g_humn.getTimer_port().addListener(PIM_pim.getGuard_human_port());
PIM_pim.getGuard_human_port().addListener(TimerJava_g_humn.getTimer_port());
MQTTDriver_T1.getProvide_temp_port().addListener(PIM_pim.getGet_sensor_port());
Human_myself.getSend_cmd_port().addListener(PIM_pim.getHuman_input_port());
PIM_pim.getHuman_output_port().addListener(Human_myself.getGet_values_port());
MQTTDriver_T1.getProvide_lum_motion_port().addListener(TraceOnly_trace.getTrace_lum_motion_port());
TimerJava_g_humn.initTimerJava_timer_var((java.util.Timer)null);
TimerJava_g_humn.initTimerJava_timer_task_var((java.util.TimerTask)null);
PIM_pim.initPIM_tmrature_var((double) (20));
PIM_pim.initPIM_thermo_id_var((int)0);
PIM_pim.initPIM_switch_id_var((int)0);
PIM_pim.initPIM_increasing_var((boolean)false);
PIM_pim.initPIM_not_sent_req_var((boolean) (false));
PIM_pim.initPIM_lasttemp_var((double) (0));
PIM_pim.initPIM_energy_saving_temp_var((double)0.0d);
PIM_pim.initPIM_comfort_temp_var((double)0.0d);
TimerJava_g_switch.initTimerJava_timer_var((java.util.Timer)null);
TimerJava_g_switch.initTimerJava_timer_task_var((java.util.TimerTask)null);
TimerJava_g_temp.initTimerJava_timer_var((java.util.Timer)null);
TimerJava_g_temp.initTimerJava_timer_task_var((java.util.TimerTask)null);
final String[] T1_thermotext_array = new String[25];
final double[] T1_thermoval_array = new double[25];
final int[] T1_lightsensors_array = new int[25];
final int[] T1_thermometers_array = new int[25];
final int[] T1_onoffswitches_array = new int[25];
final double[] T1_lightval_array = new double[25];
final int[] T1_motionsensors_array = new int[25];
MQTTDriver_T1.initMQTTDriver_last_mo_var((int) (0));
MQTTDriver_T1.initMQTTDriver_last_light_var((int) (0));
MQTTDriver_T1.initMQTTDriver_last_thermo_var((int) (0));
MQTTDriver_T1.initMQTTDriver_foundL_var((boolean)false);
MQTTDriver_T1.initMQTTDriver_i_var((int)0);
MQTTDriver_T1.initMQTTDriver_id_s_var((int)0);
MQTTDriver_T1.initMQTTDriver_found_var((boolean)false);
MQTTDriver_T1.initMQTTDriver_last_onoff_var((int) (0));
MQTTDriver_T1.initMQTTDriver_did_var((int)0);
MQTTDriver_T1.initMQTTDriver_thermotext_var(T1_thermotext_array);
MQTTDriver_T1.initMQTTDriver_thermoval_var(T1_thermoval_array);
MQTTDriver_T1.initMQTTDriver_lightsensors_var(T1_lightsensors_array);
MQTTDriver_T1.initMQTTDriver_thermometers_var(T1_thermometers_array);
MQTTDriver_T1.initMQTTDriver_onoffswitches_var(T1_onoffswitches_array);
MQTTDriver_T1.initMQTTDriver_lightval_var(T1_lightval_array);
MQTTDriver_T1.initMQTTDriver_motionsensors_var(T1_motionsensors_array);
//Network components for external connectors
/*$NETWORK$*/
MQTTJava null_MQTT = (MQTTJava) new MQTTJava("tcp://localhost:1883", "CPS2021/SwitchControl", "CPS2021/tempoutput").buildBehavior(null, null);

//External Connectors
/*$EXT CONNECTORS$*/
null_MQTT.getMQTT_port().addListener(MQTTDriver_T1.getMQTT_port());
MQTTDriver_T1.getMQTT_port().addListener(null_MQTT.getMQTT_port());

/*$START$*/
null_MQTT.init().start();

TimerJava_g_humn.start();
TimerJava_g_temp.start();
TimerJava_g_switch.start();
Human_myself.start();
PIM_pim.start();
MQTTDriver_T1.start();
TraceOnly_trace.start();
//Hook to stop instances following client/server dependencies (clients firsts)
Runtime.getRuntime().addShutdownHook(new Thread() {
public void run() {
TraceOnly_trace.stop();
MQTTDriver_T1.stop();
PIM_pim.stop();
Human_myself.stop();
TimerJava_g_switch.stop();
TimerJava_g_temp.stop();
TimerJava_g_humn.stop();
/*$STOP$*/
null_MQTT.stop();

}
});

}
}
package org.thingml.generated.api;

import org.thingml.generated.api.*;

public interface IPIM_human_outputClient{
void temperature_from_human_output(int TemperatureMsg_temperature_id_var, String TemperatureMsg_temperature_txt_var, double TemperatureMsg_temperature_t_var);
void prompt_from_human_output(String GeneralMsg_prompt_txt_var);
void SwitchStateOn_from_human_output(int OnOffMsg_SwitchStateOn_did_var);
void SwitchStateOff_from_human_output(int OnOffMsg_SwitchStateOff_did_var);
}
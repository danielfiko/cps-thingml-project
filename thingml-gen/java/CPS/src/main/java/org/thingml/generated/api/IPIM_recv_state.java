package org.thingml.generated.api;

import org.thingml.generated.api.*;

public interface IPIM_recv_state{
void SwitchStateOn_via_recv_state(int OnOffMsg_SwitchStateOn_did_var);
void SwitchStateOff_via_recv_state(int OnOffMsg_SwitchStateOff_did_var);
void CurrentPower_via_recv_state(int OnOffMsg_CurrentPower_power_var);
void TotalPower_via_recv_state(double OnOffMsg_TotalPower_power_var);
void SwitchChangeOk_via_recv_state(int OnOffMsg_SwitchChangeOk_did_var);
void SwitchChangeFail_via_recv_state(int OnOffMsg_SwitchChangeFail_did_var);
}
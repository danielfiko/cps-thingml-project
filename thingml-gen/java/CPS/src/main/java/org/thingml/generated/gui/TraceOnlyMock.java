/**
 * File generated by the ThingML IDE
 * /!\\Do not edit this file/!\\
 * In case of a bug in the generated code,
 * please submit an issue on our GitHub
 */

package org.thingml.generated.gui;

import org.thingml.generated.api.*;
import org.thingml.generated.messages.*;
import no.sintef.jasm.*;
import no.sintef.jasm.ext.*;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;

import java.util.*;
public class TraceOnlyMock extends Component implements ActionListener, ItemListener, ITraceOnly_trace_lum_motion{

private boolean debug = false;
public boolean isDebug() {return debug;}
public void setDebug(boolean debug) {this.debug = debug;}
public String instanceName;public void printDebug(String trace) {
if(this.isDebug()) {
System.out.println(this.instanceName + trace);
}
}

//Message types
private final LuminanceMessageType luminanceType = new LuminanceMessageType();
private final Add_lightsensorMessageType add_lightsensorType = new Add_lightsensorMessageType();
private final Set_luminanceMessageType set_luminanceType = new Set_luminanceMessageType();
private final MotionMessageType motionType = new MotionMessageType();
private final NomotionMessageType nomotionType = new NomotionMessageType();
private final Add_motionsensorMessageType add_motionsensorType = new Add_motionsensorMessageType();
final Port port_TraceOnly_build;
public Port getBuild_port(){return port_TraceOnly_build;}
final Port port_TraceOnly_trace_lum_motion;
public Port getTrace_lum_motion_port(){return port_TraceOnly_trace_lum_motion;}
public java.util.List<ITraceOnly_buildClient> build_listeners = new java.util.LinkedList<ITraceOnly_buildClient>();
private SimpleDateFormat dateFormat=new SimpleDateFormat("dd MMM yyy 'at' HH:mm:ss.SSS");

private JTabbedPane tabbedPane=new JTabbedPane();
private JFrame frame;

        //Attributes related to add_lightsensor via build
public JButton sendadd_lightsensor_via_build;
private JTextField fieldadd_lightsensor_via_build_Id;
public JTextField getFieldadd_lightsensor_via_build_Id() {
return fieldadd_lightsensor_via_build_Id;
}

public JButton getSendadd_lightsensor_via_build() {
return sendadd_lightsensor_via_build;
}

//Attributes related to add_motionsensor via build
public JButton sendadd_motionsensor_via_build;
private JTextField fieldadd_motionsensor_via_build_Id;
public JTextField getFieldadd_motionsensor_via_build_Id() {
return fieldadd_motionsensor_via_build_Id;
}

public JButton getSendadd_motionsensor_via_build() {
return sendadd_motionsensor_via_build;
}

public void disableAll() {
sendadd_lightsensor_via_build.setEnabled(false);
sendadd_motionsensor_via_build.setEnabled(false);
}

public void enableAll() {
sendadd_lightsensor_via_build.setEnabled(true);
sendadd_motionsensor_via_build.setEnabled(true);
}



private JTextPane screen;
private JButton clearButton;
private JButton cliButton;
private StyledDocument doc;
private final Color alertColor=new Color(255,64,32);
private boolean colorOutput=false;
private JCheckBox showColor;
private JTextField cli;
private JList<Command>commands;

private synchronized boolean isColorOutput(){
        return colorOutput;
        }

private synchronized void setColorOutput(boolean value){
        this.colorOutput=value;
        }

public TraceOnlyMock(String name){
        super(name);
        init();
        port_TraceOnly_build = new Port("build", this);
port_TraceOnly_trace_lum_motion = new Port("trace_lum_motion", this);

        initGUI(name);
        }

@Override
public void stop(){
        super.stop();
        frame.setVisible(false);
        }

@Override
public void start(){
        super.start();
        frame.setVisible(true);
        }

@Override
public Component buildBehavior(String session,Component root){
        behavior = new CompositeState("TraceOnly", true){
        	@Override
        	public void handle(final Event event, final Status status){
        		final Port p = event.getPort();
        		if(p!=null){
        			print(event.getType().getName() + "_via_" + p.getName(),dateFormat.format(new Date())+": " + p.getName() + "?"+event.toString());
        		}
        	}
        };
        return this;
}

        public JPanel createadd_lightsensor_via_buildPanel(){
GridBagConstraints c = new GridBagConstraints();
c.fill = GridBagConstraints.HORIZONTAL;
c.weightx = 0.5;
JPanel panel = new JPanel(new GridBagLayout());
JLabel labelid = new JLabel();
labelid.setText("id");
c.gridx = 0;
c.gridy = 0;
panel.add(labelid, c);
fieldadd_lightsensor_via_build_Id = new JTextField();
fieldadd_lightsensor_via_build_Id.setText("int");
c.gridx = 1;
c.gridy = 0
;panel.add(fieldadd_lightsensor_via_build_Id, c);
return panel;
}

public JPanel createadd_motionsensor_via_buildPanel(){
GridBagConstraints c = new GridBagConstraints();
c.fill = GridBagConstraints.HORIZONTAL;
c.weightx = 0.5;
JPanel panel = new JPanel(new GridBagLayout());
JLabel labelid = new JLabel();
labelid.setText("id");
c.gridx = 0;
c.gridy = 0;
panel.add(labelid, c);
fieldadd_motionsensor_via_build_Id = new JTextField();
fieldadd_motionsensor_via_build_Id.setText("int");
c.gridx = 1;
c.gridy = 0
;panel.add(fieldadd_motionsensor_via_build_Id, c);
return panel;
}



public void print(String id,String data){
        try{
        if(isColorOutput())
        doc.insertString(doc.getLength(),formatForPrint(data),doc.getStyle(id));
        else
        doc.insertString(doc.getLength(),formatForPrint(data),null);
        screen.setCaretPosition(doc.getLength());
        }catch(BadLocationException ex){
        ex.printStackTrace();
        }
        }

        public void addListener(ActionListener l){
sendadd_lightsensor_via_build.addActionListener(l);
sendadd_motionsensor_via_build.addActionListener(l);
}



private void initGUI(String name){

        GridBagConstraints c=new GridBagConstraints();
        c.gridwidth=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.insets=new Insets(0,3,0,3);
        c.weightx=0.5;
        c.weighty=0;


        c.gridy=0;
        c.gridx=0;
        frame=new JFrame(name);
        frame.setLayout(new GridBagLayout());
        frame.add(tabbedPane,c);

        JPanel frame_build = new JPanel();
frame_build.setLayout(new GridBagLayout());
//GUI related to build_via_build => add_lightsensor
c.gridy = 0;
c.gridx = 0;
frame_build.add(createLabel("add_lightsensor"), c);
c.gridy = 1;
c.gridx = 0;
frame_build.add(createadd_lightsensor_via_buildPanel(), c);
c.gridy = 2;
c.gridx = 0;
c.weighty = 0;
sendadd_lightsensor_via_build = createSendButton("build => add_lightsensor");
frame_build.add(sendadd_lightsensor_via_build, c);
tabbedPane.addTab("build", frame_build);
//GUI related to build_via_build => add_motionsensor
c.gridy = 0;
c.gridx = 1;
frame_build.add(createLabel("add_motionsensor"), c);
c.gridy = 1;
c.gridx = 1;
frame_build.add(createadd_motionsensor_via_buildPanel(), c);
c.gridy = 2;
c.gridx = 1;
c.weighty = 0;
sendadd_motionsensor_via_build = createSendButton("build => add_motionsensor");
frame_build.add(sendadd_motionsensor_via_build, c);
tabbedPane.addTab("build", frame_build);


        c.gridy=1;
        c.gridx=0;
        c.gridwidth=1;
        c.fill=GridBagConstraints.BOTH;

        c.weighty=0;
        JPanel cliPanel=new JPanel();
        cliPanel.setLayout(new FlowLayout());
        JLabel cliLabel=new JLabel("Command line: ");
        cli=new JTextField("port!message(param1, param2, param3)");
        cliButton=new JButton("Send");
        cliPanel.add(cliLabel);
        cliPanel.add(cli);
        cliPanel.add(cliButton);
        frame.add(cliPanel,c);
        cliButton.addActionListener(this);

        c.gridx=0;
        c.gridy=2;
        c.weighty=1;
        frame.add(createJTextPane(),c);


        c.gridy=2;
        c.weighty=0;
        clearButton=new JButton("Clear Console");
        frame.add(clearButton,c);

        c.gridy=3;
        c.gridx=0;
        showColor=new JCheckBox("Colored logs");
        showColor.addItemListener(this);
        frame.add(showColor,c);

        commands=new JList<Command>();
        commands.setModel(new DefaultListModel<Command>());
        commands.setVisible(true);
        commands.setLayout(new GridBagLayout());
        c.gridx=1;
        c.gridy=0;
        c.weighty=1;
        c.gridheight=4;
        c.fill=GridBagConstraints.BOTH;
        frame.add(new JScrollPane(commands),c);


        frame.setMinimumSize(new Dimension(480,480));
        frame.pack();
        clearButton.addActionListener(this);
        addListener(this);
        frame.setVisible(true);
        }

public static JLabel createLabel(String name){
        return new JLabel(name);
        }

public static JButton createSendButton(String name){
        return new JButton("send");
        }

public JScrollPane createJTextPane(){
        screen=new JTextPane();
        screen.setFocusable(false);
        screen.setEditable(false);
        screen.setAutoscrolls(true);

        JScrollPane editorScrollPane=new JScrollPane(screen);
        editorScrollPane.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //editorScrollPane.setPreferredSize(new Dimension(480,240));
        //editorScrollPane.setMinimumSize(new Dimension(320,160));

        doc=screen.getStyledDocument();
        //Style def = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);\n"

        Style receiveluminance_via_trace_lum_motionStyle = doc.addStyle("luminance_via_trace_lum_motion", null);
StyleConstants.setBackground(receiveluminance_via_trace_lum_motionStyle, new Color(221, 215, 133));
Style receivemotion_via_trace_lum_motionStyle = doc.addStyle("motion_via_trace_lum_motion", null);
StyleConstants.setBackground(receivemotion_via_trace_lum_motionStyle, new Color(187, 215, 147));
Style receivenomotion_via_trace_lum_motionStyle = doc.addStyle("nomotion_via_trace_lum_motion", null);
StyleConstants.setBackground(receivenomotion_via_trace_lum_motionStyle, new Color(212, 215, 252));


        return editorScrollPane;
        }

private String formatForPrint(String text){
        return(text.endsWith("\n")?text:text+"\n");
        }

private void parseAndExecute(String command){
        String[]params=command.split("!");
        if(params.length!=2){
        cliButton.setForeground(alertColor);
        cli.setText("port!message(param1, param2, param3)");
        return;
        }

        if(params[0].equals("build")) {
if (params[1].startsWith("add_lightsensor")) {
params[1] = params[1].substring("add_lightsensor".length(), params[1].length());
if (!(params[1].startsWith("(") && params[1].endsWith(")"))) {
cliButton.setForeground(alertColor);
cli.setText("port!message(param1, param2, param3)");
return;
}
params = params[1].substring(1,params[1].length()-1).split(",");
if (!(params.length == 1)) {
cliButton.setForeground(alertColor);
cli.setText("port!message(param1, param2, param3)");
return;
}
try {
Map<String, Object> param = new HashMap<String, Object>();
param.put("id", StringHelper.toObject (int.class, params[0].trim()));
Command c = new Command(port_TraceOnly_build, add_lightsensorType, param);c.execute();
((DefaultListModel)commands.getModel()).addElement(c);
cliButton.setForeground(Color.BLACK);
} catch(IllegalArgumentException iae) {
System.err.println("Cannot parse arguments for message add_lightsensor on port build. Please try again with proper parameters");
cliButton.setForeground(alertColor);
}
}
else if (params[1].startsWith("add_motionsensor")) {
params[1] = params[1].substring("add_motionsensor".length(), params[1].length());
if (!(params[1].startsWith("(") && params[1].endsWith(")"))) {
cliButton.setForeground(alertColor);
cli.setText("port!message(param1, param2, param3)");
return;
}
params = params[1].substring(1,params[1].length()-1).split(",");
if (!(params.length == 1)) {
cliButton.setForeground(alertColor);
cli.setText("port!message(param1, param2, param3)");
return;
}
try {
Map<String, Object> param = new HashMap<String, Object>();
param.put("id", StringHelper.toObject (int.class, params[0].trim()));
Command c = new Command(port_TraceOnly_build, add_motionsensorType, param);c.execute();
((DefaultListModel)commands.getModel()).addElement(c);
cliButton.setForeground(Color.BLACK);
} catch(IllegalArgumentException iae) {
System.err.println("Cannot parse arguments for message add_motionsensor on port build. Please try again with proper parameters");
cliButton.setForeground(alertColor);
}
}
}


        else{
        cliButton.setForeground(alertColor);
        cli.setText("port!message(param1, param2, param3)");
        }
        }

@Override
public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==cliButton){
        parseAndExecute(cli.getText());
        }
        else if(ae.getSource()==clearButton){
        screen.setText("");
        }
        else if ( ae.getSource() == getSendadd_lightsensor_via_build()) {
try{
Map<String, Object> param = new HashMap<String, Object>();
param.put("id", StringHelper.toObject (int.class, getFieldadd_lightsensor_via_build_Id().getText()));
Command c = new Command(port_TraceOnly_build, add_lightsensorType, param);c.execute();
((DefaultListModel)commands.getModel()).addElement(c);
for(ITraceOnly_buildClient l : build_listeners)
l.add_lightsensor_from_build((Integer)StringHelper.toObject (int.class, getFieldadd_lightsensor_via_build_Id().getText()));
getSendadd_lightsensor_via_build().setForeground(Color.BLACK);
} catch(IllegalArgumentException iae) {
System.err.println("Cannot parse arguments for message add_lightsensor on port build. Please try again with proper parameters");
getSendadd_lightsensor_via_build().setForeground(alertColor);
}
}
else if ( ae.getSource() == getSendadd_motionsensor_via_build()) {
try{
Map<String, Object> param = new HashMap<String, Object>();
param.put("id", StringHelper.toObject (int.class, getFieldadd_motionsensor_via_build_Id().getText()));
Command c = new Command(port_TraceOnly_build, add_motionsensorType, param);c.execute();
((DefaultListModel)commands.getModel()).addElement(c);
for(ITraceOnly_buildClient l : build_listeners)
l.add_motionsensor_from_build((Integer)StringHelper.toObject (int.class, getFieldadd_motionsensor_via_build_Id().getText()));
getSendadd_motionsensor_via_build().setForeground(Color.BLACK);
} catch(IllegalArgumentException iae) {
System.err.println("Cannot parse arguments for message add_motionsensor on port build. Please try again with proper parameters");
getSendadd_motionsensor_via_build().setForeground(alertColor);
}
}

        }

@Override
public void itemStateChanged(ItemEvent e){
        Object source=e.getItemSelectable();
        if(source==showColor){
        setColorOutput(!isColorOutput());
        }
        }
@Override
public synchronized void luminance_via_trace_lum_motion(int LuminanceMsg_luminance_id_var, double LuminanceMsg_luminance_lum_var){
print("luminance_via_trace_lum_motion", "TODO");
}
@Override
public synchronized void motion_via_trace_lum_motion(int MotionMsg_motion_id_var){
print("motion_via_trace_lum_motion", "TODO");
}
@Override
public synchronized void nomotion_via_trace_lum_motion(int MotionMsg_nomotion_id_var){
print("nomotion_via_trace_lum_motion", "TODO");
}
}
package edu.kis.powp.jobs2d.events;


import edu.kis.powp.jobs2d.command.DriverCommand;


import edu.kis.powp.jobs2d.command.Transformations.ZoomTransformation;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SelectTransformationCommand implements ActionListener {
    private DriverCommandManager driverCommandManager;

    public SelectTransformationCommand(DriverCommandManager driverCommandManager) {
        this.driverCommandManager = driverCommandManager;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        DriverCommand driverCommand = driverCommandManager.getCurrentCommand();


        ZoomTransformation zoomTransformation = new ZoomTransformation(2);

        driverCommand = zoomTransformation.performTransformation(driverCommand);

        driverCommandManager.setCurrentCommand(driverCommand);



    }
}

package edu.kis.powp.jobs2d.command;

import jdk.internal.vm.compiler.collections.Pair;

import java.util.Iterator;

public class CompoundCommandTransformation {

    private ICompoundCommand compoundCommand;
    private Pair<Boolean, Integer> transformationZoomIn = new Pair<>(false, 0);
    private Pair<Boolean, Integer> transformationZoomOut = new Pair<>(false, 0);

    public CompoundCommandTransformation(ICompoundCommand compoundCommand) {
        this.compoundCommand = compoundCommand;
    }

    public void setTransformationZoomIn(Boolean boolValue, Integer intValue) {
        this.transformationZoomIn = new Pair<>(boolValue, intValue);
    }

    public void setTransformationZoomOut(Boolean boolValue, Integer intValue) {
        this.transformationZoomOut = new Pair<>(boolValue, intValue);
    }

    public ICompoundCommand transform(){
            transformZoomIn();
            transformZoomOut();
        return this.compoundCommand;
    }

    private void transformZoomIn() {
        OperateToCommand operateToCommand;
        SetPositionCommand setPositionCommand;
        Iterator<DriverCommand> iterator = compoundCommand.iterator();

        while(iterator.hasNext()){
            DriverCommand driverCommand = iterator.next();
            if (driverCommand instanceof OperateToCommand)
                operateToCommand = (OperateToCommand) driverCommand;
        }

    }
}

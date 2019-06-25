package edu.kis.powp.jobs2d.command.Transformations;

import edu.kis.powp.jobs2d.command.CompoundCommand;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;

public class Rotate90ToRight implements ITransform{


    Rotate90ToRight() {
    }

    @Override
    public CompoundCommand performTransformation(CompoundCommand compoundCommand) {
        CompoundCommand newCompoundCommand = new CompoundCommand();
        DriverCommand newCommand = null;
        while(compoundCommand.iterator().hasNext()){
            DriverCommand command = compoundCommand.iterator().next();
            if (command instanceof OperateToCommand)
                newCommand = new OperateToCommand(((OperateToCommand) command).getPosY() , -1 * ((OperateToCommand) command).getPosX() );
            else if (command instanceof SetPositionCommand)
                newCommand = new SetPositionCommand(((SetPositionCommand) command).getPosY() ,-1 * ((SetPositionCommand) command).getPosX() );
            newCompoundCommand.addComand(newCommand);
        }
        return newCompoundCommand;
    }
}
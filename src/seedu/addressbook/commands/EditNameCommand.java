package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;

public class EditNameCommand extends Command {

    public static final String COMMAND_WORD = "edit";
    
    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" + "Edits the name of a person in the address book. \n\t"
             + "Parameters: INDEX , NAME \n\t"
             + "Example: " + COMMAND_WORD
             + " 1 Chase";
    public static final String MESSAGE_SUCCESS = "Person's name succesfully edited";
    public static final String MESSAGE_INVALID_INDEX = "Given index is invalid.";

    private String editedName;
    
    public EditNameCommand(int targetIndex, String name) {
        super(targetIndex);
        this.editedName = name;
    }
    
    @Override
    public CommandResult execute() {
        try {
            addressBook.editPersonName(getTargetIndex(), editedName);
        } catch (PersonNotFoundException e) {
            return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
        } catch (IllegalValueException e) {
            return new CommandResult(MESSAGE_INVALID_INDEX);
        }
        return new CommandResult(MESSAGE_SUCCESS);
    }

}
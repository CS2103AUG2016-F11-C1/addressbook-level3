package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;

public class EditAddressCommand extends Command {

    public static final String COMMAND_WORD = "editAddress";
    
    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" + "Edits the address of a person in the address book. \n\t"
             + "Parameters: INDEX , ADDRESS \n\t"
             + "Example: " + COMMAND_WORD
             + " 1 Clementi Ave 2, #02-25";
    public static final String MESSAGE_SUCCESS = "Person's address succesfully edited";
    public static final String MESSAGE_INVALID_INDEX = "Given index is invalid.";

    private String editedAddress;
    
    public EditAddressCommand(int targetIndex, String address) {
        super(targetIndex);
        this.editedAddress = address;
    }
    
    @Override
    public CommandResult execute() {
        try {
            addressBook.editPersonAddress(getTargetIndex(), editedAddress);
        } catch (PersonNotFoundException e) {
            return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
        } catch (IllegalValueException e) {
            return new CommandResult(MESSAGE_INVALID_INDEX);
        }
        return new CommandResult(MESSAGE_SUCCESS);
    }

}
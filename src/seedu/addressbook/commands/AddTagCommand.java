package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.exception.DuplicateDataException;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;

public class AddTagCommand extends Command {

    public static final String COMMAND_WORD = "addtag";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" 
            + "Adds a tag to a person.\n\t"
            + "Parameters: INDEX TAG\n\t"
            + "Example: " + COMMAND_WORD + " 1 friends";

    public static final String MESSAGE_SUCCESS = "New tag added: %1$s";
    public static final String MESSAGE_TAG_EXISTS = "Tag '%1$s' already exists for person.";
    public static final String MESSAGE_TAG_INVALID = "Tag name is invalid.";

	private String tagName;
    
    public AddTagCommand(int targetVisibleIndex, String tagName) throws IllegalValueException {
    	super(targetVisibleIndex);
    	this.tagName = tagName;
    }

	@Override
	public CommandResult execute() {
		try {
			addressBook.addTagToPerson(getTargetIndex(), tagName);
		} catch (PersonNotFoundException e) {
			return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
		} catch (DuplicateDataException e) {
			return new CommandResult(String.format(MESSAGE_TAG_EXISTS, tagName));
		} catch (IllegalValueException e) {
			return new CommandResult(MESSAGE_TAG_INVALID);
		} 
		
		return new CommandResult(String.format(MESSAGE_SUCCESS, tagName));
	}

}

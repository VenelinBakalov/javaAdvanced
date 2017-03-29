package bg.softuni.exceptions;

/**
 * Created by Venelin on 6.3.2017 г..
 */
public class DuplicateEntryInStructureException extends RuntimeException {

    private static final String DUPLICATE_ENTRY = "the %s already exists in %s.";

    public DuplicateEntryInStructureException(String entryName, String structureName) {
        super(String.format(DUPLICATE_ENTRY, entryName, structureName));
    }

    public DuplicateEntryInStructureException(String message) {
        super(message);
    }
}

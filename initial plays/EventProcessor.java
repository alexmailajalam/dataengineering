import java.util.Map;

/**
 * Utility class for processing WActionEvent instances.
 */
public class EventProcessor {
    /**
     * Returns the provided event unchanged if the metadata contains a TableName
     * (case-insensitive key match) whose table part equals "patient" (case-insensitive).
     *
     * If the metadata does not contain a TableName, or the value does not match
     * "patient", this method returns null to indicate the event should be ignored.
     *
     * This method tolerates values like "SCHEMA.TABLE" and will compare only the
     * table portion after the dot.
     *
     * @param event the event to check
     * @return the same event if table is patient, otherwise null
     */
    public static WActionEvent filterByTableName(WActionEvent event) {
        if (event == null) return null;

        Map<String, String> metadata = event.getMetadata();
        if (metadata == null || metadata.isEmpty()) return null;

        // Find a key matching "TableName" ignoring case
        String rawTableName = null;
        for (Map.Entry<String, String> e : metadata.entrySet()) {
            if (e.getKey() != null && e.getKey().equalsIgnoreCase("TableName")) {
                rawTableName = e.getValue();
                break;
            }
        }

        if (rawTableName == null) return null;

        // If value contains schema (e.g. SCOTT.PATIENT), use the part after last dot.
        String table = rawTableName;
        int lastDot = rawTableName.lastIndexOf('.');
        if (lastDot >= 0 && lastDot < rawTableName.length() - 1) {
            table = rawTableName.substring(lastDot + 1);
        }

        if (table.trim().equalsIgnoreCase("patient")) {
            return event; // keep unchanged
        }

        return null; // ignore
    }
}

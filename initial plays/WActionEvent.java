import java.util.List;
import java.util.Map;

/**
 * Simple data holder representing the custom "wactionevent" structure.
 * Contains:
 *  - data: list of string values
 *  - metadata: map of string keys to string values
 *  - before: list of string values representing the before state
 */
public class WActionEvent {
    private final List<String> data;
    private final Map<String, String> metadata;
    private final List<String> before;

    public WActionEvent(List<String> data, Map<String, String> metadata, List<String> before) {
        this.data = data;
        this.metadata = metadata;
        this.before = before;
    }

    public List<String> getData() {
        return data;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public List<String> getBefore() {
        return before;
    }

    @Override
    public String toString() {
        return "WActionEvent{data=" + data + ", metadata=" + metadata + ", before=" + before + "}";
    }
}

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Small demo to show EventProcessor.filterByTableName behavior.
 */
public class Demo {
    public static void main(String[] args) {
        // Example event where TableName is 'patient' (should be returned)
        List<String> data1 = Arrays.asList("COMPANY 5A", "D6RJPwyuLXoLqQRQcOcouJ26KGxJSf6hgbu", null, null, null,
                null, null, null, null, null, null);
        Map<String, String> meta1 = new HashMap<>();
        meta1.put("TableName", "patient");
        meta1.put("OperationName", "UPDATE");
        List<String> before1 = Arrays.asList("COMPANY 1", "D6RJPwyuLXoLqQRQcOcouJ26KGxJSf6hgbu", null, null, null, null, null, null, null,
                null, null);

        WActionEvent e1 = new WActionEvent(data1, meta1, before1);
        WActionEvent r1 = EventProcessor.filterByTableName(e1);
        System.out.println("Event 1 -> " + (r1 != null ? "kept: " + r1 : "ignored"));

        // Example event where TableName is something else (should be ignored)
        List<String> data2 = Arrays.asList("COMPANY 5A", "D6RJPwyuLXoLqQRQcOcouJ26KGxJSf6hgbu", null, null, null,
                null, null, null, null, null, null);
        Map<String, String> meta2 = new HashMap<>();
        meta2.put("TableName", "SCOTT.POSAUTHORIZATIONS");
        meta2.put("OperationName", "UPDATE");
        List<String> before2 = Arrays.asList("COMPANY 1", "D6RJPwyuLXoLqQRQcOcouJ26KGxJSf6hgbu", null, null, null, null, null, null, null,
                null, null);

        WActionEvent e2 = new WActionEvent(data2, meta2, before2);
        WActionEvent r2 = EventProcessor.filterByTableName(e2);
        System.out.println("Event 2 -> " + (r2 != null ? "kept: " + r2 : "ignored"));
    }
}

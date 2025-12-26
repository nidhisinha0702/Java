package IO;
import java.util.*;

class FileSystem {

    // Each node represents a directory or a file
    private static class Node {
        boolean isFile = false;
        Map<String, Node> children = new TreeMap<>();
        StringBuilder content = new StringBuilder();
    }

    private final Node root;

    public FileSystem() {
        root = new Node();
    }

    // Helper: traverse to the node represented by a path
    private Node traverse(String path) {
        String[] parts = path.split("/");
        Node curr = root;
        for (String part : parts) {
            if (part.isEmpty()) continue; // skip first empty element from split("/")
            curr.children.putIfAbsent(part, new Node());
            curr = curr.children.get(part);
        }
        return curr;
    }

    // 1️⃣ mkdir(path): Create directory and its parents if needed
    public void mkdir(String path) {
        traverse(path);
    }

    // 2️⃣ addContentToFile(path, content): Append content to a file
    public void addContentToFile(String filePath, String content) {
        Node node = traverse(filePath);
        node.isFile = true;
        node.content.append(content);
    }

    // 3️⃣ readContentFromFile(path): Read file content
    public String readContentFromFile(String filePath) {
        Node node = traverse(filePath);
        return node.content.toString();
    }

    // 4️⃣ ls(path): List directory contents or single file name
    public List<String> ls(String path) {
        if (path.equals("/")) {
            // root directory
            return new ArrayList<>(root.children.keySet());
        }

        Node node = root;
        String[] parts = path.split("/");
        for (int i = 1; i < parts.length; i++) {
            node = node.children.get(parts[i]);
            if (node == null) return new ArrayList<>(); // invalid path
        }

        if (node.isFile) {
            // return only the file name
            return Arrays.asList(parts[parts.length - 1]);
        } else {
            // return directory contents (sorted automatically by TreeMap)
            return new ArrayList<>(node.children.keySet());
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();

        System.out.println(fs.ls("/")); // []

        fs.mkdir("/a/b/c");
        fs.addContentToFile("/a/b/c/d", "hello");

        System.out.println(fs.ls("/"));         // [a]
        System.out.println(fs.readContentFromFile("/a/b/c/d")); // hello

        fs.addContentToFile("/a/b/c/d", " world");
        System.out.println(fs.readContentFromFile("/a/b/c/d")); // hello world
    }
}

import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.io.IOException;

public class UnixFind {
    
    private Path startPath;
    private Predicate<Path> filter;
    
    private UnixFind(Path startPath) {
        this.startPath = startPath;
        this.filter = p -> true; // Default filter (match everything)
    }

    public static UnixFind from(String directory) {
        return new UnixFind(Paths.get(directory));
    }

    public UnixFind name(String pattern) {
        this.filter = this.filter.and(p -> p.getFileName().toString().matches(pattern));
        return this;
    }

    public UnixFind type(FileType type) {
        this.filter = this.filter.and(p -> {
            try {
                return Files.isDirectory(p) == (type == FileType.DIRECTORY);
            } catch (Exception e) {
                return false;
            }
        });
        return this;
    }

    public UnixFind size(long minSize, long maxSize) {
        this.filter = this.filter.and(p -> {
            try {
                long size = Files.size(p);
                return size >= minSize && size <= maxSize;
            } catch (IOException e) {
                return false;
            }
        });
        return this;
    }

    public UnixFind modifiedBefore(long millis) {
        this.filter = this.filter.and(p -> {
            try {
                FileTime fileTime = Files.getLastModifiedTime(p);
                return fileTime.toMillis() < millis;
            } catch (IOException e) {
                return false;
            }
        });
        return this;
    }

    public UnixFind permissions(PosixFilePermission permission) {
        this.filter = this.filter.and(p -> {
            try {
                return Files.getPosixFilePermissions(p).contains(permission);
            } catch (IOException e) {
                return false;
            }
        });
        return this;
    }

    public void execute(Action action) throws IOException {
        try (Stream<Path> paths = Files.walk(startPath)) {
            paths.filter(filter).forEach(action::apply);
        }
    }

    public enum FileType { FILE, DIRECTORY }
    
    @FunctionalInterface
    public interface Action {
        void apply(Path path);
    }

    public static void main(String[] args) throws IOException {
        UnixFind.from("/home/user")
            .name(".*\\.txt")
            .type(FileType.FILE)
            .size(100, 10000)
            .modifiedBefore(System.currentTimeMillis() - 86400000)
            .execute(System.out::println);
    }
}


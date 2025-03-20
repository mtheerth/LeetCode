import java.util.ArrayList;
import java.util.List;

// File representation
class File {
    private String name;
    private long size;
    private String format;
    private boolean isDirectory;
    private List<File> children;

    public File(String name, long size, String format, boolean isDirectory) {
        this.name = name;
        this.size = size;
        this.format = format;
        this.isDirectory = isDirectory;
        this.children = new ArrayList<>();
    }

    public String getName() { return name; }
    public long getSize() { return size; }
    public String getFormat() { return format; }
    public boolean isDirectory() { return isDirectory; }
    public List<File> getChildren() { return children; }
    public void addFile(File file) { this.children.add(file); }
}

// Search Criteria Interface (Open-Closed Principle)
interface SearchCriteria {
    boolean matches(File file);
}

// Composite Criteria to combine multiple filters
class CompositeCriteria implements SearchCriteria {
    private List<SearchCriteria> criteriaList;

    public CompositeCriteria(List<SearchCriteria> criteriaList) {
        this.criteriaList = criteriaList;
    }

    @Override
    public boolean matches(File file) {
        for (SearchCriteria criteria : criteriaList) {
            if (!criteria.matches(file)) {
                return false;
            }
        }
        return true;
    }
}

// Concrete Criteria Implementations
class SizeCriteria implements SearchCriteria {
    private long minSize;

    public SizeCriteria(long minSize) {
        this.minSize = minSize;
    }

    @Override
    public boolean matches(File file) {
        return file.getSize() > minSize;
    }
}

class FormatCriteria implements SearchCriteria {
    private String format;

    public FormatCriteria(String format) {
        this.format = format;
    }

    @Override
    public boolean matches(File file) {
        return file.getFormat().equalsIgnoreCase(format);
    }
}

class DirectoryPathCriteria implements SearchCriteria {
    private String directoryName;

    public DirectoryPathCriteria(String directoryName) {
        this.directoryName = directoryName;
    }

    @Override
    public boolean matches(File file) {
        return file.isDirectory() && file.getName().equalsIgnoreCase(directoryName);
    }
}

class NameCriteria implements SearchCriteria {
    private String name;

    public NameCriteria(String name) {
        this.name = name;
    }

    @Override
    public boolean matches(File file) {
        return file.getName().equalsIgnoreCase(name);
    }
}

// Facade to simplify file search
class FileSearchFacade {
    private FileFinder fileFinder;

    public FileSearchFacade() {
        this.fileFinder = new FileFinder();
    }

    public List<File> searchWithCriteria(File directory, List<SearchCriteria> criteriaList) {
        CompositeCriteria compositeCriteria = new CompositeCriteria(criteriaList);
        return fileFinder.search(directory, compositeCriteria);
    }
}

// File Finder Class
class FileFinder {
    public List<File> search(File directory, SearchCriteria criteria) {
        List<File> result = new ArrayList<>();
        if (!directory.isDirectory()) return result;
        for (File file : directory.getChildren()) {
            if (criteria.matches(file)) {
                result.add(file);
            }
            if (file.isDirectory()) {
                result.addAll(search(file, criteria));
            }
        }
        return result;
    }
}

// API Usage
public class FindCommandAPI {
    public static void main(String[] args) {
        // Creating a mock file structure
        File root = new File("root", 0, "", true);
        File subDir = new File("subdir", 0, "", true);
        File file1 = new File("file1.xml", 6000000, "xml", false);
        File file2 = new File("file2.txt", 4000000, "txt", false);
        File file3 = new File("file3.xml", 2000000, "xml", false);
        root.addFile(subDir);
        subDir.addFile(file1);
        subDir.addFile(file2);
        subDir.addFile(file3);

        FileSearchFacade searchFacade = new FileSearchFacade();

        // Find all XML files
        List<File> xmlFiles = searchFacade.searchWithCriteria(root, List.of(new FormatCriteria("xml")));
        System.out.println("XML Files:");
        xmlFiles.forEach(f -> System.out.println(f.getName()));

        // Find files greater than 5MB
        List<File> largeFiles = searchFacade.searchWithCriteria(root, List.of(new SizeCriteria(5000000)));
        System.out.println("\nFiles greater than 5MB:");
        largeFiles.forEach(f -> System.out.println(f.getName()));

        // Find by directory
        List<File> directoryFiles = searchFacade.searchWithCriteria(root, List.of(new DirectoryPathCriteria("subdir")));
        System.out.println("\nFiles in 'subdir':");
        directoryFiles.forEach(f -> System.out.println(f.getName()));

        // Find by name
        List<File> namedFiles = searchFacade.searchWithCriteria(root, List.of(new NameCriteria("file1.xml")));
        System.out.println("\nFiles with name 'file1.xml':");
        namedFiles.forEach(f -> System.out.println(f.getName()));

        // Find by all criteria
        List<SearchCriteria> allCriteria = new ArrayList<>();
        allCriteria.add(new FormatCriteria("xml"));
        allCriteria.add(new SizeCriteria(5000000));
        allCriteria.add(new DirectoryPathCriteria("subdir"));
        allCriteria.add(new NameCriteria("file1.xml"));
        List<File> allMatchingFiles = searchFacade.searchWithCriteria(root, allCriteria);
        System.out.println("\nFiles matching all criteria:");
        allMatchingFiles.forEach(f -> System.out.println(f.getName()));
    }
}


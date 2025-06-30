interface Database {
    void connect();
}

class MySQLDatabase implements Database {
    public void connect() {
        System.out.println("Connected to MySQL");
    }
}

class MongoDB implements Database {
    public void connect() {
        System.out.println("Connected to MongoDB");
    }
}

class Application {
    private Database database;

    public Application(Database database) {
        this.database = database;
    }

    public void start() {
        database.connect();
    }
}

public class DIPDemo {
    public static void main(String[] args) {
        Database db1 = new MySQLDatabase();
        Application app1 = new Application(db1);
        app1.start();

        Database db2 = new MongoDB();
        Application app2 = new Application(db2);
        app2.start();
    }
}


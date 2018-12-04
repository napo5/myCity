package database;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class operationTest {

    @Test
    void create() {
        operation op = new operation();
        op.createDB("test.db");
    }

}
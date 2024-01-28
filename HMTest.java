
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class HMTest {

    // Testing constructor for MyHashMap class
    @Test
    public void MyHashMapConstructorTest() {
        MyHashMap<String> hashMap = new MyHashMap<>("Hello", "Hi");
        assertEquals(1, hashMap.size());;
        assertEquals("Hi", hashMap.get("Hello"));
    }

}

// head = @543e710e
// head.next = @543e710e
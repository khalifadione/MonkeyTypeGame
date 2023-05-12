package fr.uparis.informatique.cpoo5.junit5demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestJunit5Demo {
    @Test
    public void testFonctionATester() {
        assertEquals(Junit5Demo.fonctionATester(), 42, "Si ça rate c'est que ça ne retourne pas 42.");
        assertEquals(Junit5Demo.fonctionATester(), 5, "Si ça rate c'est que ça ne retourne pas 5.");
    }
    
}

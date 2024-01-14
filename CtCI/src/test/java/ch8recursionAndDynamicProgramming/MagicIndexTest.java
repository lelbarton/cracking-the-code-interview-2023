package ch8recursionAndDynamicProgramming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagicIndexTest {

    private MagicIndex magicIndex;

    @BeforeEach
    public void setup() {
        this.magicIndex = new MagicIndex();
    }

    @Test
    void whenEmptyArray_noIndexFound() {
        int[] emptyArray= {};
        assertEquals(-1, magicIndex.findMagicIndex(emptyArray));
    }

    @Test
    void whenMagicIndexExistsInFirstHalf_returnIndex() {
        int[] array = {-3,1,3,4,5};
        assertEquals(1, magicIndex.findMagicIndex(array));
    }

    @Test
    void whenMagicIndexExistsInLastHalf_returnIndex() {
        int[] array = {-1,0,1,2,4,5};
        assertEquals(4, magicIndex.findMagicIndex(array));
    }

    @Test
    void whenMagicIndexExistsInMiddle_returnIndex() {
        int[] array = {-1,1,2,3,5};
        assertEquals(2, magicIndex.findMagicIndex(array));
    }
}

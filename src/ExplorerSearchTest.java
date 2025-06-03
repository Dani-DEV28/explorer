import static org.junit.Assert.*;
import org.junit.Test;

public class ExplorerSearchTest {
    @Test
    public void testReachableArea_someUnreachable() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }

    @Test
    public void testReachableArea_allReachable() {
        int[][] island = {
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,0,1},
            {1,1,1,1,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(30, actual);
    }

    @Test
    public void testReachableArea_noExplorer() {
        int[][] island = {
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
        };

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            ExplorerSearch.reachableArea(island);
        });

        assertEquals("No explorer starting point (value 0) found", ex.getMessage());
    }


// Test unusable - current
    // @Test
    // public void testReachableArea_twoExplorer() {
    //     int[][] island = {
    //         {1,1,1,1,1,1},
    //         {1,0,1,1,1,1},
    //         {1,1,1,1,1,1},
    //         {1,1,1,1,0,1},
    //         {1,1,1,1,1,1},
    //     };

    //     IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
    //         ExplorerSearch.reachableArea(island);
    //     });

    //     assertEquals("Extra Explorer found", ex.getMessage());
    // }

    @Test
    public void testReachableArea_onlyWater() {
        int[][] island = {
            {2,2,2,2,2,2},
            {2,0,2,2,2,2},
            {2,2,2,2,2,2},
            {2,2,2,2,2,2},
            {2,2,2,2,2,2},
        };

        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testReachableArea_onlyMountain() {
        int[][] island = {
            {3,3,3,3,3,3},
            {3,0,3,3,3,3},
            {3,3,3,3,3,3},
            {3,3,3,3,3,3},
            {3,3,3,3,3,3},
        };

        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

        @Test
    public void testReachableArea_oneVert() {
        int[][] island = {
            {1,1,1,3,1,1},
            {1,1,1,3,1,1},
            {1,1,1,3,1,1},
            {1,1,1,3,0,1},
            {1,1,1,3,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(10, actual);
    }

        @Test
    public void testReachableArea_twoHori() {
        int[][] island = {
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {3,3,3,3,3,3},
            {1,1,1,1,0,1},
            {2,2,2,2,2,2},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(6, actual);
    }

    // Add more tests here!
    // Come up with varied cases
}

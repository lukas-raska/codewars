package solutions.kyu5.paginationHelper;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PaginationHelperTestInteger {

    private final List<Integer> collection = List.of(1,2,3,4);
    private final int itemsPerPage = 4;

    PaginationHelper<Integer> helper = new PaginationHelper<>(collection,itemsPerPage);

    @Test
    void test1 (){
        assertEquals(4, helper.pageItemCount(0));
    }

}
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FirstMockitoTest {
    @Test
    public void letsMockListSize_ReturnMultipleValues(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);
        assertEquals(2,listMock.size());
        assertEquals(3,listMock.size());
    }

    @Test
    public void letsMockListGet(){
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenReturn("Wow");
        assertEquals("Wow",listMock.get(0));
    }

    @Test(expected = RuntimeException.class)
    public void letsMockListException(){
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));
        listMock.get(1);
    }
}

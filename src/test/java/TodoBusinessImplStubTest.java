import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TodoBusinessImplStubTest {
    @Test
    public void test(){
        //TodoService todoService = new TodoServiceStub();
        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList("Spring1","Spring2","Dance");
        when(todoServiceMock.retrieveTodos("Junk")).thenReturn(todos);

        //TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);
        //List<String> filteredTodos = todoBusiness.retrieveTodosRelatedToSpring("Junk");
        assertEquals(2, todos.size());
    }
}

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import org.mockito.ArgumentCaptor;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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

    @Test
    public void test1(){
        //Given
        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList("Spring1","Spring2","Dance");
        given(todoServiceMock.retrieveTodos("Junk")).willReturn(todos);

        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);

        //When
        List<String> filteredTodos = todoBusiness.retrieveTodosRelatedToSpring("Junk");

        //Then
        assertThat(filteredTodos.size(),is(2));


    }

    @Test
    public void testDeleteTodosNotRelatedToSpring(){
        //Given
        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList("Spring1","Spring2","Dance");
        given(todoServiceMock.retrieveTodos("Junk")).willReturn(todos);

        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);

        //When
        todoBusiness.deleteTodosNotRelatedToSpring("Junk");

        //Then
        verify(todoServiceMock).deleteTodos("Junk");
        //is equivalent to
        then(todoServiceMock).should().deleteTodos("Junk");

        verify(todoServiceMock, never()).deleteTodos("Junk");
        //is equivalent to
        then(todoServiceMock).should(never()).deleteTodos("Junk");

        verify(todoServiceMock, times(1)).deleteTodos("Junk");
        verify(todoServiceMock, atLeast(1)).deleteTodos("Junk");
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_CaptureArgument(){
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

        //Given
        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList("Spring1","Spring2","Dance");
        given(todoServiceMock.retrieveTodos("Junk")).willReturn(todos);

        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);

        //When
        todoBusiness.deleteTodosNotRelatedToSpring("Junk");

        //Then
        then(todoServiceMock).should().deleteTodos(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getValue(),is("Junk"));

        //Then 2
        then(todoServiceMock).should(times(2)).deleteTodos(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getAllValues(),is("Junk"));
    }
}

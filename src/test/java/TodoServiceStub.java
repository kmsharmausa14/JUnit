import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService{
    @Override
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Spring1","Spring2","Dance");
    }

    @Override
    public void deleteTodos(String todo) {

    }
}

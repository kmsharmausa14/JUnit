import java.util.ArrayList;
import java.util.List;

public class TodoBusinessImpl {
    private TodoService todoService;

    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveTodosRelatedToSpring(String user){
        List<String> filteredToDos = new ArrayList<>();
        List<String> todos = todoService.retrieveTodos(user);
        for(String item : todos)
            if(item.contains("Spring"))
                filteredToDos.add(item);
        return filteredToDos;
    }

    public void deleteTodosNotRelatedToSpring(String user){
        List<String> todos = todoService.retrieveTodos(user);
        for(String item : todos)
            if(!item.contains("Spring"))
                todoService.deleteTodos(item);
    }
}

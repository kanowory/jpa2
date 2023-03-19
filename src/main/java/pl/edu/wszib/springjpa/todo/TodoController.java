package pl.edu.wszib.springjpa.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public String list(Model model, @RequestParam(required = false) Integer edytowanyId){
        List<ToDo> toDoList = todoRepository.findAll();
        ToDo newTodo = new ToDo();
        ToDoStatus[] statuses = ToDoStatus.values();

        model.addAttribute("todos", toDoList);
        model.addAttribute("newTodo", newTodo);
        model.addAttribute("statuses", statuses);
        model.addAttribute("edytowanyId", edytowanyId);

        if (edytowanyId != null) {
            model.addAttribute("editTodo", todoRepository.findById(edytowanyId).get());
        }

        return "list-todo";
    }

    @PostMapping
    public String create(ToDo toDo){
        toDo.setId(null);
        toDo.setStatus(ToDoStatus.NEW);
        todoRepository.save(toDo);
        return "redirect:/todos";
    }

    @GetMapping("/usun/{id}")
    public String usun(@PathVariable Integer id) {
        todoRepository.deleteById(id);
        return "redirect:/todos";
    }

    @PostMapping("/zmien/{id}")
    public String zmien (ToDo todo, @PathVariable Integer id) {
        ToDo existing = todoRepository.findById(id).get();
        existing.setStatus(todo.getStatus());
        existing.setTermin(todo.getTermin());
        existing.setZadanie(todo.getZadanie());
        todoRepository.save(existing);
        return "redirect:/todos";
    }
}

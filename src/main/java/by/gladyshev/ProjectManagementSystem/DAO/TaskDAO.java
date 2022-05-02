package by.gladyshev.ProjectManagementSystem.DAO;

import by.gladyshev.ProjectManagementSystem.model.MyModel;
import by.gladyshev.ProjectManagementSystem.model.TaskModel;
import by.gladyshev.ProjectManagementSystem.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskDAO extends DAO {
    @Autowired
    public TaskDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
        table = "tasks";
        rm = new TaskMapper();
        if(jdbcTemplate.queryForObject("SELECT MAX(id) FROM "+table, Integer.class)!=null)
        {
            ID = jdbcTemplate.queryForObject("SELECT MAX(id) FROM "+table, Integer.class);
        } else
        {
            ID=0;
        }
        repository = TaskRepository.INSTANCE;
        TaskRepository.INSTANCE.setAll(index("id"));
    }
    @Override
    public void update(MyModel tm)
    {
        jdbcTemplate.update("UPDATE "+table+" SET name=?, developer=? WHERE id=?",
                tm.getName(), ((TaskModel)tm).getResponsible().getId(), tm.getId());
    }
    public int getID() {
        return this.ID;
    }
}

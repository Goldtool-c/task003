package by.gladyshev.ProjectManagementSystem.DAO;

import by.gladyshev.ProjectManagementSystem.model.MyModel;
import by.gladyshev.ProjectManagementSystem.model.TaskModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskMapper implements RowMapper<MyModel> {

    @Override
    public MyModel mapRow(ResultSet resultSet, int i) throws SQLException {
        TaskModel tm = new TaskModel();
        tm.setId(resultSet.getInt("id"));
        tm.setName(resultSet.getString("name"));
        return (MyModel) tm;
    }
}

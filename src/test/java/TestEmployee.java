import com.team.com.team.domain.Employee;
import com.team.com.team.service.NameListService;
import com.team.com.team.service.TeamException;
import org.junit.Test;

public class TestEmployee {
    @Test
    public void testAllEmployee(){
        NameListService nameListService = new NameListService();
        Employee[] allEmployees = nameListService.getAllEmployees();
        for(int i = 0; i < allEmployees.length; i++){
            System.out.println(allEmployees[i]);
        }
    }
    @Test
    public void testGetEmployee(){
        NameListService nameListService = new NameListService();
        try {
            System.out.println(nameListService.getEmployee(39));
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }
}

package CompositeMethod;

import java.util.ArrayList;
import java.util.List;
// composite component
public class CompanyHead implements Company{
    private int id;
    private String name;

    private List<Company> subDepartments;
    public CompanyHead(int id, String name) {
        this.id = id;
        this.name= name;
        this.subDepartments = new ArrayList<>();
    }
    public void displayName() {
        subDepartments.forEach(Company::displayName);
    }
    public void addDepartments(Company company) {
        subDepartments.add(company);
    }
    // remove details
}
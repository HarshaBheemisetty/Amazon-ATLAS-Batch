import java.util.Date;
public class Day37_UserServiceTask1 {
    private final Day37_UserRepoTask1 userRepository;


    public Day37_UserServiceTask1(Day37_UserRepoTask1 userRepository) {
        this.userRepository = userRepository;
    }


    public Day37_User02Task1 registerUser(Day37_User02Task1 user) {
        user.setRegistrationDate(new Date());
        return userRepository.save(user);   //.save(user);
    }
}

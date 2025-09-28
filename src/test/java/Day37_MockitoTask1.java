import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Date;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class Day37_MociktoTask1 {
    @Mock
    private Day37_UserRepoTask1 userRepository;
    @InjectMocks
    private Day37_UserServiceTask1 userService;
    @Test
    void testRegisterUser() {
        Day37_User02Task1 newUser = new Day37_User02Task1();
        newUser.setName("Prasunamba Meher");
        when(userRepository.save(any(Day37_User02Task1.class))).thenReturn(newUser);
        Day37_User02Task1 registeredUser = userService.registerUser(newUser);
        assertNotNull(registeredUser);
        assertNotNull(registeredUser.getRegistrationDate());
    }
}

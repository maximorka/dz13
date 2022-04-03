package testApi;

import testApi.task1.Task1;
import testApi.task2.Task2;
import testApi.task3.Task3;

public class UseCases {

    public static void main(String[] args) {
        User user = new User().createUser();

        Task1 task1 = new Task1();
        task1.createNewUser(user);
        task1.updateUser(user);
        task1.deleteUser(1);
        task1.getInfAbAllUsers();
        task1.getInfAbUserForId(1);
        task1.getInfAbUserForUserName("Bret");

        Task2 task2 = new Task2();
        task2.getCommentsForLastPostAndWriteFile(1);

        Task3 task3 = new Task3();
        task3.getOpenTaskForUser(2);
    }
}

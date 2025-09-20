package com.example.MethodologySpringBoot;
import com.example.MethodologySpringBoot.model.Student;
import com.example.MethodologySpringBoot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnectivityTest implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        // Test the connection by saving a sample user
        Student user = new Student();
        user.setEmail("Test User");
        user.setMajor("Computer");
        user.setLast_name("Jock");
        user.setFirst_name("Yes");
        studentRepository.save(user);

        System.out.println("User saved successfully!");
    }



}








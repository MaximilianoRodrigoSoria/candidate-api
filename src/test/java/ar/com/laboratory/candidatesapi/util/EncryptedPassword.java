package ar.com.laboratory.candidatesapi.util;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class EncryptedPassword {

    @Test
    public void testEncryptPassword() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = "writeonly";
        String encryptedPassword = bCryptPasswordEncoder.encode(password);
        System.out.println("Password:  "+ password+ "\nEncrypted password: \n" + encryptedPassword);
    }
}

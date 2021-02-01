/*
package com.mng.todo.model;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 implements PasswordEncoder {
    private static MessageDigest md;


    @Override
    public String encode(CharSequence input) {
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] passBytes = input.toString().getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<digested.length;i++){
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);


        }

    }



    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return encode(charSequence).toString().equals(s);
    }
}
*/

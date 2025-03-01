package org.TestScriptData;

import java.util.List;

public class LoginHomeTestData {
    private String email;
    private String password;
    private String confirmPassword;

    private List<String> expectedErrorMsgs;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public List<String> getExpectedErrorMsgs() {
        return expectedErrorMsgs;
    }
}

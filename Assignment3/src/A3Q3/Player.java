package A3Q3;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    private final String account = generateAccount();
    private String password;
    private Mail mail;
    private PhoneNumber phoneNumber;
    ArrayList<Pokemon> pokemons = new ArrayList<>();

    public Player(Mail mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public Player(PhoneNumber phoneNumber, String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public Player(Mail mail, PhoneNumber phoneNumber, String password) {
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public boolean checkIdentity(Mail mail, String password) {
        return this.mail.getMail().equals(mail.getMail()) && this.password.equals(password);
    }

    public boolean checkIdentity(PhoneNumber phoneNumber, String password) {
        return this.phoneNumber.getPhoneNumber().equals(phoneNumber.getPhoneNumber()) && this.password.equals(password);
    }

    public boolean setMail(PhoneNumber phoneNumber, String password, Mail mail) {
        if (checkIdentity(phoneNumber, password)) {
            this.mail = mail;
            return true;
        } else {
            return false;
        }
    }

    public boolean setPhoneNumber(Mail mail, String password, PhoneNumber phoneNumber) {
        if (checkIdentity(mail, password)) {
            this.phoneNumber = phoneNumber;
            return true;
        } else {
            return false;
        }
    }


    public String generateAccount() {
        Random rand = new Random();
        String str = Integer.toString(rand.nextInt(9000000) + 1000000);
        return str;
    }

    public String getAccount() {
        return account;
    }

    public Mail getMail() {
        return mail;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public boolean changePassword(PhoneNumber phoneNumber, String oldPassword, String newPassword) {
        if (checkIdentity(phoneNumber, oldPassword)) {
            this.password = newPassword;
            return true;
        } else {
            return false;
        }
    }

    public boolean changePassword(Mail mail, String oldPassword, String newPassword) {
        if (checkIdentity(mail, oldPassword)) {
            this.password = newPassword;
            return true;
        } else {
            return false;
        }
    }

    public void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

}

class Mail {
    String mail;

    public Mail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }
}

class PhoneNumber {
    String phoneNumber;

    public PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
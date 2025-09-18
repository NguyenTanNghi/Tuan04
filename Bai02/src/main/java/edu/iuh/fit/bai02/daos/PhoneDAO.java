package edu.iuh.fit.bai02.daos;

import edu.iuh.fit.bai02.etities.Phone;

import java.util.List;

public interface PhoneDAO {
    public List<Phone> findAll();

    public Phone getById(int id);

    public void addPhone(Phone phone);
}

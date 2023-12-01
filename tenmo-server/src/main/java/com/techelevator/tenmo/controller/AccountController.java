package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@PreAuthorize("isAuthenticated()")
public class AccountController {
    @Autowired
    private AccountDao accountDao;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/account/create/{userId}", method = RequestMethod.POST)
    public Account createAccount(@PathVariable int userId) {
        return accountDao.createAccount(userId);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/account/delete/{userId}/{accountId}", method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable int userId,@PathVariable int accountId) {
        accountDao.deleteAccount(userId,accountId);
    }

    @RequestMapping(path = "/account/balance/{userId}", method = RequestMethod.GET)
    public Account getBalance(@PathVariable int userId) {
        return accountDao.getBalanceById(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/account", method = RequestMethod.GET)
    public Account listTransfers(@RequestParam int userId) {
        return null;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping( method = RequestMethod.POST)
    public void   sendMoney(@RequestParam  int senderAccountId, @RequestParam int recipientAccountId,@RequestParam double amount) {
       accountDao.sendMoney(senderAccountId,recipientAccountId,amount);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/account/5", method = RequestMethod.POST)
    public Account getTransferById(@RequestParam int userId) {
        return null;
    }
}

package com.app.server;

import com.app.entities.superMarket;

public interface superMarketServer {
    public void add(superMarket supermarket);
    public superMarket getsuperMarketById(Integer Id);
    public String deletesuperMarketById(Integer Id);
    public String updatesuperMarketById(Integer Id,superMarket supermarket);
}

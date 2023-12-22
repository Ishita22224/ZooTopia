package org.example;

import java.io.BufferedReader;
import java.io.IOException;

public interface User {
    public void viewAttractions(ZooTopia zootopia) throws IOException;
    public void viewAnimals(ZooTopia zootopia);
    public void viewDiscounts(ZooTopia zootopia);
    public void viewSpecialDeals(ZooTopia zootopia);

}
